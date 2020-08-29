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
	 * compare first point
	 * @param point {x, y} the first pos
	 * @return boolean
	 */
	public boolean isFirst ( Point point ) {
		if (this.point.getX() < point.getX()) return true;
		if (this.point.getY() < point.getY()) return true;
		return false;
	}
}
