package org.terminal.displaymanager.print;

import org.terminal.displaymanager.coordinate.Pos;

/**
 * hold text / string, should have length limit. 
 * also had position info (x,y). 
 * dicide the way to display string 
 * 
 * @author Mohammed Salem
 *
 */
public interface Text {

	void setString (String string);
	void setString (Character ch);
	void setString (CharSequence charSequence);
	
	void setLengthLimit (int limit);
	void setPositionX(int x);
	void setPositionY(int y);
	
	void setPosition (Pos position );
	Pos getPosition ();
	
	
	void setTextRender ( TextRender textRender);
}
