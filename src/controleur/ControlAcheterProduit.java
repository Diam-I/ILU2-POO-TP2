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
	
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
    public boolean controlVerifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }
    
    public Gaulois[] rechercherVendeursProduit(String produit) {
    	return village.rechercherVendeursProduit(produit);
    }
    
}
