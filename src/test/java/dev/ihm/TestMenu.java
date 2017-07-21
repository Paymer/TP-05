package dev.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.dao.CategoriePizza;
import dev.dao.Pizza;
import dev.dao.PizzaDaoMemo;
import dev.dao.PizzaDaoMemoTest;
import dev.ihm.menu.Menu;

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

import dev.dao.Pizza;
import java.util.Scanner;


public class TestMenu {

	
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoMemoTest.class);
	
	Scanner scanner = new Scanner (System.in);
	 	private PizzaDaoMemo pizzaDao;
	 	Menu menu = new Menu(pizzaDao, scanner);
	
	
	// This rule allows to define what is going to be introduced throw the console while the test
	 @Rule	 
	  	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	 
	 @Rule
		public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Before
		public void setUp() {
			pizzaDao = new PizzaDaoMemo();
			pizzaDao.init();
			
		}
	 
	
	 @Test
	 public void testManageList () {
		 
		 //It is necessary to define the console inputs before calling the method
		systemInMock.provideLines("1" ,"99");
	
		 menu.manage();
		 
		 
		 
		 String logConsole = systemOutRule.getLog();
		 assertThat(logConsole).containsOnlyOnce( "0 PEP Peperoni 12.5 VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "1 MAR Margherita 14.0 VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "2 REI La Reine 11.5 VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "3 FRO La 4 fromages 12.0 SANS_VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "4 CAN La Cannibale 12.5 VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "5 SAV La savoyarde 13.0 POISSON");
		 assertThat(logConsole).containsOnlyOnce( "6 ORI L'orientale 13.5 SANS_VIANDE");
		 assertThat(logConsole).containsOnlyOnce( "7 IND L'indienne 14.0 SANS_VIANDE");


	}

	 
	 @Test
	 public void TestAfficher () {
		 
		 //It is necessary to define the console inputs before calling the method
	
		 menu.afficher();
		
		 String logConsole = systemOutRule.getLog();
		 assertThat(logConsole).containsOnlyOnce("***** Pizzeria Administration *****");
		 assertThat(logConsole).containsOnlyOnce( "1. Lister les pizzas");
		 assertThat(logConsole).containsOnlyOnce( "2. Ajouter une nouvelle pizza");
		 assertThat(logConsole).containsOnlyOnce( "3. Mettre à jour une pizza");
		 assertThat(logConsole).containsOnlyOnce( "4. Supprimer une pizza");
		 assertThat(logConsole).containsOnlyOnce( "99. Sortir");

	}
	
	
	
	
}
