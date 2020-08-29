package org.terminal.ui.unit;

import org.terminal.beans.CellPosition;
import org.terminal.beans.TableThemes;
import org.terminal.strings.StyleBuilder;

public class Cell<R> {
	
	public Cell() {}
	
	R data;
	public Cell(R data) {this.data = data; this.width = widthConsiderHight();this.hight = dataHight();}
	public R    data() {return data;}
	public void data(R data) {this.data = data;}
	public String dataString() {return data.toString();}
	public int dataLength() {return dataString().length();}
	public int dataLengthConsiderHight() {return dataString().length() - dataHight() + 1;}
	
	int numberOfCelles = 1;
	public Cell(R data, int numberOfCelles) {this(data); this.numberOfCelles = numberOfCelles;}
	public int  numberOfCelles() {return numberOfCelles;}
	public void numberOfCelles(int numberOfCelles) {this.numberOfCelles = numberOfCelles;}
	
	int width = 22;
	public Cell(int width, int numberOfCelles) {this.width = width;  if(numberOfCelles > 0)this.numberOfCelles = numberOfCelles;}
	public Cell(int width, R data) {this.data = data; this.width = width;}
	public Cell(R data, int width, int numberOfCelles) {this.data = data; this.numberOfCelles = numberOfCelles;this.width = width;}
	public void width(int width) {this.width = width;}
	public int  width() {return width;}
	public int  dataWidth() {return data != null?  dataLength() : 0;}
	
	public int  widthConsiderHight() { 
//		String lines[] = dataString().split("\n");
//		int minWidth = width;
//		for (String string : lines) {
//			minWidth = string.length() < minWidth ? string.length() : minWidth;
//			minWidth = minWidth > width ? width : minWidth;
//		}
//		return minWidth;
		
		int hight = dataHight();
		if(hight > 1) {
			return dataWidth() - hight + 1;
		}
		return dataWidth();
	}
	
	int hight = 1;
	public Cell(int width, int hight, int numberOfCelles) {this.width = width; this.hight = hight; this.numberOfCelles = numberOfCelles;}
	public Cell(int width, int hight, R data) {this.data = data; this.hight = hight; this.width = width;}
	public Cell(R data,int width, int hight, int numberOfCelles) {this.data = data; this.hight = hight; this.numberOfCelles = numberOfCelles;this.width = width;}
	public void hight(int hight) {this.hight = hight;}
	public int  hight() {return hight;}
	public int  dataHight() {if(data == null) return 1;int h = 1 ;for (char c : dataString().toCharArray()) {if(c == '\n')h++;}return h;}

//	public int  minHight() {int dataHight = dataHight();if(dataHight == 1) return hight;else return dataHight < hight ? dataHight : hight;}
//	public int  maxHight() {int dataHight = dataHight();if(dataHight == 1) return hight;else return dataHight > hight ? dataHight : hight;}
	
	
	int padding = 1;
	public Cell(int width, int hight, int padding, int numberOfCelles) {this.width = width; this.hight = hight; this.padding = padding; this.numberOfCelles = numberOfCelles;}
	public Cell(int width, int hight, int padding, R data) {this.data = data; this.hight = hight; this.width = width; this.padding = padding;}
	public Cell(R data,int width, int hight, int padding, int numberOfCelles) {this.data = data; this.hight = hight; this.padding = padding; this.numberOfCelles = numberOfCelles;this.width = width;}
	public void padding(int padding) {this.padding = padding;}
	public int  padding() {return padding;}
	public int  borderWidth() {return width() + (padding * 2);}
	
	
	String[] array = null;
	public String[] getArray() {
		if(array == null)
			array = dataString().split("\n");
		return array;
	}
	public String dataIndex(int index) {
		if( index >= getArray().length ) return "";
		return getArray()[index];
	}
	
	public Cell<R>  cloneMetaData() {
		Cell<R> cell = new Cell<>();
		cell.hight = this.hight;
		cell.width = this.width;
		cell.numberOfCelles = this.numberOfCelles;
		cell.padding = this.padding;
		return cell;
	}
	
