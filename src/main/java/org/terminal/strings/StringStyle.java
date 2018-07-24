package org.terminal.strings;

import org.terminal.ansi.display.Style;

public interface StringStyle {

	void style(Style style);

	void clearStyle();

	
	String effect();
	String reverse();
	
	public default String build(String string) {
		return effect() + string + reverse();
	}
	
	public default StringStyle bold() {
		style(Style.Bold);
		return this;
	}

	public default StringStyle dim() {
		style(Style.Dim);
		return this;
	}

	public default StringStyle italic() {
		style(Style.Italic);
		return this;
	}

	public default StringStyle underline() {
		style(Style.Underline);
		return this;
	}

	public default StringStyle blink() {
		style(Style.Blink);
		return this;
	}

	public default StringStyle fastBlink() {
		style(Style.FastBlink);
		return this;
	}

	public default StringStyle inverse() {
		style(Style.Reverse);
		return this;
	}

	public default StringStyle hidden() {
		style(Style.Hidden);
		return this;
	}

	public default StringStyle reset() {
		style(Style.Reset);
		return this;
	}

}
