package org.terminal.ansi;

import java.util.Arrays;

public interface CursorControl extends AnsiBase{
	
	/**
	 * Sets the cursor position where subsequent text will begin. 
	 * If no row/column parameters are provided (ie. "\u001B[H"), 
	 * the cursor will move to the home position, 
	 * at the upper left of the screen. 
	 * 
	 */
	final String CursorHome = escape_sequences + 'H';
    
    /**
	 * Sets the cursor position where subsequent text will begin. 
	 * If no row/column parameters are provided (ie. "\u001B[H"), 
	 * the cursor will move to the home position, 
	 * at the upper left of the screen. 
	 * "\u001B[{ROW};{COLUMN}H"
	 */
    default String cursor(int ROW, int COLUMN) { 
    	return escape_sequences + ROW + ';' + COLUMN + 'H';
    }
    
    final String CursorColumn = escape_sequences + "1G";
    final String CursorRaw 	= escape_sequences + "0;H";
    
    /**
     * moves cursor to column n
     * @param column number of column
     * @return 
     */
    default String cursorColumn(int column) { return escape_sequences + column + 'G'; }
    /**
     * Moves the cursor up by 1 row.
     */
    final String CursorUp = escape_sequences + "1A";
    /**
     * Moves the cursor up by COUNT rows; the default count is 1. 
     * @param count the count of rows to be 
     * @return represented code for movie cursor up by count
     */
    default String cursorUp(int count) {
    	if (count <= 0) {
			return CursorUp;
		}
    	return escape_sequences + count + 'A';
    }
    /**
     * Moves the cursor down by one row.
     */
    final String CursorDown = escape_sequences + "1B";
    /**
     * Moves the cursor down by COUNT rows; the default count is 1.
     * @param count
     * @return
     */
    default String cursorDown(int count) {
    	if (count <= 0) {
			return CursorDown;
		}
    	return escape_sequences + count + 'B';
    }
    
    final String CursorForward = escape_sequences + "1C";
    /**
     * Moves the cursor forward by COUNT columns; the default count is 1.
     * @param count
     * @return
     */
    default String cursorForward(int count){ return escape_sequences + count + 'C';}
    
    final String  CursorBackward = escape_sequences + "1D";
    /**
     * Moves the cursor backward by COUNT columns; the default count is 1
     * @param count
     * @return
     */
    default String cursorBackward(int count){ return escape_sequences + count + 'D';}
    
    /**
     * Identical to Cursor Home.
     * @param row
     * @param column
     * @return
     */
    default String forceCursorPosition(int row, int column){return escape_sequences+row+';'+column+'f';}
    
    
    final String CursorNextLine = escape_sequences + "1E";
    /**
     * moves cursor to beginning of line n lines down
     * @param count
     * @return
     */
    default String cursorNextLine(int count){ return escape_sequences + count + 'E';}
    default String newln(int count) {return chars('\n', count);}
    default String chars(char c, int count){ char[] cs = new char[count]; Arrays.fill(cs, c); return new String(cs);}
    
    final String CursorPrevLine = escape_sequences + "1F";
    /**
     *  moves cursor to beginning of line n lines down
     * @param count
     * @return
     */
    default String cursorPrevLine(int count){ return escape_sequences + count + 'F';}
    
    /**
     * Save current cursor position. 
     */
    final String SaveCursor = escape_sequences + 's';
    /**
     * Restores cursor position after a Save Cursor. 
     */
    final String UnSaveCursor =	escape_sequences + 'u';
    /**
     * Save current cursor position. 
     */
    final String SaveCursorAttrs = 	escape_sequences + 7;
    /**
     * Restores cursor position after a Save Cursor. 
     */
    final String RestoreCursorAttrs =	escape_sequences + 8;
    
    /**
     * do nothing 
     * @param string
     * @return string
     */
    default String cursorLineLast(String string) {
    	// do nothing =D
    	return string;
    }
    
    /**
     * save the cursor position in the begin of string
     * @param string don't have '\n' "new line char"
     * @return a representing string plus the given input string
     */
    default String saveCursor(String string) {
    	return SaveCursor + string + UnSaveCursor;
    }
    
    /**
     * will check for number on '\n' in code 
     * if the string terminated by new line... will remove 
     * @param string
     * @return
     */
    default String cursorFirst(final String string) {
    	return cursorFirst(string, 0); 
    }
    
    
    
    /**
     * Previous 
     * @param string
     * @param previousCharLength length of the written char in the current line
     * @return
     */
    default String cursorFirst(final String string, int previousCharLength) {
    	String[] lines = string.split("\n");
    	int i = string.charAt(string.length()-1) == '\n' ? 1 : 0;
    	return string + cursorPrevLine(lines.length-1 + i) + cursorForward(previousCharLength);
    }

}
