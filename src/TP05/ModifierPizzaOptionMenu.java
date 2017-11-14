package TP05;

import java.util.Scanner;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{
	
	public String getLibelle()
	{
		return "modifier une pizza" ;
	}

	public boolean execute(PizzaDaoMemoire dao) {

		System.out.println("veuiller saisir le code à modifier");
		Scanner sc = new Scanner(System.in);
		String codeAModifier = sc.nextLine();
		
		// Je regarde si le code existe
		boolean existe = false;
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {

			if (pizzas[i] != null && pizzas[i].code.equals(codeAModifier)) {
				existe = true;
			}
		}

		if (existe) {
			System.out.println("veuiller saisir le new code");
			Scanner sc1 = new Scanner(System.in);
			String code1 = sc.nextLine();

			System.out.println("veuiller saisir le new nom");
			String nom1 = sc.nextLine();

			System.out.println("veuiller saisir le new prix");
			String prix1 = sc.nextLine();
			double prixdb1 = Double.parseDouble(prix1);

			Pizza pizza = new Pizza(0, code1, nom1, prixdb1);
			dao.updatePizza(codeAModifier, pizza);

		}
		return true;
	}

}
