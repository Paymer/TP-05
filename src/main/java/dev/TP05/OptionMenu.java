package dev.TP05;



public abstract class OptionMenu {

	
	
	//It reestructure the table to eliminate the gaps
	protected static void reestructure (Pizza[] pizzas, int a, int j){
		// Reestructuracion de la tabla
		int b;
		while (a <(j-1)) {

						b = a + 1;
						
						String code = pizzas[b].getCode();
						String nom = pizzas[b].getNom();
						Double prix = pizzas[b].getPrix();
						pizzas[a].setPizza(code, nom, prix);
						a++;}
	}

	
	//It returns the position of the code searched
	protected static int checkList(String Q, Pizza[] pizzas, int j){
		
		
		/* Busqueda en la matriz a ver si encuentra el codigo */
		int a = 0;
		boolean c = false;
		do {

			if (Q.equals(pizzas[a].getCode())) {
				c = true;
			} else if (!Q.equals(pizzas[a].getCode())) {
				a++;
			}

		} while (c == false && a<j);
		
		
		
		return a;
	}
	
}
