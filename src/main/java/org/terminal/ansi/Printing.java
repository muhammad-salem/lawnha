package org.terminal.ansi;


/**
 *  Some terminals support local printing
 * @author salem
 *
 */
public interface Printing {
	
	/**
	 * Print the current screen.
	 */
	String PrintScreen = "\u001B[0i";
	
	/**
	 * Print the current line. 
	 */
    String PrintLine = "\u001B[1i";
    
    /**
     * Disable log. 
     */
    String StopPrintLog = "\u001B[4i";
    
    /**
     * Start log; all received text is echoed to a printer. 
     */
    String StartPrintLog = "\u001B[5i";
}
