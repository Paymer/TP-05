package pizzeria.dao.commandes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import pizzeria.central.Client;
import pizzeria.central.Commande;
import pizzeria.central.Pizza;
import pizzeria.dao.exception.AddException;
import pizzeria.dao.pizzadao.PizzaDaoAPI;


public class CommandesDaoAPI implements ICommandesDao {

	
	
	// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
		EntityManagerFactory emf;
		
		public CommandesDaoAPI(EntityManagerFactory emf) {
			super();
			this.emf = emf;
		}
	

	@Override
	public void init() throws AddException {
		

		try {
						EntityManager init = emf.createEntityManager();
						init.getTransaction().begin();
						
						
						PizzaDaoAPI pidao = new PizzaDaoAPI(emf);
						pidao.init();
						List<Pizza> pizza =pidao.getPizzas();
						
						int a = 0;
						while (a<=5){
						//TypedQuery<Client> queryClient = init.createQuery("select c from Client c where c.id =:ID", Client.class)
						//.setParameter("ID", a);
						//this.add(a,new Commande(LocalDateTime.now(),queryClient.getSingleResult(),pizza));
							a++;
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
	
	
		
		// etape 2 - création d'une session => EntityManager
		EntityManager getList = emf.createEntityManager();
		getList.getTransaction().begin();
				
				
				// etape 3 - je communique avec la base de données
				
				TypedQuery<Commande> query = getList.createQuery("select c from Commande c where c.client_id =:id", Commande.class)
						.setParameter("id", clDao.getId());
				List<Commande> com = query.getResultList();
				//etape 4 - je ferme tous les usines
				
				 getList.close();
				 
				 return com;
				
			
	}
	
	
	



@Override
	public void close() {
		emf.close();
	}

	
	
	
	
}
