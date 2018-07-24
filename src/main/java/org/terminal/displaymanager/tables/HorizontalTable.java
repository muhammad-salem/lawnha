package org.terminal.displaymanager.tables;

import java.util.List;

import org.terminal.beans.ColumnStyle;
import org.terminal.beans.Row;

public interface HorizontalTable<T> extends BaseTable<T>{

	
	default void printHead(StringBuilder builder) {
		
	}
	default void printRow(StringBuilder builder, int index) {
		
	}
	default void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles) {
		
	}
	default void printHeadBorder(StringBuilder builder) {
		
	}
	default void printMidLine(StringBuilder builder) {
		
	}
	default void printFootBorder(StringBuilder builder) {
		
	}
}
