package pizzeria.central;



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
import javax.persistence.Table;
import javax.persistence.Transient;

import pizzeria.pizzeria_admin.dao.utils.DaoLogger;


@Entity
@Table (name = "pizza")
public class Pizza {

	
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
	@Column(name = "URL_image")
	String url;
	@Transient
	DaoLogger co = new DaoLogger();
	


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
	


	@Override
	public String toString() {
		return  code + " " + nom + " " + prix + " " + categ;
	}

	
	
	
	/* Inicializacion del metodo */

	// this method is super necessary in the API case	
		public Pizza() {
			
		}
	
	public Pizza(String code, String nom, double prix, CategoriePizza categ) {
		
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categ = categ;
		this.valide = true;
		this.url ="";
	}
	
	public void setPizza(String code, String nom, double prix, CategoriePizza categ) {
		this.nom = nom;
		this.code = code;
		this.prix = prix;
		this.categ = categ;

	}
	

	
	
	// Getters and Setters
	
	
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

	
	
	public CategoriePizza getCateg() {
		return categ;
	}

	public void setCateg(CategoriePizza categ) {
		this.categ = categ;
	}
	
	
	public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DaoLogger getCo() {
		return co;
	}

	public void setCo(DaoLogger co) {
		this.co = co;
	}
	
	

}
