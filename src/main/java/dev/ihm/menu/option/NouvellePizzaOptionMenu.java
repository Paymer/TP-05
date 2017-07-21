package dev.ihm.menu.option;

import java.util.Scanner;

import dev.dao.CategoriePizza;
import dev.dao.IPizzaDao;
import dev.dao.Pizza;
import dev.dao.PizzaDaoMemo;
import dev.exception.SavePizzaException;
import dev.ihm.utils.ConsoleLogger;

public class NouvellePizzaOptionMenu implements OptionMenu {
	ConsoleLogger co = new ConsoleLogger();

	@Override
	public String getLibelle() {
		return ("Ajouter une nouvelle pizza");
	}

	@Override
	public void execute(IPizzaDao dao, Scanner scanner) {

		Scanner scann = new Scanner(System.in);
		co.console("Veuillez saisir le code");
		String code = scann.next();
		co.console("Veuillez saisir le nom (sans espace)");
		String nom = scann.next();
		co.console("Veuillez saisir la categorie");
		String cat = scann.next();
		CategoriePizza categ = CategoriePizza.valueOf(cat);
	
		co.console("Veuillez saisir le prix");
		double prix;

		//	scann.next();
		//while (!scann.hasNextDouble()) {	
		//	co.console("Sorry, couldn't understand you! Try it again!");
		//	// * THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER
						// BUG!!!*//
		//	scann.next();
		//}
		
		
		
		//if (scann.hasNextDouble()) {
			prix = scann.nextDouble();

			try {
				dao.saveNewPizza(new Pizza(code, nom, prix, categ));
				co.app("Added new Pizza");
			} catch (SavePizzaException e) {
				// in the file the e.message will appear twice
				co.app(e.getMessage(), e);
				co.console(e.getMessage());
			//}

		}

	}

}