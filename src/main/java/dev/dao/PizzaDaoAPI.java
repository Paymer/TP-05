package dev.dao;

import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.PizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public class PizzaDaoAPI implements IPizzaDao{

	@Override
	public List<Pizza> getPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws PizzaException {
		// TODO Auto-generated method stub
		
	}

}
