package dev.dao;

import java.lang.reflect.Field;

import dev.ihm.Console;

public class Pizza {
	@ToString
	int id;
	@ToString
	String code;
	@ToString
	String nom;
	@ToString
	double prix;
	@ToString
	CategoriePizza categ;

	Console co = new Console();
	/* Inicializacion del metodo */

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categ) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categ = categ;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categ) {

		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categ = categ;
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

	public void setPizza(String code, String nom, double prix, CategoriePizza categ) {
		this.nom = nom;
		this.code = code;
		this.prix = prix;
		this.categ = categ;
	}

	// Metodo To String
	@Override
	public String toString() {
		String chaine = "";
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				ToString annotation = field.getAnnotation(ToString.class);
				if (annotation != null) {

					chaine += " " + field.get(this).toString();
				}
			}
		} catch (Exception e) {
			co.console("Une erreur s'est produite " + e.getMessage());
			return "";
		}
		return chaine;
	}

}
