package org.terminal.ansi.display;

public enum Style implements AttributeUnit{
	
	Reset(0, 0),
	Bold(1,22),
	Dim(2,22),
	Italic(3,23),
	Underline(4,24),	
	Blink(5,25),
	FastBlink(6,25),
	Reverse(7,27),
	Hidden(8,28),
	CrossedOut(9,29),
	
	PrimaryFont(10),
	
	Fraktur(20),
//	BoldOff(21),
//	Intensity(22),
//	NOItalic(23),
//	NOUnderline(24),	
//	NOBlink(25),
//	NOReverse(27),
//	Reveal(28),
//	NotCrossedOut(29),
	
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
	private int reverse = 0;
	
	Style(int code) {
		this.code = code;
	}
	Style(int code, int reverse) {
		this.code = code;
		this.reverse = reverse;
	}
	
	public int getCode() {
		return code;
	}
	
	
	@Override
	public int baseCode() {
		return code;
	}

	@Override
	public int secondCode() {
		return reverse;
	}
	

	@Override
	public String toString() {
		return baseString();
	}
	
}
