package pizzeria.pizzeria_client.dao.client;

import pizzeria.pizzeria_client.dao.exceptions.AddException;

public interface IClientDao {

	/**
	 * will gave initial values to the clients list
	 */
	void init() throws AddException;
	

	
	/**
	 * will add the new clients
	 */
	void add(Client cl) throws AddException;

	
	
	/**
	 * will check that the client has introduced the correct password
	 */
	boolean check(String mail, String psswd);

	
	
	public default void close() {
		/**
		 * in case there is need for the API
		 */
	}



	Client getClient(String mail, String psswd);
	
	
	
}
