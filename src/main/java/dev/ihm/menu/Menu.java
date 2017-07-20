package dev.ihm.menu;

import java.util.Scanner;

import dev.dao.PizzaDao;
import dev.ihm.menu.option.Delete;
import dev.ihm.menu.option.ListerPizzasOptionMenu;
import dev.ihm.menu.option.Modify;
import dev.ihm.menu.option.NouvellePizzaOptionMenu;
import dev.ihm.utils.ConsoleLogger;

public class Menu {

	ConsoleLogger co = new ConsoleLogger();

	ListerPizzasOptionMenu list = new ListerPizzasOptionMenu();
	NouvellePizzaOptionMenu add = new NouvellePizzaOptionMenu();
	Modify modify = new Modify();
	Delete delete = new Delete();


	private Scanner scanner;
	private PizzaDao dao;

	public Menu(PizzaDao dao, Scanner scanner) {
		this.scanner = scanner;
		this.dao = dao;
	}

	
	public void afficher() {

		co.console("***** Pizzeria Administration *****");

		co.console("1. " + list.getLibelle());
		co.console("2. " + add.getLibelle());
		co.console("3. " + modify.getLibelle());
		co.console("4. " + delete.getLibelle());
		co.console("99. Sortir");

	}

	
	public void manage() {
/**
 * public void demarrer() {
		
		
		int saisie = NUMERO_OPTION_SORTIE;
		
		// Afficher le menu tant qu'on ne sort pas (ie : response = 99)
		do {
			// afficher menu
			LOG.info(titre);
			actions.forEach((numero, option) -> LOG.info(numero + ". " + option.getLibelle()));

			saisie = this.scanner.nextInt();
			
			actions.get(saisie).execute();
		} while (saisie != NUMERO_OPTION_SORTIE);
		
	}
 */
		
		afficher();

		
		int a = this.scanner.nextInt();

		while (a != 99) {

			switch (a) {

			case (1): // ListerPizzasOptionMenu of Pizzas

				co.app(" Choose to List ");
				list.execute(dao, scanner);

				break;

			case (2):// NouvellePizzaOptionMenu a new Pizza

				co.app(" Choose to Add ");
				add.execute(dao, scanner);

				break;

			case (3): // Correct the information of one pizza

				co.app(" Choose to Modify ");
				modify.execute(dao, scanner);

				break;

			case (4):// Delete a Pizza from the list

				co.app(" Choose to Delete ");
				delete.execute(dao, scanner);

				break;
			case (99):
				co.app("System Finalized");
				break;
			default:
				co.console("Code not found");
			}

			afficher();

			a = scanner.nextInt();

		}
	}

	
}
