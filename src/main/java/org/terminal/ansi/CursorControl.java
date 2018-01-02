package org.terminal.ansi;

public interface CursorControl {
	
	/**
	 * Sets the cursor position where subsequent text will begin. 
	 * If no row/column parameters are provided (ie. "\u001B[H"), 
	 * the cursor will move to the home position, 
	 * at the upper left of the screen. 
	 * 
	 */
    String CursorHome = "\u001B[H";
    
    /**
	 * Sets the cursor position where subsequent text will begin. 
	 * If no row/column parameters are provided (ie. "\u001B[H"), 
	 * the cursor will move to the home position, 
	 * at the upper left of the screen. 
	 * "\u001B[{ROW};{COLUMN}H"
	 */
    default String CursorHome(int ROW, int COLUMN) { return "\u001B["+ROW+';'+COLUMN+'H'; }
    String CursorCol0 = "\u001B[;0H";
    String CursorRaw0 = "\u001B[0;H";
    
    /**
     * Moves the cursor up by 1 row.
     */
    String CursorUp = "\u001B[1A";
    /**
     * Moves the cursor up by COUNT rows; the default count is 1. 
     * @param count the count of rows to be 
     * @return represented code for movie cursor up by count
     */
    default String CursorUp(int count) {
    	if (count <= 0) {
			count = 1;
		}
    	return "\u001B[" + count + 'A';
    }
    /**
     * Moves the cursor down by one row.
     */
    String CursorDown = "\u001B[1B";
    /**
     * Moves the cursor down by COUNT rows; the default count is 1.
     * @param count
     * @return
     */
    default String CursorDown(int count) {
    	if (count <= 0) {
			count = 1;
		}
    	return "\u001B[" + count + 'B';
    }
    
    String CursorForward = "\u001B[1C";
    /**
     * Moves the cursor forward by COUNT columns; the default count is 1.
     * @param count
     * @return
     */
    default String CursorForward(int count){ return "\u001B["+count+"C";}
    
    String  CursorBackward = "\u001B[1D";
    /**
     * Moves the cursor backward by COUNT columns; the default count is 1
     * @param count
     * @return
     */
    default String CursorBackward(int count){ return "\u001B["+count+"D";}
    
    /**
     * Identical to Cursor Home.
     * @param row
     * @param column
     * @return
     */
    default String ForceCursorPosition(int row, int column){return "\u001B["+row+';'+column+'f';}
    
    
    /**
     * Save current cursor position. 
     */
    String SaveCursor = 	"\u001B[s";
    /**
     * Restores cursor position after a Save Cursor. 
     */
    String UnsaveCursor =	"\u001B[u";
    /**
     * Save current cursor position. 
     */
    String SaveCursorAttrs = 	"\u001B[7";
    /**
     * Restores cursor position after a Save Cursor. 
     */
    String RestoreCursorAttrs =	"\u001B[8";

}
