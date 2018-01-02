package org.terminal.ansi;

import org.terminal.ansi.display.BackgroundColours;
import org.terminal.ansi.display.ForegroundColours;
import org.terminal.ansi.display.StandardAttributes;

public interface DisplayAttributes {
	
	default String SetAttributeMode(StandardAttributes attr) {
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
	
	default String SetAttributeMode(StandardAttributes... attrs) {
		String terminalDisplaycode = "\u001B[" + attrs[0].getCode() ;
		for (int i = 1; i < attrs.length; i++) {
			terminalDisplaycode += ';' + attrs[i].getCode();
		}
		terminalDisplaycode += 'm';
		return terminalDisplaycode;
	}
	
	default String getAttributeFormt(StandardAttributes... attrs) {
		String terminalDisplaycode = new String() ;
		for (int i = 0; i < attrs.length; i++) {
			if (i > 0) {
				terminalDisplaycode +=  ';';
			}
			terminalDisplaycode +=  attrs[i].getCode();
			
		}
		return terminalDisplaycode;
	}
	
	default String SetAttributeMode(ForegroundColours colour) {
		return colour.toString();
	}
	
	default String SetAttributeMode(BackgroundColours colour) {
		return colour.toString();
	}
	
	default String SetAttributeMode(StandardAttributes attr, BackgroundColours bgcolour) {
		return "\u001B[" + attr.getCode() + ';' + bgcolour.getCode() + "m";
	}
	
	default String SetAttributeMode(StandardAttributes attr, ForegroundColours fgColour) {
		return "\u001B[" + attr.getCode() + ';' + fgColour.getCode() + "m";
	}
	
	default String SetAttributeMode(ForegroundColours fgColour, BackgroundColours bgcolour) {
		return "\u001B[" + fgColour.getCode() + ';' + bgcolour.getCode() + "m";
	}
	
	default String SetAttributeMode(StandardAttributes attr, ForegroundColours fgColour, BackgroundColours bgcolour) {
		return "\u001B[" + attr.getCode() + ';' + fgColour.getCode() + ';' + bgcolour.getCode() + "m";
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
	
	
	
	String ResetAllAttributes = StandardAttributes.ResetAllAttributes.toString();
	String Bright = StandardAttributes.Bright.toString();
	String Dim = StandardAttributes.Dim.toString();
	String Underscore = StandardAttributes.Underscore.toString();
	String Blink = StandardAttributes.Blink.toString();
	String Reverse = StandardAttributes.Reverse.toString();
	String Hidden = StandardAttributes.Hidden.toString();
	
	default String putColourAndRest(String string, ForegroundColours colour) {
		return colour.toString() + string + ResetAllAttributes;
	}
	
	default String putBGColourAndRest(String string, BackgroundColours colour) {
		return colour.toString() + string + ResetAllAttributes;
	}
	
	
	String Black = ForegroundColours.Black.toString();
	default String Black(String string) {
		return putColourAndRest(string, ForegroundColours.Black);
	}
	
	String Blackbg = BackgroundColours.Black.toString();
	default String Blackbg(String string) {
	    return 	putBGColourAndRest(string, BackgroundColours.Black);
	}
	
	String Red = ForegroundColours.Red.toString();
	default String Red(String string) {
		return  putColourAndRest(string, ForegroundColours.Red);
	}
	
	String Redbg = BackgroundColours.Red.toString();
	default String Redbg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Red);
	}
	
	String Green = ForegroundColours.Green.toString();
	default String Green(String string) {
		return putColourAndRest(string, ForegroundColours.Green);
	}
	
	String Greenbg = BackgroundColours.Green.toString();
	default String Greenbg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Green);
	}
	
	String Yellow = ForegroundColours.Yellow.toString();
	default String Yellow(String string) {
		return putColourAndRest(string, ForegroundColours.Yellow);
	}
	
	String Yellowbg = BackgroundColours.Yellow.toString();
	default String Yellowbg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Yellow);
	}
	
	String Blue = ForegroundColours.Blue.toString();
	default String Blue(String string) {
		return putColourAndRest(string, ForegroundColours.Blue);
	}
	
	String Bluebg = BackgroundColours.Blue.toString();
	default String Bluebg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Blue);
	}
	
	String Magenta = ForegroundColours.Magenta.toString();
	default String Magenta(String string) {
		return putColourAndRest(string, ForegroundColours.Magenta);
	}
	
	String Magentabg = BackgroundColours.Magenta.toString();
	default String Magentabg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Magenta);
	}
	
	String Cyan = ForegroundColours.Cyan.toString();
	default String Cyan(String string) {
		return putColourAndRest(string, ForegroundColours.Cyan);
	}
	
	String Cyanbg = BackgroundColours.Cyan.toString();
	default String Cyanbg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.Cyan);
	}
	String White = ForegroundColours.White.toString();
	default String White(String string) {
		return putColourAndRest(string, ForegroundColours.White);
	}
	
	String Whitebg = BackgroundColours.White.toString();
	default String Whitebg(String string) {
	    return putBGColourAndRest(string, BackgroundColours.White);
	}
	
	
	
}
