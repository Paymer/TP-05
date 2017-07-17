package dev.ihm;

import dev.dao.PizzaDao;

public abstract class OptionMenu {

	public abstract void execute(PizzaDao dao);

	public abstract String getLibelle();

	Console co = new Console();
}
