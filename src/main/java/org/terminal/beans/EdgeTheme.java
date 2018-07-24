package org.terminal.beans;



import java.util.HashMap;
import java.util.Map;

public interface EdgeTheme {

	EdgeTheme DEFAULT_THEME = new EdgeTheme() {
		
		@Override
		public Map<Edge, Character> getTheme() {
			Map<Edge, Character> map = new HashMap<>();
			String theme = "┌─┬┐│┤┘┴└├┼";
			try {
				EdgeTheme.fillMap(map, theme);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			map.put(Edge.Top,'─');
//			map.put(Edge.TopMid, '┬');
//			map.put(Edge.TopLeft, '┌'); 
//			map.put(Edge.TopRight, '┐'); 
//			
//			map.put(Edge.Bottom, '─');
//			map.put(Edge.BottomMid, '┴'); 
//			map.put(Edge.BottomLeft, '└'); 
//			map.put(Edge.BottomRight, '┘'); 
//			
//			map.put(Edge.Left, '│');
//			map.put(Edge.LeftMid, '├'); 
//			
//			map.put(Edge.Right, '│');
//			map.put(Edge.RightMid, '┤'); 
//			
//			map.put(Edge.Middle, '│');
//			map.put(Edge.Mid, '─'); 
//			map.put(Edge.MidMid, '┼');
			return map;
		}
	};
	
	/**
	 * 
	 * <pre>
	 * 		Top
	 *     ┌0────1──────2┬───1──────3┐
	 *     │4           4│          4│
	 * Left├9────1─────10┼───1──────5┤Right
	 *     │4           4│          4│
	 *     └8────1──────7┴───1──────6┘
	 * 		Bottom
	 *
	 *  0 -> TopLeft, 		
	 *  1 -> Top, Bottom, Mid,
	 *  2 -> TopMid,		
	 *  3 -> TopRight,
	 *  4 -> Right, Left, Middle
	 *  5 -> RightMid,
	 *  6 -> BottomRight, 	
	 *  7 -> BottomMid,
	 *  8 -> BottomLeft,
	 *  9 -> LeftMid,
	 * 10 -> MidMid.
	 * </pre>
	 * @param map
	 * @param chars
	 * @throws Exception 
	 */
	public static void fillMap(Map<Edge, Character> map, char[] chars) throws NullPointerException, Exception {
		if(chars == null) throw new NullPointerException("chars == null");
		if(chars.length == 0) {
			EdgeTheme.fillMap(map, (char) 0);
			return;
		} 
		else if(chars.length != 11) throw new Exception("chars length != 14 : found size " + chars.length);
		map.put(Edge.TopLeft, chars[0]); 		map.put(Edge.Top, chars[1]);		map.put(Edge.TopMid, chars[2]);		map.put(Edge.TopRight, chars[3]); 
		map.put(Edge.Right, chars[4]);			map.put(Edge.RightMid, chars[5]);
		map.put(Edge.BottomRight, chars[6]); 	map.put(Edge.Bottom, chars[1]);		map.put(Edge.BottomMid, chars[7]); 	map.put(Edge.BottomLeft, chars[8]); 
		map.put(Edge.Left, chars[4]);			map.put(Edge.LeftMid, chars[9]); 
		map.put(Edge.Mid, chars[1]);			map.put(Edge.MidMid, chars[10]);	map.put(Edge.Middle, chars[4]);			
		
	} 
	public static void fillMap(Map<Edge, Character> map, String string ) throws NullPointerException, Exception {
		fillMap(map, string.toCharArray());
	}
	
	public static void fillMap(Map<Edge, Character> map, char c ) {
		for (Edge edge : Edge.values()) {
			map.put(edge, c);
		}
	}
	
	public static void fillMap(Map<Edge, Character> map, char topLeft, char top , char topMid, char topRight,
			char right, char rightMid,
			char bottomRight, char bottom, char bottomMid, char bottomLeft,
			char left, char leftMid,
			char mid, char midMid, char middle) {
		
		map.put(Edge.TopLeft, topLeft); 		map.put(Edge.Top, top);		map.put(Edge.TopMid, topMid);		map.put(Edge.TopRight, topRight); 
		map.put(Edge.Right, right);			map.put(Edge.RightMid, rightMid);
		map.put(Edge.BottomRight, bottomRight); 	map.put(Edge.Bottom, bottom);		map.put(Edge.BottomMid, bottomMid); 	map.put(Edge.BottomLeft, bottomLeft); 
		map.put(Edge.Left, left);			map.put(Edge.LeftMid, leftMid); 
		map.put(Edge.Mid, mid);			map.put(Edge.MidMid, midMid);	map.put(Edge.Middle, middle);			
		
	} 
	
	Map<Edge, Character> getTheme();
	public default char top() { return getTheme().get(Edge.Top);}
	public default char topMid() { return getTheme().get(Edge.TopMid);}
	public default char topLeft() { return getTheme().get(Edge.TopLeft);}
	public default char topRight() { return getTheme().get(Edge.TopRight);}
	
	public default char bottom() { return getTheme().get(Edge.Bottom);}
	public default char bottomMid() { return getTheme().get(Edge.BottomMid);}
	public default char bottomLeft() { return getTheme().get(Edge.BottomLeft);}
	public default char bottomRight() { return getTheme().get(Edge.BottomRight);}
	
	
	public default char left() { return getTheme().get(Edge.Left);}
	public default char leftMid() { return getTheme().get(Edge.LeftMid);}
	
	public default char right() { return getTheme().get(Edge.Right);}
	public default char rightMid() { return getTheme().get(Edge.RightMid);}
	
	public default char middle() { return getTheme().get(Edge.Middle);}
	public default char mid() { return getTheme().get(Edge.Mid);}
	public default char midMid() { return getTheme().get(Edge.MidMid);}
	
}
