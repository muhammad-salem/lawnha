package org.terminal.console.api;

/**
* Each console namespace object has an associated timer table,
* which is a map of strings to times, initially empty.
*/
public interface Timing {

    /**
    * 
    * - If the associated timer table contains an entry with key label, return,
    *    optionally reporting a warning to the console indicating
    *    that a timer with label label has already been started.
    * - Otherwise, set the value of the entry with key label in the associated
    *     timer table to the current time.
    */
    void time(String label);
    default void time(){
        time("default");
    }
    /**
    * 
    *
    * - Let timerTable be the associated timer table.
    * - Let startTime be timerTable[label].
    * - Let duration be a string representing the difference between the current time and startTime, in an implementation-defined format.
    "4650", "4650.69 ms", "5 seconds", and "00:05" are all reasonable ways of displaying a 4650.69 ms duration.
    * - Let concat be the concatenation of label, U+003A (:), U+0020 SPACE, and duration.
    * - Prepend concat to data.
    * - Perform Printer("timeLog", data).
    * 
    * The data parameter in calls to timeLog() is included in the call to Logger to make it
    * easier for users to supply intermediate timer logs with some extra data throughout
    * the life of a timer. For example:
    * <code>
    * console.time("MyTimer");
    * console.timeLog("MyTimer", "Starting application up…");
    * // Perhaps some code runs to bootstrap a complex app
    * // ...
    * console.timeLog("MyTimer", "UI is setup, making API calls now");
    * // Perhaps some fetch()'s here filling the app with data
    * // ...
    * console.timeEnd("MyTimer");
    * </code>
    */
    void timeLog(String label, Object ...data);
    default void timeLog(Object ...data){
    	timeLog("default", data);
    }
    
    /**
    * 
    *
    * - Let timerTable be the associated timer table.
    * - Let startTime be timerTable[label].
    * - Remove timerTable[label].
    * - Let duration be a string representing the difference between the current time and startTime, in an implementation-defined format.
    * - Let concat be the concatenation of label, U+003A (:), U+0020 SPACE, and duration.
    * - Perform Printer("timeEnd", « concat »).
    */
    void timeEnd(String label);
    default void timeEnd(){
    	timeEnd("default");
    }

}
