package org.terminal.displaymanager.coordinate;

public abstract class AbstractPosition implements Position {
	
	protected Point point;
	
	public AbstractPosition() {
		this.point = new Point(0, 0);
	}

	public Point add ( Point point ) {
		int x = this.point.getX() + point.getX();
		int y = this.point.getY() + point.getY();
		return new Point(x,y);
	}
	
	
	public Point sub ( Point point ) {
		int x = this.point.getX() - point.getX();
		int y = this.point.getY() - point.getY();
		return new Point(x,y);
	}
	
	public Point times ( Point point ) {
		int x = this.point.getX() * point.getX();
		int y = this.point.getY() * point.getY();
		return new Point(x,y);
	}
	
	public Point div ( Point point ) {
		int x = this.point.getX() / point.getX();
		int y = this.point.getY() / point.getY();
		return new Point(x,y);
	}
	
	/**
	 * it o
	 * @param p1 {1} the first pos
	 * @param p2 {2} the second pos
	 * @return only { 1, 2 } as index for this positions 
	 */
	public boolean isFirst ( Point point ) {
		if (this.point.getX() < point.getX()) return true;
		if (this.point.getY() < point.getY()) return true;
		return false;
	}
}
