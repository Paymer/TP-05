package pizzeria.central;

import javax.persistence.Entity;
import javax.persistence.Table;

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
