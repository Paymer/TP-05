package dev.ihm;

import java.util.Scanner;

import dev.dao.CategoriePizza;
import dev.dao.Pizza;
import dev.dao.PizzaDao;
import dev.tpexception.SavePizzaException;

public class NouvellePizzaOptionMenu implements OptionMenu {
	Console co = new Console();

	@Override
	public String getLibelle() {
		return ("2. Ajouter une nouvelle pizza");
	}

	@Override
	public void execute(PizzaDao dao) {

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

		while (!scann.hasNextDouble()) {
			// * THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER
			// BUG!!!*//
			co.console("Sorry, couldn't understand you! Try it again!");

			scann.nextLine();
		}

		if (scann.hasNextDouble()) {
			prix = scann.nextDouble();

			try {
				dao.saveNewPizza(new Pizza(code, nom, prix, categ));
				co.app("Added new Pizza");
			} catch (SavePizzaException e) {
				// in the file the e.message will appear twice
				co.app(e.getMessage(), e);
				co.console(e.getMessage());
			}

		}

	}

}