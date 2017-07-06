package dev.TP05;

import dev.tpException.DeletePizzaException;
import dev.tpException.SavePizzaException;
import dev.tpException.UpdatePizzaException;

public interface IPizzaDao {

	Pizza[] findAllPizzas();
	boolean saveNewPizza (Pizza pizza) throws SavePizzaException;
	boolean updatePizza (String codePizza, Pizza pizza) throws UpdatePizzaException;
	boolean deletePizza (String codePizza) throws DeletePizzaException;
}
