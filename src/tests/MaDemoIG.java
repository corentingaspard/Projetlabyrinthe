package tests;
import grafix.interfaceGraphique.IG;

/**
 * 
 * Cette classe permet de découvrir les méthodes que propose la librairie
 *
 */
public class MaDemoIG {

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		
		int taillePlateau = 7;
		
		Object parametres[];
		parametres=IG.saisirParametres();
		
		int nbJoueurs=((Integer)parametres[0]).intValue();
		IG.creerFenetreJeu("Démo Librairie IG version 1.9",nbJoueurs);
		IG.rendreVisibleFenetreJeu();
		
		IG.changerNomJoueur(0, (String)parametres[1] +" ("+ (String)parametres[2] +")");
		IG.changerImageJoueur(0,((Integer)parametres[3]).intValue());
		IG.changerNomJoueur(1, (String)parametres[4] +" ("+ (String)parametres[5] +")");
		IG.changerImageJoueur(1,((Integer)parametres[6]).intValue());
		IG.changerNomJoueur(2, (String)parametres[7] +" ("+ (String)parametres[8] +")");
		IG.changerImageJoueur(2,((Integer)parametres[9]).intValue());
	
		// Les objets des joueurs sont affichés en suivant l'ordre de leur numéro :
		// l'objet 0 se trouve en position 0 pour le joueur 0,
		IG.changerObjetJoueur(0, 0, 0);
		// l'objet 1 se trouve en position 1 pour le joueur 0...
		for(int i = 1; i <= 5; i++) IG.changerObjetJoueur(0, i, i);
		
		// Les objets des 2 autres joueurs
		int t = 0;
		for(int j = 6; j <= 11; j++) {
			IG.changerObjetJoueur(1, j, t);
			t++;
		}
		t = 0;
		for(int j = 12; j <= 17; j++) {
			IG.changerObjetJoueur(2, j, t);
			t++;
		}
		
		// Le plateau ne contient que des pièces du modèle 2 et de type 0.
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, 2, 0);
			}
		}
		
		// La pièce hors plateau est de modèle 1 et de type 0.
		IG.changerPieceHorsPlateau(1, 0);
		
		// Les objets sont répartis sur le plateau dans l'ordre, l'objet 0 sur la première case, l'objet 1 sur la deuxième case, ...
		int c = 0;
		for(int i = 0; i <= 17; i++) {
			int l = i / taillePlateau;
			if(c >= taillePlateau) {
				c = 0;
			}
			IG.placerObjetPlateau(i, l, c);
			c++;
		}
		
		// Le premier joueur est placé sur la ligne du milieu à gauche du plateau, tandis que le deuxième joueur est placé sur la ligne du milieu à droite du plateau.
		IG.placerJoueurPrecis(0, 3, 0, 1, 0);
		IG.placerJoueurPrecis(1, 3, 6, 1, 2);
		// L'éventuel troisième joueur n'est pas présent sur le plateau.
			
		IG.miseAJourAffichage();
		
		// Un message contenant "Bonjour !" et "Cliquez pour continuer …" est affiché.
		String message[]={
				"",
				"Bonjour !",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		
		//3: Après click 1
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, 2, 1);
			}
		}
		IG.changerPieceHorsPlateau(1, 1);
		
		IG.placerJoueurPrecis(0, 3, 0, 1, 1);
		IG.placerJoueurPrecis(1, 3, 6, 1, 1);
		
		IG.placerBilleSurPlateau(3, 0, 1, 0, 0);
		IG.placerBilleSurPlateau(3, 6, 1, 2, 0);
		
		IG.enleverObjetPlateau(0, 0);
		
		String message1[]={
				"",
				"Après le clic 1",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message1);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//3: Après click 2
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, 2, 2);
			}
		}
		IG.changerPieceHorsPlateau(1, 2);
		
		IG.placerJoueurPrecis(0, 3, 0, 1, 2);
		IG.placerJoueurPrecis(1, 3, 6, 1, 0);
		
		IG.placerBilleSurPlateau(3, 0, 1, 1, 0);
		IG.placerBilleSurPlateau(3, 6, 1, 1, 0);
		
		IG.enleverObjetPlateau(0, 1);
		
		String message2[]={
				"",
				"Après le clic 2",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message2);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//3: Après click 3
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, 2, 3);
			}
		}
		IG.changerPieceHorsPlateau(1, 3);
		
		IG.placerJoueurPrecis(0, 3, 1, 1, 0);
		IG.placerJoueurPrecis(1, 3, 5, 1, 2);
		
		IG.placerBilleSurPlateau(3, 0, 1, 2, 0);
		IG.placerBilleSurPlateau(3, 6, 1, 0, 0);
		
		IG.enleverObjetPlateau(0, 2);
		
		String message3[]={
				"",
				"Après le clic 3",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message3);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//3: Après click 4
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, 2, 0);
			}
		}
		IG.changerPieceHorsPlateau(1, 0);
		
		IG.placerJoueurPrecis(0, 3, 1, 1, 1);
		IG.placerJoueurPrecis(1, 3, 5, 1, 1);
		
		IG.placerBilleSurPlateau(3, 1, 1, 0, 0);
		IG.placerBilleSurPlateau(3, 5, 1, 2, 0);
		
		IG.enleverObjetPlateau(0, 3);
		
		String message4[]={
				"",
				"Après le clic 4",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message4);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		// Gagnant
		IG.afficherGagnant(0);
		String message5[]={
				"",
				"Cliquez sur une flèche",
				"pour quitter !",
				""
		};
		IG.afficherMessage(message5);
		IG.miseAJourAffichage();
		
		int entree=IG.attendreChoixEntree();
		System.out.println(entree);
		
		String message6[]={
				"",
				"Arrêt du programme",
				"dans 2 secondes !",
				""
		};
		
		IG.afficherMessage(message6);
		IG.miseAJourAffichage();
		IG.pause(2000);
		IG.fermerFenetreJeu();
		System.exit(0);
	}
}
