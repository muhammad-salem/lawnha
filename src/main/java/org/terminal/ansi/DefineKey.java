package org.terminal.ansi;

public interface DefineKey extends AnsiBase{
	
	/**
	 * Associates a string of text to a keyboard key. 
	 * {key} indicates the key by its ASCII value in decimal
	 *
	 * @param asciiKey int
	 * @param string String
	 * @return String as ansi Key Definition
	 */
	default String SetKeyDefinition(int asciiKey, String string) {
		return escape_sequences + asciiKey + ';' + string + 'p';
	}

}
