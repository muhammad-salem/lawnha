package org.terminal.console.log.api;

public interface Logger {
	
    void assertions(Boolean assertions, String message);
	void error(String message);
	void warn(String message);
	void info(String message);
	void debug(String message);
	void trace(String message);
	void log(String message);


	void assertions(Boolean assertions, Class<?> classname, String message);
	void error(Class<?> classname, String message);
	void warn(Class<?> classname, String message);
	void info(Class<?> classname, String message);
	void debug(Class<?> classname, String message);
	void trace(Class<?> classname, String message);
	void log(Class<?> classname, String message);
	
	
	void assertions(Boolean assertions, String title, String message);
	void error(String title, String message);
	void warn(String title, String message);
	void info(String title, String message);
	void debug(String title, String message);
	void trace( String title, String message);
	void log(String title, String message);


	void assertions(Boolean assertions, Class<?> classname, String title, String message);
	void error(Class<?> classname, String title, String message);
	void warn(Class<?> classname, String title, String message);
	void info(Class<?> classname, String title, String message);
	void debug(Class<?> classname, String title, String message);
	void trace(Class<?> classname, String title, String message);
	void log(Class<?> classname, String title, String message);

}
