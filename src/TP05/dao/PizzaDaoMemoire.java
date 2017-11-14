package TP05.dao;

import fr.pizzeria.console.Pizza;

public class PizzaDaoMemoire implements IPizzaDao {
	
	private Pizza[] pizzas = new Pizza[50];
	
	public PizzaDaoMemoire() {
		
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.50);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 12.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 12.50);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {

			if (pizzas[i] == null) {

				pizzas[i] = pizza;

				System.out.println(pizzas[i]);

				break;

			}

		}
		
		return false;
	}

	@Override
	public boolean updatePizza(String codeAModifier, Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {

			if (pizzas[i] != null && pizzas[i].code.equals(codeAModifier)) {
				
				pizzas[i] = pizza;
				
			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
