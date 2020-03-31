package org.terminal.console.log.impl;

import java.io.PrintStream;

import org.terminal.console.log.Level;
import org.terminal.console.log.api.Logger;
import org.terminal.console.log.api.Printer;


public class SimpleLogger  implements Logger {

	private Printer printer; 
	
	public SimpleLogger() {
		this(new PrinterImpl(System.out));
	}
	public SimpleLogger(PrintStream printStream) {
		this( new PrinterImpl(printStream));
	}
	public SimpleLogger(Printer printer) {
		this.printer = printer;
	}
	
	

	
	
	@Override
	public void assertions(Boolean assertions, String message) {
		if (assertions) {
			printer.print(Level.warn, null, null, message);
		}
	}
	@Override
	public void error(String message) {
		printer.print(Level.error, null, null, message);
	}
	@Override
	public void warn(String message) {
		printer.print(Level.warn, null, null, message);
		
	}
	@Override
	public void info(String message) {
		printer.print(Level.info, null, null, message);
	}
	@Override
	public void debug(String message) {
		printer.print(Level.debug, null, null, message);
	}
	@Override
	public void trace(String message) {
		printer.print(Level.trace, null, null, message);
	}
	@Override
	public void log(String message) {
		printer.print(Level.log, null, null, message);
	}
	@Override
	public void assertions(Boolean assertions, Class<?> classname, String message) {
		if (assertions) {
			printer.print(Level.warn, classname, null, message);
		}
	}
	@Override
	public void error(Class<?> classname, String message) {
		printer.print(Level.error, classname, null, message);
	}
	@Override
	public void warn(Class<?> classname, String message) {
		printer.print(Level.warn, classname, null, message);
	}
	@Override
	public void info(Class<?> classname, String message) {
		printer.print(Level.info, classname, null, message);
	}
	@Override
	public void debug(Class<?> classname, String message) {
		printer.print(Level.debug, classname, null, message);
	}
	@Override
	public void trace(Class<?> classname, String message) {
		printer.print(Level.trace, classname, null, message);
	}
	@Override
	public void log(Class<?> classname, String message) {
		printer.print(Level.log, classname, null, message);
	}
	@Override
	public void assertions(Boolean assertions, String title, String message) {
		if (assertions) {
			printer.print(Level.warn, null, title, message);
		}
	}
	@Override
	public void error(String title, String message) {
		printer.print(Level.error, null, title, message);
	}
	@Override
	public void warn(String title, String message) {
		printer.print(Level.warn, null, title, message);
	}
	@Override
	public void info(String title, String message) {
		printer.print(Level.info, null, title, message);
	}
	@Override
	public void debug(String title, String message) {
		printer.print(Level.debug, null, title, message);
	}
	@Override
	public void trace(String title, String message) {
		printer.print(Level.warn, null, title, message);
	}
	@Override
	public void log(String title, String message) {
		printer.print(Level.log, null, title, message);
	}
	@Override
	public void assertions(Boolean assertions, Class<?> classname, String title, String message) {
		if (assertions) {
			printer.print(Level.warn, classname, title, message);
		}
	}
	@Override
	public void error(Class<?> classname, String title, String message) {
		printer.print(Level.error, classname, title, message);
	}
	@Override
	public void warn(Class<?> classname, String title, String message) {
		printer.print(Level.warn, classname, title, message);
	}
	@Override
	public void info(Class<?> classname, String title, String message) {
		printer.print(Level.info, classname, title, message);
	}
	@Override
	public void debug(Class<?> classname, String title, String message) {
		printer.print(Level.debug, classname, title, message);
	}
	@Override
	public void trace(Class<?> classname, String title, String message) {
		printer.print(Level.trace, classname, title, message);
	}
	@Override
	public void log(Class<?> classname, String title, String message) {
		printer.print(Level.log, classname, title, message);
	}
}
