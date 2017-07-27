package pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;

import pizzeria.central.Pizza;
import pizzeria.dao.pizzadao.IPizzaDao;
import pizzeria.ihm.utils.AdminConsole;

public class ListerPizzasOptionMenu implements OptionMenuAdmin {
	AdminConsole co = new AdminConsole();

	@Override
	public String getLibelle() {
		return ("Lister les pizzas");
	}

	@Override
	public void execute(IPizzaDao dao, Scanner scanner) {
		List<Pizza> pizzas = dao.getPizzas();
		int i = 0;
		while (i < pizzas.size()) {
			co.console(pizzas.get(i).toString());
			i++;
		}
		co.console(" List done ");
	}

}
