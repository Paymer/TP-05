package dev.TP05;

import java.util.Scanner;



public class Modify extends OptionMenu {

	
	public String getLibelle (){
		return ("3. Mettre à jour une pizza"); 
	}
	
	
	
	 public void execute(PizzaDao dao) {
		 Scanner scann = new Scanner(System.in);
		 
		// ask the code of the pizza to modify

		System.out.println("Veuillez saisir le code de la pizza a modifier:"); 
		System.out.println("99 pour abandonner");				
		String oldCode = scann.next();
		
		//Checking if the user wants to exit
		if (!oldCode.equals("99")) {
			//The user has chosen a code, now it is necessary to demand the rest of the information
			System.out.println("Introduisez le noveau code");
			String code = scann.next();
			System.out.println("Introduisez le noveau nom (sans espace)");
			String nom = scann.next();
			System.out.println("Introduisez le noveau prix");
			double prix = scann.nextDouble();
			Pizza pizza = new Pizza (code, nom, prix);
			
			// call the method dao.update
			dao.updatePizza(oldCode, pizza);}
			

		else{}
	}

	
}
