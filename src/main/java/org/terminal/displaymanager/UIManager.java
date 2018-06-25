package org.terminal.displaymanager;

import java.io.OutputStream;

import org.terminal.displaymanager.coordinate.Pos;

public interface UIManager extends Runnable{
	
	void setHeader (Header header);
	void setPage   (Page page);
	void setFotter (Fotter fotter);
	
	void updateUIManager();
	
	void clearUI  ();
	void renderUI ();
	void setRenderTime (int millsecond);
	
	void setWorkingThread (Thread thread);
	
	/**
	 * get all the rendering process as outputstream
	 * simple render to the center page;
	 * @return 
	 */
	OutputStream asOutputStream ();
	
	void setCursorPostion (Pos pos);
	Pos getCursorPostion  ();
	
	
}
