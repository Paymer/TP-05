package pizzeria.pizzeria_client;

import java.util.Scanner;

import org.slf4j.LoggerFactory;

import pizzeria.pizzeria_client.dao.client.IClientDao;
import pizzeria.pizzeria_client.dao.commandes.CommandesDaoAPI;
import pizzeria.pizzeria_client.dao.commandes.ICommandesDao;
import pizzeria.pizzeria_client.dao.client.ClientDaoAPI;
import pizzeria.pizzeria_client.ihm.menu.PremierMenuClient;
import pizzeria.pizzeria_client.ihm.menu.SecondMenuClient;

public class MainClient {

	
	
	
	
	public static void main(String[] args) {
				
		
		try (Scanner scanner = new Scanner (System.in)){

			IClientDao cl = new  ClientDaoAPI();
			ICommandesDao com = new CommandesDaoAPI();
			
			PremierMenuClient menu = new PremierMenuClient(cl, com, scanner);
			menu.manage();
			LoggerFactory.getLogger("dev.dao").info("System Finalized");
			
		}
		
		
		
		
		
		
		

	}

}
