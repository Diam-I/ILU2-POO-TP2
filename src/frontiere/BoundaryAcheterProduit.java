package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

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
			Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
	        if (vendeurs == null || vendeurs.length == 0) {
	            System.out.println("Désolé, personne ne vend ce produit au marché.");
	        } else {
	            System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
	            StringBuilder question = new StringBuilder();
	            
	            for (int i = 1; i <= vendeurs.length; i++) {
	                question.append(i + "- " + vendeurs[i - 1].getNom() + "\n");
	            }
	            int choixUtilisateur = Clavier.entrerEntier(question.toString());
	            
	            String nomVendeur = vendeurs[choixUtilisateur - 1].getNom() ;
	            System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
	            
	            StringBuilder questionQuantite = new StringBuilder();
	            questionQuantite.append("Bonjour ");
	            questionQuantite.append(nomAcheteur);
	            questionQuantite.append("\n");
	            questionQuantite.append("Combien de "); 
	            questionQuantite.append(produit);
	            questionQuantite.append(" voulez-vous acheter ?\n");
	            int quantite = Clavier.entrerEntier(questionQuantite.toString());
	            
	            Etal etalVendeur = controlAcheterProduit.trouverEtalVendeur(nomVendeur);
	            int stockDisponible = etalVendeur.getQuantite();
	            
	            if (quantite <= stockDisponible) {
	                System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur + ".");
	                etalVendeur.acheterProduit(quantite);
	            } else {
	                if (stockDisponible > 0) {
	                    System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + nomVendeur + " n’en a plus que " +  stockDisponible + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
	                    etalVendeur.acheterProduit(quantite);
	                } else {
	                    System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n’y en a plus !");
	                }
	            }
		}
		
	   
		
		}
	}
}
