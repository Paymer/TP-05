package dev.TP05;

import java.util.List;

import dev.tpexception.DeletePizzaException;
import dev.tpexception.SavePizzaException;
import dev.tpexception.UpdatePizzaException;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();
	boolean saveNewPizza (Pizza pizza) throws SavePizzaException;
	boolean updatePizza (String codePizza, Pizza pizza) throws UpdatePizzaException;
	boolean deletePizza (String codePizza) throws DeletePizzaException;
}
