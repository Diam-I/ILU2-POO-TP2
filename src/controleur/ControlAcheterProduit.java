package controleur;

import villagegaulois.Village;
import java.util.Scanner;

import frontiere.Clavier;
import personnages.Gaulois;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public void acheterProduit(String nomAcheteur ,String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		StringBuilder question = new StringBuilder();

		for (int i=1 ; i<=vendeurs.length;i++) {
			question.append(i + "- " + vendeurs[i-1]+"\n");
		}
		int choixUtilisateur = Clavier.entrerEntier(question.toString());
		System.out.println(nomAcheteur + "se déplace jusqu'à l'étal du vendeur " + vendeurs[choixUtilisateur-1]);
		System.out.println("Bonjour " + nomAcheteur);
		System.out.println("Combien de " + produit + " voulez-vous acheter ?");
		
		
	}
}
