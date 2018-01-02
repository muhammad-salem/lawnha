package org.terminal.ansi;

/**
 * Some terminals support multiple fonts: normal/bold, swiss/italic, etc. 
 * There are a variety of special codes for certain terminals
 * @author salem
 *
 */
public interface Fonts {
	/**
	 * Set default font.
	 */
	String FontSetG0 = "\u001B(";
	/**
	 * Set alternate font.
	 */
    String FontSetG1 = "\u001B)";
}
