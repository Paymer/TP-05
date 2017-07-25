package pizzeria.pizzeria_client.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import pizzeria.central.Personne;

@Entity
@Table (name = "Livreur")
public class Livreur extends Personne {
	
	
	
	
/* Inicializacion del metodo */
	
	public Livreur (){
		
	}
	
public Livreur (String nom, String prenom){
	super.nom = nom;
	super.prenom = prenom;
		
	}
	
	
	
}
