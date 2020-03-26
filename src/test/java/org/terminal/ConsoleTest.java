package org.terminal;

import org.junit.Test;
import org.terminal.console.Console;

public class ConsoleTest {
	
	@Test
	public void test1() {
		Console.clear();
		Console.log("log %s", "ddd");
		Console.info("info %s", "ddd");
		Console.trace("trace %s");
		Console.debug("debug %s", "ddd");
		Console.error("error %s", "ddd");
		Console.warn("warn %s", "ddd");
		Console.assertions(false, "assertions %s", "ddd");
	}

}
