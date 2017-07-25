package dev.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.LoggerFactory;

import dev.dao.IPizzaDao;
import dev.dao.PizzaDaoAPI;
import dev.dao.PizzaDaoJDBC;
import dev.dao.PizzaDaoMemo;
import dev.ihm.menu.Menu;
import dev.ihm.menu.option.Delete;
import dev.ihm.menu.option.ListerPizzasOptionMenu;
import dev.ihm.menu.option.Modify;
import dev.ihm.menu.option.NouvellePizzaOptionMenu;
import dev.ihm.menu.option.OptionMenu;

/**
 * @author Pau-Pau
 *
 */
public class Main {
	public static void main(String[] args) {
		
		LoggerFactory.getLogger("dev.ihm").info("System Initialized");
		/** we have to initialize it once
		 * if I initialize this in the method main
		 * it is not necessary to do it in all the classes
		 */
		
		/**private Map<Integer, OptionMenu> memory = new HashMap<>();
		private void initMemory() {
			memory.put(1, dao = new PizzaDaoMemo());
			memory.put(2, dao = new PizzaDaoJDBC());
			memory.put(3, dao = new PizzaDaoAPI());
		}
		
		
		initMemory();*/
		
		
		/** we introduce in the () of the try 
		 * all the variables that will be closed
		 * automatically once the try finalizes, 
		 * so it is not necessary to add the block finally
		 */
		try (Scanner scanner = new Scanner (System.in)){

			//IPizzaDao dao = new PizzaDaoMemo();
			//IPizzaDao dao = new PizzaDaoJDBC();
			IPizzaDao dao = new PizzaDaoAPI();
			dao.init();
			
			Menu menu = new Menu(dao, scanner);
			menu.manage();
			LoggerFactory.getLogger("dev.dao").info("System Finalized");
		}
	
		
		/**finally{
			 * Then it is necessary to close the variable,
			 * when the application finishes
			 * if it is done before, this will not allow 
			 * to introduce anything in the console
			 
		 	*/

		
		
		//scanner.close();
		
	}
	
	/**private static IPizzaDao createDao () {
		
		LoggerFactory.getLogger("dev.ihm").info("Which memory do you want to use?");
		LoggerFactory.getLogger("dev.ihm").info("1. Memo");
		LoggerFactory.getLogger("dev.ihm").info("2. JDBC");
		LoggerFactory.getLogger("dev.ihm").info("3. API");
		
		Scanner scanner = new Scanner (System.in);
		int a = scanner.nextInt();
		IPizzaDao dao;
		
		
		if (a == 1){
			dao = new PizzaDaoMemo();
			dao.init();
			return dao;
			}
	
		else if (a == 2){
			dao = new PizzaDaoJDBC();
			dao.init();
			return dao;
			}
		
		else if (a == 3){
			dao = new PizzaDaoAPI();
			dao.init();
			return dao;
			}
		
		
		
		scanner.close();
		
		
	}*/
	
}
