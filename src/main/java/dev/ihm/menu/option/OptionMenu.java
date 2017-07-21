package dev.ihm.menu.option;

import java.util.Scanner;

import dev.dao.IPizzaDao;
import dev.dao.PizzaDaoMemo;


public interface OptionMenu {

	
	public void execute(IPizzaDao dao, Scanner scanner);

	public String getLibelle();
}
