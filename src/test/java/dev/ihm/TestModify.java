package dev.ihm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.central.CategoriePizza;
import pizzeria.central.Pizza;
import pizzeria.pizzeria_admin.dao.IPizzaDao;
import pizzeria.pizzeria_admin.dao.PizzaDaoMemo;
import pizzeria.pizzeria_admin.ihm.menu.option.Modify;


public class TestModify {
	

	Scanner scanner = new Scanner (System.in);
	Modify mod = new Modify();
 	private IPizzaDao pizzaDao;
 	
	private Pizza testPizza, mar;
	

// This rule allows to define what is going to be introduced throw the console while the test
 @Rule	 
  	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
 
 @Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

 @Before
	public void setUp() {
		pizzaDao = new PizzaDaoMemo();
		pizzaDao.init();
		testPizza = new Pizza("ESP", "Espartana", 20, CategoriePizza.VIANDE);
		
	}
 

	
	@Test
	 public void testExecute () {
		//NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);
		//DecimalFormat df = (DecimalFormat)nf;
		//df.format(testPizza.getPrix())
		//Double.toString(testPizza.getPrix()) 
		Scanner scanner = new Scanner (System.in);
		 
		String code = "MAR";
		//It is necessary to define the console inputs before calling the method ---- 
		systemInMock.provideLines(code, testPizza.getCode(), testPizza.getNom(),"VIANDE", "20" , "99");
	
		 mod.execute(pizzaDao, scanner);
		
		 assertThat(pizzaDao.getPizzas()).contains(testPizza);
		 assertThat(pizzaDao.getPizzas()).doesNotContain(mar);

	}

	
	
	
	
}
