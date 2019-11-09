package org.terminal;

import org.junit.Test;
import org.terminal.strings.StyleBuilder;

public class StyleBuilderTest {
	
	@Test
	public void styleBuilderTest() {
		StyleBuilder builder = new StyleBuilder();
		builder.bgBlue();
		builder.color(150);
		builder.fastBlink();
		System.out.println(builder.build(TabelTest.getRandomString()));
	}

}
