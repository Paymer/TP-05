package pizzeria.pizzeria_admin;

import java.util.Scanner;

import org.slf4j.LoggerFactory;

import pizzeria.dao.clientdao.ClientDaoAPI;
import pizzeria.dao.clientdao.IClientDao;
import pizzeria.dao.commandes.CommandesDaoAPI;
import pizzeria.dao.commandes.ICommandesDao;
import pizzeria.ihm.menu.PremierMenuClient;

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
