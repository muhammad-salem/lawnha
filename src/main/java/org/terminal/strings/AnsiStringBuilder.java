package org.terminal.strings;

public class AnsiStringBuilder extends StyleBuilder {
	
	protected StringBuilder builder;
	protected StringBuilder holderAnsi;
	
	public AnsiStringBuilder() {
		super();
		this.builder = new StringBuilder();
		this.holderAnsi = new StringBuilder();
	}
	
	public StringBuilder stringBuilder() {
		return builder;
	}
		
	@Override
	public String toString() {
		build();
		return holderAnsi.toString();
	}
	@Override
	public String build(String string) {
		builder.append(string);
		build();
		return toString();
	}
	
//	public void appendBuild(String string) {
//		builder.append(string);
//		build();
//	}
	
	public void build() {
		holderAnsi.append(super.build(builder.toString()));
		builder.delete(0, builder.length());
		clearStyle();
	}
	
	
	public void clear() {
		builder.delete(0, builder.length());
		holderAnsi.delete(0, holderAnsi.length());
	}
	
	public void appendln() {
		append('\n');
	}
	public void appendln(String string) {
		append(string + '\n');
	}
	
	public void append(String string) {
		if(effect.isEmpty()) holderAnsi.append(string);
		else builder.append(string);
	}
	
	public void append(Object obj) {
		if(effect.isEmpty()) holderAnsi.append(obj);
		else builder.append(obj);
	}

	public void append(StringBuffer sb) {
		if(effect.isEmpty()) holderAnsi.append(sb);
		else builder.append(sb);
	}

	public void append(CharSequence s) {
		if(effect.isEmpty()) holderAnsi.append(s);
		else builder.append(s);
	}

	public void append(CharSequence s, int start, int end) {
		if(effect.isEmpty()) holderAnsi.append(s, start, end);
		else builder.append(s, start, end);
	}

	public void append(char[] str) {
		if(effect.isEmpty()) holderAnsi.append(str);
		else builder.append(str);
	}

	public void append(char[] str, int offset, int len) {
		if(effect.isEmpty()) holderAnsi.append(str, offset, len);
		else builder.append(str, offset, len);
	}

	public void append(boolean b) {
		if(effect.isEmpty()) holderAnsi.append(b);
		else builder.append(b);
	}

	public void append(char c) {
		if(effect.isEmpty()) holderAnsi.append(c);
		else builder.append(c);
	}

	public void append(int i) {
		if(effect.isEmpty()) holderAnsi.append(i);
		else builder.append(i);
	}

	public void append(long lng) {
		if(effect.isEmpty()) holderAnsi.append(lng);
		else builder.append(lng);
	}

	public void append(float f) {
		if(effect.isEmpty()) holderAnsi.append(f);
		else builder.append(f);
	}

	public void append(double d) {
		if(effect.isEmpty()) holderAnsi.append(d);
		else builder.append(d);
	}

	public void appendCodePoint(int codePoint) {
		if(effect.isEmpty()) holderAnsi.appendCodePoint(codePoint);
		else builder.appendCodePoint(codePoint);
	}
	

	
	
	
}
