package org.terminal.displaymanager.coordinate;

public class Size {
	
	public final static Size SMALL = new Size(80, 24);
	public final static Size SMALL_WIDE = new Size(80, 43);
	public final static Size DEFALUT = new Size(132, 24);
	public final static Size DEFALUT_WIDE = new Size(132, 43);
	
	private int colum;
	private  int row;
	
	public Size(int colum, int row) {
		this.colum = colum;
		this.row = row;
	}
	public int getColum() {
		return colum;
	}
	public void setColum(int colum) {
		this.colum = colum;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
}
