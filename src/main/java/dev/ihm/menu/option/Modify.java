package dev.ihm.menu.option;

import java.util.Scanner;

import dev.dao.CategoriePizza;
import dev.dao.IPizzaDao;
import dev.dao.Pizza;
import dev.dao.PizzaDaoMemo;
import dev.exception.UpdatePizzaException;
import dev.ihm.utils.ConsoleLogger;

public class Modify implements OptionMenu {

	@Override
	public String getLibelle() {
		return ("Mettre à jour une pizza");
	}

	@Override
	public void execute(IPizzaDao dao, Scanner scanner) {
		
		ConsoleLogger co = new ConsoleLogger();
		// ask the code of the pizza to modify

		co.console("Veuillez saisir le code de la pizza a modifier:");
		co.console("99 pour abandonner");
		String oldCode = scanner.next();

		// Checking if the user wants to exit
		if (!"99".equals(oldCode)) {
			// The user has chosen a code, now it is necessary to demand the
			// rest of the information
			co.console("Introduisez le noveau code");
			String code = scanner.next();
			co.console("Introduisez le noveau nom (sans espace)");
			String nom = scanner.next();
			co.console("Veuillez saisir la categorie");
			String cat = scanner.next();
			CategoriePizza categ = CategoriePizza.valueOf(cat);
			co.console("Introduisez le noveau prix");

		/**	
		 * while (!scann.hasNextDouble()) {
		*		// * THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER
		*		// BUG!!!*
				co.console("Sorry, couldn't understand you! Try it again!");

				scann.nextLine();
			}
		*/

			Double prix = scanner.nextDouble();

			Pizza pizza = new Pizza(code, nom, prix, categ);

			// call the method dao.update
			try {
				dao.updatePizza(oldCode, pizza);
				co.app(" Modification done ");
			} catch (UpdatePizzaException e) {
				// in case the code does not exist it throws an exception
				// in the file the e.message will appear twice
				co.app(e.getMessage(), e);
				co.console(e.getMessage());

			}
		}

	}

}
