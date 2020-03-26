package org.terminal.console.api;

import java.util.Arrays;
import java.util.Objects;

public interface Assertions {

    /**
    * The console.assertions() method writes an error message to the console if the assertion is false.
    * If the assertion is true, nothing happens.
    * 
    * If condition is true, return.
    * Let message be a string without any formatting specifiers indicating generically an assertion failure (such as "Assertion failed").
    * If data is empty, append message to data.
    * Otherwise:
    *     Let first be data[0].
    *     If Type(first) is not String, then prepend message to data.
    *     Otherwise:
    *         Let concat be the concatenation of message, U+003A (:), U+0020 SPACE, and first.
    *         Set data[0] to concat.
    * Perform Logger("assert", data).
    * 
    * @param assertion Any boolean expression. If the assertion is false, the message is written to the console. 
    * @param data A list of Java objects to output. The string representations of each of these objects 
    * are appended together in the order listed and output
    *
    * The console.assertions() method writes an error message to the console if the assertion is false.
    * If the assertion is true, nothing happens.
    * @param assertion Any boolean expression. If the assertion is false, the message is written to the console. 
    * @param message A Java string containing zero or more substitution strings
    * @param data Java objects with which to replace substitution strings within message. 
    *    This parameter gives you additional control over the format of the output.
    */
    void assertions(Boolean assertion, String message, Object ...data);
    
    default void assertTrue(Boolean condition, String message, Object ...data) {
    	assertions(Boolean.TRUE.equals(condition), message, data);
    }
    default void assertFalse(Boolean condition, String message, Object ...data) {
    	assertions(Boolean.FALSE.equals(condition), message, data);
    }
    default void assertNull(Object object, String message, Object ...data) {
    	assertions(Objects.isNull(object), message, data);
    }
    default void assertNotNull(Object object, String message, Object ...data) {
    	assertions(Objects.nonNull(object), message, data);
    }
    default void assertSame(Object expected, Object actual, String message, Object ...data) {
    	assertions(expected.equals(actual), message, data);
    }
    default void assertNotSame(Object expected, Object actual, String message, Object ...data) {
    	assertions(!expected.equals(actual), message, data);
    }
    default void assertEquals(Object expected, Object actual, String message, Object ...data){
    	assertions(expected.equals(actual), message, data);
    }
    default void assertArrayEquals(Object[] expected, Object[] actual, String message, Object ...data){
    	assertions(Arrays.equals(expected, actual), message, data);
    }
    default void fail(String message, Object ...data) {
    	assertions(false, message, data);
    }
    default void assertEquals( Double expected, Double actual, Double delta,
    		String message, Object ...data) {
    	assertions(Math.abs( expected - actual ) <= delta, message, data);
    }

}
