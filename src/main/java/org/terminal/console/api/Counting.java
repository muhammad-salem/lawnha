package org.terminal.console.api;

/**
* Each console namespace object has an associated count map,
* which is a map of strings to numbers, initially empty.
*/
public interface Counting {

    /**
    * The console.count() method logs the number of times that this particular call to count()
    * has been called
    * @param label Optional
    * A String. If supplied, count() outputs the number of times it has been called with that label.
    * If omitted, count() behaves as though it was called with the "default" label. 
    * 
    * - Let map be the associated count map.
    * - If map[label] exists, set map[label] to map[label] + 1.
    * - Otherwise, set map[label] to 1.
    * - Let concat be the concatenation of label, U+003A (:), U+0020 SPACE, and ToString(map[label]).
    * - Perform Logger("count", « concat »).
    */
    void count(String label);
    default void count(){
        count("default");
    }

    /**
    * The console.countReset() method resets counter used with console.count().
    * 
    * Let map be the associated count map.
    * If map[label] exists, set map[label] to 0.
    * Otherwise:
    *     - Let message be a string without any formatting specifiers 
    *     indicating generically that the given label does not have an associated count.
    *     - Perform Logger("countReset", « message »);
    */
    void countReset(String label);
    default void countReset(){
        count("default");
    }
}
