package TP05;

import java.util.Scanner;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public String getLibelle() {
		return "Ajouter une nouvelle pizza";
	}

	public boolean execute(PizzaDaoMemoire dao) {

		System.out.println("veuiller saisir le code");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();

		System.out.println("veuiller saisir le nom");
		String nom = sc.nextLine();

		System.out.println("veuiller saisir le prix");
		String prix = sc.nextLine();
		double prixdb = Double.parseDouble(prix);
		
		Pizza pizza = new Pizza(0, code, nom, prixdb);
		
		dao.saveNewPizza(pizza);
		return true;

	}
	
}
