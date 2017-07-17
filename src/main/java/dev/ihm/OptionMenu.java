package dev.ihm;

import dev.dao.PizzaDao;


public interface OptionMenu {

	
	public void execute(PizzaDao dao);

	public String getLibelle();
}
