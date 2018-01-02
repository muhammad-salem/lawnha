package org.terminal.ansi;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public interface ANSI 
		extends DeviceStatus, 
				TerminalSetup, 
				Fonts, 
				CursorControl, 
				Scrolling, 
				TabControl,
				ErasingText,
				Printing,
				DefineKey,
				DisplayAttributes{
	
	default int[] getCursorPosition() throws Exception {
		
//		System.out.print( SaveCursor);
		System.out.print( QueryCursorPosition);
		byte[] b = new byte[20];
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		int x = System.in.read(b);
		String temp = new String(b, 0, x);
		System.out.print(CursorBackward(x));
		System.out.print(CursorUp);
		System.out.print( EraseEndofLine );
		
		return extractReportCursorPosition(temp);
	}
	
	
//	/**
//	 * need to press enter
//	 * @return
//	 * @throws Exception
//	 */
//	default int[] CursorPosition() throws Exception {
//		System.out.print( QueryCursorPosition);
//		String temp = new InputStream() {
//			
//			
//			public String getTemp() throws Exception {
//				byte[] bytes = new byte[20];
//				int x = read(bytes);
//				return new String(bytes, 0, x);
//			}
//			boolean endCode = false;
//			boolean firstTime = true;
//			@Override
//			public int read() throws IOException {
//				if(endCode) {
//					return -1;
//				}
//				if(firstTime) {
//					try {
//						Robot r = new Robot();
//						r.keyPress(KeyEvent.VK_ENTER);
//						r.keyRelease(KeyEvent.VK_ENTER);
//					} catch (Exception e) {
//					}
//					firstTime = false;
//				}
//				char key = (char) System.in.read();
//				if(key == 'R') {
//					endCode = true;
//					firstTime = true;
//				}
//				return (int) key;
//			}
//		}.getTemp();
//		System.out.print(CursorBackward(temp.length()));
//		System.out.print(CursorUp);
//		System.out.print( EraseEndofLine );
//		return extractReportCursorPosition(temp);
//	}
}
