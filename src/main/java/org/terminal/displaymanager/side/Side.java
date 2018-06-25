package org.terminal.displaymanager.side;

import org.terminal.displaymanager.coordinate.Position;
import org.terminal.displaymanager.coordinate.Size;
import org.terminal.displaymanager.print.Text;

public interface Side {
	
	void setStartPosition (Position position);
	Position getStartPosition ();
	
	void setSize (Size size);
	Size getSize ();
	
	void setVolum (Position startPosition, Size size);
	
	void addText (Text text);
	void addText (Text... texts);
	
	void changeToText (Text text);
	void changeToTexts (Text... texts);
	
	void removeText (Text text);
	void removeText (Text... texts);
	void clearText  ();
	
	
	void prepareSide ();
	
	
	
	
}
