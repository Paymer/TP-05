package dev.ihm;

import org.slf4j.LoggerFactory;

public class Console {

	public void console(String message) {
		LoggerFactory.getLogger("dev.ihm").info(message);

	}
}
