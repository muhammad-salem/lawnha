package org.terminal.strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.terminal.ansi.Styles;
import org.terminal.ansi.display.Color;
import org.terminal.ansi.display.Style;

public class StyleBuilder implements ColorAndStyle{
	
	protected static Styles STYLE;
	protected Queue<Integer> effect;
	protected Deque<Integer> revers;
	
	public StyleBuilder() {
		this.effect = new LinkedList<>();
		this.revers = new LinkedList<>();
		if(STYLE == null)
			STYLE = new Styles() {};
	}
	
	public Queue<Integer> getEffect() {
		return effect;
	}
	public Deque<Integer> getRevers() {
		return revers;
	}
	
	public boolean isEmpty() {
		return effect.isEmpty() && revers.isEmpty();
	}

	@Override
	public void clearStyle() {
		effect.clear();
		revers.clear();
	}
	
	@Override
	public String toString() {
		return build("");
	}
	

	@Override
	public String effect() {
		return STYLE.attribute((Integer[]) effect.toArray(new Integer[effect.size()]));
	}

	@Override
	public String reverse() {
		return STYLE.attribute((Integer[]) revers.toArray(new Integer[revers.size()]));
	}
	
	@Override
	public StyleBuilder color(int n) {
		if (n >= 255) {
			//n = 39;
			n %= 255;
		}
		effect.add(38);
		effect.add(5);
		effect.add(n);
		revers.add(Color.DEFAULT.color());
		return this;
	}
	
	@Override
	public StyleBuilder colorbg(int n) {
		if (n >= 255) {
			//n = 49;
			n %= 255;
		}
		effect.add(48);
		effect.add(5);
		effect.add(n);
		revers.add(Color.DEFAULT.bgColor());
		return this;
	}
	
	@Override
	public StyleBuilder color(int r, int g, int b) {
		// "\u001B[38;2;" + r + ";" + g + ";" + b + "m"
		effect.add(38);
		effect.add(2);
		effect.add(r);
		effect.add(g);
		effect.add(b);
		revers.add(Color.DEFAULT.color());
		return this;
	}
	
	@Override
	public StyleBuilder colorbg(int r, int g, int b) {
		// "\u001B[48;2;" + r + ";" + g + ";" + b + "m"
		effect.add(48);
		effect.add(2);
		effect.add(r);
		effect.add(g);
		effect.add(b);
		revers.add(Color.DEFAULT.bgColor());
		return this;
	}


	@Override
	public void color(Color color) {
		effect.add(color.color());
		revers.add(Color.DEFAULT.color());
	}
	
	@Override
	public void bgColor(Color colorbg) {
		effect.add(colorbg.bgColor());
		revers.add(Color.DEFAULT.bgColor());
	}
	

	@Override
	public void lite(Color colorLite) {
		effect.add(colorLite.lite());
		revers.add(Color.DEFAULT.lite());
	}

	@Override
	public void bgLite(Color colorLitebg) {
		effect.add(colorLitebg.bgLite());
		revers.add(Color.DEFAULT.bgColor());
		
	}
	
	@Override
	public void style(Style style) {
		effect.add(style.baseCode());
		revers.add(style.secondCode());
	}

	@Override
	protected void finalize() throws Throwable {
		clearStyle();
		effect = null;
		revers = null;
		super.finalize();
	}


	
	
	
}
