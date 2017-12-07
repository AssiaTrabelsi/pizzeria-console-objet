package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	public String getLibelle() {
		return "Lister les pizzas";
	}

	public boolean execute(IPizzaDao dao) {

		List<Pizza> pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.size(); i++) {

			System.out.println(pizzas.get(i));
		}

		System.out.println("le menu principal est ensuite affich�");
		return true;
	}

}
