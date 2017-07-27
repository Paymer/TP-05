package pizzeria.pizzeria_client.ihm.menu.option;

import java.util.Scanner;

import pizzeria.pizzeria_client.dao.client.Client;
import pizzeria.pizzeria_client.dao.client.IClientDao;
import pizzeria.pizzeria_client.ihm.menu.SecondMenuClient;
import pizzeria.pizzeria_client.ihm.utils.ClientConsole;

public class Connection implements OptionMenuClient {

	@Override
	public String getLibelle() {

		return "Se connecter";
	}

	@Override
	public void execute(Object com, Object clDao, Scanner scanner) {
		
		ClientConsole co = new ClientConsole();
		String psswd, mail;
		co.console("Introduir mail");
		mail = (scanner.nextLine());
		co.console("Introduir password");
		psswd = (scanner.nextLine());
		
		
		
		if (!((IClientDao) clDao).check(mail, psswd)){
			//true:the client does not exist
			//false: the client already exist
			
			Client client = new Client();
			
			client = ((IClientDao) clDao).getClient(mail, psswd); //search for the client
			
		SecondMenuClient menu2 = new SecondMenuClient(com, client, scanner);
		menu2.manage();
		co.console("correct user");
		co.console("Wellcome");
		}
		
		else {co.console("user not found");}
	}

	

}
