package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaojdbc implements IPizzaDao {

	public PizzaDaojdbc() {

	}

	@Override
	public List<Pizza> findAllPizzas() {

		// TODO Auto-generated method stub
		ArrayList<Pizza> liste = new ArrayList<>();
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/pizzeria";
		String utilisateur = "root";
		String motDePasse = "";
		Connection connexion = null;

		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			Statement statement = connexion.createStatement();
			/* Ici, nous placerons nos requêtes vers la BDD */

			ResultSet res = statement.executeQuery("select * FROM pizza");
			/*ResultSetMetaData meta = res.getMetaData();
			System.out.println(meta.getColumnName(2));*/
			while (res.next()) {
				int id = res.getInt("id");
				String code = res.getString("code");
				String nom = res.getString("nom");
				double prix = res.getDouble("prix");
				CategoriePizza categorie = CategoriePizza.valueOf(res.getString("categorie"));

				Pizza p = new Pizza(id, code, nom, prix, categorie);
				liste.add(p);
			}
		} catch (SQLException e) {
System.out.println(e.getMessage());
			// LOGGER.error(e.getMessage());
		} finally {
			if (connexion != null)
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					/* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
				}
		}
		return liste;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		try {

			String url = "jdbc:mysql://localhost:3306/pizzeria";
			String utilisateur = "root";
			String motDePasse = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			Statement statement = connexion.createStatement();

			String query = "INSERT INTO pizza (code, nom, prix, categorie) VALUES('" + pizza.getCode() + "','"
					+ pizza.getNom() + "'," + pizza.getPrix() + ", '" + pizza.getCategorie() + "')";
			int j = statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		try {

			String url = "jdbc:mysql://localhost:3306/pizzeria";
			String utilisateur = "root";
			String motDePasse = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			PreparedStatement statement = connexion.prepareStatement("UPDATE pizza SET code=?, nom=?, prix=?, categorie=? WHERE code=?");
			statement.setString(1,pizza.getCode());
			statement.setString(2,pizza.getNom());
			statement.setDouble(3,pizza.getPrix());
			statement.setString(4,pizza.getCategorie().name());
			statement.setString(5,codePizza);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean deletePizza(String codePizza) {
		try {

			String url = "jdbc:mysql://localhost:3306/pizzeria";
			String utilisateur = "root";
			String motDePasse = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			Statement statement = connexion.createStatement();

			String query = "DELETE FROM pizza WHERE code = '" + codePizza + "'";
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Pizza> initBase() {
		PizzaDaoMemoire pizzaMemoire = new PizzaDaoMemoire();
		List<Pizza> listePizza = pizzaMemoire.findAllPizzas();

		for (int i = 0; i < listePizza.size(); i++) {
			Pizza p = listePizza.get(i);
			saveNewPizza(p);

		}
		return listePizza;
	}
}
