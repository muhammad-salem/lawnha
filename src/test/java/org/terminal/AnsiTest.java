package org.terminal;

import org.junit.Test;
import org.terminal.strings.AnsiStringBuilder;

public class AnsiTest {


	@Test
	public void simpleTest1() {
		String summary = "";
		Ansi ansi = new Ansi() {};
		summary += ansi.yellow("Hello ");
		summary += ansi.blue("World ");
		summary += ansi.greenbg("\ttry green background");
		System.out.println(summary);
	}

	@Test
	public void simpleTest2() {
		String summary = "";
		summary += Ansi.EraseLine + "\n";
		summary += Ansi.EraseLine + "\n";
		summary += Ansi.EraseLine + Ansi.SaveCursor;

		summary += "\r ";
		summary += Ansi.Yellow;
		summary += "Hello ";
		summary += Ansi.Reset;

		summary += Ansi.Blue;
		summary += "World!";
		summary += Ansi.Reset;

		summary += Ansi.Green;
		summary += "\ttry ANSI code with Java";
		summary += Ansi.Reset;

		summary += Ansi.UnSaveCursor;
		summary += Ansi.CursorUp;
		summary += Ansi.EraseLine;
		summary += Ansi.CursorUp;
		summary += Ansi.EraseLine;

		System.out.println(summary);
	}
	
	@Test
	public void simpleTest3() {
		AnsiStringBuilder ansiString = new AnsiStringBuilder();
		ansiString.bgBlack().white();
		ansiString.append(TabelTest.getRandomString());
		ansiString.fastBlink();
		ansiString.append('\n');
		ansiString.append(TabelTest.getRandomString());
		ansiString.append('\n');
		ansiString.append(TabelTest.getRandomString());
		System.out.println(ansiString);
	}

}
