package pizzeria.ihm.menu.option;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Persistence;

import pizzeria.central.Client;
import pizzeria.central.Commande;
import pizzeria.central.Pizza;
import pizzeria.central.Statut;
import pizzeria.dao.exception.AddException;
import pizzeria.dao.pizzadao.IPizzaDao;
import pizzeria.dao.pizzadao.PizzaDaoAPI;
import pizzeria.ihm.utils.ClientConsole;

public class Commander implements OptionMenuClient {

	@Override
	public String getLibelle() {
		
		return "Faire une commande";
	}

	@Override
	public void execute(Object com, Object clDao, Scanner scanner) {
		ClientConsole co = new ClientConsole();
		Commande commande = new Commande ();
		
		commande.setClient((Client) clDao);
		commande.setDateCommande(LocalDateTime.now());
		//commande.setLivreur(livreur); there is no livreur right now
		commande.setNumeroCommande(01);
		commande.setStatut(Statut.INIT);

		List<Pizza> comm = new ArrayList<>();
	
		IPizzaDao list = new PizzaDaoAPI(Persistence.createEntityManagerFactory("PizzaDaoAPI-jpa-unit"));
		
		try {
			list.init();
		} catch (AddException e) {}
		
		List<Pizza> list2 = list.getPizzas();
		
		
		co.console("Pizzas List");
		co.console(list2.toString());
		co.console("introduce the id of the pizza of you want");
		co.console("to stop write 'XXX'");
		
		//("\b[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}\b.")
		
		
		String ch;
		scanner.nextLine();
		
		do {
			
			ch = scanner.nextLine();
			
			while (!ch.matches("^[A-Z]{3}$") || (!(this.checkCode(ch, list2))) ){
				co.console("Introduce a valid code please");
			}
			
			
			comm.add(this.searchPizza(ch, list2));
			
			
			
		}while (!ch.equals("XXX"));
		
	}
	
	
	public boolean checkCode (String code, List<Pizza> pizzas){
	
		boolean exists = false;
		for (Pizza p : pizzas) {

			if (p.getCode().equals(code)) {
				 exists = true;
			}}
		return exists;
	}

	public Pizza searchPizza (String code, List<Pizza> pizzas){
		Pizza pizza= new Pizza ();

		for (Pizza p : pizzas) {

			if (p.getCode().equals(code)) {
				 pizza = p;
			}}
		return pizza;
	}
	
	
}
