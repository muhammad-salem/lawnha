package org.terminal.ansi.display;

import org.terminal.ansi.AnsiBase;

public interface AttributeUnit extends AnsiBase{
	
	
	int baseCode();
	int secondCode();
	
	
	public default String baseString() {
		return escape_sequences + baseCode() + 'm';
	}
	
	public default String slaveString() {
		return escape_sequences + secondCode() + 'm';
	}
	
	

}
