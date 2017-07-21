package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class TestPizzaDaoJDBC {

/**	
 	private PizzaDaoMemo dao;
	private Connection conn;
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		this conn = generateConnectionWithData();
		this.conn.close();
		this.dao = new PizzaDaoMemo("org.h2.Driver", "jdbc:h2:mem:test; DB8CLOSE_DELAY=-1", "sa", "");
	}*/
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		
		/** It is necessary to introduce "mem" instead of another thing if 
		 * we want the table to be erased when the test finishes
		 * 
		 */
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		
		
		//Add all the necessary statements
		/**
		 * Table Creation in the 
		 * database H2
		 */
		PreparedStatement pizzaCreation = conn.prepareStatement("CREATE TABLE Pizzas( id int(11) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, code varchar(10) NOT NULL, type varchar(10) NOT NULL, price int(3) NOT NULL)");
		pizzaCreation.execute();	 
		
		/**
		 * Introducing the information in the table created
		 * introduction of one pizza
		 */
		
		PreparedStatement addPizza = conn.prepareStatement("INSERT INTO Pizzas (NAME, CODE, TYPE, PRICE) VALUES (?, ?, ?, ?)"); 
		addPizza.setString(1, "Regina");
		addPizza.setString(2, "REG");
		addPizza.setString(3, "VIANDE");
		addPizza.setDouble(4, 15.5);
		addPizza.executeUpdate();
		
		PreparedStatement selectPizza = conn.prepareStatement("SELECT *FROM Pizzas WHERE CODE=?"); 
		selectPizza.setString(1,"REG"); 
		ResultSet resultat = selectPizza.executeQuery();
		
		
		/**
		 * Visualize all the data found
		 */
		resultat.next();
		//while(resultat.next()) { 
            // Retrieve by column name 
            int id  = resultat.getInt("id"); 
            String code = resultat.getString("code"); 
            String name = resultat.getString("name"); 
            String type = resultat.getString("type");  
            double price  = resultat.getDouble("price");
            
            
            // Display values 
            System.out.print("ID: " + id); 
            System.out.print(", code: " + code); 
            System.out.print(", name: " + name); 
            System.out.print(", type: " + type); 
            System.out.print(", price: " + price); 
         //} 
           /**
            * Checking that the information is correct
            */
            assertThat(code.equals("REG"));
            assertThat(name.equals("Regina"));
            assertThat(type.equals("VIANDE"));
            assertThat(price == 15.5);
		
		conn.close();
	}
}
