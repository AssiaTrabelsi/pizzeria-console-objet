package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMemoire implements IPizzaDao {

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoMemoire() {

		pizzas.add(new Pizza(0, "PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(2, "REIN", "La reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.50, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(7, "IND", "L'indienne", 12.50, CategoriePizza.VIANDE));

	}

	
	/*
	 * public Pizza[] findAllPizzas() { return pizzas; }
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		return pizzas;
	}

	@Override
	/*
	 * public boolean saveNewPizza(Pizza pizza) { for (int i = 0; i < pizzas.length;
	 * i++) {
	 * 
	 * if (pizzas[i] == null) {
	 * 
	 * pizzas[i] = pizza;
	 * 
	 * System.out.println(pizzas[i]);
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return false; }
	 */
	public boolean saveNewPizza(Pizza pizza) {
		
		
		pizzas.add(pizza);
		return false;
	}

	@Override
	public boolean updatePizza(String codeAModifier, Pizza pizza) {
		for (int i = 0; i < pizzas.size(); i++) {

			if (pizzas.get(i) != null && pizzas.get(i).code.equals(codeAModifier)) {

				// pizzas.get(i) = pizza;

				pizzas.set(i, pizza);

			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pizzas.size(); i++) {

			if (pizzas.get(i).code.equals(codePizza)) {
				pizzas.remove(i);
			}
		}

		return true;
	}

	// @Override
	/*
	 * public boolean deletePizza(String codePizza) { // TODO Auto-generated method
	 * stub return false; }
	 */

}
