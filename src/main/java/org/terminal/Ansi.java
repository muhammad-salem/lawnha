package org.terminal;

import org.terminal.beans.RowPosition;
import org.terminal.beans.TableThemes;
import org.terminal.strings.StyleBuilder;
import org.terminal.ui.unit.Cell;
import org.terminal.ui.unit.Row;

public class Ansi implements org.terminal.ansi.Ansi {

	public static void main(String[] args) {
		
		Cell<String> cell1 = new Cell<String>(4,5, "cell1\nhiggggg");
		Cell<String> cell2 = new Cell<String>("cell2");
		Cell<String> cell3 = new Cell<String>("cell3");
		Cell<String> cell4 = new Cell<String>("cell4 help again hhhjm");
 		
		Row<String> row = new Row<>();
		
		
		StyleBuilder headStyle = new StyleBuilder(); 
		StyleBuilder dataStyle = new StyleBuilder(); 
		StyleBuilder borderStyle = new StyleBuilder();
		
		headStyle.redLite();
		borderStyle.blue();
		dataStyle.magenta();
		
		row.add(cell1);
		
		System.out.println(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.TABLE));
		
		row.add(cell2);
		row.add(cell3);
		row.add("help");
		row.add("KAKA");
		row.add("Good Boy");
		row.add(cell4);
//		
		StringBuilder b = new StringBuilder();
//		
		b.append(row.toString(TableThemes.DEFAULT_THEME, headStyle, borderStyle, RowPosition.HEAD));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
//		
//		cell3.width(41);
//		cell4.padding(3);
//		dataStyle.redLite();
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.BOTTOM ));
//		
		System.out.println(b.toString());
		
		
	}

}
