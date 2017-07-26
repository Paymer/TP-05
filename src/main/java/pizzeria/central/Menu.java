package pizzeria.central;

import java.util.Map;

import pizzeria.pizzeria_client.ihm.menu.option.OptionMenuClient;

public interface Menu {

	
	/**
	 * Initializes the options of the class map
	 */
	void initOpt();
	
	/**
	 * It allows to see all the options of the menu
	 */
	  void afficher();
	  
	  
	  /**
	   * Method that manages the options available and call the necessary classes
	   */
	  void manage();
	  
	  /**
	   * Necessary methods for the hashmaps
	   * @param options
	   */
	  
	
}
