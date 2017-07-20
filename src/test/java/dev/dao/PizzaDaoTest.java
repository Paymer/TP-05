package dev.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import dev.dao.PizzaDao;
import dev.exception.DeletePizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;
import dev.dao.Pizza;

public class PizzaDaoTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoTest.class);

	private PizzaDao pizzaDao;
	private Pizza testPizza, mar;
	
	@Before
	public void setUp() {
		pizzaDao = new PizzaDao();
		pizzaDao.init();
		testPizza = new Pizza(8, "ESP", "Espartana", 20.5, CategoriePizza.VIANDE);
		mar = new Pizza(1, "MAR", "Margherita", 14, CategoriePizza.VIANDE);
	}

	@Test
	public void testGetPizzas() {

		List<Pizza> listePizzas = pizzaDao.getPizzas();

		assertThat(listePizzas).hasSize(8);

	}

	@Test
	public void testSaveNewPizza() throws SavePizzaException {

		

		pizzaDao.saveNewPizza(testPizza);

		List<Pizza> toutesLesPizzas = pizzaDao.getPizzas();

		assertThat(toutesLesPizzas).contains(testPizza);
	}
	
	@Test
	public void testUpdatePizza() throws UpdatePizzaException {
		
		
		pizzaDao.updatePizza(mar.code, testPizza);

		List<Pizza> toutesLesPizzas = pizzaDao.getPizzas();
		
		assertThat(toutesLesPizzas).contains(testPizza);
		assertThat(toutesLesPizzas).doesNotContain(mar);
		
	}
	
	@Test
	public void testDeletePizza() throws DeletePizzaException {
		
	
		
		pizzaDao.deletePizza(mar.code);

		List<Pizza> toutesLesPizzas = pizzaDao.getPizzas();
		
		assertThat(toutesLesPizzas).doesNotContain(mar);
		
	}
	
	

	@Test
	public void testCheckList() {

		assertThat(pizzaDao.checkList(mar.code) != null);
		assertThat(pizzaDao.checkList(testPizza.code) == null);

	}
	
	
}
