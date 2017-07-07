package dev.optionMenu;

import java.util.List;

import dev.TP05.Pizza;
import dev.TP05.PizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {

	public String getLibelle (){
		return ("1. Lister les pizzas"); 
	}
	
	
	 public void execute(PizzaDao dao) {
		 List<Pizza> pizzas = dao.getPizzas();
		int i = 0;
		while (i < pizzas.size()) {
			System.out.println(pizzas.get(i).toString());
			i++;
		}
	}

	
}
