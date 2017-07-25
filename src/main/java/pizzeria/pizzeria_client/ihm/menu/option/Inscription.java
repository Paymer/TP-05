package pizzeria.pizzeria_client.ihm.menu.option;

import java.util.Scanner;

import pizzeria.pizzeria_client.dao.client.Client;
import pizzeria.pizzeria_client.dao.client.IClientDao;
import pizzeria.pizzeria_client.dao.commandes.ICommandesDao;
import pizzeria.pizzeria_client.ihm.utils.ClientConsole;

public class Inscription implements OptionMenuClient {

	@Override
	public String getLibelle() {

		return "S'inscrire";
	}

	@Override
	public void execute(Object com, Object clDao, Scanner scanner) {
		
		ClientConsole co = new ClientConsole();
		Client cl = new Client();
		
		co.console("Introduir nom");
		cl.setNom(scanner.nextLine());
		co.console("Introduir prenom");
		cl.setPrenom(scanner.nextLine());
		co.console("Introduir mail");
		cl.setMail(scanner.nextLine());
		co.console("Introduir password");
		cl.setPsswd(scanner.nextLine());
		
		clDao.add(cl);
		
	}

}
