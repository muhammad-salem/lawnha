package org.terminal;


import org.terminal.nio.unix.UnixRawMode;
//import sun.misc.Signal;
//import sun.misc.SignalHandler;

import java.io.IOException;
import java.util.Arrays;


public class Ansi implements org.terminal.ansi.Ansi {

//	public static class WinSizeChanged implements SignalHandler {
//		CLibrary.WinSize sz = new CLibrary.WinSize();
//		@Override
//		public void handle(Signal sig) {
//			System.out.println(sig + ", " + sig.getNumber() + ", " + sig.getName());
//			System.out.println("old_ws_col:" + sz.ws_col + ", old_ws_row:" + sz.ws_row);
//			CLibrary.ioctl(CLibrary.STDOUT_FILENO, CLibrary.TIOCGWINSZ, sz);
//			System.out.println("new_ws_col:" + sz.ws_col + ", new_ws_row:" + sz.ws_row);
//		}
//	}

	public static void main(String[] args) throws IOException{
		System.out.println("Read Data:");
		System.out.println("read x: " + (char) UnixRawMode.readUnix(true));
		Ansi ansi = new Ansi(){};
		System.out.println(ansi.Underscore("string"));
		System.out.println(Ansi.QueryCursorPosition);
		System.out.println(Arrays.toString(ansi.extractReportCursorPosition(readQuery())));
		System.out.println(Ansi.SaveCursor);
		System.out.println("SaveCursor");
		System.out.print(ansi.forceCursorPosition(999,999));
		System.out.println(Ansi.QueryCursorPosition);
		System.out.println(Arrays.toString(ansi.extractReportCursorPosition(readQuery())));
		System.out.println(Ansi.UnSaveCursor);
		System.out.println("UnSaveCursor");
		System.out.println(Ansi.QueryCursorPosition);
		System.out.println(Arrays.toString(ansi.extractReportCursorPosition(readQuery())));



		System.out.println(Ansi.QueryDeviceCode);
		System.out.println(ansi.getReportDeviceCodeStr(readQuery()));

		System.out.println(Ansi.QueryDeviceStatus);
		System.out.println(readQuery());


		UnixRawMode.resetConsoleModeUnix();
	}

	public static String readQuery() throws IOException {
		byte[] chs = new byte[50];
		int ch = UnixRawMode.readUnix(true), index = 1;
		chs[0] = (byte)ch;
		System.out.println("read report: " + (char) ch);
		System.out.println("available: " + System.in.available() + " " + (System.in.available() <= 0) );

//		boolean wait = System.in.available() <= 0;

		while( (ch = UnixRawMode.readUnix(false)) > -1 ){
			System.out.print((char) ch);
			chs[index++] = (byte) ch;
		}
		System.out.println();
		System.out.println("report: " + new String(chs, 0, index) + " " + index);
		return new String(chs, 0, index);

	}

//	public static void mainResize(String[] args) {
//
//		System.out.println("CLibrary.STDOUT_FILENO : " + CLibrary.STDOUT_FILENO);
//		System.out.println("CLibrary.STDERR_FILENO : " + CLibrary.STDERR_FILENO);
//		System.out.println("CLibrary.STDIN_FILENO : " + CLibrary.STDIN_FILENO);
//
//
//		CLibrary.WinSize sz = new CLibrary.WinSize();
//		System.out.println(CLibrary.TIOCGWINSZ);
//
//		CLibrary.ioctl(CLibrary.STDOUT_FILENO, CLibrary.TIOCGWINSZ, sz);
//		System.out.println(sz.SIZEOF);
//		System.out.println(sz.ws_col + ":" + sz.ws_row);
//
//		Signal.handle(new Signal("WINCH"), new WinSizeChanged());
//
//		try {
//			for (int i = 0; i< 5; i++){
//				TimeUnit.SECONDS.sleep(1);
//				System.out.println("sleep for: " + i);
//			}
//		}catch (Exception e){}
//
//
//		CLibrary.WinSize sz2 = new CLibrary.WinSize();
//		sz2.ws_col = 110;
//		sz2.ws_row =  45;
//		CLibrary.ioctl(CLibrary.STDOUT_FILENO, CLibrary.TIOCSWINSZ, sz2);
//
//		CLibrary.WinSize sz3 = new CLibrary.WinSize();
//		CLibrary.ioctl(CLibrary.STDOUT_FILENO, CLibrary.TIOCGWINSZ, sz3);
//		System.out.println(sz3.ws_col + ":" + sz3.ws_row);
//
//
//
//
//		CLibrary.WinSize winSize = new CLibrary.WinSize();
//		System.out.println(winSize.ws_col);
//		System.out.println(winSize.ws_row);
//		System.out.println(winSize.ws_xpixel);
//		System.out.println(winSize.ws_ypixel);
////		AnsiConsole.systemInstall();
//
////		Library lib = new Library("jansi", CLibrary.class);
////		lib.load();
//
//		Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
//		System.out.println(info.size.x + " " + info.size.y);
//
//
//
//		Cell<String> cell1 = new Cell<String>(4,5, "cell\nhi ggggg");
//		Cell<String> cell2 = new Cell<String>("cell2");
//		Cell<String> cell3 = new Cell<String>("cell3");
//		Cell<String> cell4 = new Cell<String>("cell4 help again hhhjm");
//
//		Row<String> row = new Row<>();
//
//
//		StyleBuilder headStyle = new StyleBuilder();
//		StyleBuilder dataStyle = new StyleBuilder();
//		StyleBuilder borderStyle = new StyleBuilder();
//
//		headStyle.redLite();
//		borderStyle.blue();
//		dataStyle.magenta();
//
//		row.add(cell1);
//
//		System.out.println(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.TABLE));
//
//		row.add(cell2);
//		row.add(cell3);
//		row.add("help");
//		row.add("KAKA");
//		row.add("Good Boy");
//		row.add(cell4);
////
//		StringBuilder b = new StringBuilder();
////
//		b.append(row.toString(TableThemes.DEFAULT_THEME, headStyle, borderStyle, RowPosition.HEAD));
//		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
//		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
//		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
//		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
////
////		cell3.width(41);
////		cell4.padding(3);
////		dataStyle.redLite();
//		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.BOTTOM ));
////
//		System.out.println(b.toString());
//
//
//	}

}
