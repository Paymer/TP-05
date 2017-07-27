package pizzeria.dao.pizzadao;


import java.util.List;

import pizzeria.central.Pizza;
import pizzeria.dao.exception.DeletePizzaException;
import pizzeria.dao.exception.PizzaException;
import pizzeria.dao.exception.SavePizzaException;
import pizzeria.dao.exception.UpdatePizzaException;

public interface IPizzaDao {

	List<Pizza> getPizzas();
	
	
	
	
	
	void init() throws PizzaException;
	/**
	 * Initializes the list of pizzas/db
	 */
	
	
	void saveNewPizza (Pizza pizza) throws SavePizzaException;
	/**
	 * This method adds a Pizza to the menu/list
	 * @param codePizza
	 * @param pizza
	 * @throws UpdatePizzaException
	 */
	
	
	void updatePizza (String codePizza, Pizza pizza) throws UpdatePizzaException;
	/**
	 * Modifys one of the pizzas of the list
	 * @param codePizza
	 * @throws DeletePizzaException
	 */
	
	void deletePizza (String codePizza) throws DeletePizzaException;
	/**
	 * It delete one pizza of the list
	 * @throws PizzaException
	 */
	
	default void close() {
		/**
		 * It is necessary to close the emf from API
		 * If not the application cannot be closed
		 */
	}
	


	
}
