package dev.TP05;

import java.util.Scanner;



public class Delete extends OptionMenu {

	 static int deletePizza(int j, Pizza[] pizzas) {
		System.out.println("Veuillez saisir le code de la pizza a eliminer:");
		System.out.println("99 pour abandonner");

		String code;

		Scanner scann = new Scanner(System.in);
		code = scann.next();

		if (!code.equals("99")) {

			int a=checkList(code, pizzas, j); //It returns the position of the code searched
			
			if (a<j){
				reestructure (pizzas, a, j);
				pizzas[j] = null;
				j--;}}
			else{System.out.println("Code not found");} //In case the code is not found
		
		return j;}

	
}
