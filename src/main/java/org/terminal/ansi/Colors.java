package org.terminal.ansi;

import org.terminal.ansi.display.Color;

/**
 * Colors  
 * @author salem
 *
 */
public interface Colors extends AnsiBase{
	
	
	
	default String color(int n) {
		if (n >= 255) {
			//	n = 39;			// for default background
			n %= 255;			// take reminder as value 
		}
		return escape_sequences + "38;5;" + n + CommendDisplay;
	}
	
	default String colorbg(int n) {
		if (n >= 255) {
			//	n = 49;			// for default background
			n %= 255;			// take reminder as value 
		}
		return escape_sequences + "48;5;"+ n + CommendDisplay;
	}
	
	default String color(int r, int g, int b) {
		if (r <= 5 && g <= 5 && b <= 5 ) {
			if (r >= 0 && g >= 0 && b >= 0 ) {
				int n = 16 + 36 * r + 6 * g + b;
				return color(n);
			}
		}
		return color(39);
	}
	
	default String colorbg(int r, int g, int b) {
		if (r <= 5 && g <= 5 && b <= 5 ) {
			if (r >= 0 && g >= 0 && b >= 0 ) {
				int n = 16 + 36 * r + 6 * g + b;
				return colorbg(n);
			}
		}
		return color(49);
	}
	
	default String color24(int r, int g, int b) {
//		return "\u001B[38;2;" + r + ";" + g + ";" + b + (char)'m';
		return ( escape_sequences + "38;2;" + r + ";" + g + ";" + b ) + CommendDisplay;
	}
	
	default String colorbg24(int r, int g, int b) {
//		return "\u001B[48;2;" + r + ";" + g + ";" + b + (char)'m';
		return ( escape_sequences + "48;2;" + r + ";" + g + ";" + b ) + CommendDisplay;
	}
	
	default String color(String string, int n) {
		return color(n) + string + DefaultColor;
	}
	
	default String colorbg(String string, int n) {
		return colorbg(n) + string + DefaultColorbg;
	}
	
	default String color(String string, int r, int g, int b) {
		return color(r, g, b) + string + DefaultColor;
	}
	
	default String colorbg(String string, int r, int g, int b) {
		return colorbg(r, g, b) + string + DefaultColorbg;
	}
	
	default String color24(String string, int r, int g, int b) {
		return color24(r, g, b) + string + DefaultColor;
	}
	
	default String colorbg24(String string, int r, int g, int b) {
		return colorbg24(r, g, b) + string + DefaultColorbg;
	}
	
	default String color(String string, Color color) {
		return color.colorString() + string + DefaultColor;
	}
	
	default String colorbg(String string, Color colorbg) {
		return colorbg.bgColorString() + string + DefaultColorbg;
	}
	
	default String colorLite(String string, Color color) {
		return color.liteString() + string + DefaultColor;
	}
	
	default String colorLitebg(String string, Color colorbg) {
		return colorbg.bgLiteString() + string + DefaultColorbg;
	}
	
	
	final String Black = Color.BLACK.colorString();
	default String black(String string) {
		return color(string, Color.BLACK);
	}
	
	final String Blackbg = Color.BLACK.bgColorString();
	default String blackbg(String string) {
	    return colorbg(string, Color.BLACK);
	}
	
	final String Red = Color.RED.colorString();
	default String red(String string) {
		return color(string, Color.RED);
	}
	
	final String Redbg = Color.RED.bgColorString();
	default String redbg(String string) {
	    return colorbg(string, Color.RED);
	}
	
	final String Green = Color.GREEN.colorString();
	default String green(String string) {
		return color(string, Color.GREEN);
	}
	
	final String Greenbg = Color.GREEN.bgColorString();
	default String greenbg(String string) {
	    return colorbg(string, Color.GREEN);
	}
	
	final String Yellow = Color.YELLOW.colorString();
	default String yellow(String string) {
		return color(string, Color.YELLOW);
	}
	
	final String Yellowbg = Color.YELLOW.bgColorString();
	default String yellowbg(String string) {
	    return colorbg(string, Color.YELLOW);
	}
	
