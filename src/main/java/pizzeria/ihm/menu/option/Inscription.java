package pizzeria.ihm.menu.option;

import java.util.Scanner;

import pizzeria.central.Client;
import pizzeria.dao.clientdao.IClientDao;
import pizzeria.dao.exception.AddException;
import pizzeria.ihm.utils.ClientConsole;

public class Inscription implements OptionMenuClient {

	@Override
	public String getLibelle() {

		return "S'inscrire";
	}

	@Override
	public void execute(Object com, Object clDao, Scanner scanner) {
		
		ClientConsole co = new ClientConsole();
		Client cl = new Client();
		scanner.nextLine();
		co.console("Introduir nom");
		cl.setNom(scanner.nextLine());
		
		co.console("Introduir prenom");
		cl.setPrenom(scanner.nextLine());
		
		co.console("Introduir mail");
		cl.setMail(scanner.nextLine());
		
		co.console("Introduir password");
		cl.setPsswd(scanner.nextLine());
		
		try {
			((IClientDao) clDao).add(cl);
		} catch (AddException e) {
			
			co.console("Client:Addition not performed");
		}
		
	}

}
