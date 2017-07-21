package dev.dao;


import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.PizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public interface IPizzaDao {

	List<Pizza> getPizzas();
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
	
	
	
	
	void init() throws PizzaException;
	/**
	 * Initializes the list of pizzas/db
	 */
	

	
}
