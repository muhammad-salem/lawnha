package org.terminal.console.support;

public interface Logger {
    
    /**
    * The logger operation accepts a log level and a list of other arguments.
    * Its main output is the implementation-defined side effect of printing the
    * result to the console. This specification describes how it processes format
    * specifiers while doing so.
    * 1- If args is empty, return.
    * 2- Let first be args[0].
    * 3- Let rest be all elements following first in args.
    * 4- If rest is empty, perform Printer(logLevel, « first ») and return.
    * 5- If first does not contain any format specifiers, perform Printer(logLevel, args).
    * 6- Otherwise, perform Printer(logLevel, Formatter(args)).
    * 7- Return undefined.
    *
    * @param logLevel String
    * @param args array of Objects
    */
    void log(String logLevel, Object ...args);
    
}
