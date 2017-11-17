package TP05;

import java.util.List;
import java.util.Scanner;


import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeptions.*;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	
	public String getLibelle()
	{
		return "Supprimer le pizza" ;
	}
	
	
	public boolean execute(PizzaDaoMemoire dao) throws DeletePizzaException{

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
			throw new DeletePizzaException("le pizza à supprimer n'existe pas");
		}
		dao.deletePizza(codedelete);
		
		return true;
	} 

}
