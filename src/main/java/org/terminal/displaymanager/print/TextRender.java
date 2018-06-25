package org.terminal.displaymanager.print;

public interface TextRender {
	
	void display (Text text) ;
	
	void calculateTotalTimeForTimeMark ();
	void setTimeMark (int timeMark);
	
	String nextTimeMark ();
	String nextTimeMark (int timeMark);
	
	
}
