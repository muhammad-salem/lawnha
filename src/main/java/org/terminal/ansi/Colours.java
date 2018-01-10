package org.terminal.ansi;

import org.terminal.ansi.display.Colour;

public interface Colours{
	
	default String Colour(int n) {
		if (n >= 255) {
			n = 39;
		}
		return "\u001B[38;5;"+n+'m';
	}
	
	default String Colourbg(int n) {
		if (n >= 255) {
			n = 49;
		}
		return "\u001B[48;5;"+n+'m';
	}
	
	default String Colour(int r, int g, int b) {
		if (r <= 5 && g <= 5 && b <= 5 ) {
			if (r >= 0 && g >= 0 && b >= 0 ) {
				int n = 16 + 36 * r + 6 * g + b;
				return Colour(n);
			}
		}
		return Colour(39);
	}
	
	default String Colourbg(int r, int g, int b) {
		if (r <= 5 && g <= 5 && b <= 5 ) {
			if (r >= 0 && g >= 0 && b >= 0 ) {
				int n = 16 + 36 * r + 6 * g + b;
				return Colourbg(n);
			}
		}
		return Colour(49);
	}
	
	default String Colour24(int r, int g, int b) {
		return "\u001B[38;2;" + r +';' + g +';' + b +'m';
	}
	
	default String Colourbg24(int r, int g, int b) {
		return "\u001B[48;2;" + r +';' + g +';' + b +'m';
	}
	
	default String Colour(String string, int n) {
		return Colour(n) + string + "\u001B[0m";
	}
	
	default String Colourbg(String string, int n) {
		return Colourbg(n) + string + "\u001B[0m";
	}
	
	default String Colour(String string, int r, int g, int b) {
		return Colour(r, g, b) + string + "\u001B[0m";
	}
	
	default String Colourbg(String string, int r, int g, int b) {
		return Colourbg(r, g, b) + string + "\u001B[0m";
	}
	
	default String Colour24(String string, int r, int g, int b) {
		return Colour24(r, g, b) + string + "\u001B[0m";
	}
	
	default String Colourbg24(String string, int r, int g, int b) {
		return Colourbg24(r, g, b) + string + "\u001B[0m";
	}
	
	default String Colour(String string, Colour colour) {
		return colour.color() + string + "\u001B[0m";
	}
	
	default String Colourbg(String string, Colour colour) {
		return colour.colorbg() + string + "\u001B[0m";
	}
	
	
	String Black = Colour.Black.color();
	default String Black(String string) {
		return Colour(string, Colour.Black);
	}
	
	String Blackbg = Colour.Black.colorbg();
	default String Blackbg(String string) {
	    return 	Colourbg(string, Colour.Black);
	}
	
	String Red = Colour.Red.color();
	default String Red(String string) {
		return  Colour(string, Colour.Red);
	}
	
	String Redbg = Colour.Red.colorbg();
	default String Redbg(String string) {
	    return Colourbg(string, Colour.Red);
	}
	
	String Green = Colour.Green.color();
	default String Green(String string) {
		return Colour(string, Colour.Green);
	}
	
	String Greenbg = Colour.Green.colorbg();
	default String Greenbg(String string) {
	    return Colourbg(string, Colour.Green);
	}
	
	String Yellow = Colour.Yellow.color();
	default String Yellow(String string) {
		return Colour(string, Colour.Yellow);
	}
	
	String Yellowbg = Colour.Yellow.colorbg();
	default String Yellowbg(String string) {
	    return Colourbg(string, Colour.Yellow);
	}
	
	String Blue = Colour.Blue.color();
	default String Blue(String string) {
		return Colour(string, Colour.Blue);
	}
	
	String Bluebg = Colour.Blue.colorbg();
	default String Bluebg(String string) {
	    return Colourbg(string, Colour.Blue);
	}
	
	String Magenta = Colour.Magenta.color();
	default String Magenta(String string) {
		return Colour(string, Colour.Magenta);
	}
	
	String Magentabg = Colour.Magenta.colorbg();
	default String Magentabg(String string) {
	    return Colourbg(string, Colour.Magenta);
	}
	
	String Cyan = Colour.Cyan.color();
	default String Cyan(String string) {
		return Colour(string, Colour.Cyan);
	}
	
	String Cyanbg = Colour.Cyan.colorbg();
	default String Cyanbg(String string) {
	    return Colourbg(string, Colour.Cyan);
	}
	String White = Colour.White.color();
	default String White(String string) {
		return Colour(string, Colour.White);
	}
	
	String Whitebg = Colour.White.colorbg();
	default String Whitebg(String string) {
	    return Colourbg(string, Colour.White);
	}
	
	String DefaultColor = Colour.Default.color();
	default String DefaultForegroundColor(String string) {
		return Colour(string, Colour.Default);
	}
	
	String DefaultColorbg = Colour.Default.colorbg();
	default String DefaultBackgroundColor(String string) {
	    return Colourbg(string, Colour.Default);
	}
	
	
	
	//////////////////////
	
	String Gray = Colour.Gray.color();
	default String Gray(String string) {
		return Colour(string, Colour.Gray);
	}
	
	String Graybg = Colour.Gray.colorbg();
	default String Graybg(String string) {
	    return 	Colourbg(string, Colour.Gray);
	}
	
	String RedLight = Colour.RedLight.color();
	default String RedLight(String string) {
		return  Colour(string, Colour.RedLight);
	}
	
	String RedLightbg = Colour.RedLight.colorbg();
	default String RedLightbg(String string) {
	    return Colourbg(string, Colour.RedLight);
	}
	
	String GreenLight = Colour.GreenLight.color();
	default String GreenLight(String string) {
		return Colour(string, Colour.GreenLight);
	}
	
	String GreenLightbg = Colour.GreenLight.colorbg();
	default String GreenLightbg(String string) {
	    return Colourbg(string, Colour.GreenLight);
	}
	
	String YellowLight = Colour.YellowLight.color();
	default String YellowLight(String string) {
		return Colour(string, Colour.YellowLight);
	}
	
	String YellowLightbg = Colour.YellowLight.colorbg();
	default String YellowLightbg(String string) {
	    return Colourbg(string, Colour.YellowLight);
	}
	
	String BlueLight = Colour.BlueLight.color();
	default String BlueLight(String string) {
		return Colour(string, Colour.BlueLight);
	}
	
	String BlueLightbg = Colour.BlueLight.colorbg();
	default String BlueLightbg(String string) {
	    return Colourbg(string, Colour.BlueLight);
	}
	
	String MagentaLight = Colour.MagentaLight.color();
	default String MagentaLight(String string) {
		return Colour(string, Colour.MagentaLight);
	}
	
	String MagentaLightbg = Colour.MagentaLight.colorbg();
	default String MagentaLightbg(String string) {
	    return Colourbg(string, Colour.MagentaLight);
	}
	
	String CyanLight = Colour.CyanLight.color();
	default String CyanLight(String string) {
		return Colour(string, Colour.CyanLight);
	}
	
	String CyanLightnbg = Colour.CyanLight.colorbg();
	default String CyanLightbg(String string) {
	    return Colourbg(string, Colour.CyanLight);
	}
	String GrayLight = Colour.GrayLight.color();
	default String GrayLight(String string) {
		return Colour(string, Colour.GrayLight);
	}
	
	String GrayLightbg = Colour.GrayLight.colorbg();
	default String GrayLightbg(String string) {
	    return Colourbg(string, Colour.GrayLight);
	}
	
}
