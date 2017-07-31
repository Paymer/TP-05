package pizzeria;


import java.util.Scanner;

import org.slf4j.LoggerFactory;

import pizzeria.dao.exception.AddException;
import pizzeria.dao.pizzadao.IPizzaDao;
import pizzeria.dao.pizzadao.PizzaDaoAPI;
import pizzeria.ihm.menu.MenuAdmin;


/**
 * @author Pau-Pau
 *
 */
public class MainAdmin {
	public static void main(String[] args) {
		
		LoggerFactory.getLogger("dev.ihm").info("System Initialized");
	
		try (Scanner scanner = new Scanner (System.in)){


			IPizzaDao dao = new PizzaDaoAPI();
			
			/**IPizzaDao dao = new PizzaDaoMemo();
			*IPizzaDao dao = new PizzaDaoJDBC();*/
			dao.init();
			
			MenuAdmin menu = new MenuAdmin(dao, scanner);
			menu.manage();
			LoggerFactory.getLogger("dev.dao").info("System Finalized");
			dao.close();
		} catch (AddException e) {
			
		}


		
		
	}
	
	
}
