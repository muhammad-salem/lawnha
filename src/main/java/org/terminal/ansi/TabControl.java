package org.terminal.ansi;

public interface TabControl {
	
	/**
	 * Sets a tab at the current position.
	 */
	 String SetTab = "\u001BH";
	 
	 /**
	  * Clears tab at the current position.
	  */
	 String ClearTab = "\u001B[g";
	 
	 /**
	  * Clears all tabs.
	  */
	 String ClearAllTabs = "\u001B[3g";
}
