package TP05;

import java.util.Scanner;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.*;

public class Menu {

	String titre;

	OptionMenu[] actions = new OptionMenu[100];

	public Menu(String titre) {
		super();
		this.titre = titre;
		actions[1] = new ListerPizzasOptionMenu();
		actions[2] = new AjouterPizzaOptionMenu();
		actions[3] = new ModifierPizzaOptionMenu();
		actions[4] = new SupprimerPizzaOptionMenu();

	}

	public void afficher() {


		boolean exit = false;
		
		//on changer tabpizz par le dao

		PizzaDaoMemoire dao = new PizzaDaoMemoire();

		Scanner sc = new Scanner(System.in);

		do {
			for (int i = 0; i < actions.length; i++) {
				if (actions[i] != null) {
					System.out.println(i + ". " + actions[i].getLibelle());
				}
			}
			String choix = sc.nextLine();
			
			switch (choix) {
			case "1":
				System.out.println("Liste des pizzas:");
				actions[1].execute(dao);

				break;
			case "2":
				System.out.println("Ajouter une nouvelle pizza:");
				actions[2].execute(dao);

				break;

			case "3":

				System.out.println("Mise à jour d'une pizza::");
				actions[3].execute(dao);
				// update();

				break;
			case "4":
				System.out.println("Suppression d'une pizza:");

				actions[4].execute(dao);
				break;

			case "99":
				System.out.println("Aurevoir");
				// exit(true);
				break;

			}
		}

		while (exit != true);

	}

}
