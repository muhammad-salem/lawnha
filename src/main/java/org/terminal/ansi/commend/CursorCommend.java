package org.terminal.ansi.commend;
public enum CursorCommend{
		
		Up('A'),
		Down('B'),
		Forward('C'),
		Backward('D'),
		
		Column('G'),
	    Raw('H'),
		Home('H'),
	    
		Position('f'),
		Save('s'),
		UnSave('u');
//		SaveAttrs(),
//		RestoreAttrs();
		
		char commend;
		private CursorCommend() {}
		private CursorCommend(char c) {this.commend = c;}
		public char getCommend() { return commend; }
		
	}