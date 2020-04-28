package org.terminal.console.log.model;

import org.terminal.console.log.Level;

public class LogMessage {

	private Level level;
	private Class<?> classname;
	private String title;
	private String message;


	public LogMessage(Level level, String message) {
		this.level = level;
		this.message = message;
	}
	
	public LogMessage(Level level, String title, String message) {
		this.level = level;
		this.title = title;
		this.message = message;
	}
	
	public LogMessage(Level level, Class<?> classname, String message) {
		this.level = level;
		this.classname = classname;
		this.message = message;
	}
	
	public LogMessage(Level level, Class<?> classname, String title, String message) {
		this.level = level;
		this.classname = classname;
		this.title = title;
		this.message = message;
	}
	
	
	

	public Level getLevel() {
		return level;
	}

	public Class<?> getClassname() {
		return classname;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		StringBuilder log = new StringBuilder();
		log.append("[ " + level.toString() + " ] ");
		if (classname != null)
			log.append("[ " + classname.getSimpleName() + " ] ");
		if (title != null)
			log.append("[ " + title + " ]");
		String line = log.toString();
		return line + " " + message.replace("\n", "\n" + line + " ");
	}

}