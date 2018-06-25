package org.terminal.displaymanager.coordinate;

import org.terminal.displaymanager.print.Text;

public class Mark implements MarkBuilder{

	int row ;
	
	
	@Override
	public void createMark(int row, Text text) {
		this.row = row;
		
	}
	
}
