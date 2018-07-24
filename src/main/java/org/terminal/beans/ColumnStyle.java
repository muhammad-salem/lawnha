package org.terminal.beans;

import org.terminal.strings.StyleBuilder;

public class ColumnStyle extends StyleBuilder{
	
	public ColumnStyle() {
		super();
	}
	public ColumnStyle(StyleBuilder styleBuilder) {
		super();
		this.effect.addAll(styleBuilder.getEffect());
		this.revers.addAll(styleBuilder.getRevers());
	}
	
	
	
	
	
}
