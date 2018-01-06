package org.terminal.ansi;

import org.terminal.ansi.display.Attribute;
import org.terminal.ansi.display.Colour;

public interface DisplayAttr extends Colours{
	
	default String SetAttributeMode(Attribute attr) {
		return attr.toString();
	}
	
	default String getAttributeFormt(int... attrs) {
		String terminalDisplaycode = new String() ;
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode += ';' + attrs[i];
		}
		return terminalDisplaycode;
	}
	default String SetAttributeMode(int... attrs) {
		String terminalDisplaycode = "\u001B[" + attrs[0] ;
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode += ';' + attrs[i];
		}
		terminalDisplaycode += 'm';
		return terminalDisplaycode;
	}
	
	default String SetAttributeMode(Attribute... attrs) {
		String terminalDisplaycode = "\u001B[" + attrs[0].getCode() ;
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode += ';' + attrs[i].getCode();
		}
		terminalDisplaycode += 'm';
		return terminalDisplaycode;
	}
	
	default String getAttributeFormt(Attribute... attrs) {
		String terminalDisplaycode = new String() ;
		for (int i = 0; i < attrs.length; i++) {
			if (i > 0) {
				terminalDisplaycode +=  ';';
			}
			terminalDisplaycode +=  attrs[i].getCode();
			
		}
		return terminalDisplaycode;
	}
	
	
	default String SetAttributeMode(Attribute attr, Colour colour) {
		return "\u001B[" + attr.getCode() + ';' + colour.getCode() + "m";
	}
	
	default String SetAttributeMode(Colour fgColour, Colour bgcolour) {
		return "\u001B[" + fgColour.getCode() + ';' + bgcolour.getCode()+10 + "m";
	}
	
	default String SetAttributeMode(Attribute attr, Colour fgColour, Colour bgcolour) {
		return "\u001B[" + attr.getCode() + ';' + fgColour.getCode() + ';' + bgcolour.getCode()+10 + "m";
	}
	
	default String SetAttributeMode(int attr, int fgColour, int bgcolour) {
		return "\u001B[" + attr + ';' + fgColour + ';' + bgcolour + "m";
	}
	
	default String SetAttributeMode(int code1, int code2) {
		return "\u001B[" + getAttributeFormt(code1, code2) + "m";
	}
	
	default String SetAttributeMode(int code) {
		return "\u001B[" + code + "m";
	}
	
	
	
	String ResetAllAttributes = Attribute.ResetAllAttributes.toString();
	String Bright = Attribute.Bright.toString();
	String Dim = Attribute.Dim.toString();
	String Italic = Attribute.Italic.toString();
	String Underscore = Attribute.Underline.toString();
	String Blink = Attribute.Blink.toString();
	String Reverse = Attribute.Reverse.toString();
	String Hidden = Attribute.Hidden.toString();
	String CrossedOut = Attribute.CrossedOut.toString();
	
	String Fraktur = Attribute.Fraktur.toString();
	String BoldOff = Attribute.BoldOff.toString();
	String Intensity = Attribute.Intensity.toString();
	String NOItalic = Attribute.NOItalic.toString();
	String NOUnderline = Attribute.NOUnderline.toString();
	String NOBlink = Attribute.NOBlink.toString();
	String NOReverse = Attribute.NOReverse.toString();
	String Reveal = Attribute.Reveal.toString();
	String NotCrossedOut = Attribute.NotCrossedOut.toString();
	
	String Framed = Attribute.Framed.toString();
	String Ncircled = Attribute.Ncircled.toString();
	String Overlined = Attribute.Overlined.toString();
	String NotframedOrEncircled = Attribute.NotframedOrEncircled.toString();
	String NotOverLined = Attribute.NotOverLined.toString();
	
	String IdeogramRightSideLine = Attribute.IdeogramRightSideLine.toString();
	String IdeogramRightSideDoubleLine = Attribute.IdeogramRightSideDoubleLine.toString();
	String IdeogramLeftSideLine = Attribute.IdeogramLeftSideLine.toString();
	String IdeogramLeftSideDoubleLine = Attribute.IdeogramLeftSideDoubleLine.toString();
	String IdeogramIdeogramStressMarking = Attribute.IdeogramIdeogramStressMarking.toString();
	String IdeogramAttributesOff = Attribute.IdeogramAttributesOff.toString();
	
	
	
}
