package pizzeria.ihm.menu;


import java.util.Scanner;
import pizzeria.ihm.menu.option.Commander;
import pizzeria.ihm.menu.option.Lister;


public class SecondMenuClient extends Menu {



	public SecondMenuClient(Object cl, Object com, Scanner scanner2) {
		super(cl, com, scanner2);
		
	}

	
	//It is necessary to get activate the options in the hash map
	
	public void initOpt() {
		options.put(1, new Commander());
		options.put(2, new Lister());
	
	}


	
	
	
}
