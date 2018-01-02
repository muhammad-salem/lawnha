package org.terminal.ansi.display;

public enum ForegroundColours {
	Black(30),
	Red(31),
	Green(32),
	Yellow(33),
	Blue(34),
	Magenta(35),
	Cyan(36),
	White(37);
	
	private int code;
	private ForegroundColours(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return  "\u001B["+code+"m";
	}
}
