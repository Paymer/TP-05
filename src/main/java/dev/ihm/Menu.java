package dev.ihm;

import java.util.Scanner;

import dev.dao.PizzaDao;

public class Menu {

	ConsoleLogger co = new ConsoleLogger();

	ListerPizzasOptionMenu list = new ListerPizzasOptionMenu();
	NouvellePizzaOptionMenu add = new NouvellePizzaOptionMenu();
	Modify modify = new Modify();
	Delete delete = new Delete();

	public void manage() {

		PizzaDao dao = new PizzaDao();

		afficher();

		Scanner scann = new Scanner(System.in);
		int a = scann.nextInt();

		while (a != 99) {

			switch (a) {

			case (1): // ListerPizzasOptionMenu of Pizzas

				co.app(" Choose to List ");
				list.execute(dao);

				break;

			case (2):// NouvellePizzaOptionMenu a new Pizza

				co.app(" Choose to Add ");
				add.execute(dao);

				break;

			case (3): // Correct the information of one pizza

				co.app(" Choose to Modify ");
				modify.execute(dao);

				break;

			case (4):// Delete a Pizza from the list

				co.app(" Choose to Delete ");
				delete.execute(dao);

				break;
			case (99):
				co.app("System Finalized");
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

		co.console(list.getLibelle());
		co.console(add.getLibelle());
		co.console(modify.getLibelle());
		co.console(delete.getLibelle());
		co.console("99. Sortir");

	}

}
