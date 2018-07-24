package org.terminal.beans;

public enum RowPosition {
	HEAD, MID, BOTTOM, TABLE;
	
	public CellPosition first() {
		
		switch (this) {
			case TABLE :
			case HEAD :
				return CellPosition.TOP_LEFT;
			case MID :
				return CellPosition.MID_LEFT;
			case BOTTOM :
				return CellPosition.BOTTOM_LEFT;
			default :
				break;
		}
		return CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT;
	}
	
	public CellPosition middle() {
		switch (this) {
			case TABLE :
			case HEAD :
				return CellPosition.TOP_MID;
			case MID :
				return CellPosition.MID_MID;
			case BOTTOM :
				return CellPosition.BOTTOM_MID;
		default :
			break;
	}
	return CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT;
}
	

	public CellPosition last() {
		switch (this) {
			case TABLE :
			case HEAD :
				return CellPosition.TOP_RIGHT;
			case MID :
				return CellPosition.MID_RIGHT;
			case BOTTOM :
				return CellPosition.BOTTOM_RIGHT;
			default :
				break;
		}
		return CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT;
	}
	
	public boolean isFull() {
		switch (this) {
			case TABLE :
			case BOTTOM :
				return true;
			default :
				return false;
		}
	}
	
}
