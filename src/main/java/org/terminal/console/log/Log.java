package org.terminal.console.log;

import org.terminal.console.log.api.Logger;
import org.terminal.console.log.api.Printer;
import org.terminal.console.log.impl.LevelLoggerImpl;


public final class Log {
	private Log() {}

	private static LevelLoggerImpl logger = new LevelLoggerImpl();
	
	public static void level(String levelName) {
		logger.setLevel(Level.valueOf(levelName));
	}

	public static void setLevel(Level level) {
		logger.setLevel(level);
	}

	public static void setLogger(LevelLoggerImpl logger) {
		Log.logger = logger;
	}

	public static void setPrinter(Printer printer) {
		logger.setPrinter(printer);
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void log(String message) {logger.log(message);}
	public static void error(String message) {logger.error(message);}
	public static void warn(String message) {logger.warn(message);}
	public static void info(String message) {logger.info(message);}
	public static void assertions(Boolean assertions, String message) {logger.assertions(assertions, message);}
	public static void debug(String message) {logger.debug(message);}
	public static void trace(String message) {logger.trace(message);}

	public static void log(Class<?> classname, String message) {logger.log(classname, message);}
	public static void error(Class<?> classname, String message) {logger.error(classname, message);}
	public static void warn(Class<?> classname, String message) {logger.warn(classname, message);}
	public static void info(Class<?> classname, String message) {logger.info(classname, message);}
	public static void assertions(Boolean assertions, Class<?> classname, String message) {logger.assertions(assertions, classname, message);}
	public static void debug(Class<?> classname, String message) {logger.debug(classname, message);}
	public static void trace(Class<?> classname, String message) {logger.trace(classname, message);}

	public static void log(String title, String message) {logger.log(title, message);}
	public static void error(String title, String message) {logger.error(title, message);}
	public static void warn(String title, String message) {logger.warn(title, message);}
	public static void info(String title, String message) {logger.info(title, message);}
	public static void assertions(Boolean assertions, String title, String message) {logger.assertions(assertions, title, message);}
	public static void debug(String title, String message) {logger.debug(title, message);}
	public static void trace(String title, String message) {logger.trace(title, message);}

	public static void log(Class<?> classname, String title, String message)
							{logger.log(classname, title, message);}
	public static void error(Class<?> classname, String title, String message)
							{logger.error(classname, title, message);}
	public static void warn(Class<?> classname, String title, String message)
							{logger.warn(classname, title, message);}
	public static void info(Class<?> classname, String title, String message)
							{logger.info(classname, title, message);}
	public static void assertions(Boolean assertions, Class<?> classname, String title, String message)
							{logger.assertions(assertions, classname, title, message);}
	public static void debug(Class<?> classname, String title, String message)
							{logger.debug(classname, title, message);}
	public static void trace(Class<?> classname, String title, String message)
							{logger.trace(classname, title, message);}
}
