package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exeptions.*;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	
	public String getLibelle()
	{
		return "Supprimer le pizza" ;
	}
	
	
	public boolean execute(IPizzaDao dao) throws DeletePizzaException{

		List<Pizza> pizzas = dao.findAllPizzas();
		
		System.out.println("veuiller saisir le code");
		Scanner sc = new Scanner(System.in);
		String codedelete = sc.nextLine();
		
		boolean existe = false;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).code.equals(codedelete))
			{
				existe=true;
				break;
			}
		}
		if (!existe) {
			throw new DeletePizzaException("le pizza � supprimer n'existe pas");
		}
		dao.deletePizza(codedelete);
		
		return true;
	} 

}
