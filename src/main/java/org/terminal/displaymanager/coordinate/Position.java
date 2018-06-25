package org.terminal.displaymanager.coordinate;

public interface Position {
	
	Position moveBy ( Pos pos ) ;
	Position moveBy ( int x, int y );
	
	Position moveXBy ( int x );
	Position moveYBy ( int y );
	
	
}
