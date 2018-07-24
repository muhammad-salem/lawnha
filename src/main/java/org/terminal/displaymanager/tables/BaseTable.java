package org.terminal.displaymanager.tables;

import java.util.List;

import org.terminal.beans.ColumnStyle;
import org.terminal.beans.Row;

public interface BaseTable<T> {

	AbstractTable<T> getTable();
	void printHead(StringBuilder builder);
	void printRow(StringBuilder builder, int index) ;
	void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles);
	void printHeadBorder(StringBuilder builder);
	void printMidLine(StringBuilder builder);
	void printFootBorder(StringBuilder builder);
}
