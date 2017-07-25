package dev.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import dev.exception.DeletePizzaException;
import dev.exception.PizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;
import dev.ihm.utils.ConsoleLogger;

public class PizzaDaoAPI implements IPizzaDao{
	

	// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaDaoAPI-jpa-unit");
	
	
	// etape 2 - création d'une session => EntityManager
	EntityManager em1 = emf.createEntityManager();
	
	
	@Override
	public List<Pizza> getPizzas() {
	
				em1.getTransaction().begin();
				
				
				// etape 3 - je communique avec la base de données
				//*Pizza es el nombre de la clase!!!
				TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.valide = true", Pizza.class);
				return query.getResultList();

			
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		
		
		em1.getTransaction().begin();
		
		// etape 3 - je communique avec la base de données
		
		
		TypedQuery<Pizza> query2 = em1.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
				.setParameter("codePizza", pizza.getCode());
		if (query2.getResultList().isEmpty()){
			em1.persist(new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCateg()));
			em1.getTransaction().commit();
		}
		else {
			throw new SavePizzaException ("The code choosen already exists");
		}

	
				
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// etape 1 - Créer l'usine à session (EntityManager) => EntityManagerFactory
	try {	
		
		
		em1.getTransaction().begin();
		
		// etape 3 - je communique avec la base de données
	

		TypedQuery<Pizza> query2 = em1.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
				.setParameter("codePizza", pizza.getCode());
		Pizza pizza2 = query2.getSingleResult();
		
		Pizza p = em1.find(Pizza.class, pizza2.getId());

		if(p != null){

		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCateg(pizza.getCateg());
		p.setValide(true);

		}
		em1.getTransaction().commit();
		
		
	}catch ( NoResultException e){
		throw new UpdatePizzaException("Pizzacode not found" + e.getMessage(), e);
	}
	

		
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		
		
		try {	
			
			// etape 2 - création d'une session => EntityManager
			
			em1.getTransaction().begin();
			
			// etape 3 - je communique avec la base de données
		

			TypedQuery<Pizza> query2 = em1.createQuery("select p from Pizza p where p.code =:codePizza", Pizza.class)
					.setParameter("codePizza", codePizza);
			Pizza pizza2 = query2.getSingleResult();
			
			Pizza p = em1.find(Pizza.class, pizza2.getId());

			if(p != null){

		
			p.setValide(false);

			}
			
			em1.getTransaction().commit();
			
		}catch (NoResultException e){
			throw new DeletePizzaException("Pizzacode not found" + e.getMessage(), e);
		}
			
	}

	@Override
	public void init() throws PizzaException {
		ConsoleLogger co = new ConsoleLogger();
	try {
		
	

		em1.getTransaction().begin();
		
		// etape 3 - je communique avec la base de données
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.valide = true", Pizza.class);
		co.console(query.getResultList().toString());


		
	}catch (IllegalArgumentException e){
	throw new PizzaException("empty list" + e.getMessage(), e);
	}
	}

	
	
	//etape 4 - je ferme tous les usines
	 {
		 em1.close();
		 emf.close();
		 }
	
}
