package org.terminal.displaymanager.coordinate;

public class SimplePosition extends AbstractPosition {

	@Override
	public void moveBy(Point point) {
		this.point.plus(point);
	}

	@Override
	public void moveBy(int x, int y) {
		point.plus(new Point(x, y));
	}

	@Override
	public void moveByX(int x) {
		this.point.plusX(x);
	}

	@Override
	public void moveByY(int y) {
		this.point.plusY(y);
	}

	@Override
	public int getX() {
		return this.point.getX();
	}

	@Override
	public int getY() {
		return this.point.getY();
	}

	@Override
	public void moveTo( Point point) {
		this.point = point;
	}

	@Override
	public void moveToX(int x) {
		this.point.setX(x);
	}

	@Override
	public void moveToY(int y) {
		this.point.setY(y);
	}

}
