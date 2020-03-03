package org.terminal.displaymanager.coordinate;
public class Point {
	private int x;
	private int y;
	public Point() { }
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	
	public void plusX(int x) {this.x += x;}
	public void plusY(int y) {this.y += y;}
	public void plus(Point point) {this.x += point.x; this.y += point.y;}
	
	public void minX(int x) {this.x -= x;}
	public void minY(int y) {this.y -= y;}
	public void min(Point point) {this.x -= point.x; this.y -= point.y;}
}