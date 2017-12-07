package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;
import fr.pizzeria.exeptions.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.IPizzaDao;

public class ModifierPizzaOptionMenu extends OptionMenu{
	
	public String getLibelle()
	{
		return "modifier une pizza" ;
	}

	public boolean execute(IPizzaDao dao) throws UpdatePizzaException  {

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
			String code = sc.nextLine();

			System.out.println("veuiller saisir le new nom");
			String nom = sc.nextLine();

			System.out.println("veuiller saisir le new prix");
			double prix = Double.parseDouble(sc.nextLine());
			
			System.out.println("veuiller choisir la categorie (1.VIANDE, 2.POISSON, 3.SANS_VIANDE)");
			Integer categorie = Integer.parseInt(sc.nextLine());
			
			Pizza pizza = new Pizza(0, code, nom, prix, CategoriePizza.getCategorieByIndex(categorie));

			dao.updatePizza(codeAModifier, pizza);

		}
		else {
			throw new UpdatePizzaException("le code n'existe pas") ;
		}
		return true;
	}

	
}
