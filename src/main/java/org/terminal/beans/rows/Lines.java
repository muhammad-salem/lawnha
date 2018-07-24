package org.terminal.beans.rows;

import java.util.ArrayList;
import java.util.List;

public class Lines {
	
	final static char EMPTY_CHAR = '\u0000';
	final static char PADDING_CHAR = ' ';
	
	int marker;
	List<StringBuffer> buffers = new ArrayList<>();
	StringBuffer currentLine;
	
	char left;
	char right;
	char paddingChar;
	int padding;
	
	int start;
	
	public Lines() {
		this(EMPTY_CHAR, EMPTY_CHAR, 0 , PADDING_CHAR);
	}
	
	public Lines(char left, char right) {
		this(left, right, 0 ,PADDING_CHAR);
	}
	
	public Lines(char left, char right, int padding, char paddingChar) {
		this.left  = left;
		this.right = right;
		this.padding     = padding;
		this.paddingChar = paddingChar;
		this.start  = 0;
		this.marker = 0;
		nextLine();
	}
	
	public void nextLine() {
		// add new buffers
		if(marker == 0) {
			createBuffer();
		}
		else if(marker == buffers.size()) {
			start = currentLine.length();
			createBuffer();
			
		}else if (marker < buffers.size()) {
			start = currentLine.length();
		}else {
//			start = 0;
		}
		
		currentLine = buffers.get(++marker);
		// check start of the previous line
		
		
	}

	/**
	 * 
	 */
	protected void createBuffer() {
		StringBuffer buffer = new StringBuffer();
		buffers.add(buffer);
		if(left != EMPTY_CHAR) buffer.append(left);
		if(padding > 0) {
			for (int i = 0; i < padding; i++) {
				buffer.append(paddingChar);
			}
		}
	}
	
	// previous  
	public void previousLine() {
		if(buffers.size() == 0 ) return;
		currentLine = buffers.get(--marker);
	}
	
	public void endLine() {
		start = currentLine.length();
	}
	
	public StringBuffer currentLine() {
		return currentLine;
	}
	
	public List<StringBuffer> getBuffers() {
		return buffers;
	}
	
	public int size() {
		return buffers.size();
	}
	
	
	public String currentString() {
		if(right != EMPTY_CHAR) currentLine.append(right);
		return currentLine.toString();
	}
	
	
	
}
