package pizzeria.pizzeria_client.dao.commandes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.dao.PizzaDaoAPI;
import pizzeria.pizzeria_admin.ihm.utils.ConsoleLogger;
import pizzeria.pizzeria_client.dao.client.Client;
import pizzeria.pizzeria_client.dao.exceptions.AddException;


public class CommandesDaoAPI implements ICommandesDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CommandeDaoAPI-jpa-unit");
	private List<Commande> com = new ArrayList<>();
	

	@Override
	public void init() throws AddException {
		ConsoleLogger co = new ConsoleLogger();

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


		
	
	public void close() {
		emf.close();
	}
	
	
	
}
