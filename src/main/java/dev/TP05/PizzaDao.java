package dev.TP05;

import dev.tpException.CodeRepeteException;
import dev.tpException.DeletePizzaException;
import dev.tpException.SavePizzaException;
import dev.tpException.UpdatePizzaException;

public class PizzaDao implements IPizzaDao {

	Pizza[] pizzas = new Pizza[20];
	public static int numPizzas = 8;

	public PizzaDao() {
		pizzas[0] = new Pizza(0, "PEP", "Peperoni", 12.5);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14);
		pizzas[2] = new Pizza(2, "REI", "La Reine", 11.5);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12);
		pizzas[4] = new Pizza(4, "CAN", "La Cannibale", 12.5);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.0);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.5);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14);
	}

	public Pizza[] getPizzas() {
		return pizzas;
	}

	public void setPizzas(Pizza[] pizzas) {
		this.pizzas = pizzas;
	}

	public Pizza[] findAllPizzas() {

		return pizzas;
	}

	// Adds a new Pizza to the menu
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		if (numPizzas < 19) {
			int a = checkList(pizza.code);
			if (a < numPizzas) {
				throw new SavePizzaException("This code: "+ pizza.code +" already exists.");
			} else {
				pizza.setId(numPizzas);
				pizzas[numPizzas] = pizza;
				numPizzas++;
			}
			return false;
		} else {
			throw new SavePizzaException("There is not enough space, redefine the table");
		}
	}

	// It modifies a pizza that already exists
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// It returns the position of the code searched
		int a = checkList(codePizza);

		if (a < numPizzas) {

			pizzas[a].setPizza(pizza.code, pizza.nom, pizza.prix);
		}

		else {
			throw new UpdatePizzaException("The code : "+ pizza.code + "has been not found");
		}

		return false;

	}

	// It deletes a pizza
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// It returns the position of the code searched
		int a = checkList(codePizza);

		if (a < numPizzas) {
			reestructure(a);
			pizzas[numPizzas] = null;
			numPizzas--;
		} else {
			throw new DeletePizzaException( "The code : "+ codePizza + "has been not found" );
		}
		return false;
	}

	// It returns the position of the code searched
	protected int checkList(String Q) {

		/* It searches in the table the position of the code */
		int a = 0;
		boolean c = false;
		do {

			if (Q.equals(getCode(a))) {
				c = true;
			} else if (!Q.equals(getCode(a))) {
				a++;
			}

		} while (c == false && a < numPizzas);

		return a;
	}

	public String getCode(int a) {
		return pizzas[a].code;
	}

	// It re-structures the table to eliminate the gaps
	protected void reestructure(int a) {

		// Reestructuracion de la tabla
		int b;
		while (a < (numPizzas - 1)) {

			b = a + 1;

			String code = pizzas[b].getCode();
			String nom = pizzas[b].getNom();
			Double prix = pizzas[b].getPrix();
			pizzas[a].setPizza(code, nom, prix);
			a++;
		}
	}

}
