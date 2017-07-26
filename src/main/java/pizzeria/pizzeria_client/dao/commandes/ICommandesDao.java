package pizzeria.pizzeria_client.dao.commandes;


import pizzeria.pizzeria_client.dao.exceptions.AddException;

public interface ICommandesDao {
	
	/**
	 * will gave initial values to the clients list
	 */
	void init() throws AddException;
	

	
	/**
	 * will add the new clients
	 */
	void add(Commande co) throws AddException;


	
	
	public default void close() {
		/**
		 * in case there is need for the API
		 */

		}
	

}
