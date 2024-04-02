package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

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
	public void acheterProduit(String nomAcheteur, String produit) {
	    if (!controlVerifierIdentite(nomAcheteur)) {
	        System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
	    } else {
	        Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
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
	            
	            Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
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

    public boolean controlVerifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }
}
