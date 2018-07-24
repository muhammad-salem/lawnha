package org.terminal.ansi;

import org.junit.Test;

public class CursorControlTest {

	public static void main(String[] args) throws InterruptedException {
		CursorControl cursor = new CursorControl() {};
		String str = "foo:fooo:foo";
		System.out.println(str);
		System.out.print(cursor.cursorFirst("!no good\n hi three\n\n\n\n\n\n\n\n\n\n\n\n.hi gain"));
		
		
		
		System.out.print(str);
		System.out.print(cursor.cursorFirst("!string\nline 2\nline 3\n", str.length()));
		Thread.sleep(3000);
//		System.out.println();
	}
	
	@Test
	public void CursorLineFirstTest() {
		
	}

}