	/**
	 * 
	 * ┌───────┬───────┬───────┐
	 * ├───────┼───────┼───────┤
	 * ├───────┼───────┼───────┤
	 * └───────┴───────┴───────┘
	 * 
	 * @param theme TableThemes
	 * @param style StyleBuilder
	 * @param position CellPosition
	 * @return only topBorder of a table
	 */
	
	public String topBorder(TableThemes theme, StyleBuilder style, CellPosition position){
		StringBuilder builder = new StringBuilder(style.effect());
		topBorder(builder, theme, position);
		builder.append(style.reverse());
		return builder.toString();
	}

	public String bottomBorder(TableThemes theme, StyleBuilder style, CellPosition position){
		StringBuilder builder = new StringBuilder(style.effect());
		bottomBorder(builder, theme, position);
		builder.append(style.reverse());
		return builder.toString();
	}
	
	public void topBorder(StringBuilder builder, TableThemes theme, CellPosition position){
		char left = position.topLeft(theme);
		char mid = theme.mid();
		char right = position.topRight(theme);
		border(builder, left, mid);
		if(position.isFull()) {
			builder.append(right);
		}
	}

	public void bottomBorder(StringBuilder builder, TableThemes theme, CellPosition position){
		char left = position.bottomLeft(theme);
		char mid = theme.mid();
		char right = position.bottomRight(theme);
		if(position.isFull() ) {
			border(builder, left, mid, right);
		}else {
			border(builder, left, mid);
		}
	}

	protected void border(StringBuilder builder, char left, char mid, char right){
		border(builder, left, mid);
		if(right != 0) {
			builder.append(right);
		}
	}
	
	protected void border(StringBuilder builder, char left, char mid){
		if (left == 0 & mid == 0 )
			return ;
		if(left != 0) builder.append(left);
		if(mid != 0 )
		for (int i = 0; i < borderWidth() ; i++) {
			builder.append(mid);
		}
		return;
	}
	
	public String[] dataLines(StyleBuilder dataStyle, StyleBuilder borderStyle, char middle, boolean isfull){
		String[] lines = new String[hight()];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = data(i, dataStyle, borderStyle, middle, isfull);
		}
		return lines;	
	}
	
	public String data(StyleBuilder dataStyle, StyleBuilder borderStyle, char middle, boolean isfull){
		return data(0, dataStyle, borderStyle, middle, isfull);
	}
	
	public String data(int index, StyleBuilder dataStyle, StyleBuilder borderStyle, char middle, boolean isfull){
		StringBuilder builder = new StringBuilder();
		data(builder, dataStyle, borderStyle, middle, index);
		if (isfull) {
			if (middle != 0)
				builder.append(borderStyle.build(middle + ""));
		}
		return builder.toString();
	}
	
	protected String data(StyleBuilder dataStyle, StyleBuilder borderStyle, char middle ){
		StringBuilder builder = new StringBuilder();
		data(builder, dataStyle, borderStyle, middle, 0);
		return builder.toString();
	}
	
	
	protected void data(StringBuilder builder, StyleBuilder dataStyle, StyleBuilder borderStyle, char middle ){
		data(builder, dataStyle, borderStyle, middle, 0);
	}

	protected void data(StringBuilder builder, StyleBuilder dataStyle, StyleBuilder borderStyle, char middle, int index ){
		
		String print = dataIndex(index);
		int fill_empty_char = width() - print.length();
		int reminder = 0;
		if(fill_empty_char < 0) {
			print = print.substring(0, width() - 1 ) + '.';
			fill_empty_char = 0;
		}else if(fill_empty_char == 0) {
			fill_empty_char = 0;
		}else {
			reminder = (fill_empty_char%2);
			fill_empty_char /= 2 ;
			
		}
		
		if (middle != 0)
			builder.append(borderStyle.build(middle + ""));
		for (int j = 0; j < fill_empty_char + padding ; j++) {
			builder.append(' ');
		}
		builder.append(dataStyle.build(print));
		for (int i = 0; i < fill_empty_char + reminder + padding; i++) {
			builder.append(' ');
		}
	}
	
}
