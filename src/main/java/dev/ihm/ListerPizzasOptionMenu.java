package dev.ihm;

import java.util.List;

import dev.dao.Pizza;
import dev.dao.PizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		return ("1. Lister les pizzas");
	}

	@Override
	public void execute(PizzaDao dao) {
		List<Pizza> pizzas = dao.getPizzas();
		int i = 0;
		while (i < pizzas.size()) {
			co.console(pizzas.get(i).toString());
			i++;
		}
		co.app(" List done ");
	}

}
