package pizzeria.pizzeria_client.dao.client;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.ihm.utils.ConsoleLogger;
import pizzeria.pizzeria_client.dao.exceptions.AddException;

public class ClientDaoAPI implements IClientDao{

	

	// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientDaoAPI-jpa-unit");
	
	
	@Override
	public void init() throws AddException {
		ConsoleLogger co = new ConsoleLogger();

	try {

					// etape 2 - création d'une session => EntityManager
					EntityManager init = emf.createEntityManager();
					init.getTransaction().begin();
		
					
					this.add(new Client("Jules", "Verne","aaa@gmail.com", "usuario"));
					this.add(new Client("Marie", "Curie","bbb@gmail.com", "usuario"));
					this.add(new Client("Isaac", "Newton","ccc@gmail.com", "usuario"));
					this.add(new Client("Isaac", "Asimov","ddd@gmail.com", "usuario"));
					this.add(new Client("Nicholas", "Tesla","eee@gmail.com", "usuario"));
					
					
		// etape 3 - je communique avec la base de données
		TypedQuery<Pizza> query = init.createQuery("select p from Pizza p where p.valide = true", Pizza.class);
		co.console(query.getResultList().toString());
		init.close();
	

	}catch (IllegalArgumentException | AddException e){
	throw new AddException("Client: empty list" + e.getMessage(), e);
	}
	}

	
	@Override
	public void add (Client cl) throws AddException {
		
				// etape 2 - création d'une session => EntityManager
				EntityManager save = emf.createEntityManager();
				save.getTransaction().begin();
				
				
				// etape 3 - je communique avec la base de données
				TypedQuery<Client> query2 = save.createQuery("select c from Client c where c.mail =:mail", Client.class)
						.setParameter("mail", cl.getMail());
				
				
				if (query2.getResultList().isEmpty()){
					save.persist(cl);
					save.getTransaction().commit();
				}
				else {
					throw new AddException ("Client:The code choosen already exists");
				}

			
				//etape 4 - je ferme tous les usines
				 
					save.close();
					
	}

	@Override
	public boolean check(String mail, String psswd) {
		// TODO Auto-generated method stub
		return false;
	}


	
	public void close() {
		emf.close();
	}
	
	
	
}
