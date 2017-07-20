package dev.ihm.menu.option;

import java.util.List;
import java.util.Scanner;

import dev.dao.Pizza;
import dev.dao.PizzaDao;
import dev.ihm.utils.ConsoleLogger;

public class ListerPizzasOptionMenu implements OptionMenu {
	ConsoleLogger co = new ConsoleLogger();

	@Override
	public String getLibelle() {
		return ("Lister les pizzas");
	}

	@Override
	public void execute(PizzaDao dao, Scanner scanner) {
		List<Pizza> pizzas = dao.getPizzas();
		int i = 0;
		while (i < pizzas.size()) {
			co.console(pizzas.get(i).toString());
			i++;
		}
		co.app(" List done ");
	}

}
