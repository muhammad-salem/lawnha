package org.terminal.beans;

import java.util.List;

import org.terminal.displaymanager.tables.AbstractTable;

public class BaseTable<T> extends AbstractTable<T> {

	@Override
	public void printHead(StringBuilder builder) {
		if (horizontal)
			horizontalHead(builder, head, headStyle);
	}

	protected void horizontalHead(StringBuilder builder, Row<?> row, ColumnStyle styles) {
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

	protected void virtucalHead(StringBuilder builder, Row<?> row, ColumnStyle styles) {
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

	@Override
	public void printRow(StringBuilder builder, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMidLine(StringBuilder builder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printHeadBorder(StringBuilder builder) {
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

	@Override
	public void printFootBorder(StringBuilder builder) {
		// TODO Auto-generated method stub

	}

}
