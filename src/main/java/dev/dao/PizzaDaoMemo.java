package dev.dao;

import java.util.ArrayList;

import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public class PizzaDaoMemo implements IPizzaDao {
	
	
	

	

	private List<Pizza> pizzas = new ArrayList<>();
	/**
	 * Este metodo no deberia ser un constructor
	 * Puede aue nos interese empezar desde otra lista
	 * @return 
	 */
	public void init() {
		
		pizzas.add(new Pizza("PEP", "Peperoni", 12.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La Cannibale", 12.5, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.0, CategoriePizza.POISSON));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.5, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("IND", "L'indienne", 14, CategoriePizza.SANS_VIANDE));
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

		if (a != null && (b == null ||  a.getCode().equals(codePizza)) ) {
			a.setPizza(pizza.code, pizza.nom, pizza.prix, pizza.categ);
		} else if (a != null && !a.getCode().equals(codePizza)) {
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