	final String Blue = Color.BLUE.colorString();
	default String blue(String string) {
		return color(string, Color.BLUE);
	}
	
	final String Bluebg = Color.BLUE.bgColorString();
	default String bluebg(String string) {
	    return colorbg(string, Color.BLUE);
	}
	
	final String Magenta = Color.MAGENTA.colorString();
	default String magenta(String string) {
		return color(string, Color.MAGENTA);
	}
	
	final String Magentabg = Color.MAGENTA.bgColorString();
	default String magentabg(String string) {
	    return colorbg(string, Color.MAGENTA);
	}
	
	final String Cyan = Color.CYAN.colorString();
	default String cyan(String string) {
		return color(string, Color.CYAN);
	}
	
	final String Cyanbg = Color.CYAN.bgColorString();
	default String cyanbg(String string) {
	    return colorbg(string, Color.CYAN);
	}
	final String White = Color.WHITE.colorString();
	default String white(String string) {
		return color(string, Color.WHITE);
	}
	
	final String Whitebg = Color.WHITE.bgColorString();
	default String whitebg(String string) {
	    return colorbg(string, Color.WHITE);
	}
	
	final String DefaultColor = Color.DEFAULT.colorString();
	default String defaultForegroundColor(String string) {
		return color(string, Color.DEFAULT);
	}
	
	final String DefaultColorbg = Color.DEFAULT.bgColorString();
	default String defaultBackgroundColor(String string) {
	    return colorbg(string, Color.DEFAULT);
	}
	
	
	
	//////////////////////
	
	final String Gray = Color.BLACK.liteString();
	default String gray(String string) {
		return colorLite(string, Color.BLACK);
	}
	
	final String Graybg = Color.BLACK.bgLiteString();
	default String graybg(String string) {
	    return colorLitebg(string, Color.BLACK);
	}
	
	final String GrayLight = Color.WHITE.liteString();
	default String grayLight(String string) {
		return color(string, Color.WHITE);
	}
	
	final String GrayLightbg = Color.WHITE.bgLiteString();
	default String grayLightbg(String string) {
	    return colorbg(string, Color.WHITE);
	}
	
	final String RedLight = Color.RED.liteString();
	default String redLight(String string) {
		return colorLite(string, Color.RED);
	}
	
	final String RedLightbg = Color.RED.bgLiteString();
	default String redLightbg(String string) {
	    return colorLitebg(string, Color.RED);
	}
	
	final String GreenLight = Color.GREEN.liteString();
	default String greenLight(String string) {
		return colorLite(string, Color.GREEN);
	}
	
	final String GreenLightbg = Color.GREEN.bgLiteString();
	default String greenLightbg(String string) {
	    return colorLitebg(string, Color.GREEN);
	}
	
	final String YellowLight = Color.YELLOW.liteString();
	default String yellowLight(String string) {
		return colorLite(string, Color.YELLOW);
	}
	
	final String YellowLightbg = Color.YELLOW.bgLiteString();
	default String yellowLightbg(String string) {
	    return colorLitebg(string, Color.YELLOW);
	}
	
	final String BlueLight = Color.BLUE.liteString();
	default String blueLight(String string) {
		return colorLite(string, Color.BLUE);
	}
	
	final String BlueLightbg = Color.BLUE.bgLiteString();
	default String blueLightbg(String string) {
	    return colorLitebg(string, Color.BLUE);
	}
	
	final String MagentaLight = Color.MAGENTA.liteString();
	default String magentaLight(String string) {
		return colorLite(string, Color.MAGENTA);
	}
	
	final String MagentaLightbg = Color.MAGENTA.bgLiteString();
	default String magentaLightbg(String string) {
	    return colorLitebg(string, Color.MAGENTA);
	}
	
	final String CyanLight = Color.CYAN.liteString();
	default String cyanLight(String string) {
		return colorLite(string, Color.CYAN);
	}
	
	final String CyanLightnbg = Color.CYAN.bgLiteString();
	default String cyanLightbg(String string) {
	    return colorLitebg(string, Color.CYAN);
	}
	
	
}
