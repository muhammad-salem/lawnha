package org.terminal.console.api;

import java.util.stream.Stream;

public interface Logging {
    

    /**
    * The console.clear() method clears the console if the environment allows it.
    * Empty the appropriate group stack.
    * If possible for the environment, clear the console. (Otherwise, do nothing.)
    */
    void clear();
    
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

    /**
    * Perform Logger("debug", data).
    * @param message A Java string containing zero or more substitution strings
    * @param data Java objects with which to replace substitution strings within message.
    */
    void debug(String message, Object... data);
    
    /**
    * Perform Logger("error", data).
    * @param message A Java string containing zero or more substitution strings
    * @param data Java objects with which to replace substitution strings within message.
    */
    void error(String message, Object... data);
    
    /**
     * Perform Logger("warn", data).
     * @param message A Java string containing zero or more substitution strings
     * @param data Java objects with which to replace substitution strings within message.
     */
    void warn(String message, Object... data);
    
    /**
     *
     * Let trace be some implementation-specific, potentially-interactive representation of
     *  the callstack from where this function was called.
     * Optionally, let formattedData be the result of Formatter(data), and incorporate
     * formattedData as a label for trace.
     * Perform Printer("trace", « trace »).
     * @param message A Java string containing zero or more substitution strings
     */
    void trace(String message);
    
    /**
    * Perform Logger("info", data).
    * @param message A Java string containing zero or more substitution strings
    * @param data Java objects with which to replace substitution strings within message.
    */
    void info(String message, Object... data);
    
    /**
    * Perform Logger("log", data).
    * @param message A Java string containing zero or more substitution strings
    * @param data Java objects with which to replace substitution strings within message.
    */
    void log(String message, Object... data);
    

    /**
    * 
    * Try to construct a table with the columns of the properties of tableData 
    * (or use properties) and rows of tableData and log it with a logLevel of "log".
    * Fall back to just logging the argument if it can’t be parsed as table.
    * @param <T> This is the type parameter
    * @param data to be printed
    * @param properties Stream of String as header map to object properties
    */
    <T> void table(T data, Stream<String> properties);
    default <T>  void table(T data){
        table(data, null);
    };

    
    /**
     * Displays an interactive tree of the descendant elements of the specified XML/HTML element.
     * If it is not possible to display as an element the JavaScript Object view is shown instead.
     * The output is presented as a hierarchical listing of expandable nodes that let you see the
     * contents of child nodes.
     * Let object be item with generic Java object formatting applied.
     * Perform Printer("dir", « object », options).
     * @param item Object
     * @param options Object
     */
    void dir(Object item, Object options);
    
    /**
     * Displays an interactive tree of the descendant elements of the specified XML/HTML element.
     * If it is not possible to display as an element the JavaScript Object view is shown instead.
     * The output is presented as a hierarchical listing of expandable nodes that let you see the
     * contents of child nodes.
    * Let finalList be a new list, initially empty.
    * For each item of data:
    *     Let converted be a DOM tree representation of item if possible;
    *        otherwise let converted be item with optimally useful formatting applied.
    *     Append converted to finalList.
    * Perform Logger("dirxml", finalList).
    * @param data xml object represintation
    */
    void dirxml(Object... data);
}
