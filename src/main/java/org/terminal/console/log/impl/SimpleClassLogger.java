package org.terminal.console.log.impl;

import java.io.PrintStream;

import org.terminal.console.log.api.Logger;


public class SimpleClassLogger {

	private final Class<?> clazz;
	private Logger logger;
	
	public SimpleClassLogger(Class<?> clazz) {
		this(clazz, new SimpleLogger(System.out));
	}
	public SimpleClassLogger(Class<?> clazz, PrintStream printStream) {
		this(clazz, new SimpleLogger(printStream));
	}
	public SimpleClassLogger(Class<?> clazz, Logger logger) {
		this.clazz = clazz;
		this.logger = logger;
	}
	
	
	public void assertions(Boolean assertions, String message) {
		logger.assertions(assertions,clazz, message);
	}
	public void error(String message) {
		logger.error(clazz, message);
	}
	public void warn(String message) {
		logger.warn(clazz, message);
	}
	
	public void info(String message) {
		logger.info(clazz, message);
	}
	
	public void debug(String message) {
		logger.debug(clazz, message);
	}
	
	public void trace(String message) {
		logger.trace(clazz, message);
	}
	
	public void log(String message) {
		logger.log(clazz, message);
	}
	
	public void assertions(Boolean assertions, String title, String message) {
		logger.assertions(assertions, clazz, title, message);
	}
	
	public void error(String title, String message) {
		logger.error(clazz, title, message);
	}
	
	public void warn(String title, String message) {
		logger.warn(clazz, title, message);
	}
	
	public void info(String title, String message) {
		logger.info(clazz, title, message);
	}
	
	public void debug(String title, String message) {
		logger.debug(clazz, title, message);
	}
	
	public void trace(String title, String message) {
		logger.trace(clazz, title, message);
	}
	
	public void log(String title, String message) {
		logger.log(clazz, title, message);
	}

}
