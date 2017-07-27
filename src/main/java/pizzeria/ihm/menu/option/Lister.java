package pizzeria.ihm.menu.option;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pizzeria.central.Client;
import pizzeria.central.Commande;
import pizzeria.dao.commandes.CommandesDaoAPI;


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
