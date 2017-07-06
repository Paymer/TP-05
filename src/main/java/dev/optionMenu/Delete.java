package dev.optionMenu;

import java.util.Scanner;

import dev.TP05.Pizza;
import dev.TP05.PizzaDao;
import dev.tpException.DeletePizzaException;



public class Delete extends OptionMenu {

	
	public String getLibelle (){
		return ("4. Supprimer une pizza"); 
	}
	
	
	 public void execute(PizzaDao dao) {
		Pizza[] pizzas = dao.getPizzas();
		System.out.println("Veuillez saisir le code de la pizza a eliminer:");
		System.out.println("99 pour abandonner");

		Scanner scann = new Scanner(System.in);
		String codePizza = scann.next();

		if (!codePizza.equals("99")) {
			
			try {
				dao.deletePizza(codePizza);
			} catch (DeletePizzaException e) {
				// in case the code does not exist it throws an exception
				System.out.println(e.getMessage());
				
				
			}}
		
		
		
		}

	
}