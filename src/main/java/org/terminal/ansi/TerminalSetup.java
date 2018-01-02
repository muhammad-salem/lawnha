package org.terminal.ansi;

/**
 * The h and l codes are used for setting terminal/display mode, 
 * and vary depending on the implementation. 
 * Line Wrap is one of the few setup codes that tend to be used consistently
 * @author salem
 *
 */
public interface TerminalSetup {
	/**
	 * Reset all terminal settings to default.
	 */
    String ResetDevice = "\u001Bc";
    /**
     * Text wraps to next line if longer than the length of the display area.
     */
    String EnableLineWrap = "\u001B[7h";
    /**
     * Disables line wrapping.
     */
    String DisableLineWrap = "\u001B[7l";
}
