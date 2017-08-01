package pizzeria.ihm.menu;


import java.util.Scanner;


import pizzeria.ihm.menu.option.Connection;
import pizzeria.ihm.menu.option.Inscription;


public class PremierMenuClient extends Menu {


	
	public PremierMenuClient(Object cl, Object com, Scanner scanner2) {
		super(cl, com, scanner2);
		
	}

	//It is necessary to get activate the options in the hash map
	@Override
	public void initOpt() {
		options.put(1, new Inscription());
		options.put(2, new Connection());
	
	}


	
	
	
}
