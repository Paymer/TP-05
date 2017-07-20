package dev.dao;

import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public interface IPizzaDao {

	List<Pizza> getPizzas();
	void saveNewPizza (Pizza pizza) throws SavePizzaException;
	void updatePizza (String codePizza, Pizza pizza) throws UpdatePizzaException;
	void deletePizza (String codePizza) throws DeletePizzaException;
	
	/**crear metodo
	 * 
	 * 
	 * default void init (){
		throw new NotImplementedException();
	}
	*/
	
}
