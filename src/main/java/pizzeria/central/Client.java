package pizzeria.central;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Client")
public class Client extends Personne {
	
	@Column (name = "mail")
	String mail;
	
	@Column (name = "password")
	String password;

/* Inicializacion del metodo */
	
	public Client (){
		
	}
	
public Client (String nom, String prenom, String mail, String password){
	super.nom = nom;
	super.prenom = prenom;
	this.mail = mail;
	this.password = password;
		
	}
	
	
	/*Getters and Setters*/

public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPsswd() {
	return password;
}
public void setPsswd(String psswd) {
	this.password = psswd;
}


	

}
