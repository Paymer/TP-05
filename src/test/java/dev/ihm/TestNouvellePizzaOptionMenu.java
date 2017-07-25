package dev.ihm;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.central.CategoriePizza;
import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.dao.PizzaDaoMemo;
import pizzeria.pizzeria_admin.ihm.menu.option.NouvellePizzaOptionMenu;

public class TestNouvellePizzaOptionMenu {

	
	NouvellePizzaOptionMenu add = new NouvellePizzaOptionMenu();
 	private PizzaDaoMemo pizzaDao;
	private Pizza testPizza;


// This rule allows to define what is going to be introduced throw the console while the test
 @Rule	 
  	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
 
 @Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

@Before
	public void setUp() {
		pizzaDao = new PizzaDaoMemo();
		pizzaDao.init();
		testPizza = new Pizza("ESP", "Espartana", 20.5, CategoriePizza.VIANDE);
		
	}
	
	
 @Test
	 public void testExecute () {
	 	Scanner scanner = new Scanner (System.in);
		 //when(calculService.additionner(expression)).thenReturn(35);
		 //It is necessary to define the console inputs before calling the method () )
		systemInMock.provideLines("ESP", "Espartana", "VIANDE", "15.5" , "99");
		
		add.execute (pizzaDao, scanner);
		
		 
		 assertThat(pizzaDao.getPizzas()).contains(testPizza);
		

	}
	
}
