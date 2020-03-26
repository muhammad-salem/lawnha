package org.terminal.console.log.api;

public interface AdvancedLogger extends Logger {
	
	@Override default void assertions(Boolean assertions, String message) {assertions(assertions,null, null, message);}
	@Override default void error(String message) {error(null, null,message);}
	@Override default void warn(String message) {warn(null, null,message);}
	@Override default void info(String message) {info(null, null,message);}
	@Override default void debug(String message) {debug(null, null,message);}
	@Override default void trace(String message) {trace(null, null,message);}
	@Override default void log(String message) {log(null, null,message);}

	@Override default void assertions(Boolean assertions, Class<?> classname,String message)
	{assertions(assertions,classname, null, message);}
	@Override default void error(Class<?> classname, String message) {error(classname, null, message);}
	@Override default void warn(Class<?> classname, String message) {warn(classname, null, message);}
	@Override default void info(Class<?> classname, String message) {info(classname, null, message);}
	@Override default void debug(Class<?> classname, String message) {debug(classname, null, message);}
	@Override default void trace(Class<?> classname, String message) {trace(classname, null, message);}
	@Override default void log(Class<?> classname, String message) {log(classname, null, message);}


	@Override default void assertions(Boolean assertions, String title, String message) {
		{assertions(assertions,null,title, message);}
	}
	@Override default void error(String title, String message) {error (null, title, message);}
	@Override default void warn(String title, String message) {warn(null,title, message);}
	@Override default void info(String title, String message) {info(null,title, message);}
	@Override default void debug(String title, String message) {debug(null,title, message);}
	@Override default void trace(String title, String message) {trace(null,title, message);}
	@Override default void log(String title, String message) {log(null,title, message);}

}
