package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public String getLibelle() {
		return "Ajouter une nouvelle pizza";
	}
	
	@Override
	public boolean execute(IPizzaDao dao) {

		System.out.println("veuiller saisir le code");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();

		System.out.println("veuiller saisir le nom");
		String nom = sc.nextLine();

		System.out.println("veuiller saisir le prix");
		String prix = sc.nextLine();
		double prixdb = Double.parseDouble(prix);
		
		System.out.println("veuiller choisir la categorie (1.VIANDE, 2.POISSON, 3.SANS_VIANDE)");
		int categorie = Integer.parseInt(sc.nextLine());
		
		Pizza pizza = new Pizza(0, code, nom, prixdb, CategoriePizza.getCategorieByIndex(categorie));
		
		dao.saveNewPizza(pizza);
		return true;

	}

	
}
