package org.terminal.ansi;

public interface ErasingText {
	
	/**
	 * Erases from the current cursor position to the end of the current line. 
	 */
	String EraseEndofLine = "\u001B[0K";
	
	/**
	 * Erases from the current cursor position to the start of the current line.
	 */
    String EraseStartofLine = "\u001B[1K";
    
    /**
     * Erases the entire current line. 
     */
    String EraseLine = "\u001B[2K";
    /**
     * Erases the screen from the current line down to the bottom of the screen
     */
    String EraseDown = "\u001B[0J";
    
    /**
     * Erases the screen from the current line up to the top of the screen. 
     */
    String EraseUp = "\u001B[1J";
    
    /**
     * Erases the screen with the background color and moves the cursor to home. 
     */
    String EraseScreen = "\u001B[2J";
}
