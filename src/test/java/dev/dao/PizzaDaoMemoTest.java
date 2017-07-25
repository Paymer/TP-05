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

import pizzeria.central.CategoriePizza;
import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.dao.PizzaDaoMemo;
import pizzeria.pizzeria_admin.dao.exception.DeletePizzaException;
import pizzeria.pizzeria_admin.dao.exception.SavePizzaException;
import pizzeria.pizzeria_admin.dao.exception.UpdatePizzaException;

public class PizzaDaoMemoTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoMemoTest.class);

	private PizzaDaoMemo pizzaDao;
	private Pizza testPizza, mar;
	
	@Before
	public void setUp() {
		pizzaDao = new PizzaDaoMemo();
		pizzaDao.init();
		testPizza = new Pizza("ESP", "Espartana", 20.5, CategoriePizza.VIANDE);
		mar = new Pizza("MAR", "Margherita", 14, CategoriePizza.VIANDE);
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
		
		
		pizzaDao.updatePizza(mar.getCode(), testPizza);

		List<Pizza> toutesLesPizzas = pizzaDao.getPizzas();
		
		assertThat(toutesLesPizzas).contains(testPizza);
		assertThat(toutesLesPizzas).doesNotContain(mar);
		
	}
	
	@Test
	public void testDeletePizza() throws DeletePizzaException {
		
	
		
		pizzaDao.deletePizza(mar.getCode());

		List<Pizza> toutesLesPizzas = pizzaDao.getPizzas();
		
		assertThat(toutesLesPizzas).doesNotContain(mar);
		
	}
	
	

	@Test
	public void testCheckList() {
		assertThat(pizzaDao.checkList(mar.getCode()) == true);	
		assertThat(pizzaDao.checkList(testPizza.getCode()) == false);

	}
	
	
}
