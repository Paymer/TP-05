package dev.ihm;

import java.util.Scanner;

import dev.dao.PizzaDao;
import dev.tpexception.DeletePizzaException;

public class Delete implements OptionMenu {
	ConsoleLogger co = new ConsoleLogger();

	@Override
	public String getLibelle() {
		return ("4. Supprimer une pizza");
	}

	@Override
	public void execute(PizzaDao dao) {

		co.console("Veuillez saisir le code de la pizza a eliminer:");
		co.console("99 pour abandonner");

		Scanner scann = new Scanner(System.in);
		String codePizza = scann.next();

		if (!codePizza.equals("99")) {

			try {
				dao.deletePizza(codePizza);
				co.app(" Deletion done ");
			} catch (DeletePizzaException e) {
				// in case the code does not exist it throws an exception
				co.console(e.getMessage());

			}
		}

	}

}
