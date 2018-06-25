package org.terminal.ansi.display;

public enum Attribute {
	ResetAllAttributes(0),
	Bright(1),
	Bold(1),
	Dim(2),
	Italic(3),
	Underline(4),	
	Blink(5),
	BlinkRapid(6),
	Reverse(7),
	Hidden(8),
	CrossedOut(9),
	
	PrimaryFont(10),
	
	Fraktur(20),
	BoldOff(21),
	Intensity(22),
	NOItalic(23),
	NOUnderline(24),	
	NOBlink(25),
	NOReverse(27),
	Reveal(28),
	NotCrossedOut(29),
	
	Framed(51),
	Ncircled(52),
	Overlined(53),
	NotFramedOrEncircled(54),
	NotOverLined(55),
	
	IdeogramRightSideLine(60),
	IdeogramRightSideDoubleLine(61),
	IdeogramLeftSideLine(62),
	IdeogramLeftSideDoubleLine(63),
	IdeogramIdeogramStressMarking(64),
	IdeogramAttributesOff(65);
	
	
	private int code;
	Attribute(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	
	@Override
	public String toString() {
		return  "\u001B["+code+'m';
	}
}
