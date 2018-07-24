package org.terminal.displaymanager.tables;

import java.util.ArrayList;
import java.util.List;

import org.terminal.beans.ColumnStyle;
import org.terminal.beans.Row;
import org.terminal.beans.TableThemes;
import org.terminal.displaymanager.PrintTable;

public abstract class AbstractTable<T> implements PrintTable<T> {
	
	protected static char truncate = '…';
	
	protected Row<T> head;
	protected ColumnStyle headStyle;
	
	protected List<Row<T>> rows;
	protected List<ColumnStyle> columnStyle;
	
	protected TableThemes tableTheme;
	protected ColumnStyle borderStyle;
	
	protected List<Integer> columnWidths;
	protected boolean horizontal = false;
	
	
	public AbstractTable(boolean horizontal) {
		this();
		this.horizontal = horizontal;
	}
	public AbstractTable() {
		head = new Row<>();
		rows = new ArrayList<>();
		tableTheme = TableThemes.DEFAULT_THEME;
		headStyle = new ColumnStyle();
		columnStyle = new ArrayList<>();
		borderStyle = new ColumnStyle();
		columnWidths = new ArrayList<>();
	}
	
	protected int columnCount;
	protected int getColumnCount() {
		return columnCount;
	}
	
	
	protected void calculateColumnCount() {
		int max = 0;
		if(!head.isEmpty()) max = head.size();
		if(!rows.isEmpty()) {
			for (Row<T> row : rows) {
				max = row.size() > max ? row.size() : max;
			}
		}
		columnCount = max;
	}
	protected void calculateColumnWidth() {
		if (getHead().isEmpty() & getRows().isEmpty()) {
			getColumnWidths().add(0);
			return;
		} else if (!getHead().isEmpty() & getRows().isEmpty()) {
			for (int i = 0; i < getHead().size(); i++) {
				getColumnWidths().add(getHead().get(i).toString().length() + 2);
			}
			return;
		} else if (getHead().isEmpty() & !getRows().isEmpty()) {
			Integer[] width = new Integer[getRows().get(0).size()];
			for (int i = 0; i < getRows().get(0).size(); i++) {
				width[i] = getRows().get(0).get(i).toString().length() + 2;
			}
			for (int col = 0; col < getColumnCount(); col++) {
				for (int i = 1; i < getRows().size(); i++) {
					int wi = getRows().get(i).get(col).toString().length() + 2;
					width[col] = width[col] > wi ? width[col] : wi;
				}
				getColumnWidths().add(width[col]);
			}
			return;
		} else {
			Integer[] width = new Integer[getHead().size()];
			for (int i = 0; i < getHead().size(); i++) {
				width[i] = getHead().get(i).toString().length() + 2;
			}
			for (int col = 0; col < getHead().size(); col++) {
				for (int i = 0; i < getRows().size(); i++) {
					int wi = getRows().get(i).get(col).toString().length() + 2;
					width[col] = width[col] > wi ? width[col] : wi;

				}
				getColumnWidths().add(width[col]);
			}
			return;
		}

	}
	public Row<T> getHead() {
		return head;
	}
	public void setHead(Row<T> head) {
		this.head = head;
	}
	public ColumnStyle getHeadStyle() {
		return headStyle;
	}
	public void setHeadStyle(ColumnStyle headStyle) {
		this.headStyle = headStyle;
	}
	public List<Row<T>> getRows() {
		return rows;
	}
	public void setRows(List<Row<T>> rows) {
		this.rows = rows;
	}
	public List<ColumnStyle> getColumnStyle() {
		return columnStyle;
	}
	public void setColumnStyle(List<ColumnStyle> columnStyle) {
		this.columnStyle = columnStyle;
	}
	public TableThemes getTableTheme() {
		return tableTheme;
	}
	public void setTableTheme(TableThemes tableTheme) {
		this.tableTheme = tableTheme;
	}
	public ColumnStyle getBorderStyle() {
		return borderStyle;
	}
	public void setBorderStyle(ColumnStyle borderStyle) {
		this.borderStyle = borderStyle;
	}
	public List<Integer> getColumnWidths() {
		return columnWidths;
	}
	public void setColumnWidths(List<Integer> colWidths) {
		this.columnWidths = colWidths;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	@Override
	public void initHeadStyle() {
		if(headStyle.isEmpty())
			headStyle.blue().bold();// .color(22, 200, 44);
	}
	@Override
	public void initColumnStyle() {
		if(columnStyle.isEmpty()) {
			for (int i = 0; i < columnCount; i++) {
			ColumnStyle style = new ColumnStyle();
			style.green().dim().italic();
			columnStyle.add(style);
		}
		}
		
	}
	@Override
	public void initBorderStyle() {
		if(borderStyle.isEmpty())
			borderStyle.bold().color(22, 200, 44);
	}

	protected void beforePrint() {
		calculateColumnCount();
		calculateColumnWidth();
		initHeadStyle();
		initColumnStyle();
		initBorderStyle();
	}
	
	public abstract void printHead(StringBuilder builder);
	public abstract void printRow(StringBuilder builder, int index) ;
	public abstract void printLine(StringBuilder builder, Row<T> row, List<ColumnStyle> styles);
	public abstract void printHeadBorder(StringBuilder builder);
	public abstract void printMidLine(StringBuilder builder);
	public abstract void printFootBorder(StringBuilder builder);

}
