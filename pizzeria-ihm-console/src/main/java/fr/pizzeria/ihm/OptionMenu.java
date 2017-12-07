package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.exeptions.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {

	public OptionMenu() {

	}

	public abstract String getLibelle();

	public abstract boolean execute(PizzaDaoMemoire dao) throws Exception;
} 
