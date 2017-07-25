package client_pizzeria;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany
	@JoinColumn(name="livreur_id")
	@JoinColumn(name="client_id")
	int id;
	@Column (name = "nom")
	String nom;
	@Column (name = "prenom")
	String prenom;
	
	
	/*Getters and Setters*/
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}
