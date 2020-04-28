package org.terminal.console.log.api;

import org.terminal.console.log.Level;

public interface Message {

	Level getLevel();

	Class<?> getClassname();

	String getTitle();

	String getMessage();

	String toString();

}