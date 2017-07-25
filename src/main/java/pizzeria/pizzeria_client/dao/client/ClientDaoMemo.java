package pizzeria.pizzeria_client.dao.client;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoMemo implements IClientDao{

	List<Client> users = new ArrayList<>();

	@Override
	public void add(Client cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean check(String mail, String psswd) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
