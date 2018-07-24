package org.terminal.strings;

import org.terminal.ansi.display.Color;

public interface StringColor {
	
	void color(Color color);	
	void bgColor(Color colorbg);
	
	void lite(Color color);	
	void bgLite(Color colorbg);
	
	
	StringColor color(int n);
	StringColor colorbg(int n);
	StringColor color(int r, int g, int b);
	StringColor colorbg(int r, int g, int b);
	
	void clearStyle();
	
	String effect();
	String reverse();
	
	public default String build(String string) {
		return effect() + string + reverse();
	}	
	
	public default StringColor black() {
		color(Color.BLACK);
		return this;
	}
	
	public default StringColor bgBlack() {
		bgColor(Color.BLACK);
		return this;
	}
		
	public default StringColor red() {
		color(Color.RED);
		return this;
	}

	public default StringColor bgRed() {
		bgColor(Color.RED);
		return this;
	}

	public default StringColor green() {
		color(Color.GREEN);
		return this;
	}

	public default StringColor bgGreen() {
		bgColor(Color.GREEN);
		return this;
	}

	public default StringColor yellow() {
		color(Color.YELLOW);
		return this;
	}

	public default StringColor bgYellow() {
		bgColor(Color.YELLOW);
		return this;
	}

	public default StringColor blue() {
		color(Color.BLUE);
		return this;
	}

	public default StringColor bgBlue() {
		bgColor(Color.BLUE);
		return this;
	}

	public default StringColor magenta() {
		color(Color.MAGENTA);
		return this;
	}

	public default StringColor bgMagenta() {
		bgColor(Color.MAGENTA);
		return this;
	}

	public default StringColor cyan() {
		color(Color.CYAN);
		return this;
	}

	public default StringColor bgCyan() {
		bgColor(Color.CYAN);
		return this;
	}

	public default StringColor white() {
		color(Color.WHITE);
		return this;
	}

	public default StringColor bgWhite() {
		bgColor(Color.WHITE);
		return this;
	}

	public default StringColor defaultColor() {
		color(Color.DEFAULT);
		return this;
	}

	public default StringColor defaultColorbg() {
		bgColor(Color.DEFAULT);
		return this;
	}



	public default StringColor gray() {
		lite(Color.BLACK);
		return this;
	}
	public default StringColor bgGray() {
		bgLite(Color.BLACK);
		return this;
	}

	public default StringColor redLite() {
		lite(Color.RED);
		return this;
	}

	public default StringColor bgRedLite() {
		bgLite(Color.RED);
		return this;
	}

	public default StringColor greenLite() {
		lite(Color.GREEN);
		return this;
	}

	public default StringColor bgGreenLite() {
		bgLite(Color.GREEN);
		return this;
	}

	public default StringColor yellowLite() {
		lite(Color.YELLOW);
		return this;
	}

	public default StringColor bgYellowLite() {
		bgLite(Color.YELLOW);
		return this;
	}

	public default StringColor blueLite() {
		lite(Color.BLUE);
		return this;
	}

	public default StringColor bgBlueLite() {
		bgLite(Color.BLUE);
		return this;
	}

	public default StringColor magentaLite() {
		lite(Color.MAGENTA);
		return this;
	}

	public default StringColor bgMagentaLite() {
		bgLite(Color.MAGENTA);
		return this;
	}

	public default StringColor cyanLite() {
		lite(Color.CYAN);
		return this;
	}

	public default StringColor bgCyanLite() {
		bgLite(Color.CYAN);
		return this;
	}

	public default StringColor grayLite() {
		lite(Color.WHITE);
		return this;
	}

	public default StringColor bgGrayLite() {
		bgLite(Color.WHITE);
		return this;
	}
	
	
}
