package org.terminal.ansi;

public interface AnsiBase {
	final char escape = '\u001B';		// 27
	final String escape_sequences = "\u001B[";
	
	final char CommendDisplay = 'm';
	
	
	default String getcommend(char commend) {
		return escape_sequences + commend;
	} 
	
	default String getcommend(int first, int second, char commend) {
		return escape_sequences + first + ';' + second + commend;
	}
	
	default String getcommend(int[] values, char commend) {
		StringBuilder builder = new StringBuilder(escape_sequences);
		int i = 0;
		for (; i < values.length-1; i++) {
			builder.append(values[i]);
			builder.append(';');
		}
		builder.append(values[i]);
		builder.append(commend);
		return builder.toString();
	}
	
	
	
}
