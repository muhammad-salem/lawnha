package org.terminal.beans;

import java.util.ArrayList;
import java.util.List;

import org.terminal.strings.StyleBuilder;

public class Table<T> {

	protected static char truncate = '…';

	protected List<Integer> columnWidths;

	protected Row<String> head;
	protected List<Row<T>> rows;

	protected ColumnStyle headStyle;
	protected List<ColumnStyle> columnStyle;
	protected StyleBuilder borderStyle;
	protected TableThemes tableTheme;

	// protected List<Integer> colAligns;
	// protected Map<Direction, Integer> padding;

	// protected boolean colors = true;
	// protected boolean compact = false;
	
	protected boolean horizontal = false;

	protected int columnCount;

	public Table(int columnCount, boolean horizontal) {
		this(columnCount);
		this.horizontal = horizontal;
	}
	public Table(int columnCount) {
		this.columnCount = columnCount;
		head = new Row<>(columnCount);
		rows = new ArrayList<>();

		tableTheme = TableThemes.DEFAULT_THEME;

		headStyle = new ColumnStyle();
		initHeaderStyle();

		columnStyle = new ArrayList<>();
		initColumnStyle();

		borderStyle = new StyleBuilder();
		borderStyle.bold().color(22, 200, 44);

		columnWidths = new ArrayList<>();
		// initColWidth();

		// colAligns = new ArrayList<>();
		// initColAligns();

		// padding = new HashMap<>();
		// initPadding();
	}

	/**
	 * 
	 */
	protected void initHeaderStyle() {
		headStyle.blue().bold();// .color(22, 200, 44);
	}

	/**
	 * 
	 */
	protected void initColumnStyle() {
		for (int i = 0; i < columnCount; i++) {
			ColumnStyle style = new ColumnStyle();
			style.green().dim().italic();
			columnStyle.add(style);
		}
	}

	/**
	 * 
	 */
	protected void initColWidth() {
		columnWidths.add(5); // id
		columnWidths.add(25); // first name
		columnWidths.add(25); // last name
		columnWidths.add(30); // e-mail
	}

	protected void callColWidth() {

		if (head.isEmpty() & rows.isEmpty()) {
			for (int i = 0; i < columnCount; i++) {
				columnWidths.add(10);
			}
			return;
		} else if (!head.isEmpty() & rows.isEmpty()) {
			for (int i = 0; i < head.size(); i++) {
				columnWidths.add(head.get(i).toString().length() + 2);
			}
			return;
		} else if (head.isEmpty() & !rows.isEmpty()) {
			Integer[] width = new Integer[rows.get(0).size()];
			for (int i = 0; i < rows.get(0).size(); i++) {
				width[i] = rows.get(0).get(i).toString().length() + 2;
			}
			for (int col = 0; col < columnCount; col++) {
				for (int i = 1; i < rows.size(); i++) {
					int wi = rows.get(i).get(col).toString().length() + 2;
					width[col] = width[col] > wi ? width[col] : wi;
				}
				columnWidths.add(width[col]);
			}
			return;
		} else {
			Integer[] width = new Integer[head.size()];
			for (int i = 0; i < head.size(); i++) {
				width[i] = head.get(i).toString().length() + 2;
			}
			for (int col = 0; col < columnCount; col++) {
				for (int i = 0; i < rows.size(); i++) {
					int wi = rows.get(i).get(col).toString().length() + 2;
					width[col] = width[col] > wi ? width[col] : wi;

				}
				columnWidths.add(width[col]);
			}
			return;
		}

	}

	// protected void initColAligns() {
	// colAligns.add(1);
	// colAligns.add(1);
	// colAligns.add(1);
	// colAligns.add(1);
	// }
	//
	// protected void initPadding() {
	// padding.put(Direction.Top , 1);
	// padding.put(Direction.Right , 1);
	// padding.put(Direction.Bottom , 1);
	// padding.put(Direction.Left , 1);
	// }

