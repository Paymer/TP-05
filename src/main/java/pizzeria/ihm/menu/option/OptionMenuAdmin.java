package pizzeria.ihm.menu.option;

import java.util.Scanner;

import pizzeria.dao.pizzadao.IPizzaDao;



public interface OptionMenuAdmin {

	
	public void execute(IPizzaDao dao, Scanner scanner);
	

	public String getLibelle();
}
