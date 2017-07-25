package pizzeria.pizzeria_admin.ihm.menu.option;

import java.util.Scanner;

import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.dao.exception.DeletePizzaException;
import pizzeria.pizzeria_admin.ihm.utils.ConsoleLogger;

public class Delete implements OptionMenuAdmin {
	ConsoleLogger co = new ConsoleLogger();

	@Override
	public String getLibelle() {
		return ("Supprimer une pizza");
	}

	@Override
	public void execute(IPizzaDao dao, Scanner scanner) {
		
		co.console("Veuillez saisir le code de la pizza a eliminer:");
		co.console("99 pour abandonner");

		
		String codePizza = scanner.next();

		if (!codePizza.equals("99")) {

			try {
				dao.deletePizza(codePizza);
				co.console(" Deletion done ");
			} catch (DeletePizzaException e) {
				// in case the code does not exist it throws an exception
				co.console(e.getMessage());

			}
		}

	}

}
