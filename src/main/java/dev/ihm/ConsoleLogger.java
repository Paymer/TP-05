package dev.ihm;

import org.slf4j.LoggerFactory;

public class ConsoleLogger {

	public void console(String message) {

		/*
		 * That part is configurated in the logbak to appear in the console and
		 * in the file
		 */
		LoggerFactory.getLogger("dev.ihm").info(message);

	}

	public void app(String message) {
		/*
		 * That is seen in the logback but not in the console It seems that in
		 * the logback is not configurated but this is the default:
		 * 
		 * <!-- règle de logs par défaut. Ici : niveau INFO vers la sortie
		 * standard -->
		 * 
		 * <root level="DEBUG"> <appender-ref ref="FILE" /> </root>
		 * </configuration>
		 * 
		 */

		LoggerFactory.getLogger("dev.dao").info(message);

	}

	public void app(String message, Object e) {

		LoggerFactory.getLogger("dev.dao").error(message, e);

	}
}
