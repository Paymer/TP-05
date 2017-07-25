package pizzeria.pizzeria_client.dao;

public enum Statut {

	
	INIT("INIT"), PARTI("PART"), FINALISEE("FINAL");

	
	String name;
	
private Statut (String name) {
this.name = name;
}
}
