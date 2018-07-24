package org.terminal.strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnsiString extends StyleBuilder implements CharSequence, Appendable{

	List<Character> characters;

	public AnsiString(char[] chars) {
		characters = new ArrayList<Character>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String toString() {
				Iterator<Character> it = iterator();
		        if (! it.hasNext())
		            return "";

		        StringBuilder sb = new StringBuilder();
		        for (;;) {
		        	Character e = it.next();
		            sb.append(e);
		            if (! it.hasNext())
		                return sb.toString();
		        }
			}
		};
		for (int i = 0; i < chars.length; i++) {
			characters.add(chars[i]);
		}
		characters.addAll(characters);
	}

	public AnsiString(String string) {
		this(string.toCharArray());
	}

	public String toString() {
		return build(characters.toString());
	}
	
	@Override
	public int length() {
		return characters.size();
	}

	@Override
	public char charAt(int index) {
		return characters.get(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return String.valueOf(characters.toArray()).subSequence(start, end);
	}
	
	@Override
	public Appendable append(CharSequence csq) {
		for (int i = 0; i < csq.length(); i++) {
			characters.add(csq.charAt(i));
		}
		return this;
	}


	@Override
	public Appendable append(CharSequence csq, int start, int end) {
		for (int i = start; i < end; i++) {
			characters.add(csq.charAt(i));
		}
		return this;
	}


	@Override
	public Appendable append(char c) {
		characters.add(c);
		return this;
	}

	@Override
	protected void finalize() throws Throwable {
		characters.clear();
		characters = null;
		super.finalize();
	}

	
	
}
