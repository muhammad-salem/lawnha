package org.terminal.console.log.api;

import org.terminal.console.log.Level;

public interface Printer {
	void print(Level level, Class<?> classname, String title, String message);
}
