package client_pizzeria;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.dao.Pizza;


@Entity
@Table (name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column (name = "numero_commande")
	int numeroCommande;
	
	@Column (name = "status")
	@Enumerated(EnumType.STRING)
	Statut statut;
	
	@Column (name = "date_commande")
	LocalDateTime dateCommande;
	
	//The join column specifies the name of the column
	@ManyToOne
	@JoinColumn(name="livreur_id")
	int livreur;
	
	//Many to one: as there can be many commandes for one client
	// But one commande cannot have more than one client
	@ManyToOne
	@JoinColumn(name="client_id")
	int client;
	
	
	//Table intermediaire
	//Trying to get table commande Pizza
	@ManyToMany

	@JoinTable(name="Commande_pizza", 
	joinColumns=
	@JoinColumn(name="Commande_ID", referencedColumnName="ID"), 
	inverseJoinColumns=
	@JoinColumn(name="Pizza_ID", referencedColumnName="ID"))
	
	private List<Pizza> pizza;
	
	/* Inicializacion del metodo */
	
	public Commande (){
		
	}
	
	
	/*Getters and Setteres*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public LocalDateTime getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(LocalDateTime dateCommande) {
		this.dateCommande = dateCommande;
	}
	public int getLivreur() {
		return livreur;
	}
	public void setLivreur(int livreur) {
		this.livreur = livreur;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	
	
	
	
}
