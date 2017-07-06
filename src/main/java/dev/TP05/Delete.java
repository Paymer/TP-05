package dev.TP05;

import java.util.Scanner;



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
			
			dao.deletePizza(codePizza);}
		
		else{System.out.println("Code not found");} //In case the code is not found
		
		}

	
}
