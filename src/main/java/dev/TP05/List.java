package dev.TP05;



public class List extends OptionMenu {

	 static void list(Pizza[] pizzas, int j) {
		int i = 0;
		while (i < j) {
			System.out.println(pizzas[i].toString());
			i++;
		}
	}

	
}
