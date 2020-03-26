package org.terminal.console.api;

import java.io.PrintStream;
import java.util.stream.Stream;

import org.terminal.ansi.Colors;
import org.terminal.ansi.ErasingText;

/**
* This specification is an early work in progress that welcomes feedback to refine
* toward more precise and compatible definitions. It is also the editors' first specification,
* so please be kind and constructive.
* see https://console.spec.whatwg.org/
*/
public class ConsoleImpl implements Logging, Grouping, Counting, Timing,
								Colors, ErasingText {

	protected PrintStream printStream;
	
	public ConsoleImpl(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void time(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timeLog(String label, Object... data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timeEnd(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void count(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void countReset(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void group(Object... data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void group(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupCollapsed(Object... data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupCollapsed(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupEnd() {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public void assertions(Boolean assertion, String message, Object... args) {
		if (!assertion.booleanValue()) {
			message = redLightbg(message).concat("\n");
			printStream.printf(message, args);
		}
	}

	@Override
	public void clear() {
		printStream.print(EraseScreen);
	}

	@Override
	public void debug(String message, Object... data) {
		message = cyanLightbg(blue(message)).concat("\n");
		printStream.printf(message, data);
	}

	@Override
	public void error(String message, Object... data) {
		message = redbg(message).concat("\n");
		printStream.printf(message, data);
	}


	@Override
	public void warn(String message, Object... data) {
		message = redLightbg(message).concat("\n");
		printStream.printf(message, data);
	}

	@Override
	public void trace(String message) {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		printStream.print(YellowLightbg);
		printStream.print(Blue);
		printStream.print(message);
		for (int i = 3; i < trace.length; i++) {
			printStream.print("\n\tat " + trace[i]);
		}
		printStream.print(DefaultColor);
		printStream.println(DefaultColorbg);
//		try {
//			throw new Exception(message);
//		} catch (Exception e) {
//			printStream.print(YellowLightbg);
//			printStream.print(Blue);
//			e.printStackTrace(printStream);
//			printStream.println(DefaultColor);
//			printStream.println(DefaultColorbg);
//		}
	}

	@Override
	public void info(String message, Object... data) {
		message = greenLight(message).concat("\n");
		printStream.printf(message, data);
	}

	@Override
	public void log(String message, Object... data) {
		message = grayLight(message).concat("\n");
		printStream.printf(message, data);
	}

	@Override
	public <T> void table(T data, Stream<String> properties) {
		
	}

	@Override
	public void dir(Object item, Object options) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dirxml(Object... data) {
		// TODO Auto-generated method stub
		
	}
	
}
