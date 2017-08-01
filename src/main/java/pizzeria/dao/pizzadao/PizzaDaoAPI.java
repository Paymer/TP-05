package pizzeria.dao.pizzadao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pizzeria.central.CategoriePizza;
import pizzeria.central.Pizza;
import pizzeria.dao.exception.AddException;
import pizzeria.dao.exception.DeletePizzaException;
import pizzeria.dao.exception.UpdatePizzaException;
import pizzeria.ihm.utils.AdminConsole;

public class PizzaDaoAPI implements IPizzaDao{
	

	// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaDaoAPI-jpa-unit");
	
	
	@Override
	public void init() throws AddException {
		AdminConsole co = new AdminConsole();

	try {

					// etape 2 - création d'une session => EntityManager
					EntityManager init = emf.createEntityManager();
					init.getTransaction().begin();
		
					
					this.saveNewPizza(new Pizza("PEP", "Peperoni", 12.5, CategoriePizza.VIANDE));
					this.saveNewPizza(new Pizza("MAR", "Margherita", 14, CategoriePizza.VIANDE));
					this.saveNewPizza(new Pizza("REI", "La Reine", 11.5, CategoriePizza.VIANDE));
					this.saveNewPizza(new Pizza("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE));
					this.saveNewPizza(new Pizza("CAN", "La Cannibale", 12.5, CategoriePizza.VIANDE));
					this.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.0, CategoriePizza.POISSON));
					this.saveNewPizza(new Pizza("ORI", "L'orientale", 13.5, CategoriePizza.SANS_VIANDE));
					this.saveNewPizza(new Pizza("IND", "L'indienne", 14, CategoriePizza.SANS_VIANDE));
					
		// etape 3 - je communique avec la base de données
		TypedQuery<Pizza> query = init.createQuery("select p from Pizza p where p.valide = true", Pizza.class);
		co.console(query.getResultList().toString());
		init.close();
	

		
	}catch (IllegalArgumentException | AddException e){
	throw new AddException("Pizza:empty list" + e.getMessage(), e);
	}
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws AddException {
		
		
		
		// etape 2 - création d'une session => EntityManager
		EntityManager save = emf.createEntityManager();
		save.getTransaction().begin();
		
		
		// etape 3 - je communique avec la base de données
		
		
		TypedQuery<Pizza> query2 = save.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
				.setParameter("codePizza", pizza.getCode());
		if (query2.getResultList().isEmpty()){
			save.persist(new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCateg()));
			save.getTransaction().commit();
		}
		else {
			throw new AddException ("Pizza: The code choosen already exists");
		}

	
		//etape 4 - je ferme tous les usines
		 
			save.close();
			
			 
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
	try {	
		
				
				
				// etape 2 - création d'une session => EntityManager
				EntityManager update = emf.createEntityManager();
				update.getTransaction().begin();
		
		// etape 3 - je communique avec la base de données
	

		TypedQuery<Pizza> query2 = update.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
				.setParameter("codePizza", pizza.getCode());
		Pizza pizza2 = query2.getSingleResult();
		
		Pizza p = update.find(Pizza.class, pizza2.getId());

		if(p != null){

		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCateg(pizza.getCateg());
		p.setValide(true);

		}
		update.getTransaction().commit();
		update.close();
		
		
	}catch ( NoResultException e){
		throw new UpdatePizzaException("Pizzacode not found" + e.getMessage(), e);
	}
	

		
	}


	public void deletePizza(String codePizza) throws DeletePizzaException {
		
		
		try {	
			
	
			
			// etape 2 - création d'une session => EntityManager
			EntityManager delete = emf.createEntityManager();
			delete.getTransaction().begin();
			
			// etape 3 - je communique avec la base de données
		

			TypedQuery<Pizza> query2 = delete.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
					.setParameter("codePizza", codePizza);
			Pizza pizza2 = query2.getSingleResult();
			
			Pizza p = delete.find(Pizza.class, pizza2.getId());

			if(p != null){

		
			p.setValide(false);

			}
			
			delete.getTransaction().commit();
			delete.close();
			
		}catch (NoResultException e){
			throw new DeletePizzaException("Pizzacode not found" + e.getMessage(), e);
		}
			
	}

	@Override
	public List<Pizza> getPizzas() {
	
		
		
		// etape 2 - création d'une session => EntityManager
		EntityManager getPizzas = emf.createEntityManager();
		getPizzas.getTransaction().begin();
				
				
				// etape 3 - je communique avec la base de données
				//*Pizza es el nombre de la clase!!!
				TypedQuery<Pizza> query = getPizzas.createQuery("select p from Pizza p where p.valide = true", Pizza.class);
				List<Pizza> x = query.getResultList();
				//etape 4 - je ferme tous les usines
				
				 getPizzas.close();
				 
				 return x;
				
			
	}

	@Override
	public void close() {
		emf.close();
	}
	
	


}
