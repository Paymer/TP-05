package dev.TP05;

import java.util.Scanner;



public class Add extends OptionMenu {


	 static int addPizza(Pizza[] pizzas, int j) {
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
		pizzas[j] = new Pizza(j, code, nom, prix);
		j++;
		return j;
	}

	
}
