package dev.ihm;

import java.util.Scanner;

import dev.dao.CategoriePizza;
import dev.dao.Pizza;
import dev.dao.PizzaDao;
import dev.tpexception.UpdatePizzaException;

public class Modify extends OptionMenu {

	@Override
	public String getLibelle() {
		return ("3. Mettre à jour une pizza");
	}

	@Override
	public void execute(PizzaDao dao) {
		Scanner scann = new Scanner(System.in);

		// ask the code of the pizza to modify

		co.console("Veuillez saisir le code de la pizza a modifier:");
		co.console("99 pour abandonner");
		String oldCode = scann.next();

		// Checking if the user wants to exit
		if (!oldCode.equals("99")) {
			// The user has chosen a code, now it is necessary to demand the
			// rest of the information
			co.console("Introduisez le noveau code");
			String code = scann.next();
			co.console("Introduisez le noveau nom (sans espace)");
			String nom = scann.next();
			co.console("Veuillez saisir la categorie");
			String cat = scann.next();
			CategoriePizza categ = CategoriePizza.valueOf(cat);
			co.console("Introduisez le noveau prix");

			while (!scann.hasNextDouble()) {
				// * THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER
				// BUG!!!*//
				co.console("Sorry, couldn't understand you! Try it again!");

				scann.nextLine();
			}

			double prix = scann.nextDouble();

			Pizza pizza = new Pizza(code, nom, prix, categ);

			// call the method dao.update
			try {
				dao.updatePizza(oldCode, pizza);
				co.app(" Modification done ");
			} catch (UpdatePizzaException e) {
				// in case the code does not exist it throws an exception
				co.console(e.getMessage());
			}
		}

	}

}
