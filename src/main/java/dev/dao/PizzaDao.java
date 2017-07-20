package dev.dao;

import java.util.ArrayList;
import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public class PizzaDao implements IPizzaDao {
	
	

	private List<Pizza> pizzas = new ArrayList<>();
	/**
	 * Este metodo no deberia ser un constructor
	 * Puede aue nos interese empezar desde otra lista
	 * @return 
	 */
	public void init() {
		pizzas.add(new Pizza(0, "PEP", "Peperoni", 12.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(2, "REI", "La Reine", 11.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La Cannibale", 12.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.0, CategoriePizza.POISSON));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", 13.5, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(7, "IND", "L'indienne", 14, CategoriePizza.SANS_VIANDE));
	}

	/** Setters and Getters
	 */

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public List<Pizza> getPizzas() {
		/** Se devuelve una nueva lista de manera
		 * que aunque la moifiauen no va a variar nuestra lista
		 */
		return new ArrayList<>(pizzas);
	}


	
	
	
	
	
	/** Adds a new Pizza to the Menu
	 * if it already exists throw an exception
	 * 
	 * 
	 * Le find any return an optional
	 * si il y a une pizza il return la pizza
	 * sinon il throw an exception
	 * 
	 * pizzas.stream()
			.filter(p -> p.getCode().equals(pizza.getCode()))
			.findAny()
			.orElseThrow(() -> new SavePizzaException("Erreur : Le code de la pizza existe déjà. Pizza non sauvée."));
	 * 
	 * 
	 * 
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		Pizza a = checkList(pizza.code);

		if (a != null) {
			throw new SavePizzaException("This code: " + pizza.code + " already exists.");
		} else {
			pizzas.add(pizza);

		}
		
	}

	/** It modifys a pizza that already exist
	 * if it does not exist throw an exception
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// It returns the position of the code searched
		Pizza a = checkList(codePizza);
		Pizza b = checkList(pizza.code);

		if (a != null && b == null) {
			a.setPizza(pizza.code, pizza.nom, pizza.prix, pizza.categ);
		} else if (a != null) {
			throw new UpdatePizzaException("The new code : " + pizza.code + " already exists");
		} else {
			throw new UpdatePizzaException("The code : " + pizza.code + " not found");
		}

	

	}

	/** It deletes a pizza
	 * searching the code of the pizza
	 *  It returns the position of the code searched
	 */
	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		
		Pizza a = checkList(codePizza);

		if (a != null) {
			pizzas.remove(a);

		} else {
			throw new DeletePizzaException("The code : " + codePizza + " has been not found");
		}
	
	}


	
	/** It returns the position of the code searched
	 * It searches in the table the position of the code
	 *  Does it already exist?
	 *  Does not exist?
	 */
	protected Pizza checkList(String code) {

		/*
		 * "pizza" actua como el propio contador el programa va a recorrer toda
		 * la tabla hasta encontrar el codigo o llegar a la ultima posicion de
		 * la lista.
		 */
		for (Pizza p : pizzas) {

			if (p.getCode().equals(code)) {
				return p;
			}
		}

		return null;

	}
}
