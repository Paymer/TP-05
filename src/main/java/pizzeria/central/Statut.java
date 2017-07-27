package pizzeria.central;

public enum Statut {

	
	INIT("INIT"), PARTI("PART"), FINALISEE("FINAL");

	
	String name;
	
private Statut (String name) {
this.name = name;
}
}
