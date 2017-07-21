package dev.dao;




import java.sql.*;

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
			Class.forName("org.h2.Driver");

			/**
			 * It is necessary to introduce "mem" instead of another thing if we
			 * want the table to be erased when the test finishes The database
			 * is found in a local host
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:pizzeria-paula", "root", "");

			/**
			 * Exporting all the data from the database
			 */
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM pizza");
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

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PizzaException("afdsfgsg");
		}
	}

	/**
	 * @Override public List<Pizza> getPizzas() { // Change that method
	 * 
	 * 
	 *           PreparedStatement selectPizza = conn.prepareStatement("SELECT
	 *           *FROM Pizzas WHERE CODE=?"); selectPizza.setString(1,"REG");
	 *           ResultSet resultat = selectPizza.executeQuery();
	 * 
	 *           resultat.next(); //while(resultat.next()) { // Retrieve by
	 *           column name int id = resultat.getInt("id"); String code =
	 *           resultat.getString("code"); String name =
	 *           resultat.getString("name"); String type =
	 *           resultat.getString("type"); double price =
	 *           resultat.getDouble("price");
	 * 
	 * 
	 *           // Display values System.out.print("ID: " + id);
	 *           System.out.print(", code: " + code); System.out.print(", name:
	 *           " + name); System.out.print(", type: " + type);
	 *           System.out.print(", price: " + price); //}
	 * 
	 * 
	 * 
	 *           return null; }
	 */

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:pizzeria-paula", "root", "");

			PreparedStatement addPizza = conn
					.prepareStatement("INSERT INTO Pizzas (NAME, CODE, TYPE, PRICE) VALUES (?, ?, ?, ?)");
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
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SavePizzaException("Addition not performed: (check the class or the sql)" + e.getMessage(), e);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:pizzeria-paula", "root", "");

			PreparedStatement updatePizza = conn
					.prepareStatement("UPDATE PIZZA SET NAME=?, CODE=?, TYPE=?, PRICE=?  WHERE CODE=?");
			updatePizza.setString(1, pizza.getNom());
			updatePizza.setString(2, pizza.getCode());
			updatePizza.setString(3, pizza.getCateg().toString());
			updatePizza.setDouble(4, pizza.getPrix());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pizza> getPizzas() {
		// TODO Auto-generated method stub
		return null;
	};

}
