package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;
import fr.pizzeria.exeptions.*;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeptions.*;
public class ModifierPizzaOptionMenu extends OptionMenu{
	
	public String getLibelle()
	{
		return "modifier une pizza" ;
	}

	public boolean execute(PizzaDaoMemoire dao) throws UpdatePizzaException  {

		System.out.println("veuiller saisir le code � modifier");
		Scanner sc = new Scanner(System.in);
		String codeAModifier = sc.nextLine();
		
		// Je regarde si le code existe
		 
		
		boolean existe = false;
		List<Pizza> pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.size(); i++) {

			if (pizzas.get(i) != null && pizzas.get(i).code.equals(codeAModifier)) {
				
				
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
		else {
			throw new UpdatePizzaException("le code n'existe pas") ;
		}
		return true;
	}

	
}
