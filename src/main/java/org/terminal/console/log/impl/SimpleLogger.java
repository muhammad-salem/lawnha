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
			printer.log(Level.warn, null, null, message);
		}
	}
	@Override
	public void error(String message) {
		printer.log(Level.error, null, null, message);
	}
	@Override
	public void warn(String message) {
		printer.log(Level.warn, null, null, message);
		
	}
	@Override
	public void info(String message) {
		printer.log(Level.info, null, null, message);
	}
	@Override
	public void debug(String message) {
		printer.log(Level.debug, null, null, message);
	}
	@Override
	public void trace(String message) {
		printer.log(Level.trace, null, null, message);
	}
	@Override
	public void log(String message) {
		printer.log(Level.log, null, null, message);
	}
	@Override
	public void assertions(Boolean assertions, Class<?> classname, String message) {
		if (assertions) {
			printer.log(Level.warn, classname, null, message);
		}
	}
	@Override
	public void error(Class<?> classname, String message) {
		printer.log(Level.error, classname, null, message);
	}
	@Override
	public void warn(Class<?> classname, String message) {
		printer.log(Level.warn, classname, null, message);
	}
	@Override
	public void info(Class<?> classname, String message) {
		printer.log(Level.info, classname, null, message);
	}
	@Override
	public void debug(Class<?> classname, String message) {
		printer.log(Level.debug, classname, null, message);
	}
	@Override
	public void trace(Class<?> classname, String message) {
		printer.log(Level.trace, classname, null, message);
	}
	@Override
	public void log(Class<?> classname, String message) {
		printer.log(Level.log, classname, null, message);
	}
	@Override
	public void assertions(Boolean assertions, String title, String message) {
		if (assertions) {
			printer.log(Level.warn, null, title, message);
		}
	}
	@Override
	public void error(String title, String message) {
		printer.log(Level.error, null, title, message);
	}
	@Override
	public void warn(String title, String message) {
		printer.log(Level.warn, null, title, message);
	}
	@Override
	public void info(String title, String message) {
		printer.log(Level.info, null, title, message);
	}
	@Override
	public void debug(String title, String message) {
		printer.log(Level.debug, null, title, message);
	}
	@Override
	public void trace(String title, String message) {
		printer.log(Level.warn, null, title, message);
	}
	@Override
	public void log(String title, String message) {
		printer.log(Level.log, null, title, message);
	}
	@Override
	public void assertions(Boolean assertions, Class<?> classname, String title, String message) {
		if (assertions) {
			printer.log(Level.warn, classname, title, message);
		}
	}
	@Override
	public void error(Class<?> classname, String title, String message) {
		printer.log(Level.error, classname, title, message);
	}
	@Override
	public void warn(Class<?> classname, String title, String message) {
		printer.log(Level.warn, classname, title, message);
	}
	@Override
	public void info(Class<?> classname, String title, String message) {
		printer.log(Level.info, classname, title, message);
	}
	@Override
	public void debug(Class<?> classname, String title, String message) {
		printer.log(Level.debug, classname, title, message);
	}
	@Override
	public void trace(Class<?> classname, String title, String message) {
		printer.log(Level.trace, classname, title, message);
	}
	@Override
	public void log(Class<?> classname, String title, String message) {
		printer.log(Level.log, classname, title, message);
	}
}
