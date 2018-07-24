package org.terminal.beans;

import java.util.HashMap;
import java.util.Map;

public final class TableThemes implements EdgeTheme {

	public static final String EMPTY_STYLE		= "           ";
	public static final String DEFAULT_STYLE	= "┌─┬┐│┤┘┴└├┼";
	public static final String DOUBLE_STYLE		= "╔═╦╗║╣╝╩╚╠╬";
	
	
	public static final TableThemes DEFAULT_THEME	= new TableThemes(DEFAULT_STYLE);
	public static final TableThemes EMPTY_THEME	= new TableThemes("");
	
	public static TableThemes editDefault(Map<Edge, Character> edit) {
		TableThemes theme	= new TableThemes(DEFAULT_STYLE);
		for (Edge edge : edit.keySet()) {
			theme.map.put(edge, edit.get(edge));
		}
		return theme;
	};
	
	public static TableThemes edit(String style, Map<Edge, Character> edit) {
		TableThemes theme	= new TableThemes(style);
		for (Edge edge : edit.keySet()) {
			theme.map.put(edge, edit.get(edge));
		}
		return theme;
	};
	
	Map<Edge, Character> map = new HashMap<>();

	public TableThemes(String style) {
		this(style.toCharArray());
	}
	public TableThemes(char c) {
		map = new HashMap<>();
		EdgeTheme.fillMap(map, c);
	}
	public TableThemes(char[] chars) {
		map = new HashMap<>();
		try {
			EdgeTheme.fillMap(map, chars);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TableThemes(Map<Edge, Character> chars) {
		this.map = chars;
	}
	public TableThemes(char topLeft, char top , char topMid, char topRight,
			char right, char rightMid,
			char bottomRight, char bottom, char bottomMid, char bottomLeft,
			char left, char leftMid,
			char mid, char midMid, char middle) {
		map = new HashMap<>();
		EdgeTheme.fillMap(map, topLeft, top, topMid, topRight, right, rightMid, bottomRight, bottom, bottomMid, bottomLeft, left, leftMid, mid, midMid, middle);
	}

	@Override
	public Map<Edge, Character> getTheme() {
		return map;
	}
	
	
	public void removeMiddle() {
		// {'mid': '', 'left-mid': '', 'mid-mid': '', 'right-mid': ''}
		map.put(Edge.Mid, (char)0);
		map.put(Edge.LeftMid, (char)0);
		map.put(Edge.MidMid, (char)0);
		map.put(Edge.RightMid, (char)0);
	}

}
