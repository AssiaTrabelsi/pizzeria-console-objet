package TP05;

import java.util.List;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeptions.*;

public class ListerPizzasOptionMenu extends OptionMenu {

	public String getLibelle() {
		return "Lister les pizzas";
	}

	public boolean execute(PizzaDaoMemoire dao) {
		
		List<Pizza> pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.size(); i++) {
			
			//if (pizzas.get(i) != null) {
				
			
				
				
				System.out.println(pizzas.get(i));
			}
		
		System.out.println("le menu principal est ensuite affiché");
		return true;
	}

	
	
}
