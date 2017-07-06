package dev.optionMenu;

import dev.TP05.Pizza;
import dev.TP05.PizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {

	public String getLibelle (){
		return ("1. Lister les pizzas"); 
	}
	
	
	 public void execute(PizzaDao dao) {
		Pizza[] pizzas = dao.getPizzas();
		int i = 0;
		while (i < dao.numPizzas) {
			System.out.println(pizzas[i].toString());
			i++;
		}
	}

	
}