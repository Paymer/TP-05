package dev.TP05;

import java.util.Scanner;



public class NouvellePizzaOptionMenu extends OptionMenu {
	
	public String getLibelle (){
		return ( "2. Ajouter une nouvelle pizza"); 
	}

	 public void execute(PizzaDao dao) {
		Pizza[] pizzas = dao.findAllPizzas();
		String code;
		String nom;
		Double prix;
		Scanner scann = new Scanner(System.in);
		System.out.println("Veuillez saisir le code");
		code = scann.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		nom = scann.next();
		System.out.println("Veuillez saisir le prix");
		prix = scann.nextDouble();
		
		dao.saveNewPizza(new Pizza(code, nom, prix));
		
		
		
		
	}

	
}
