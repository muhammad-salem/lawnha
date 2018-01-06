package org.terminal.ansi;


public interface ANSI 
		extends DeviceStatus, 
				TerminalSetup, 
				Fonts, 
				CursorControl, 
				Scrolling, 
				TabControl,
				ErasingText,
				Printing,
				DefineKey,
				DisplayAttr
{
	
	public static void main(String ... args) throws Exception {
		  String summery = "";
		  ANSI ansi = new ANSI(){};
		  summery += ansi.Yellow("HelloY ");
		  summery += ansi.Blue("WorldB ");
		  summery += ansi.Greenbg("\ttry green background");
		  System.out.println(summery);
	}
		
}
