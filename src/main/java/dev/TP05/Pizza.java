package dev.TP05;

public class Pizza {

	int id;
	String code;
	String nom;
	double prix;
	
	/* Inicializacion del metodo*/
	
	public Pizza (int id, String code, String nom, double prix){
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	//Metodos Get y Set
	
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

	
	//Metodo To String
	
	@Override
	public String toString() {
		return  code + " --> " + nom + " ( " + prix + " €)";
	}
	
	public void setPizza(String code, String nom, double prix) {
		this.nom = nom;
		this.code=code;
		this.prix=prix;
	}
	
	
}
