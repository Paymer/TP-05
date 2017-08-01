package pizzeria.dao.clientdao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import pizzeria.central.Client;
import pizzeria.central.Pizza;
import pizzeria.dao.exception.AddException;
import pizzeria.ihm.utils.AdminConsole;

public class ClientDaoAPI implements IClientDao{

	

	// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
	EntityManagerFactory emf;
	
	public ClientDaoAPI(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}


	@Override
	public void init() throws AddException {
		AdminConsole co = new AdminConsole();

	try {

					// etape 2 - création d'une session => EntityManager
					EntityManager init = emf.createEntityManager();
					init.getTransaction().begin();
					String ps = "usuario";
					
					this.add(new Client("Jules", "Verne","aaa@gmail.com", ps));
					this.add(new Client("Marie", "Curie","bbb@gmail.com", ps));
					this.add(new Client("Isaac", "Newton","ccc@gmail.com", ps));
					this.add(new Client("Isaac", "Asimov","ddd@gmail.com", ps));
					this.add(new Client("Nicholas", "Tesla","eee@gmail.com", ps));
					
					
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
		
				
				EntityManager save = emf.createEntityManager();
				save.getTransaction().begin();
				
				
				
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
		
		
		EntityManager check = emf.createEntityManager();
		check.getTransaction().begin();
		
		
		
		TypedQuery<Client> query2 = check.createQuery("select c from Client c where c.mail=:mail", Client.class)
				.setParameter("mail", mail);
		
		boolean exists = false;
		exists= query2.getResultList().isEmpty();
		//true:the client does not exist
		//false: the client already exist
		
		//now it is necessary to check the password
	
			if (!exists && !query2.getSingleResult().getPsswd().equals(psswd)){
				exists = true;
			}
		
		
		
		check.close();

		
		return exists;
	}


	

	public Client getClient(String mail) {
		
		
		EntityManager getClient = emf.createEntityManager();
		getClient.getTransaction().begin();
		
		
		
		TypedQuery<Client> query2 = getClient.createQuery("select c from Client c where c.mail=:Email", Client.class)
				.setParameter("Email", mail);
		
		Client client = query2.getSingleResult();
		
		
		
		getClient.close();

		
		return client;
	}

	
	@Override
	public void close() {
		emf.close();
	}
	
	
	
}
