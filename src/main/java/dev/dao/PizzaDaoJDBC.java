package dev.dao;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dev.exception.DeletePizzaException;
import dev.exception.PizzaException;
import dev.exception.SavePizzaException;
import dev.exception.UpdatePizzaException;

public class PizzaDaoJDBC implements IPizzaDao {

	/**
	 * Introduction of a database: it is necessary to introduce chaine of
	 * characters (String)
	 * 
	 */

	public void init() throws PizzaException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			/**
			 * It is necessary to introduce "mem" instead of another thing if we
			 * want the table to be erased when the test finishes The database
			 * is found in a local host
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria-paula", "root", "");
			//it has to be set to false to avoid it commiting after every action
			conn.setAutoCommit(false);
			/**
			 * Exporting all the data from the database
			 */
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM pizza WHERE ACTIVE = ?");
			statement.setBoolean(1, true);
			ResultSet resultats = statement.executeQuery();


			/**
			 * Printing all the data
			 */
			while (resultats.next()) {

				Integer id = resultats.getInt("ID");
				String name = resultats.getString("NAME");
				String type = resultats.getString("TYPE");
				Double price = resultats.getDouble("PRICE");

				System.out.println("[id=" + id + " name=" + name + " type=" + type + " price=" + price + "]");
			}
			
			statement.close();
			conn.close();

			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PizzaException("afdsfgsg",e);
		}
	}



	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria-paula", "root", "");
			conn.setAutoCommit(false);
			
			PreparedStatement addPizza = conn
					.prepareStatement("INSERT INTO Pizza (NAME, CODE, TYPE, PRICE) VALUES (?, ?, ?, ?)");
			addPizza.setString(1, pizza.getNom());
			addPizza.setString(2, pizza.getCode());
			addPizza.setString(3, pizza.getCateg().toString());
			addPizza.setDouble(4, pizza.getPrix());
		

			/**
			 * We don't know if the code is repeated, or already exists ...
			 */
			int lineAffected = addPizza.executeUpdate();
			if (lineAffected != 1) {
				conn.rollback(); // We return the table to the initial state
				throw new SavePizzaException("Addition not performed: (lines moddified != 1) ");
				
			}
			conn.commit();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SavePizzaException("Addition not performed: (check the class or the sql)" + e.getMessage(), e);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria-paula", "root", "");
			conn.setAutoCommit(false);
			
			PreparedStatement updatePizza = conn
					.prepareStatement("UPDATE PIZZA SET NAME=?, CODE=?, TYPE=?, PRICE=?  WHERE CODE=?");
			updatePizza.setString(1, pizza.getNom());
			updatePizza.setString(2, pizza.getCode());
			updatePizza.setString(3, pizza.getCateg().toString());
			updatePizza.setDouble(4, pizza.getPrix());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
			
			int lineAffected = updatePizza.executeUpdate();
			if (lineAffected != 1) {
				conn.rollback(); // We return the table to the initial state
				throw new UpdatePizzaException("Code not found");
				
			}
			conn.commit();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			/**
			 * Asi es como poner las excepciones!!!
			 */
			throw new UpdatePizzaException("Update not performed: (check the class or the sql)" + e.getMessage(), e);
		}
		
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria-paula", "root", "");
			conn.setAutoCommit(false);
		
			
			PreparedStatement deletePizza = conn.prepareStatement("UPDATE PIZZA SET ACTIVE=? WHERE CODE=?");
			deletePizza.setString(2, codePizza);
			deletePizza.setBoolean(1, false);
			
		
			

			int lineAffected = deletePizza.executeUpdate();
			if (lineAffected != 1) {
				conn.rollback(); // We return the table to the initial state
				throw new DeletePizzaException("Code not found");
				
			}
			conn.commit();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DeletePizzaException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<Pizza> getPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * It is necessary to introduce "mem" instead of another thing if we
			 * want the table to be erased when the test finishes The database
			 * is found in a local host
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria-paula", "root", "");
			//it has to be set to false to avoid it commiting after every action
			conn.setAutoCommit(false);
			/**
			 * Exporting all the data from the database
			 */
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM pizza WHERE ACTIVE = ?");
			statement.setBoolean(1, true);
			ResultSet resultats = statement.executeQuery();

			/**
			 * Printing all the data
			 */
			while (resultats.next()) {
				Pizza pizza = new Pizza ();
				//Integer id = resultats.getInt("ID");
				pizza.setNom(resultats.getString("NAME"));
				pizza.setCode(resultats.getString("CODE"));
				pizza.setCateg(CategoriePizza.valueOf(resultats.getString("TYPE")));
				pizza.setPrix(resultats.getDouble("PRICE"));
				
				pizzas.add(pizza);
			
			}
			statement.close ();
			conn.close();
			return pizzas;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PizzaException("afdsfgsg");
		}
	
	}


}
