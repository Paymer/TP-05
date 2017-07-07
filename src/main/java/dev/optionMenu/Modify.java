package dev.optionmenu;

import java.util.Scanner;

import dev.TP05.CategoriePizza;
import dev.TP05.Pizza;
import dev.TP05.PizzaDao;
import dev.tpexception.UpdatePizzaException;



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
			System.out.println("Veuillez saisir la categorie");
			String cat = scann.next();
			CategoriePizza categ= CategoriePizza.valueOf(cat);
			System.out.println("Introduisez le noveau prix");
			
			
			
			while (!scann.hasNextDouble()) {
				//* THE FIRST TIME IT PRINTS IT TWO TIMES! NOT CORRECT! SCANNER BUG!!!*//
				System.out.println("Sorry, couldn't understand you! Try it again!");

				scann.nextLine();
			}
	
				double prix = scann.nextDouble();
			
			Pizza pizza = new Pizza (code, nom, prix, categ);
			
			// call the method dao.update
			try {
				dao.updatePizza(oldCode, pizza);
			} catch (UpdatePizzaException e) {
				// in case the code does not exist it throws an exception
				System.out.println(e.getMessage());
			}}
			

		else{}
	}

	
}
