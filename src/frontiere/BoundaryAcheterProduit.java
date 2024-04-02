package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		boolean estHabitant = controlAcheterProduit.controlVerifierIdentite(nomAcheteur);
		if (!estHabitant) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
			
		}		
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			controlAcheterProduit.acheterProduit(nomAcheteur,produit);
		}
		
		
	}
}
