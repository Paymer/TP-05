package pizzeria.pizzeria_client.ihm.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pizzeria.central.Menu;
import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.dao.PizzaDaoAPI;
import pizzeria.pizzeria_client.dao.client.IClientDao;
import pizzeria.pizzeria_client.dao.commandes.CommandesDaoAPI;
import pizzeria.pizzeria_client.dao.commandes.ICommandesDao;
import pizzeria.pizzeria_client.ihm.menu.option.Commander;
import pizzeria.pizzeria_client.ihm.menu.option.Connection;
import pizzeria.pizzeria_client.ihm.menu.option.Inscription;
import pizzeria.pizzeria_client.ihm.menu.option.Lister;
import pizzeria.pizzeria_client.ihm.menu.option.OptionMenuClient;
import pizzeria.pizzeria_client.ihm.utils.ClientConsole;

public class SecondMenuClient implements Menu {

	
	private Scanner scanner;
	Object comDao; // list of commandes
	Object user; //the client
	

	
	public SecondMenuClient(Object cl, Object com, Scanner scanner2) {
		this.scanner = scanner2;
		this.comDao = com;
		this.user = cl; 
	}


	Map<Integer, OptionMenuClient> options = new HashMap<>();
	
	//It is necessary to get activate the options in the hash map
	
	public void initOpt() {
		options.put(1, new Commander());
		options.put(2, new Lister());
	
	}

	
	
	public void afficher() {
	/**
	 * This method allows to see the all the options
	 */
		//It is necessary to initialize the options before using them.
		this.initOpt();
		
		ClientConsole co = new ClientConsole();
		
		co.console("***** Pizzeria Client *****");
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
	
			 if (a > 0 && a < 2 ) {options.get(a).execute(comDao, user, scanner);}
			 
		}while (a!= 99);

	}

	
	
	
	
	/**
	 * @param options
	 */
	public void setOptions(Map<Integer, OptionMenuClient> options) {
		this.options = options;
	}
	
	/**
	 * @return the actions
	 */
	public Map<Integer, OptionMenuClient> getOptions() {
		return options;
	}
	
	
	
	
	
}
