package dev.ihm;

import java.util.Scanner;

import dev.dao.PizzaDao;

public class Menu {

	Console co = new Console();

	ListerPizzasOptionMenu A = new ListerPizzasOptionMenu();
	NouvellePizzaOptionMenu B = new NouvellePizzaOptionMenu();
	Modify C = new Modify();
	Delete D = new Delete();

	public void manage() {

		PizzaDao dao = new PizzaDao();

		afficher();

		Scanner scann = new Scanner(System.in);
		int a = scann.nextInt();

		while (a != 99) {

			switch (a) {

			case (1): // ListerPizzasOptionMenu of Pizzas

				A.execute(dao);
				break;

			case (2):// NouvellePizzaOptionMenu a new Pizza

				B.execute(dao);

				break;

			case (3): // Correct the information of one pizza
				C.execute(dao);
				break;

			case (4):// Delete a Pizza from the list

				D.execute(dao);

				break;
			case (99):
				break;
			default:
				co.console("Code not found");
			}

			afficher();

			a = scann.nextInt();

		}
	}

	private void afficher() {

		co.console("***** Pizzeria Administration *****");

		co.console(A.getLibelle());
		co.console(B.getLibelle());
		co.console(C.getLibelle());
		co.console(D.getLibelle());
		co.console("99. Sortir");

	}

}
