package dev.dao;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	
			String name;
	private CategoriePizza(String name) {
		this.name = name;
	}
}
