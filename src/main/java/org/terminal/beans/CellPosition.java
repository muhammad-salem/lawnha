package org.terminal.beans;


/**
 * 
 *
 * 		Top
 *     ┌0────1──────2┬───1──────3┐
 *     │4           4│          4│
 * Left├9────1─────10┼───1──────5┤Right
 *     │4           4│          4│
 *     └8────1──────7┴───1──────6┘
 * 		Bottom
 *
 *  0 : TopLeft, 		
 *  1 : Top, Bottom, Mid,
 *  2 : TopMid,		
 *  3 : TopRight,
 *  4 : Right, Left, Middle
 *  5 : RightMid,
 *  6 : BottomRight, 	
 *  7 : BottomMid,
 *  8 : BottomLeft,
 *  9 : LeftMid,
 * 10 : MidMid.
 * 
 * 
 * ┌0──────1──────2┬─────1──────2┬──────1───────3┐
 * │4  TOP_LEFT   4│  TOP_MID   4│  TOP_RIGHT   4│
 * ├9──────1─────10┼─────1─────10┼──────1───────5┤
 * │4  MID_LEFT   4│  MID_MID   4│  MID_RIGHT   4│
 * ├9──────1─────10┼─────1─────10┼──────1───────5┤
 * │4 BOTTOM_LEFT 4│ BOTTOM_MID 4│ BOTTOM_RIGHT 4│
 * └8──────1──────7┴────1───────7┴──────1───────6┘
 * 
 * 
 */
public enum CellPosition {
	
	ONE_TOP_BOTTOM_LEFT_RIGHT,
	
	TWO_TOP_LEFT,
	TWO_TOP_RIGHT,
	TWO_BOTTOM_LEFT,
	TWO_BOTTOM_RIGHT,
	
	TOP_LEFT,
	TOP_MID,
	TOP_RIGHT,
	
	MID_LEFT,
	MID_MID,
	MID_RIGHT,
	
	BOTTOM_LEFT,
	BOTTOM_MID,
	BOTTOM_RIGHT;
	
	
	public char bottomRight(TableThemes theme) {
		switch (this) {
			
			case BOTTOM_RIGHT :	case TWO_BOTTOM_RIGHT:	case ONE_TOP_BOTTOM_LEFT_RIGHT : 
				return theme.bottomRight();		// 6

			case TOP_RIGHT :		case MID_RIGHT :			case TWO_TOP_RIGHT :
				return theme.rightMid();		// 5
				
			case BOTTOM_LEFT :		case BOTTOM_MID :		case TWO_BOTTOM_LEFT :
				return theme.bottomMid();		// 7 
				
			case TOP_LEFT:		case TOP_MID :		case MID_LEFT :		case MID_MID:		case TWO_TOP_LEFT:
				return theme.midMid();			// 10
			default :
				break;
		}
		return 0;
	}
	
	public char bottomLeft(TableThemes theme) {
		switch (this) {
			
			case BOTTOM_LEFT :	case TWO_BOTTOM_LEFT :	case ONE_TOP_BOTTOM_LEFT_RIGHT : 
				return theme.bottomLeft();		// 8

			case TOP_LEFT :		case MID_LEFT :			case TWO_TOP_RIGHT :
				return theme.leftMid();			// 9
				
			case BOTTOM_MID :		case BOTTOM_RIGHT :		case TWO_BOTTOM_RIGHT :
				return theme.bottomMid();		// 7 
				
			case MID_MID:		case MID_RIGHT :		case TOP_MID :		case TOP_RIGHT:		case TWO_TOP_LEFT:
				return theme.midMid();			// 10
			default :
				break;
		}
		return 0;
	}

	public char topLeft(TableThemes theme) {
		switch (this) {
			case TOP_LEFT :		case TWO_TOP_LEFT :		case ONE_TOP_BOTTOM_LEFT_RIGHT :
				return theme.topLeft();
				
			case TOP_RIGHT :	case TWO_TOP_RIGHT :	case TOP_MID :
				return theme.topMid();
				
			case MID_LEFT :		case BOTTOM_LEFT :		case TWO_BOTTOM_LEFT :
				return theme.leftMid();
				
			case MID_MID :		case MID_RIGHT :		case BOTTOM_MID :		case BOTTOM_RIGHT :		case TWO_BOTTOM_RIGHT :	
				return theme.midMid();
			default :
				break;
		}
		return 0;
	}
	
	public char topRight(TableThemes theme) {
		switch (this) {
			
			case TOP_RIGHT :	case TWO_TOP_RIGHT :	case ONE_TOP_BOTTOM_LEFT_RIGHT : 
				return theme.topRight();

			case TOP_LEFT :		case TOP_MID :			case TWO_TOP_LEFT :
				return theme.topMid();
				
			case MID_RIGHT :		case BOTTOM_RIGHT :		case TWO_BOTTOM_RIGHT :
				return theme.rightMid();
				
			case MID_LEFT :		case MID_MID :		case BOTTOM_LEFT :		case BOTTOM_MID:	
				return theme.midMid();
			default :
				break;
		}
		return 0;
	}
	
	
	public boolean isFull() {
		return name().toLowerCase().contains("right");
	}
	
}
