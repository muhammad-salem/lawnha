package org.terminal.console.log.api;

import org.terminal.console.log.Level;

public interface AdvancedPrinter extends Printer{
	
//	default void assertions(Boolean assertions, String message) {
//		if (assertions) {
//			log(Level.assertion, null, null, message);
//		}
//	}
	default void error(String message) {log(Level.error, null, null,message);}
	default void warn (String message) {log(Level.warn,  null, null,message);}
	default void info (String message) {log(Level.info,  null, null,message);}
	default void debug(String message) {log(Level.debug, null, null,message);}
	default void trace(String message) {log(Level.trace, null, null,message);}
	default void log  (String message) {log(Level.log,   null, null,message);}

//	default void assertions(Boolean assertions, Class<?> classname,String message) {
//		if (assertions) {
//			log(Level.assertion, classname, null, message);
//		}
//	}
	default void error(Class<?> classname, String message) {log(Level.error, classname, null,message);}
	default void warn (Class<?> classname, String message) {log(Level.warn,  classname, null,message);}
	default void info (Class<?> classname, String message) {log(Level.info,  classname, null,message);}
	default void debug(Class<?> classname, String message) {log(Level.debug, classname, null,message);}
	default void trace(Class<?> classname, String message) {log(Level.trace, classname, null,message);}
	default void log  (Class<?> classname, String message) {log(Level.log,   classname, null,message);}


//	default void assertions(Boolean assertions, String title, String message){
//		if (assertions) {
//			log(Level.assertion, null, title, message);
//		}
//	}
	default void error(String title, String message) {log(Level.error, null, title,message);}
	default void warn (String title, String message) {log(Level.warn,  null, title,message);}
	default void info (String title, String message) {log(Level.info,  null, title,message);}
	default void debug(String title, String message) {log(Level.debug, null, title,message);}
	default void trace(String title, String message) {log(Level.trace, null, title,message);}
	default void log  (String title, String message) {log(Level.log,   null, title,message);}
	
}
