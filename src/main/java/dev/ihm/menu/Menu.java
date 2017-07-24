package dev.ihm.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dev.dao.IPizzaDao;
import dev.ihm.menu.option.Delete;
import dev.ihm.menu.option.ListerPizzasOptionMenu;
import dev.ihm.menu.option.Modify;
import dev.ihm.menu.option.NouvellePizzaOptionMenu;
import dev.ihm.menu.option.OptionMenu;
import dev.ihm.utils.ConsoleLogger;

public class Menu {

	ConsoleLogger co = new ConsoleLogger();
	
	private Scanner scanner;
	private IPizzaDao dao;
	
	public Menu(IPizzaDao dao, Scanner scanner) {
		this.scanner = scanner;
		this.dao = dao;
	}

	private Map<Integer, OptionMenu> options = new HashMap<>();
	
	//It is necessary to get activate the options in the hash map
	private void initOpt() {
		options.put(1, new ListerPizzasOptionMenu());
		options.put(2, new NouvellePizzaOptionMenu());
		options.put(3, new Modify());
		options.put(4, new Delete());
	}

	public void afficher() {

		co.console("***** Pizzeria Administration *****");
		//This allows to go to all the options in the menu
		options.forEach((numero, option) -> co.console(numero+"."+option.getLibelle()));

		co.console("99. Sortir");

	}

	
	public void manage() {
		//It is necessary to initialize the options before using them.
		initOpt();

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
	public void setOptions(Map<Integer, OptionMenu> options) {
		this.options = options;
	}
	
	/**
	 * @return the actions
	 */
	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}
	
}
