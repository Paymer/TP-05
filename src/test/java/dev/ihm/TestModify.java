package dev.ihm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import dev.dao.CategoriePizza;
import dev.dao.Pizza;
import dev.dao.PizzaDaoMemo;
import dev.ihm.menu.option.Modify;


public class TestModify {
	

	Scanner scanner = new Scanner (System.in);
	Modify menu = new Modify();
 	private PizzaDaoMemo pizzaDao;
 	
	private Pizza testPizza, mar;
	List<Pizza> pizzas;

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
		pizzas = pizzaDao.getPizzas();
	}
 

	
	@Test
	 public void testExecute () {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);
		DecimalFormat df = (DecimalFormat)nf;
		
		 
		String code = "MAR";
		//It is necessary to define the console inputs before calling the method ---- 
		systemInMock.provideLines(code, testPizza.getCode(), testPizza.getNom(), testPizza.getCateg().name(), df.format(testPizza.getPrix()));
	
		 menu.execute(pizzaDao, scanner);
		
		 assertThat(pizzas).contains(testPizza);
		 assertThat(pizzas).doesNotContain(mar);

	}

	
	
	
	
}
