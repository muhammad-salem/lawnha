package org.terminal.string;

import org.junit.Test;
import org.terminal.beans.Edge;
import org.terminal.beans.RowPosition;
import org.terminal.beans.Table;
import org.terminal.beans.TableThemes;
import org.terminal.strings.AnsiString;
import org.terminal.strings.AnsiStringBuilder;
import org.terminal.strings.StyleBuilder;
import org.terminal.ui.unit.Cell;
import org.terminal.ui.unit.Row;

public class StyleBuilderTest {

	@Test
	public void test() {
		
		StyleBuilder builder = new StyleBuilder();
		builder.cyanLite().bold().bgYellowLite().underline();
		
		System.out.println(builder.build("cyanLight Bold yellowLightbg underline"));
		System.out.println("hi");
		builder.reset().blue().defaultColorbg();		
		System.out.println(builder.build("reset blue defaultColorbg"));
		
		String string = new String("red dim");
		
		AnsiString ss = new AnsiString(string);
		ss.red().dim();
		System.out.println("ss : "+ ss);
//		ss.setString(string.concat(" blink"));
		System.out.println("ss : "+ ss.blink());
		System.out.println(ss.length());
		
		ss.color(20, 55, 255);
		ss.colorbg(200, 255, 33);
		ss.append(" append");
		System.out.println(ss.length());
		System.out.println("ss " + ss);
		
		ss.reset();
		System.out.println(ss);
		
//		Table<String> table = new Table<>(4);
//		table.head("Id", "First Name", "Last Name", "E-mail");
//		table.addRow("111", "moha", "salem", "nods@dddd.com");
//		table.addRow("2", "hassen", "bilal", "nods@dddd.com");
//		table.addRow("3", "ahmed", "nada", "nods@dddd.com");
//		table.addRow("35", "ahmed", "nada", "noda@dddd.com");
//		//System.out.println(table);
		
		Table<String> table = new Table<>(3);
		
		table.head("Name", "Index", "char index");
		String[] names = new String[Edge.values().length];
		String[] index = new String[Edge.values().length];
		String[] charindex = new String[Edge.values().length];
		int i = 0;
		for (Edge edge : Edge.values()) {
			names[i] = edge.name();
			index[i] = edge.ordinal() + "";
			charindex[i] = edge.ordinal() + "";
			i++;
		}
		table.vertical(names, index, charindex);
		
		System.out.println(table.toString());
		
	}
	
	@Test
	public void ansiStringBuilder() {
		AnsiStringBuilder builder = new AnsiStringBuilder();
		
		builder.append("normal\n");
		builder.red().bold().bgGreenLite().build("red().bold().bgGreenLite()");
		builder.append("\nnormal");
		builder.blue().bgYellowLite();
		builder.append("\nblue().bgYellowLite()");
		builder.build();
		builder.magenta();
		builder.append("\nmagenta()");
		builder.build();
		builder.bgGreen();
		builder.append("\nbgGreen()");
		System.out.println(builder.toString());
//		builder.clear();
		System.out.println("hi");
		System.out.println(builder.toString());
		builder.clear();
		builder.clearStyle();
		builder.reset();
		
		System.out.println(builder.toString());
		
//		System.out.println("\n\n\n");
	}

	@Test
	public void Ccell() {
		Cell<String> cell1 = new Cell<String>("cell1");
		Cell<String> cell2 = new Cell<String>("cell2");
		Cell<String> cell3 = new Cell<String>("cell3");
		Cell<String> cell4 = new Cell<String>(4, "cell4 hhhj");
 		
		Row<String> row = new Row<>();
		
		
		StyleBuilder headStyle = new StyleBuilder(); 
		StyleBuilder dataStyle = new StyleBuilder(); 
		StyleBuilder borderStyle = new StyleBuilder();
		
		headStyle.redLite();
		borderStyle.blue();
		dataStyle.magenta();
		
		row.add(cell1);
		row.add(cell2);
		row.add(cell3);
		row.add("help");
		row.add("KAKA");
		row.add("Good Boy");
		row.add(cell4);
		
		StringBuilder b = new StringBuilder();
//		b.append(cell.topBorder(TableThemes.DEFAULT_THEME, borderStyle, CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT));
//		b.append('\n');
//		b.append(cell.data(dataStyle, borderStyle, TableThemes.DEFAULT_THEME.middle()));
//		b.append('\n');
//		b.append(cell.bottomBorder(TableThemes.DEFAULT_THEME, borderStyle, CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT));
		
		b.append(row.toString(TableThemes.DEFAULT_THEME, headStyle, borderStyle, RowPosition.HEAD));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.MID));
		cell3.width(40);
		cell4.padding(3);
		dataStyle.redLite();
		b.append(row.toString(TableThemes.DEFAULT_THEME, dataStyle, borderStyle, RowPosition.BOTTOM ));
		
		System.out.println(b.toString());

	}
}
