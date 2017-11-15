package fr.pizzeria.console;

import java.util.Scanner;

import TP05.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws Exception {
		Menu menu = new Menu("*****Pizzeria Administration*****");
		menu.afficher();
		/*
		boolean exit = false;
		// TODO Auto-generated method stub

		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.50);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 12.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 12.50);

		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1.Lister les pizzas");
		System.out.println("2.Ajouter une nouvelle pizza");
		System.out.println("3.Mettre à jour une pizza");
		System.out.println("4.Supprimer une pizza");
		System.out.println("99.Au revoir");

		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		do {
			switch (choix) {

			case "1":
				System.out.println("Liste des pizzas:");

				listePizza();
				break;
			case "2":
				System.out.println("Ajouter une nouvelle pizza:");

				ajoutPizza();

				break;

			case "3":

				System.out.println("Mise à jour d'une pizza::");

				update();

				break;
			case "4":
				System.out.println("Suppression d'une pizza:");

				break;
			case "99":
				System.out.println("Aurevoir");
				// exit(true);
				break;

			}
		}

		while (exit != true);

	}

	private static void listePizza() {

		for (int i = 0; i < pizzas.length; i++)
			System.out.println(pizzas[i]);
		System.out.println("le menu principal est ensuite affiché");
	}

	private static void ajoutPizza() {

		System.out.println("veuiller saisir le code");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();

		System.out.println("veuiller saisir le nom");
		String nom = sc.nextLine();

		System.out.println("veuiller saisir le prix");
		String prix = sc.nextLine();
		double prixdb = Double.parseDouble(prix);

		for (int i = 0; i < pizzas.length; i++) {

			if (pizzas[i] == null) {

				pizzas[i] = new Pizza(0, code, nom, prixdb);

				System.out.println(pizzas[i]);
				listePizza();
				break;
			}

		}

	}

	private static void update() {

		System.out.println("veuiller saisir le code à modifier");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();

		for (int i = 0; i < pizzas.length; i++) {

			// System.out.println("test " + pizzas[i].code);

			// System.out.println("test code saisi " + code);

			if (pizzas[i] != null && pizzas[i].code.equals(code)) {

				System.out.println("veuiller saisir le new code");
				Scanner sc1 = new Scanner(System.in);
				String code1 = sc.nextLine();

				System.out.println("veuiller saisir le new nom");
				String nom1 = sc.nextLine();

				System.out.println("veuiller saisir le new prix");
				String prix1 = sc.nextLine();
				double prixdb1 = Double.parseDouble(prix1);

				pizzas[i] = new Pizza(0, code1, nom1, prixdb1);

				break;
			}
			return;
		}

	}
	*/

}}
