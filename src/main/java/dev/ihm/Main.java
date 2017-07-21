package dev.ihm;

import java.util.Scanner;

import org.slf4j.LoggerFactory;

import dev.dao.IPizzaDao;
import dev.dao.PizzaDaoMemo;
import dev.ihm.menu.Menu;

/**
 * @author Pau-Pau
 *
 */
public class Main {
	public static void main(String[] args) {
		
		LoggerFactory.getLogger("dev.dao").info("System Initialized");
		/** we have to initialize it once
		 * if I initialize this in the method main
		 * it is not necessary to do it in all the classes
		 */
		
		
		IPizzaDao dao = new PizzaDaoMemo();
		dao.init();
		
		/** we introduce in the () of the try 
		 * all the variables that will be closed
		 * automatically once the try finalizes, 
		 * so it is not necessary to add the block finally
		 */
		try (Scanner scanner = new Scanner (System.in)){
			Menu menu = new Menu(dao, scanner);
			menu.manage();
		}
		
		
		/**finally{
			 * Then it is necessary to close the variable,
			 * when the application finishes
			 * if it is done before, this will not allow 
			 * to introduce anything in the console
			 

			//scanner.close();
			LoggerFactory.getLogger("dev.dao").info("System Finalized");
		}*/

		
		
		

	}
}
