package fr.pizzeria.ihm;

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map.Entry;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.dao.PizzaDaojdbc;
import fr.pizzeria.exeptions.DeletePizzaException;
import fr.pizzeria.exeptions.SavePizzaException;
import fr.pizzeria.exeptions.UpdatePizzaException;

public class Menu {

	String titre;

	// OptionMenu[] actions = new OptionMenu[100];

	HashMap<String, OptionMenu> actions = new HashMap<String, OptionMenu>();

	public Menu(String titre) {
		super();
		this.titre = titre;

		actions.put("1", new ListerPizzasOptionMenu());
		actions.put("2", new AjouterPizzaOptionMenu());
		actions.put("3", new ModifierPizzaOptionMenu());
		actions.put("4", new SupprimerPizzaOptionMenu());

		/*
		 * actions[1] = new ListerPizzasOptionMenu(); actions[2] = new
		 * AjouterPizzaOptionMenu(); actions[3] = new ModifierPizzaOptionMenu();
		 * actions[4] = new SupprimerPizzaOptionMenu();
		 */
	}

	public void afficher() {

		boolean exit = false;

		// on a changer tabpizz par le dao

		// PizzaDaoMemoire dao = new PizzaDaoMemoire();
		PizzaDaojdbc dao = new PizzaDaojdbc();

		Scanner sc = new Scanner(System.in);

		do {
			for (Entry<String, OptionMenu> pair : actions.entrySet()) {
				// on affiche la collection

				System.out.println(pair.getKey() + ". " + pair.getValue().getLibelle());

				/*
				 * if (actions[i] != null) { System.out.println(i + ". " +
				 * actions[i].getLibelle()); }
				 */
			}
			String choix = sc.nextLine();
			choix = choix.trim();
			if (actions.containsKey(choix)) {
				try {
					actions.get(choix).execute(dao);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			} else if (choix.equals("99")) {
				System.out.println("Au revoir");
				break;
			}
		} while (exit != true);

	}

}
