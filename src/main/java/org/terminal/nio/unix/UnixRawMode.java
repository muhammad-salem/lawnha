package org.terminal.nio.unix;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class UnixRawMode {

	private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

	static {
		try {
			if (! isWindows){
				initUnix();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static boolean initDone;
	private static boolean stdinIsConsole;
	private static boolean consoleModeAltered;

	private static final int invalidKey = 0xFFFE;
	private static final String invalidKeyStr = String.valueOf((char) invalidKey);

	private static CharsetDecoder charsetDecoder;
	private static Termios originalTermios;
	private static Termios rawTermios;
	private static Termios intermediateTermios;

	private static final int stdinFd = 0;
	private static Libc libc;


	private static synchronized void initUnix() throws IOException {
		if (initDone) {
			return;
		}
		libc = Native.load("c", Libc.class);
		// libc = (Libc) Native.loadLibrary("c", Libc.class);
		stdinIsConsole = libc.isatty(stdinFd) == 1;
		charsetDecoder = Charset.defaultCharset().newDecoder();
		if (stdinIsConsole) {
			originalTermios = getTerminalAttrs(stdinFd);
			rawTermios = new Termios(originalTermios);
			rawTermios.c_lflag &= ~(LibcDefs.ICANON | LibcDefs.ECHO | LibcDefs.ECHONL | LibcDefs.ISIG);
			intermediateTermios = new Termios(rawTermios);
			intermediateTermios.c_lflag |= LibcDefs.ICANON;
			// Canonical mode can be switched off between the read() calls, but echo must
			// remain disabled.
			registerShutdownHook();
		}
		initDone = true;
	}

	private static void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() { try { resetConsoleModeUnix(); } catch (Exception e) {} }
		});
	}

	public static void resetConsoleModeUnix() throws IOException {
		if (!initDone || !stdinIsConsole || !consoleModeAltered) {
			return;
		}
		setTerminalAttrs(stdinFd, originalTermios);
		consoleModeAltered = false;
	}


	public static int readUnix(boolean wait) throws IOException {
//		initUnix();
		if (!stdinIsConsole) { // STDIN is not a console
			return readSingleCharFromByteStream(System.in);
		}
		consoleModeAltered = true;
		setTerminalAttrs(stdinFd, rawTermios); // switch off canonical mode, echo and signals
		try {
			if (!wait && System.in.available() == 0) {
				return -2;
			} // no input available
			return readSingleCharFromByteStream(System.in);
		} finally {
			setTerminalAttrs(stdinFd, intermediateTermios);
		}
	} // reset some console attributes


	private static Termios getTerminalAttrs(int fd) throws IOException {
		Termios termios = new Termios();
		try {
			int rc = libc.tcgetattr(fd, termios);
			if (rc != 0) {
				throw new RuntimeException("tcgetattr() failed.");
			}
		} catch (LastErrorException e) {
			throw new IOException("tcgetattr() failed.", e);
		}
		return termios;
	}

	private static void setTerminalAttrs(int fd, Termios termios) throws IOException {
		try {
			int rc = libc.tcsetattr(fd, LibcDefs.TCSANOW, termios);
			if (rc != 0) {
				throw new RuntimeException("tcsetattr() failed.");
			}
		} catch (LastErrorException e) {
			throw new IOException("tcsetattr() failed.", e);
		}
	}

	private static int readSingleCharFromByteStream(InputStream inputStream) throws IOException {
		byte[] inBuf = new byte[4];
		int inLen = 0;
		while (true) {
			if (inLen >= inBuf.length) { // input buffer overflow
				return invalidKey;
			}
			int b = inputStream.read(); // read next byte
			if (b == -1) { // EOF
				return -1;
			}
			inBuf[inLen++] = (byte) b;
			int c = decodeCharFromBytes(inBuf, inLen);
			if (c != -1) {
				return c;
			}
		}
	}

	// (This method is synchronized because the charsetDecoder must only be used by
	// a single thread at once.)
	private static synchronized int decodeCharFromBytes(byte[] inBytes, int inLen) {
		charsetDecoder.reset();
		charsetDecoder.onMalformedInput(CodingErrorAction.REPLACE);
		charsetDecoder.replaceWith(invalidKeyStr);
		ByteBuffer in = ByteBuffer.wrap(inBytes, 0, inLen);
		CharBuffer out = CharBuffer.allocate(1);
		charsetDecoder.decode(in, out, false);
		if (out.position() == 0) {
			return -1;
		}
		return out.get(0);
	}

}
