package pizzeria.pizzeria_client.ihm.menu.option;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		co.console("Introduir prenom");
		commande.setDateCommande();
		//commande.setLivreur(livreur); there is no livreur right now
		commande.setNumeroCommande(01);
		commande.setStatut(Statut.INIT);
		
		
		co.console("Introduir password");
	
		
		
	}

}
