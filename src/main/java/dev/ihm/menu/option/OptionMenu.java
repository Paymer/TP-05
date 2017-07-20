package dev.ihm.menu.option;

import java.util.Scanner;

import dev.dao.PizzaDao;


public interface OptionMenu {

	
	public void execute(PizzaDao dao, Scanner scanner);

	public String getLibelle();
}
