package org.terminal.strings;

import org.terminal.ansi.display.Color;
import org.terminal.ansi.display.Style;

public interface ColorAndStyle extends StringColor, StringStyle {
	
	
	public default String build(String string) {
		return effect() + string + reverse();
	}

	public default ColorAndStyle black() {
		color(Color.BLACK);
		return this;
	}
	
	public default ColorAndStyle bgBlack() {
		bgColor(Color.BLACK);
		return this;
	}
		
	public default ColorAndStyle red() {
		color(Color.RED);
		return this;
	}

	public default ColorAndStyle bgRed() {
		bgColor(Color.RED);
		return this;
	}

	public default ColorAndStyle green() {
		color(Color.GREEN);
		return this;
	}

	public default ColorAndStyle bgGreen() {
		bgColor(Color.GREEN);
		return this;
	}

	public default ColorAndStyle yellow() {
		color(Color.YELLOW);
		return this;
	}

	public default ColorAndStyle bgYellow() {
		bgColor(Color.YELLOW);
		return this;
	}

	public default ColorAndStyle blue() {
		color(Color.BLUE);
		return this;
	}

	public default ColorAndStyle bgBlue() {
		bgColor(Color.BLUE);
		return this;
	}

	public default ColorAndStyle magenta() {
		color(Color.MAGENTA);
		return this;
	}

	public default ColorAndStyle bgMagenta() {
		bgColor(Color.MAGENTA);
		return this;
	}

	public default ColorAndStyle cyan() {
		color(Color.CYAN);
		return this;
	}

	public default ColorAndStyle bgCyan() {
		bgColor(Color.CYAN);
		return this;
	}

	public default ColorAndStyle white() {
		color(Color.WHITE);
		return this;
	}

	public default ColorAndStyle bgWhite() {
		bgColor(Color.WHITE);
		return this;
	}

	public default ColorAndStyle defaultColor() {
		color(Color.DEFAULT);
		return this;
	}

	public default ColorAndStyle defaultColorbg() {
		bgColor(Color.DEFAULT);
		return this;
	}


	public default ColorAndStyle gray() {
		lite(Color.BLACK);
		return this;
	}
	public default ColorAndStyle bgGray() {
		bgLite(Color.BLACK);
		return this;
	}

	public default ColorAndStyle redLite() {
		lite(Color.RED);
		return this;
	}

	public default ColorAndStyle bgRedLite() {
		bgLite(Color.RED);
		return this;
	}

	public default ColorAndStyle greenLite() {
		lite(Color.GREEN);
		return this;
	}

	public default ColorAndStyle bgGreenLite() {
		bgLite(Color.GREEN);
		return this;
	}

	public default ColorAndStyle yellowLite() {
		lite(Color.YELLOW);
		return this;
	}

	public default ColorAndStyle bgYellowLite() {
		bgLite(Color.YELLOW);
		return this;
	}

	public default ColorAndStyle blueLite() {
		lite(Color.BLUE);
		return this;
	}

	public default ColorAndStyle bgBlueLite() {
		bgLite(Color.BLUE);
		return this;
	}

	public default ColorAndStyle magentaLite() {
		lite(Color.MAGENTA);
		return this;
	}

	public default ColorAndStyle bgMagentaLite() {
		bgLite(Color.MAGENTA);
		return this;
	}

	public default ColorAndStyle cyanLite() {
		lite(Color.CYAN);
		return this;
	}

	public default ColorAndStyle bgCyanLite() {
		bgLite(Color.CYAN);
		return this;
	}

	public default ColorAndStyle grayLite() {
		lite(Color.WHITE);
		return this;
	}

	public default ColorAndStyle bgGrayLite() {
		bgLite(Color.WHITE);
		return this;
	}
	
	public default ColorAndStyle bold() {
		style(Style.Bold);
		return this;
	}

	public default ColorAndStyle dim() {
		style(Style.Dim);
		return this;
	}

	public default ColorAndStyle italic() {
		style(Style.Italic);
		return this;
	}

	public default ColorAndStyle underline() {
		style(Style.Underline);
		return this;
	}

	public default ColorAndStyle blink() {
		style(Style.Blink);
		return this;
	}

	public default ColorAndStyle fastBlink() {
		style(Style.FastBlink);
		return this;
	}

	public default ColorAndStyle inverse() {
		style(Style.Reverse);
		return this;
	}

	public default ColorAndStyle hidden() {
		style(Style.Hidden);
		return this;
	}

	public default ColorAndStyle reset() {
		style(Style.Reset);
		return this;
	}
	
}
