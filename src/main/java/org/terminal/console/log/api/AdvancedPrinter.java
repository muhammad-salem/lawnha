package org.terminal.console.log.api;

import org.terminal.console.log.Level;

public interface AdvancedPrinter extends Printer {
	
//	default void assertions(Boolean assertions, String message) {
//		if (assertions) {
//			log(Level.assertion, null, null, message);
//		}
//	}
	default void error(String message) {print(Level.error, null, null,message);}
	default void warn (String message) {print(Level.warn,  null, null,message);}
	default void info (String message) {print(Level.info,  null, null,message);}
	default void debug(String message) {print(Level.debug, null, null,message);}
	default void trace(String message) {print(Level.trace, null, null,message);}
	default void log  (String message) {print(Level.log,   null, null,message);}

//	default void assertions(Boolean assertions, Class<?> classname,String message) {
//		if (assertions) {
//			log(Level.assertion, classname, null, message);
//		}
//	}
	default void error(Class<?> classname, String message) {print(Level.error, classname, null,message);}
	default void warn (Class<?> classname, String message) {print(Level.warn,  classname, null,message);}
	default void info (Class<?> classname, String message) {print(Level.info,  classname, null,message);}
	default void debug(Class<?> classname, String message) {print(Level.debug, classname, null,message);}
	default void trace(Class<?> classname, String message) {print(Level.trace, classname, null,message);}
	default void log  (Class<?> classname, String message) {print(Level.log,   classname, null,message);}


//	default void assertions(Boolean assertions, String title, String message){
//		if (assertions) {
//			log(Level.assertion, null, title, message);
//		}
//	}
	default void error(String title, String message) {print(Level.error, null, title,message);}
	default void warn (String title, String message) {print(Level.warn,  null, title,message);}
	default void info (String title, String message) {print(Level.info,  null, title,message);}
	default void debug(String title, String message) {print(Level.debug, null, title,message);}
	default void trace(String title, String message) {print(Level.trace, null, title,message);}
	default void log  (String title, String message) {print(Level.log,   null, title,message);}
	
}
