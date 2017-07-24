package dev.dao;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.dao.utils.DaoLogger;


@Entity
@Table (name = "pizza")
public class Pizza {
	public CategoriePizza getCateg() {
		return categ;
	}

	public void setCateg(CategoriePizza categ) {
		this.categ = categ;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column (name = "CODE")
	String code;
	@Column(name = "NAME")
	String nom;
	@Column(name = "PRICE")
	double prix;
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	CategoriePizza categ;
	@Column(name = "ACTIVE")
	Boolean valide;
	@Transient
	DaoLogger co = new DaoLogger();
	/* Inicializacion del metodo */

	public Pizza(String code, String nom, double prix, CategoriePizza categ) {
		
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categ = categ;
		this.valide = true;
	}

// this method is super necessary in the API case	
	public Pizza() {
		
	}

	// Metodos Get y Set



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Boolean getValide() {
		return valide;
	}

	
	
	public void setPizza(String code, String nom, double prix, CategoriePizza categ) {
		this.nom = nom;
		this.code = code;
		this.prix = prix;
		this.categ = categ;
		
	}

	@Override
	public String toString() {
		return  code + " " + nom + " " + prix + " " + categ;
	}
	
	

	// Metodo To String
	/*
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				ToString annotation = field.getAnnotation(ToString.class);
				if (annotation != null) {

					chaine.append(" ").append(field.get(this).toString());
				}
			}
		} catch (Exception e) {
			co.app("Une erreur s'est produite " + e.getMessage());
			return "";
		}
		return chaine.toString();
	}
	*/
	
	

}
