package org.terminal;

import java.util.Random;

import org.junit.Test;
import org.terminal.beans.RowPosition;
import org.terminal.beans.TableThemes;
import org.terminal.strings.StyleBuilder;
import org.terminal.ui.unit.Cell;
import org.terminal.ui.unit.Row;


public class AnsiTest {
	
	public static String getRandomString() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    return buffer.toString();
	}
	public Cell<String> getNewCell() {
		return new Cell<String>(getRandomString());
	}
	
	public Row<String> getNewRow() {
		Row<String> row = new Row<String>();
		row.add(getNewCell());
		row.add(getNewCell());
		row.add(getNewCell());
		row.add(getNewCell());
		return row;
	}
	

	@Test
	public void testAnsi() throws Exception {
		
		Cell<String> cell = new Cell<String>(4,5, "cell\nnew line\n3'th line");
		
		Row<String> row = new Row<>();


		StyleBuilder headStyle = new StyleBuilder();
		StyleBuilder dataStyle = new StyleBuilder();
		StyleBuilder borderStyle = new StyleBuilder();

		headStyle.redLite();
		borderStyle.blue();
		dataStyle.magenta();

		row.add(cell);
		System.out.println(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.TABLE));

		StringBuilder b = new StringBuilder();
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, headStyle, borderStyle, RowPosition.HEAD));
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(getNewRow().toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.BOTTOM ));

		System.out.println(b.toString());


	}

}
