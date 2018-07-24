package org.terminal.displaymanager;

import java.util.List;

import org.terminal.beans.ColumnStyle;
import org.terminal.beans.Row;
import org.terminal.beans.TableThemes;
import org.terminal.strings.StyleBuilder;

public interface PrintTable<T> {
	
	public Row<T> getHead();
	public List<Row<T>> getRows();
	
	void initHeadStyle();
	void initColumnStyle();
	void initBorderStyle();
	
	public List<Integer> getColumnWidths();
	public ColumnStyle getHeadStyle();

	public List<ColumnStyle> getColumnStyle();

	public StyleBuilder getBorderStyle();
	public TableThemes getTableTheme();	
	
	
	@Override
	String toString();

	void printHead(StringBuilder builder);

	void printRow(StringBuilder builder, int index) ;

	void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles);

	void printHeadBorder(StringBuilder builder);
	void printMidLine(StringBuilder builder) ;
	void printFootBorder(StringBuilder builder) ;
	
	
	

	public default boolean addRow(Row<T> e) {
		return getRows().add(e);
	}

	public default void addRow(int index, Row<T> element) {
		getRows().add(index, element);
	}

	public default void addRow(@SuppressWarnings("unchecked") T... ts) {
		Row<T> row = new Row<>();
		for (T t : ts) {
			row.add(t);
		}
		getRows().add(row);
	}

	public default Row<T> createNewRow() {
		Row<T> row = new Row<>();
		getRows().add(row);
		return row;
	}
	
}
