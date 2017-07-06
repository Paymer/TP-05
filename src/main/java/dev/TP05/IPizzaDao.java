package dev.TP05;

public interface IPizzaDao {

	Pizza[] findAllPizzas();
	boolean saveNewPizza (Pizza pizza);
	boolean updatePizza (String codePizza, Pizza pizza);
	boolean deletePizza (String codePizza);
}
