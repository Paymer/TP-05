package pizzeria.ihm.menu.option;

import java.util.Scanner;

import pizzeria.dao.exception.DeletePizzaException;
import pizzeria.dao.pizzadao.IPizzaDao;
import pizzeria.ihm.utils.AdminConsole;

public class Delete implements OptionMenuAdmin {
	AdminConsole co = new AdminConsole();

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
