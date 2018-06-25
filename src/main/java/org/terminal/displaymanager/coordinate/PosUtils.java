package org.terminal.displaymanager.coordinate;

public class PosUtils {
	
	public static Pos addPos (Pos p1, Pos p2 ) {
		final Pos pos = new Pos();
		pos.x = p1.x + p2.x;
		pos.y = p1.y + p2.y;
		return pos;
	}
	
	public static Pos subPos (Pos p1, Pos p2 ) {
		final Pos pos = new Pos();
		pos.x = p1.x - p2.x;
		pos.y = p1.y - p2.y;
		return pos;
	}
	
	public static Pos timesPos (Pos p1, Pos p2 ) {
		final Pos pos = new Pos();
		pos.x = p1.x * p2.x;
		pos.y = p1.y * p2.y;
		return pos;
	}
	
	public static Pos divPos (Pos p1, Pos p2 ) {
		final Pos pos = new Pos();
		pos.x = p1.x / p2.x;
		pos.y = p1.y / p2.y;
		return pos;
	}
	
	/**
	 * it o
	 * @param p1 {1} the first pos
	 * @param p2 {2} the second pos
	 * @return only { 1, 2 } as index for this positions 
	 */
	public static int firstPos (Pos p1, Pos p2 ) {
		if (p1.x < p2.x) return 1;
		if (p1.y < p2.y) return 1;
		return 2;
	}

}
