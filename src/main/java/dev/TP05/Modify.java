package dev.TP05;

import java.util.Scanner;



public class Modify extends OptionMenu {

	 static void modifyPizza(Pizza[] pizzas, int j) {
		Scanner scann = new Scanner(System.in);
		System.out.println("Veuillez saisir le code de la pizza a modifier:"); 
		System.out.println("99 pour abandonner");															
																				
		String code = scann.next();

		if (!code.equals("99")) {

			int a=checkList(code, pizzas, j); //It returns the position of the code searched
			

			
			if (a<j){
				
				String nom;
				Double prix;
				System.out.println("Introduisez le noveau code");
				code = scann.next();
				System.out.println("Introduisez le noveau nom (sans espace)");
				nom = scann.next();
				System.out.println("Introduisez le noveau prix");
				prix = scann.nextDouble();

				pizzas[a].setPizza(code, nom, prix);}
		
			else{System.out.println("Code not found");} }
	}

	
}
