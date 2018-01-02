package org.terminal.ansi;

public interface Scrolling {
	
	/**
	 * Scroll display down one line
	 */
	String ScrollDown = "\u001BD";
	
	/**
	 * Scroll display up one line
	 */
    String ScrollUP = "\u001BM";

    /**
     * Enable scrolling for entire display.
     */
    String ScrollScreen = "\u001B[r";
    
    /**
     * Enable scrolling from row {start} to row {end}. 
     * @param start row to scroll from.
     * @param end row to scroll to.
     * @return String as code of terminal scroll 
     */
    default String ScrollScreen(int start, int end){
        return "\u001B[" + start + ';' + end + 'r';
    }
}
