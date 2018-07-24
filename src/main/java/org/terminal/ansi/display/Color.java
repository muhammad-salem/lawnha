package org.terminal.ansi.display;

import org.terminal.ansi.AnsiBase;

public enum Color implements AnsiBase{
	
	BLACK(30),
	RED(31),
	GREEN(32),
	YELLOW(33),
	BLUE(34),
	MAGENTA(35),
	CYAN(36),
	WHITE(37),
	
	DEFAULT(39);

	
	private int color;
	private int bgcolor;
	private int lite;
	private int bglite;
	private Color(int code) {
		this.color		= code;
		this.bgcolor	= code + 10;
		this.lite		= code + 60;
		this.bglite		= code + 70;
	}
	
	
	public String colorString() {
		return escape_sequences + color + 'm';
	}
	
	public String bgColorString() {
		return escape_sequences + bgcolor + 'm';
	}
	

	public String liteString() {
		return escape_sequences + lite + 'm';
	}
	
	public String bgLiteString() {
		return escape_sequences + bglite + 'm';
	}
	
	public int color() {
		return color;
	}
	public int bgColor() {
		return bgcolor;
	}
	
	public int lite() {
		return lite;
	}
	public int bgLite() {
		return bglite;
	}
	
	

	@Override
	public String toString() {
		return name();
	}
	

}
