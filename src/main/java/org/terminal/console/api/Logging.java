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
    * Perform Logger("debug", data).
    */
    void debug(Object ...data);
    
    /**
    * Perform Logger("error", data).
    */
    void error(Object ...data);
    
    /**
    * Perform Logger("info", data).
    */
    void info(Object ...data);
    
    /**
    * Perform Logger("log", data).
    */
    void log(Object ...data);
    
    /**
    * 
    * 
    * Try to construct a table with the columns of the properties of tabularData 
    * (or use properties) and rows of tabularData and log it with a logLevel of "log".
    * Fall back to just logging the argument if it can’t be parsed as tabular.
    */
    void table(Object data, Stream<String> properties);
    default void table(Object data){
        table(data, null);
    };

    /**
     * print table foreach object
     * @param data
     */
    void table(Object ...data);

    /**
     *
     * Let trace be some implementation-specific, potentially-interactive representation of
     *  the callstack from where this function was called.
     * Optionally, let formattedData be the result of Formatter(data), and incorporate
     * formattedData as a label for trace.
     * Perform Printer("trace", « trace »).
     */
    void trace(Object ...data);
    
    /**
     * Perform Logger("warn", data).
     */
    void warn(Object ...data);
    
    /**
     * Displays an interactive tree of the descendant elements of the specified XML/HTML element.
     * If it is not possible to display as an element the JavaScript Object view is shown instead.
     * The output is presented as a hierarchical listing of expandable nodes that let you see the
     * contents of child nodes.
     * Let object be item with generic Java object formatting applied.
     * Perform Printer("dir", « object », options).
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
    */
    void dirxml(Object ...data);
}
