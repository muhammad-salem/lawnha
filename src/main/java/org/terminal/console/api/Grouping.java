package org.terminal.console.api;


/**
* A group is an implementation-specific, potentially-interactive view for output produced
* by calls to Printer, with one further level of indentation than its parent.
* Each console namespace object has an associated group stack, which is a stack,
* initially empty. Only the last group in a group stack will host output produced
* by calls to Printer.
 */
public interface Grouping {
    
    // Grouping
    /**
    * Creates a new inline group in the Web Console log.
    * This indents following console messages by an additional level,
    * until console.groupEnd() is called.
    *
    * - Let group be a new group.
    * - If data is not empty, let groupLabel be the result of Formatter(data). Otherwise, let groupLabel be an implementation-chosen label representing a group.
    * - Incorporate groupLabel as a label for group.
    * - Optionally, if the environment supports interactive groups, group should be expanded by default.
    * - Perform Printer("group", « group »).
    * - Push group onto the appropriate group stack.
    *
    * @param data array of objects
    */
    void group(Object ...data);
    void group(String label);
    
    /**
    * Creates a new inline group in the Web Console. Unlike console.group(), 
    * however, the new group is created collapsed.
    * The user will need to use the disclosure button next to it to expand it,
    * revealing the entries created in the group.
    * Call console.groupEnd() to back out to the parent group.
    * 
    * - Let group be a new group.
    * - If data is not empty, let groupLabel be the result of Formatter(data). Otherwise, let groupLabel be an implementation-chosen label representing a group.
    * - Incorporate groupLabel as a label for group.
    * - Optionally, if the environment supports interactive groups, group should be collapsed by default.
    * - Perform Printer("groupCollapsed", « group »).
    * - Push group onto the appropriate group stack.
    *
    * @param data array of objects
    */
    void groupCollapsed(Object ...data);
    void groupCollapsed(String label);

    /**
    * Exits the current inline group in the Web Console.
    * See Using groups in the console in the console documentation for details and examples.
    * 
    * - Pop the last group from the group stack.
    */
    void groupEnd();
}
