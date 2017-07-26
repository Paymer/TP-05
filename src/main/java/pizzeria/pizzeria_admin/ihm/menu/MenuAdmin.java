package pizzeria.pizzeria_admin.ihm.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pizzeria.central.Menu;
import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.ihm.menu.option.Delete;
import pizzeria.pizzeria_admin.ihm.menu.option.ListerPizzasOptionMenu;
import pizzeria.pizzeria_admin.ihm.menu.option.Modify;
import pizzeria.pizzeria_admin.ihm.menu.option.NouvellePizzaOptionMenu;
import pizzeria.pizzeria_admin.ihm.menu.option.OptionMenuAdmin;
import pizzeria.pizzeria_admin.ihm.utils.ConsoleLogger;

public class MenuAdmin implements Menu {


	
	private Scanner scanner;
	private IPizzaDao dao;
	
	public MenuAdmin(IPizzaDao dao, Scanner scanner) {
		this.scanner = scanner;
		this.dao = dao;
	}

	private Map<Integer, OptionMenuAdmin> options = new HashMap<>();
	
	 //It is necessary to get activate the options in the hash map
	
	public void initOpt() {
		options.put(1, new ListerPizzasOptionMenu());
		options.put(2, new NouvellePizzaOptionMenu());
		options.put(3, new Modify());
		options.put(4, new Delete());
	}

	
	
	
	public void afficher() {
	/**
	 * This method allows to see the all the options
	 */
		//It is necessary to initialize the options before using them.
		this.initOpt();
		
		ConsoleLogger co = new ConsoleLogger();
		co.console("***** Pizzeria Administration *****");
		//This allows to go to all the options in the menu
		options.forEach((numero, option) -> co.console(numero+"."+option.getLibelle()));
		co.console("99. Sortir");

	}

	
	public void manage() {

		//It will do the actions choose until 99 is introduced through the console
		int a;
		do{
			afficher();
			
			a = scanner.nextInt();
			//the hash Map is used to get the actions we need
	
			 if (a > 0 && a < 5 ) {options.get(a).execute(dao, scanner);}
			 
		}while (a!= 99);

	}

	
	
	
	
	/**
	 * @param options
	 */
	public void setOptions(Map<Integer, OptionMenuAdmin> options) {
		this.options = options;
	}
	
	/**
	 * @return the actions
	 */
	public Map<Integer, OptionMenuAdmin> getOptions() {
		return options;
	}
	
}
