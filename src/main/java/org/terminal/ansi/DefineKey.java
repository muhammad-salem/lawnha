package org.terminal.ansi;

public interface DefineKey {
	
	/**
	 * Associates a string of text to a keyboard key. 
	 * {key} indicates the key by its ASCII value in decimal
	 */
	
	default String SetKeyDefinition(int keyASCII, String string) {
		return "\u001B["+keyASCII + ';'+ string+'p';
	}

}
