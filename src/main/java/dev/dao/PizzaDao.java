package dev.dao;

import java.util.ArrayList;
import java.util.List;

import dev.tpexception.DeletePizzaException;
import dev.tpexception.SavePizzaException;
import dev.tpexception.UpdatePizzaException;

public class PizzaDao implements IPizzaDao {

	List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDao() {
		pizzas.add(new Pizza(0, "PEP", "Peperoni", 12.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14, CategoriePizza.VIANDE ));
		pizzas.add(new Pizza(2, "REI", "La Reine", 11.5,  CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12,  CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La Cannibale", 12.5,  CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.0,  CategoriePizza.POISSON));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", 13.5,  CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(7, "IND", "L'indienne", 14,  CategoriePizza.SANS_VIANDE));
	}

	public int numPizzas = pizzas.size();

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	// Adds a new Pizza to the menu
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		Pizza a = checkList(pizza.code);

		if (a!=null) {
			throw new SavePizzaException("This code: " + pizza.code + " already exists.");
		} else {
			pizzas.add(pizza);
			numPizzas++;
		}
		return false;
	}

	// It modifies a pizza that already exists
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// It returns the position of the code searched
		Pizza a = checkList(codePizza);
		Pizza b = checkList(pizza.code);
		
		if (a!=null && b==null) {

			a.setPizza(pizza.code, pizza.nom, pizza.prix, pizza.categ);
		}
		else if (a!=null) {
			throw new UpdatePizzaException("The new code : " + pizza.code + " already exists");
		}
		else {
			throw new UpdatePizzaException("The code : " + pizza.code + " not found");
		}

		return false;

	}

	// It deletes a pizza
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// It returns the position of the code searched
		Pizza a = checkList(codePizza);

		if (a!=null) {
					pizzas.remove(a);
					numPizzas--;
		} else {
			throw new DeletePizzaException("The code : " + codePizza + " has been not found");
		}
		return false;
	}

	// It returns the position of the code searched
	/* It searches in the table the position of the code */
	protected Pizza checkList(String Q) {

		/*
		 * "pizza" actua como el propio contador el programa va a recorrer toda
		 * la tabla hasta encontrar el codigo o llegar a la ultima posicion de
		 * la lista.
		 */
		for (Pizza pizza : pizzas) {

			if (pizza.getCode().equals(Q)) {
				return pizza;
			}
		}
		
		return null;

	}
}
