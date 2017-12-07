package fr.pizzeria.ihm;

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map.Entry;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.exeptions.DeletePizzaException;
import fr.pizzeria.exeptions.SavePizzaException;
import fr.pizzeria.exeptions.UpdatePizzaException;

public class Menu {

	String titre;

	//OptionMenu[] actions = new OptionMenu[100];
	
	HashMap<Integer, OptionMenu> actions= new HashMap<Integer,OptionMenu>();

	public Menu(String titre) {
		super();
		this.titre = titre; 
		
		
		actions.put(1,new ListerPizzasOptionMenu());
		actions.put(2,new AjouterPizzaOptionMenu());
		actions.put(3,new ModifierPizzaOptionMenu());
		actions.put(4,new SupprimerPizzaOptionMenu());
		
		/*actions[1] = new ListerPizzasOptionMenu();
		actions[2] = new AjouterPizzaOptionMenu();
		actions[3] = new ModifierPizzaOptionMenu();
		actions[4] = new SupprimerPizzaOptionMenu();
*/
	}

	public void afficher() throws Exception {


		boolean exit = false;
		
		//on a changer tabpizz par le dao 

		PizzaDaoMemoire dao = new PizzaDaoMemoire();

		Scanner sc = new Scanner(System.in);

		do {
			for (Entry<Integer, OptionMenu> pair : actions.entrySet()) {
				// on affiche la collection
				
                System.out.println(pair.getKey()+". "+pair.getValue().getLibelle());
                
               
               
			/*	if (actions[i] != null) {
					System.out.println(i + ". " + actions[i].getLibelle());
				}*/
			}
			String choix = sc.nextLine();
			
			try {
				switch (choix) {
				case "1":
					System.out.println("Liste des pizzas:");
					
				
					actions.get(1).execute(dao);

					break;
				case "2":
					System.out.println("Ajouter une nouvelle pizza:");
					actions.get(2).execute(dao);

					break;

				case "3":

					System.out.println("Mise � jour d'une pizza::");
					//actions[3].execute(dao);
					
					actions.get(2).execute(dao) ;
					// update();

					break;
				case "4":
					System.out.println("Suppression d'une pizza:");
                        actions.get(4).execute(dao) ;
					//actions[4].execute(dao);
					break;

				case "99":
					System.out.println("Aurevoir");
					// exit(true);
					break;

				}
			} catch (UpdatePizzaException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (DeletePizzaException e)
			
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
		} catch(SavePizzaException e) {
			System.out.println(e.getMessage());
		}
			
		}

		while (exit != true);

	}

}
