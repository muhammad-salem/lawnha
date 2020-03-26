package org.terminal.console;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.terminal.console.api.ConsoleImpl;

public final class Console {
	private Console() {}
	
	private static ConsoleImpl console = new ConsoleImpl(System.out);
	
	public static void time(){time("default");}
	public static void timeLog(Object ...data){timeLog("default", data);}
	public static void timeEnd(){timeEnd("default");}
	public static void time(String label) {console.time(label);}
	public static void timeLog(String label, Object... data) {console.timeLog(label, data);}
	public static void timeEnd(String label) {console.timeEnd(label);}

	
	public static  void count(){count("default");}
	public static  void countReset(){count("default");}
	public static void count(String label) {console.count(label);}
	public static void countReset(String label) {console.countReset(label);}

	
	public static void group(Object... data) {console.group(data);}
	public static void group(String label) {console.group(label);}
	public static void groupCollapsed(Object... data) {console.groupCollapsed(data);}
	public static void groupCollapsed(String label) {console.groupCollapsed(label);}
	public static void groupEnd() {console.groupEnd();}
	
	
	public static void clear() {console.clear();}
	public static void debug(String message, Object... data) {console.debug(message, data);}
	public static void error(String message, Object... data) {console.error(message, data);}
	public static void warn(String message, Object... data) {console.warn(message, data);}
	public static void trace(String message) {console.trace(message);}
	public static void info(String message, Object... data) {console.info(message, data);}
	public static void log(String message, Object... data) {console.log(message, data);}
	
	public static void assertions(Boolean assertion, String message, Object... args) {
		console.assertions(assertion, message, args);
	}
	public static void assertTrue(Boolean condition, String message, Object ...data) {
    	assertions(Boolean.TRUE.equals(condition), message, data);
    }
    public static void assertFalse(Boolean condition, String message, Object ...data) {
    	assertions(Boolean.FALSE.equals(condition), message, data);
    }
    public static void assertNull(Object object, String message, Object ...data) {
    	assertions(Objects.isNull(object), message, data);
    }
    public static void assertNotNull(Object object, String message, Object ...data) {
    	assertions(Objects.nonNull(object), message, data);
    }
    public static void assertSame(Object expected, Object actual, String message, Object ...data) {
    	assertions(expected.equals(actual), message, data);
    }
    public static void assertNotSame(Object expected, Object actual, String message, Object ...data) {
    	assertions(!expected.equals(actual), message, data);
    }
    public static void assertEquals(Object expected, Object actual, String message, Object ...data){
    	assertions(expected.equals(actual), message, data);
    }
    public static void assertArrayEquals(Object[] expected, Object[] actual, String message, Object ...data){
    	assertions(Arrays.equals(expected, actual), message, data);
    }
    public static void fail(String message, Object ...data) {
    	assertions(false, message, data);
    }
    public static void assertEquals( Double expected, Double actual, Double delta,
    		String message, Object ...data) {
    	assertions(Math.abs( expected - actual ) <= delta, message, data);
    }
    


	public static <T> void table(T data, Stream<String> properties) {console.table(data, properties);}
	public static void dir(Object item, Object options) {console.dir(item, options);}
	public static void dirxml(Object... data) {console.dirxml(data);}
}
