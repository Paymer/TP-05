package pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pizzeria.central.Menu;
import pizzeria.dao.clientdao.IClientDao;
import pizzeria.dao.commandes.ICommandesDao;
import pizzeria.ihm.menu.option.Connection;
import pizzeria.ihm.menu.option.Inscription;
import pizzeria.ihm.menu.option.OptionMenuClient;
import pizzeria.ihm.utils.ClientConsole;

public class PremierMenuClient implements Menu {

	
	private Scanner scanner;
	ICommandesDao comDao;
	IClientDao clDao;
	
	public PremierMenuClient(IClientDao cl, ICommandesDao com, Scanner scanner) {
		this.scanner = scanner;
		this.comDao = com;
		this.clDao = cl;
		
		
	}

	Map<Integer, OptionMenuClient> options = new HashMap<>();
	
	//It is necessary to get activate the options in the hash map
	
	public void initOpt() {
		options.put(1, new Inscription());
		options.put(2, new Connection());
	
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
		
		
		//FIRST MENU
		//It will do the actions choose until 99 is introduced through the console
		int a;
		do{
			afficher();
			
			a = scanner.nextInt();
			//the hash Map is used to get the actions we need
	
			 if (a > 0 && a < 3 ) {options.get(a).execute(comDao, clDao, scanner);}
			 
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
