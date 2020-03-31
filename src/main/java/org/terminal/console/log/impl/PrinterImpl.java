package org.terminal.console.log.impl;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.terminal.Ansi;
import org.terminal.ansi.Colors;
import org.terminal.ansi.ErasingText;
import org.terminal.console.log.Level;
import org.terminal.console.log.api.AdvancedPrinter;
import org.terminal.console.log.api.Printer;

public class PrinterImpl implements Printer, AdvancedPrinter, Colors, ErasingText {
	private static final String NEW_LINE = Ansi.EraseEndofLine + "\n" + Ansi.EraseLine + "  ";

	
	private PrintStream printStream;
	public PrinterImpl(PrintStream printStream) {
		this.printStream = printStream;
	}
	
	private String dateFormatString = "hh:mm:ss a";
	private SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);

	private String hhmmss() {
		return hhmmss(System.currentTimeMillis());
	}

	private String hhmmss(final long millsecond) {
		return dateFormat.format(new Date(millsecond));
	}

	@Override
	public void print(Level level, Class<?> classname, String title, String message) {
		printStream.print(EraseEndofLine);
		printStream.print(blueLight( "( " + hhmmss() + " )"));
		printStream.print(' ');
		printStream.print(color24(("[ " + level + " ]"),  119,41,83));
		printStream.print(' ');
		if (Objects.nonNull(classname)) {
			printStream.print(yellow ("[ " + classname.getSimpleName() + " ]"));
			printStream.print(' ');
		}
		if(Objects.nonNull(title)) {
			printStream.print(green("[ " + title + " ]"));
		}
		
		printStream.print(magentaLight(" {\n"));
		printStream.print(EraseEndofLine);
		printStream.print("  ");
		char c = ' ';
		for (int i = 0; i < message.length(); i++) {
			c = message.charAt(i);
			if (c == '\n') {
				printStream.print(NEW_LINE);
			} else {
				printStream.print(c);
			}
		}
		printStream.print(magentaLight("\n}"));
		printStream.print(EraseEndofLine);
		printStream.println();
	}

}
