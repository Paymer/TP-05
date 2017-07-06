package dev.optionMenu;

import java.util.Scanner;

import dev.TP05.Pizza;
import dev.TP05.PizzaDao;
import dev.tpException.SavePizzaException;

public class NouvellePizzaOptionMenu extends OptionMenu {

	public String getLibelle() {
		return ("2. Ajouter une nouvelle pizza");
	}

	public void execute(PizzaDao dao) {
		Pizza[] pizzas = dao.findAllPizzas();

		Scanner scann = new Scanner(System.in);
		System.out.println("Veuillez saisir le code");
		String code = scann.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = scann.next();
		System.out.println("Veuillez saisir le prix");
		double prix;

		while (!scann.hasNextDouble()) {
			//* THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER BUG!!!*//
			System.out.println("Sorry, couldn't understand you! Try it again!");

			scann.nextLine();
		}
		if (scann.hasNextDouble()) {
			prix = scann.nextDouble();
			try {
				dao.saveNewPizza(new Pizza(code, nom, prix));
			} catch (SavePizzaException e) {
				// in case there is not enough space in the table (max 20)
				System.out.println(e.getMessage());
			}
		}

	}

}