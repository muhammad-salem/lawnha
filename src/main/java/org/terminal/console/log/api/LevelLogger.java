package org.terminal.console.log.api;

import org.terminal.console.log.Level;

public interface LevelLogger extends Logger {

	Level getLevel();
	void setLevel(Level level);
	boolean isAllowed(Level level);
	public Printer getPrinter();
	
}
