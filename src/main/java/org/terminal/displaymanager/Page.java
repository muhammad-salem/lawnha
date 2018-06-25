package org.terminal.displaymanager;

import org.terminal.displaymanager.print.Printer;
import org.terminal.displaymanager.side.BottomSide;
import org.terminal.displaymanager.side.LeftSide;
import org.terminal.displaymanager.side.RightSide;
import org.terminal.displaymanager.side.UpperSide;

/**
 * Page element hold the 5 sides in the terminal 
 * up, bottom, left, right, center.
 * <br/>
 * 
 * @author salem
 *
 */
public interface Page {
	
	void setUpperSide  (UpperSide upperSide);
	void setRightSide  (RightSide rightSide );
	void setBottomSide (BottomSide bottomSide);
	void setLeftSide   (LeftSide leftSide);
	
	UpperSide  getUpperSide  ();
	RightSide  getRightSide  ();
	BottomSide getBottomSide ();
	LeftSide   getLeftSide   ();
	
	void setPrinter (Printer printer);
	Printer getPrinter ();
	
}
