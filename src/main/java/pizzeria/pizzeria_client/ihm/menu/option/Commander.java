package pizzeria.pizzeria_client.ihm.menu.option;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.dao.PizzaDaoAPI;
import pizzeria.pizzeria_client.dao.Statut;
import pizzeria.pizzeria_client.dao.client.Client;
import pizzeria.pizzeria_client.dao.client.IClientDao;
import pizzeria.pizzeria_client.dao.commandes.Commande;
import pizzeria.pizzeria_client.dao.commandes.ICommandesDao;
import pizzeria.pizzeria_client.ihm.utils.ClientConsole;

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
	
		IPizzaDao list = new PizzaDaoAPI();
		list.init();
		
		List<Pizza> list2 = new ArrayList<>();
		list2 = list.getPizzas();
		
		co.console("Pizzas List");
		co.console(list2.toString());
		co.console("introduce the id of the pizza of you want");
		co.console("to stop write 'a'");
		
		//CAHOS SEARCH HOW TO DO THAT!!!!
		int c = -1;
		do{
			String ch = scanner.nextLine();
			
			try {c = Integer.parseInt(ch);
			//it should take all the pizzas 
			if ( c >= 0 && c < list2.size()){
			comm.add(list2.get(c));
			}
			
			}catch{
				//TODO in case it is not possible to transform the string into a integer
			}
			
		}while (c != 'a');
		
		
	}

}
