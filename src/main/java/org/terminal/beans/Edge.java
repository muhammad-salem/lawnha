package org.terminal.beans;

/**
 * 
 * <pre>
 * 		Top
 *     ┌0────1──────2┬───1──────3┐
 *     │4           4│          4│
 * Left├9────1─────10┼───1──────5┤Right
 *     │4           4│          4│
 *     └8────1──────7┴───1──────6┘
 * 		Bottom
 * </pre>
 * 
 */
public enum Edge {
	TopLeft, Top, TopMid, TopRight, 
	Right, RightMid, 
	BottomRight, Bottom, BottomMid, BottomLeft, 
	Left, LeftMid, 
	Mid, MidMid, Middle;
	// Top('─'),
	// TopMid('┬'),
	// TopLeft('┌'),
	// TopRight('┐'),
	//
	// Bottom('─'),
	// BottomMid('┴'),
	// BottomLeft('└'),
	// BottomRight('┘'),
	//
	// Left('│'),
	// LeftMid('├'),
	//
	// Right('│'),
	// RightMid('┤'),
	//
	// Middle('│'),
	// Mid('─'),
	// MidMid('┼');

}
