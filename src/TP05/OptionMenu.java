package TP05;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;

public abstract class OptionMenu {

	public OptionMenu() {

	}

	public abstract String getLibelle();

	public abstract boolean execute(PizzaDaoMemoire dao);
}
