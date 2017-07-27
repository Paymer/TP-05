package pizzeria.pizzeria_client.ihm.menu.option;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pizzeria.pizzeria_client.dao.client.Client;
import pizzeria.pizzeria_client.dao.commandes.Commande;
import pizzeria.pizzeria_client.dao.commandes.CommandesDaoAPI;


public class Lister implements OptionMenuClient {

	@Override
	public String getLibelle() {

		return "Lister ses commandes";
	}

	@Override
	public void execute (Object com, Object clDao, Scanner scanner) {
		 
		
		// cldao is the user/client
		
				List<Commande> commande = new ArrayList<>();
				
				commande = ((CommandesDaoAPI) com).getList((Client)clDao); //It takes the commands made by the user
				
				commande.toString();
		
		
	}

	
	

	
	
}
