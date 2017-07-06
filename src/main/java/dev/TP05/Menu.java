package dev.TP05;

import java.util.Scanner;

public class Menu {

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
				System.out.println("Code not found");
			}

			afficher();

			a = scann.nextInt();

		}
	}

	private void afficher() {

		System.out.println("***** Pizzeria Administration *****");
		

		System.out.println(A.getLibelle());
		System.out.println(B.getLibelle());
		System.out.println(C.getLibelle());
		System.out.println(D.getLibelle());
		System.out.println("99. Sortir");
		
	}

}
