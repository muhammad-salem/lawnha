package org.terminal.nio.win;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.io.IOException;

public class WinRawMode {

	private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	private static final int invalidKey = 0xFFFE;
	private static final String invalidKeyStr = String.valueOf((char) invalidKey);

	private static boolean initDone;
	private static boolean stdinIsConsole;
	private static boolean consoleModeAltered;

	private static Msvcrt msvcrt;
	private static Kernel32 kernel32;
	private static Pointer consoleHandle;
	private static int originalConsoleMode;

	private static void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try{
					resetConsoleModeWindows();
				} catch (IOException e){
					e.printStackTrace();
				}
				
			}
		});
	}

	public static int readWindows(boolean wait) throws IOException {
		initWindows();
		if (!stdinIsConsole) {
			int c = msvcrt.getwchar();
			if (c == 0xFFFF) {
				c = -1;
			}
			return c;
		}
		consoleModeAltered = true;
		setConsoleMode(consoleHandle, originalConsoleMode & ~Kernel32Defs.ENABLE_PROCESSED_INPUT);
		// ENABLE_PROCESSED_INPUT must remain off to prevent Ctrl-C from beeing
		// processed by the system
		// while the program is not within getwch().
		if (!wait && msvcrt._kbhit() == 0) {
			return -2;
		} // no key available
		return getwch();
	}

	private static int getwch() {
		int c = msvcrt._getwch();
		if (c == 0 || c == 0xE0) { // Function key or arrow key
			c = msvcrt._getwch();
			if (c >= 0 && c <= 0x18FF) {
				return 0xE000 + c;
			} // construct key code in private Unicode range
			return invalidKey;
		}
		if (c < 0 || c > 0xFFFF) {
			return invalidKey;
		}
		return c;
	} // normal key

	private static synchronized void initWindows() throws IOException {
		if (initDone) {
			return;
		}
		msvcrt = Native.load("msvcrt", Msvcrt.class);
		kernel32 = Native.load("kernel32", Kernel32.class);
		// msvcrt = (Msvcrt) Native.loadLibrary("msvcrt", Msvcrt.class);
		// kernel32 = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
		try {
			consoleHandle = getStdInputHandle();
			originalConsoleMode = getConsoleMode(consoleHandle);
			stdinIsConsole = true;
		} catch (IOException e) {
			stdinIsConsole = false;
		}
		if (stdinIsConsole) {
			registerShutdownHook();
		}
		initDone = true;
	}

	private static Pointer getStdInputHandle() throws IOException {
		Pointer handle = kernel32.GetStdHandle(Kernel32Defs.STD_INPUT_HANDLE);
		if (Pointer.nativeValue(handle) == 0 || Pointer.nativeValue(handle) == Kernel32Defs.INVALID_HANDLE_VALUE) {
			throw new IOException("GetStdHandle(STD_INPUT_HANDLE) failed.");
		}
		return handle;
	}

	private static int getConsoleMode(Pointer handle) throws IOException {
		IntByReference mode = new IntByReference();
		int rc = kernel32.GetConsoleMode(handle, mode);
		if (rc == 0) {
			throw new IOException("GetConsoleMode() failed.");
		}
		return mode.getValue();
	}

	private static void setConsoleMode(Pointer handle, int mode) throws IOException {
		int rc = kernel32.SetConsoleMode(handle, mode);
		if (rc == 0) {
			throw new IOException("SetConsoleMode() failed.");
		}
	}

	private static void resetConsoleModeWindows() throws IOException {
		if (!initDone || !stdinIsConsole || !consoleModeAltered) {
			return;
		}
		setConsoleMode(consoleHandle, originalConsoleMode);
		consoleModeAltered = false;
	}
}
