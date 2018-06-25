package org.terminal.displaymanager.coordinate;

public class Pos extends PosUtils implements Position{
	public int x;
	public int y;
	
	@Override
	public Pos moveBy ( Pos pos ) {
		this.x += pos.x;
		this.y += pos.y;
		return this;
	}
	
	@Override
	public Pos moveBy ( int x, int y ) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	@Override
	public Pos moveXBy(int x) {
		this.x += x;
		return this;
	}

	@Override
	public Pos moveYBy(int y) {
		this.y += y;
		return this;
	}
	
	public Pos getAddPos ( Pos addpos ) {
		return addPos(this, addpos);
	}
	
	public Pos getSubPos ( Pos pos ) {
		return subPos(this, pos);
	}

	
}
