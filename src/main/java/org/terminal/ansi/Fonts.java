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
    
    
    String FontPrimary = "\u001B[10m";
//    String Font0 = FontPrimary;
    String Font1 = "\u001B[11m";
    String Font2 = "\u001B[12m";
    String Font3 = "\u001B[13m";
    String Font4 = "\u001B[14m";
    String Font5 = "\u001B[15m";
    String Font6 = "\u001B[16m";
    String Font7 = "\u001B[17m";
    String Font8 = "\u001B[18m";
    String Font9 = "\u001B[19m";
    
}
