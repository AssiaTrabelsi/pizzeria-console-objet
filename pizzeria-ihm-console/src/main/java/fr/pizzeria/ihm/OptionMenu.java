package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {

	public OptionMenu() {

	}

	public abstract String getLibelle();

	public abstract boolean execute(IPizzaDao dao) throws Exception;
} 
