package org.terminal.ansi.display;

public enum StandardAttributes {
	ResetAllAttributes(0),
	Bright(1),
	Dim(2),
	Underscore(4),	
	Blink(5),
	Reverse(7),
	Hidden(8);
	
	private int code;
	private StandardAttributes(int code) {
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
