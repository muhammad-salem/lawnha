package org.terminal.ansi;

import org.terminal.ansi.display.BackgroundColours;
import org.terminal.ansi.display.ForegroundColours;
import org.terminal.ansi.display.StandardAttributes;

public interface Colours extends DisplayAttributes{
	
	ForegroundColours red = ForegroundColours.Red;
	default String getRed(String string) {
		return    SetAttributeMode(ForegroundColours.Red) 
				+ string 
				+ SetAttributeMode(StandardAttributes.ResetAllAttributes);
	}
	
	default String getRedBackground(String string) {
	    return SetAttributeMode(BackgroundColours.Red) 
	    		+ string 
				+ SetAttributeMode(StandardAttributes.ResetAllAttributes);
	}
	
	@Deprecated
	default String getRedOnRedBackground(String string) {
	    return SetAttributeMode(ForegroundColours.Red, BackgroundColours.Red) 
	    		+ string 
				+ SetAttributeMode(StandardAttributes.ResetAllAttributes);
	}
}
