package pizzeria.dao.commandes;


import java.util.List;

import pizzeria.central.Client;
import pizzeria.central.Commande;
import pizzeria.dao.IDao;
import pizzeria.dao.exception.AddException;

public interface ICommandesDao extends IDao {
	
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



	List<Commande> getList(Client clDao);
	
	
	

}
