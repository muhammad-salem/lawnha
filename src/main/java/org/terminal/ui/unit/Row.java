package org.terminal.ui.unit;

import java.util.ArrayList;
import java.util.List;

import org.terminal.beans.CellPosition;
import org.terminal.beans.RowPosition;
import org.terminal.beans.TableThemes;
import org.terminal.strings.StyleBuilder;

public class Row<R> {
	
	List<Cell<R>> cells;
	
	public Row() {
		cells = new ArrayList<>();
	}
	
	public boolean add(R data) {
		return cells.add(new Cell<R>(data));
	}

	public boolean add(Cell<R> e) {
		return cells.add(e);
	}

	public void clear() {
		cells.clear();
	}

	public Cell<R> get(int index) {
		return cells.get(index);
	}
	
	
	
	public String toString(TableThemes theme, StyleBuilder dataStyle, StyleBuilder borderStyle, RowPosition position) {
		if(cells.isEmpty()) return "";
		StringBuilder builder = new StringBuilder();
		if(cells.size() > 2) {
			cellsRow(builder, dataStyle, borderStyle, position, theme);
		}
		else if(cells.size() == 2) {
			twoCellsRow(builder, dataStyle, borderStyle, position, theme);
		}
		else if(cells.size() == 1) {
			oneCellasRow(builder, dataStyle, borderStyle, theme);
		}
		return builder.toString();
	}


	protected void cellsRow(StringBuilder builder, StyleBuilder dataStyle,
			StyleBuilder borderStyle, RowPosition position, TableThemes theme) {
		builder.append(cells.get(0).topBorder(theme, borderStyle, position.first()));
		for (int i = 1; i < cells.size()-1; i++) {
			builder.append(cells.get(i).topBorder(theme, borderStyle, position.middle()));
		}
		builder.append(cells.get(cells.size()-1).topBorder(theme, borderStyle, position.last()));
		builder.append('\n');
		builder.append(cells.get(0).data(dataStyle, borderStyle, theme.middle(), false));
		for (int i = 1; i < cells.size()-1; i++) {
			builder.append(cells.get(i).data(dataStyle, borderStyle, theme.middle(), false));
		}
		builder.append(cells.get(cells.size()-1).data(dataStyle, borderStyle, theme.middle(), true));
		
		builder.append('\n');
		if(position.isFull()) {
			builder.append(cells.get(0).bottomBorder(theme, borderStyle, position.first()));
			for (int i = 1; i < cells.size()-1; i++) {
				builder.append(cells.get(i).bottomBorder(theme, borderStyle, position.middle()));
			}
			builder.append(cells.get(cells.size()-1).bottomBorder(theme, borderStyle, position.last()));
			builder.append('\n');
		}
	}

	protected void twoCellsRow(StringBuilder builder, StyleBuilder dataStyle,
			StyleBuilder borderStyle, RowPosition position, TableThemes theme) {
		builder.append(cells.get(0).topBorder(theme, borderStyle, CellPosition.TWO_TOP_LEFT));
		builder.append(cells.get(1).topBorder(theme, borderStyle, CellPosition.TWO_TOP_RIGHT));
		builder.append('\n');
		builder.append(cells.get(0).data(dataStyle, borderStyle, theme.middle(), false ));
		builder.append(cells.get(1).data(dataStyle, borderStyle, theme.middle(), true ));
		builder.append('\n');
		if(position.isFull()) {
			builder.append(cells.get(0).bottomBorder(theme, borderStyle, CellPosition.TWO_BOTTOM_LEFT));			
			builder.append(cells.get(1).bottomBorder(theme, borderStyle, CellPosition.TWO_BOTTOM_RIGHT));			
			builder.append('\n');
		}
	}

	protected void oneCellasRow(StringBuilder builder, StyleBuilder dataStyle,
			StyleBuilder borderStyle, TableThemes theme ) {
		builder.append(cells.get(0).topBorder(theme, borderStyle, CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT));
		builder.append('\n');
//		cells.get(0).data(builder, dataStyle, borderStyle, theme.middle());
		
		String [] lines = cells.get(0).dataLines(dataStyle, borderStyle, theme.middle(), true);
		for (int i = 0; i < lines.length-1; i++) {
			builder.append(lines[i]);
			builder.append('\n');
		}
		builder.append(lines[lines.length-1]);
		builder.append('\n');
		builder.append(cells.get(0).bottomBorder(theme, borderStyle, CellPosition.ONE_TOP_BOTTOM_LEFT_RIGHT));
		builder.append('\n');	
	}
	
	
}
