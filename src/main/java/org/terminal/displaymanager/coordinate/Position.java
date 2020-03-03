package org.terminal.displaymanager.coordinate;

public interface Position {
	
	void moveBy ( Point point ) ;
	void moveBy ( int x, int y );
	
	void moveByX ( int x );
	void moveByY ( int y );
	
	int getX();
	int getY();
	
	void moveTo  ( Point point );
	void moveToX ( int x );
	void moveToY ( int y );
	
}
