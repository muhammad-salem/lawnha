package org.terminal.ansi.display;

public enum BackgroundColours {
	Black(40),
	Red(41),
	Green(42),
	Yellow(43),
	Blue(44),
	Magenta(45),
	Cyan(46),
	White(47);
	
	private int code;
	BackgroundColours(int code) {
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
