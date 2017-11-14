package TP05;

import java.util.Scanner;

import TP05.dao.PizzaDaoMemoire;
import fr.pizzeria.console.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	
	public String getLibelle()
	{
		return "Supprimer le pizza" ;
	}
	
	
	public boolean execute(PizzaDaoMemoire dao) {

		
		
		System.out.println("veuiller saisir le code");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		
		
		
		return true;
	}

}
