package dev.dao;

import org.slf4j.LoggerFactory;

import dev.ihm.Menu;

/**
 * @author Pau-Pau
 *
 */
public class Main {
	public static void main(String[] args) {
		LoggerFactory.getLogger("dev.dao").info("System Initialized");

		Menu M = new Menu();
		M.manage();

	}
}
