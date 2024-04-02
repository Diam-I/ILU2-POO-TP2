package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerEtalMarche();
		
		if (infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur + " , vous trouverez au marché :");
			for (int i=0 ; i<infosMarche.length/3;i++) {
				System.out.println("- " + infosMarche[i*3]+" qui vend " + infosMarche[i*3 +1] + " " + infosMarche[i*3+2]);
				
			}
		}
	}
}
