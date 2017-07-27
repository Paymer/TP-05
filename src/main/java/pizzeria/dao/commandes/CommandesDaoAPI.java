package pizzeria.dao.commandes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pizzeria.central.Client;
import pizzeria.central.Commande;
import pizzeria.central.Pizza;
import pizzeria.dao.exception.AddException;
import pizzeria.dao.pizzadao.PizzaDaoAPI;


public class CommandesDaoAPI implements ICommandesDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CommandeDaoAPI-jpa-unit");

	

	@Override
	public void init() throws AddException {
		

		try {
						EntityManager init = emf.createEntityManager();
						init.getTransaction().begin();
						
						List<Pizza> pizza = new ArrayList<>();
						PizzaDaoAPI pidao = new PizzaDaoAPI();
						pidao.init();
						pizza =pidao.getPizzas();
						
						int a = 0;
						while (a<=5){
						TypedQuery<Client> queryClient = init.createQuery("select c from Client c where c.id =:ID", Client.class)
						.setParameter("ID", a);
						Client cl = queryClient.getSingleResult();
						this.add(new Commande(a,LocalDateTime.now(),cl,pizza));
						}
						
						
						
			init.close();
		

		}catch (IllegalArgumentException | AddException e){
		throw new AddException("Commande: empty list" + e.getMessage(), e);
		}
		
	}

	@Override
	public void add(Commande co) throws AddException {
		
		
		EntityManager save = emf.createEntityManager();
		save.getTransaction().begin();
		
			save.persist(co);
			save.getTransaction().commit();
		
		 
			save.close();
			}
	
	public List<Commande> getList(Client clDao) {
	
		List<Commande> com = new ArrayList<>();
		
		// etape 2 - création d'une session => EntityManager
		EntityManager getList = emf.createEntityManager();
		getList.getTransaction().begin();
				
				
				// etape 3 - je communique avec la base de données
				
				TypedQuery<Commande> query = getList.createQuery("select c from Commande c where c.client_id =:id", Commande.class)
						.setParameter("id", clDao.getId());
				com = query.getResultList();
				//etape 4 - je ferme tous les usines
				
				 getList.close();
				 
				 return com;
				
			
	}

	public void close() {
		emf.close();
	}

	
	
	
	
}
