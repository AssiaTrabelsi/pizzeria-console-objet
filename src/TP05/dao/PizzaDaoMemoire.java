package TP05.dao;

import fr.pizzeria.console.Pizza;
import java.util.*;

public class PizzaDaoMemoire implements IPizzaDao {

	// private Pizza[] pizzas = new Pizza[50];

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoMemoire() {

		pizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00));

		pizzas.add(new Pizza(2, "REIN", "La reine", 11.50));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.50));

		pizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", 12.50));
		pizzas.add(new Pizza(7, "IND", "L'indienne", 12.50));

		/*
		 * pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50); pizzas[1] = new Pizza(1,
		 * "MAR", "Margherita", 14.00); pizzas[2] = new Pizza(2, "REIN", "La reine",
		 * 11.50); pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.50); pizzas[4] =
		 * new Pizza(4, "CAN", "La cannibale", 12.50); pizzas[5] = new Pizza(5, "SAV",
		 * "La savoyarde", 13.00); pizzas[6] = new Pizza(6, "ORI", "L'orientale",
		 * 12.50); pizzas[7] = new Pizza(7, "IND", "L'indienne", 12.50);
		 */
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
