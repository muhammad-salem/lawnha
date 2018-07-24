package org.terminal.displaymanager.tables;

import java.util.List;

import org.terminal.beans.ColumnStyle;
import org.terminal.beans.Row;
import org.terminal.beans.TableThemes;

public interface VerticalTable<T> extends BaseTable<T>{
	
	default void printHead(StringBuilder builder) {
		AbstractTable<T> table =  getTable();
		printLine(builder, table.head, table.headStyle);
	}
	default void printLine(StringBuilder builder, Row<?> row, ColumnStyle styles) {
		AbstractTable<T> table =  getTable();
		TableThemes tableTheme = table.tableTheme;
		ColumnStyle borderStyle = table.borderStyle;
		List<Integer> columnWidths = table.columnWidths;
		
		if (tableTheme.left() != 0)
			builder.append(borderStyle.build(tableTheme.left() + ""));
		for (int i = 0; i < table.columnCount; i++) {
			String print = row.get(i).toString();
			int length = (columnWidths.get(i) - print.length()) / 2;
			int j = 0;
			for (; j < length; j++) {
				builder.append(' ');
			}
			j += print.length();
			print = styles.build(print);
			builder.append(print);
			for (; j < columnWidths.get(i); j++) {
				builder.append(' ');
			}
			if (i < columnWidths.size() - 1) {
				if (tableTheme.middle() != 0)
					builder.append(borderStyle.build(tableTheme.middle() + ""));
			}

			else {
				if (tableTheme.right() != 0)
					builder.append(borderStyle.build(tableTheme.right() + ""));
			}
		}
		builder.append('\n');
	}
	default void printRow(StringBuilder builder, int index) {
		AbstractTable<T> table =  getTable();
		Row<T> row = table.rows.get(index);
		if (row.isEmpty())
			return;
		printLine(builder, row, table.columnStyle);
	}
	default void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles) {
		AbstractTable<T> table =  getTable();
		TableThemes tableTheme = table.tableTheme;
		ColumnStyle borderStyle = table.borderStyle;
		List<Integer> columnWidths = table.columnWidths;
		int columnCount = table.columnCount;
		
		if (tableTheme.left() != 0)
			builder.append(borderStyle.build(tableTheme.left() + ""));
		for (int i = 0; i < columnCount; i++) {
			String print = row.get(i).toString();
			int length = (columnWidths.get(i) - print.length()) / 2;
			int j = 0;
			for (; j < length; j++) {
				builder.append(' ');
			}
			j += print.length();
			print = styles.get(i).build(print);
			builder.append(print);
			for (; j < columnWidths.get(i); j++) {
				builder.append(' ');
			}
			if (i < columnWidths.size() - 1) {
				if (tableTheme.middle() != 0)
					builder.append(borderStyle.build(tableTheme.middle() + ""));
			}

			else {
				if (tableTheme.right() != 0)
					builder.append(borderStyle.build(tableTheme.right() + ""));
			}
		}
		builder.append('\n');
		
	}
	default void printHeadBorder(StringBuilder builder) {
		AbstractTable<T> table =  getTable();
		TableThemes tableTheme = table.tableTheme;
		ColumnStyle borderStyle = table.borderStyle;
		List<Integer> columnWidths = table.columnWidths;
		
		if (tableTheme.topLeft() == 0 & tableTheme.top() == 0 & tableTheme.topMid() == 0 & tableTheme.topRight() == 0)
			return;
		builder.append(borderStyle.effect());
		builder.append(tableTheme.topLeft());
		for (int i = 0; i < columnWidths.size(); i++) {
			for (int j = 0; j < columnWidths.get(i); j++) {
				builder.append(tableTheme.top());
			}
			if (i < columnWidths.size() - 1)
				builder.append(tableTheme.topMid());
			else
				builder.append(tableTheme.topRight());
		}
		builder.append(borderStyle.reverse());
		builder.append('\n');
	}
	default void printMidLine(StringBuilder builder) {
		AbstractTable<T> table =  getTable();
		TableThemes tableTheme = table.tableTheme;
		ColumnStyle borderStyle = table.borderStyle;
		List<Integer> columnWidths = table.columnWidths;
		
		if (tableTheme.leftMid() == 0 & tableTheme.mid() == 0 & tableTheme.midMid() == 0 & tableTheme.rightMid() == 0)
			return;

		builder.append(borderStyle.effect());
		builder.append(tableTheme.leftMid());
		for (int i = 0; i <columnWidths.size(); i++) {
			for (int j = 0; j < columnWidths.get(i); j++) {
				builder.append(tableTheme.mid());
			}
			if (i < columnWidths.size() - 1)
				builder.append(tableTheme.midMid());
			else
				builder.append(tableTheme.rightMid());
		}
		builder.append(borderStyle.reverse());
		builder.append('\n');
	}
	default void printFootBorder(StringBuilder builder) {
		AbstractTable<T> table =  getTable();
		TableThemes tableTheme = table.tableTheme;
		ColumnStyle borderStyle = table.borderStyle;
		List<Integer> columnWidths = table.columnWidths;
		
		if (tableTheme.bottomLeft() == 0 & tableTheme.bottom() == 0 & tableTheme.bottomMid() == 0
				& tableTheme.bottomRight() == 0)
			return;
		builder.append(borderStyle.effect());
		builder.append(tableTheme.bottomLeft());
		for (int i = 0; i < columnWidths.size(); i++) {
			for (int j = 0; j < columnWidths.get(i); j++) {
				builder.append(tableTheme.bottom());
			}
			if (i < columnWidths.size() - 1)
				builder.append(tableTheme.bottomMid());
			else
				builder.append(tableTheme.bottomRight());
		}
		builder.append(borderStyle.reverse());
	}
}
