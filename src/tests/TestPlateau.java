package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;

/**
 * 
 * Cette classe permet de tester les méthodes correspondants au plateau
 * 
 */
public class TestPlateau {

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		// 1
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
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		// 2
		Plateau plateau = new Plateau();
		Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
		
		IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
		
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				Piece piecePlateau = plateau.placerPiecesAleatoierment();
				IG.changerPiecePlateau(i, j, piecePlateau.getModelePiece(), piecePlateau.getOrientationPiece());			
			}
		}
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//int[][] chemin = plateau.calculeChemin(0, 0, 0, 2);
        //System.out.println(chemin);
        
        IG.miseAJourAffichage();
		IG.attendreClic();
	}
	
}
