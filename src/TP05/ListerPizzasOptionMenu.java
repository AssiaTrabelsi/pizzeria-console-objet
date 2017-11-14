package TP05;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	public String getLibelle() {
		return "Lister les pizzas";
	}

	public boolean execute(PizzaDaoMemoire dao) {
		
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i]);
			}
		}
		System.out.println("le menu principal est ensuite affiché");
		return true;
	}

}
