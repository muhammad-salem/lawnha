package org.terminal.console.log.api;

import org.terminal.console.log.Level;
import org.terminal.console.log.model.LogMessage;

public interface Printer {
	void print(Level level, Class<?> classname, String title, String message);
	
	default void print(LogMessage message) {
		print(message.getLevel(), message.getClass(), message.getTitle(), message.getMessage());
	}
}
