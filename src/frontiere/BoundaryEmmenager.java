package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					System.out.println("Bienvenue villageois "+ nomVisiteur);
					StringBuilder ask = new StringBuilder();
					ask.append("Quelle est voter force ?");
					int force ; 
					force = Clavier.entrerEntier(ask.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		System.out.println("Bienvenue villageois "+ nomVisiteur);
		StringBuilder question = new StringBuilder();
		question.append("Quelle est voter force ?");
		int force ; 
		force = Clavier.entrerEntier(question.toString());
		int effetPotionMax = -2 ; 
		int effetPotionMin = -1 ; 
		StringBuilder ask = new StringBuilder();
		
		do {
			System.out.println("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(ask.toString());
			System.out.println("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(ask.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Duide, vous vous êtes trompé entre le minimum et le maximumu");
			}
			else {
				controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
			}
			

		}while (effetPotionMax<effetPotionMin);
		
		
	}
}