	public Row<String> getHead() {
		return head;
	}

	public void head(String... ts) {
		head.clear();
		for (int i = 0; i < ts.length; i++) {
			head.add(ts[i]);
		}
	}

	public List<Row<T>> getRows() {
		return rows;
	}

	public boolean addRow(Row<T> e) {
		return rows.add(e);
	}

	public void addRow(int index, Row<T> element) {
		rows.add(index, element);
	}

	@SuppressWarnings("unchecked")
	public void addRow(T... ts) {
		Row<T> row = new Row<>(columnCount);
		for (T t : ts) {
			row.add(t);
		}
		rows.add(row);
	}

	public Row<T> createRow() {
		Row<T> row = new Row<>(columnCount);
		rows.add(row);
		return row;
	}

	public void horizontalHead(@SuppressWarnings("unchecked") T... heads) {
		for (int i = 0; i < heads.length; i++) {
			Row<T> row = null;
			try {
				row = rows.get(i);
				row.add(heads[i]);
			} catch (IndexOutOfBoundsException e) {
				row = new Row<>();
				row.add(heads[i]);
				rows.add(row);
			}
			
		}
	}
	
	public void horizontal(@SuppressWarnings("unchecked") T[]... columns) {
		for (int i = 0; i < columns.length; i++) {
			Row<T> row = null;
			try {
				row = rows.get(i);
				row.add(columns[i]);
			} catch (IndexOutOfBoundsException e) {
				T[] col = columns[i];
				rows.add(new Row<>(col));
			}
		}
		
	}
	
	public void vertical(@SuppressWarnings("unchecked") T[]... columns) {
		T[] col = columns[0];
		for (int i = 0; i < col.length; i++) {
			List<T> list = new ArrayList<>();
			for (int j = 0; j < columnCount; j++) {
				list.add(columns[j][i]);
			}
			rows.add(new Row<>(list));
		}
	}

	public void vertical(@SuppressWarnings("unchecked") List<T>... columns) {
		List<T> col = columns[0];
		for (int i = 0; i < col.size(); i++) {
			List<T> list = new ArrayList<>();
			for (int j = 0; j < columnCount; j++) {
				list.add(columns[j].get(i));
			}
			rows.add(new Row<>(list));
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		if (columnWidths.isEmpty())
			callColWidth();
		;

		printHeadBorder(builder);
		printHead(builder);
		if (!head.isEmpty() & !rows.isEmpty()) {
			printMidLine(builder);
		}
		for (int i = 0; i < rows.size() - 1; i++) {
			printRow(builder, i);
			printMidLine(builder);
		}
		if (!rows.isEmpty())
			printRow(builder, rows.size() - 1);
		printFootBorder(builder);
		return builder.toString();
	}

	/**
	 * @param builder
	 */
	protected void printHead(StringBuilder builder) {
		if (head.isEmpty())
			return;
		printLine(builder, head, headStyle);

	}
	protected void printLine(StringBuilder builder, Row<?> row, ColumnStyle styles) {
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

	protected void printRow(StringBuilder builder, int index) {
		Row<T> row = rows.get(index);
		if (row.isEmpty())
			return;
		printLine(builder, row, columnStyle);
	}

	protected void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles) {
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

	/**
	 * @param builder
	 */
	protected void printHeadBorder(StringBuilder builder) {
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

	/**
	 * @param builder
	 */
	protected void printMidLine(StringBuilder builder) {
		if (tableTheme.leftMid() == 0 & tableTheme.mid() == 0 & tableTheme.midMid() == 0 & tableTheme.rightMid() == 0)
			return;

		builder.append(borderStyle.effect());
		builder.append(tableTheme.leftMid());
		for (int i = 0; i < columnWidths.size(); i++) {
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

	/**
	 * @param builder
	 */
	protected void printFootBorder(StringBuilder builder) {
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
