package org.terminal.beans.rows;

import java.util.List;

interface StringLines {
	void nextLine() ;
	void createBuffer() ;
	void previousLine();
	void endLine();
	public StringBuffer currentLine();
	public List<StringBuffer> getBuffers() ;
	public int size();
	public String currentString();
	
}
