package pizzeria.ihm.utils;

import org.slf4j.LoggerFactory;



public class AdminConsole {

	public void console(String message) {

		/*
		 * That part is configurated in the logbak to appear in the console and
		 * in the file
		 */
		LoggerFactory.getLogger("dev.ihm").info(message);
		
	}

	public void console(String message, Object e) {

		LoggerFactory.getLogger("dev.ihm.exception").error(message, e);
		LoggerFactory.getLogger("dev.ihm").error(message);
	}

	
}
