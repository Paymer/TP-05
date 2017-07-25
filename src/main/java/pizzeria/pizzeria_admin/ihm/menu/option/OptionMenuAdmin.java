package pizzeria.pizzeria_admin.ihm.menu.option;

import java.util.Scanner;

import pizzeria.pizzeria_admin.dao.IPizzaDao;

public interface OptionMenuAdmin {

	
	public void execute(IPizzaDao dao, Scanner scanner);

	public String getLibelle();
}
