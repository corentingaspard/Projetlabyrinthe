package tests;

import composants.Piece;
import grafix.interfaceGraphique.IG;


/**
 * 
 * Cette classe permet de placer les pièces sur le plateau
 * 
 */
public class TestPieces {
	private static Piece[] pieces = Piece.nouvellesPieces();
	private static int taillePlateau = 7;

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		// 1. Dans un premier temps, les paramètres du jeu seront saisis. Dans la suite nous supposerons que les paramètres par défaut ont été saisis par l'utilisateur.
		
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

		// 2. Une fois les paramètres saisis, le programme ouvrira la fenêtre de jeu avec une configuration initiale correspondant à un affichage par défaut sauf pour le message affiché qui sera "Cliquez pour continuer ...". Le programme attendra un clic de souris de l'utilisateur.
		String message[]={
				"",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		// 3. Puis, le programme générera à l'aide de la méthode Piece.nouvellesPieces un tableau de 50 pièces. Les 49 premières pièces de ce tableau seront disposées sur le plateau dans l'ordre (la première pièce sera placée sur la première case de la première ligne, la deuxième pièce sera placée sur la deuxième case de la première ligne, ...). La dernière pièce du tableau (celle à l'indice 49) sera placée dans l'emplacement de la fenêtre correspondant à la pièce hors du plateau. Le programme affichera cette nouvelle configuration dans la fenêtre de jeu et attendra de nouveau un clic de l'utilisateur.
		updatePieces();
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		// 4. Dans la suite de l'exécution du programme, l'utilisateur cliquera 4 fois. Après chaque clic, l'ensemble des pièces du tableau sont rotationnées puis de nouveau affichées. De plus, la représentation sous forme de chaîne de caractères de la pièce hors plateau est affichée dans la console après chaque clic. Le programme s'arrêtera après un cinquième clic de l'utilisateur.
		for(int i = 0; i <= pieces.length - 1; i++) pieces[i].rotation();
		updatePieces();
		System.out.println(pieces[50]);
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		for(int i = 0; i <= pieces.length - 1; i++) pieces[i].rotation();
		updatePieces();
		System.out.println(pieces[50]);
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		for(int i = 0; i <= pieces.length - 1; i++) pieces[i].rotation();
		updatePieces();
		System.out.println(pieces[50]);
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		for(int i = 0; i <= pieces.length - 1; i++) pieces[i].rotation();
		updatePieces();
		System.out.println(pieces[50]);
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		IG.fermerFenetreJeu();
		System.exit(0);
	}
	
	/**
	 * 
	 * Méthode permettant de mettre à jour les pièces du plateau en partie
	 * 
	 */
	public static void updatePieces() {
		int g = 0;
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, pieces[g].getModelePiece(), pieces[g].getOrientationPiece());
				g = g + 1;
			}
		}
		IG.changerPieceHorsPlateau(pieces[50].getModelePiece(), pieces[49].getOrientationPiece());
	}
	
		
}
