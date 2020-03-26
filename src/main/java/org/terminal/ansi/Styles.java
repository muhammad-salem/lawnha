package org.terminal.ansi;

import org.terminal.ansi.display.Color;
import org.terminal.ansi.display.Style;

public interface Styles extends Colors {

	default String attribute(Integer[] integers) {
		int[] ints = new int[integers.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = integers[i];
		}
		return attribute(ints);
	}

	default String attribute(int... attrs) {
		if(attrs.length <= 0 ) return "";
		StringBuilder terminalDisplaycode = new StringBuilder();
		terminalDisplaycode.append(escape_sequences + attrs[0]);
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode.append(";" + attrs[i]);
		}
		terminalDisplaycode.append(CommendDisplay);
		return terminalDisplaycode.toString();
	}

	default String attribute(Style... attrs) {
		if(attrs.length <= 0 ) return "";
		StringBuilder terminalDisplaycode = new StringBuilder();
		terminalDisplaycode.append(escape_sequences + attrs[0].getCode());
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode.append(";" + attrs[i].getCode());
		}
		terminalDisplaycode.append(CommendDisplay);
		return terminalDisplaycode.toString();
	}

	default String attribute(Style attr, Color color) {
		return escape_sequences + attr.getCode() + ';' + color.color() + CommendDisplay;
	}

	default String attribute(Color color, Color colorbg) {
		return escape_sequences + color.color() + ';' + colorbg.color() + CommendDisplay;
	}

	default String attribute(Style attr, Color color, Color colorbg) {
		return escape_sequences + attr.getCode() + ';' + color.color() + ';' + colorbg.bgColor() + CommendDisplay;
	}

	default String attribute(int attr, int color, int colorbg) {
		return escape_sequences + attr + ';' + color + ';' + colorbg + CommendDisplay;
	}

	default String attribute(int code1, int code2) {
		return escape_sequences + code1 + ";" + code2 + CommendDisplay;
	}

	default String attribute(int code) {
		return escape_sequences + code + CommendDisplay;
	}

	String Reset = Style.Reset.toString();
	String Bold = Style.Bold.toString();
	String Dim = Style.Dim.toString();
	String Italic = Style.Italic.toString();
	String Underline = Style.Underline.toString();
	String Blink = Style.Blink.toString();
	String BlinkRapid = Style.FastBlink.toString();
	String Reverse = Style.Reverse.toString();
	String Hidden = Style.Hidden.toString();
	String CrossedOut = Style.CrossedOut.toString();

	String Fraktur = Style.Fraktur.toString();
	String BoldOff = Style.Bold.slaveString();
	String Intensity = Style.Dim.slaveString();
	String ItalicOff = Style.Italic.slaveString();
	String UnderscoreOff = Style.Underline.slaveString();
	String BlinkOff = Style.Blink.slaveString();
	String ReverseOff = Style.Reverse.slaveString();
	String Reveal = Style.Hidden.slaveString();
	String NotCrossedOut = Style.CrossedOut.slaveString();

	String Framed = Style.Framed.toString();
	String Ncircled = Style.Ncircled.toString();
	String Overlined = Style.Overlined.toString();
	String NotFramedOrEncircled = Style.NotFramedOrEncircled.toString();
	String NotOverLined = Style.NotOverLined.toString();

	String IdeogramRightSideLine = Style.IdeogramRightSideLine.toString();
	String IdeogramRightSideDoubleLine = Style.IdeogramRightSideDoubleLine.toString();
	String IdeogramLeftSideLine = Style.IdeogramLeftSideLine.toString();
	String IdeogramLeftSideDoubleLine = Style.IdeogramLeftSideDoubleLine.toString();
	String IdeogramIdeogramStressMarking = Style.IdeogramIdeogramStressMarking.toString();
	String IdeogramAttributesOff = Style.IdeogramAttributesOff.toString();

	default String clearAllSpecialAttributes() {
		return Reset;
	}

	default String bold(String string) {
		return Bold + string + BoldOff;
	}

	default String dim(String string) {
		return Dim + string + Intensity;
	}

	default String italic(String string) {
		return Italic + string + ItalicOff;
	}

	default String underscore(String string) {
		return Underline + string + UnderscoreOff;
	}

	default String blink(String string) {
		return Blink + string + BlinkOff;
	}

	default String blinkSlow(String string) {
		return Blink + string + BlinkOff;
	}

	default String blinkFast(String string) {
		return BlinkRapid + string + BlinkOff;
	}

}
