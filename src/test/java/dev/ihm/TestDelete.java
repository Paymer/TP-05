package dev.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.dao.PizzaDaoMemoTest;
import pizzeria.central.CategoriePizza;
import pizzeria.central.Pizza;
import pizzeria.dao.pizzadao.IPizzaDao;
import pizzeria.dao.pizzadao.PizzaDaoMemo;
import pizzeria.ihm.menu.MenuAdmin;
import pizzeria.ihm.menu.option.Delete;

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



public class TestDelete {

	Delete menu = new Delete();
	private IPizzaDao pizzaDao;
	private Pizza mar;

	// This rule allows to define what is going to be introduced throw the
	// console while the test
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Before
	public void setUp() {
		pizzaDao = new PizzaDaoMemo();
		pizzaDao.init();
		mar = new Pizza("MAR", "Margherita", 14, CategoriePizza.VIANDE);
	}

	@Test
	public void testExecute() {

		// It is necessary to define the console inputs before calling the
		// method
		systemInMock.provideLines(mar.getCode(), "99");
		Scanner scanner = new Scanner(System.in);

		menu.execute(pizzaDao, scanner);

		assertThat(pizzaDao.getPizzas()).doesNotContain(mar);

	}

}
