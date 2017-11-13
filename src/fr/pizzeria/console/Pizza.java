package fr.pizzeria.console;

public class Pizza {

	
	public int id;
	public String code ;
	public String nom ;
	public double prix ;
	
	
	public Pizza(int id, String code, String nom, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	public String toString()
	{
	
	return code + " ->" + nom + "("+ prix+")";
	
	
	}
	
	
	
}
