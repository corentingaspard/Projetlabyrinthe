package tests;

import java.util.Random;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import partie.ElementsPartie;

/**
 * 
 * Cette classe permet de tester tous les éléments de la partie réunis
 *
 */
public class TestElementsPartie {

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		int taillePlateau = 7;
        
        Object parametresJeu[];
        parametresJeu = IG.saisirParametres();
        int nbJoueurs = ((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie", nbJoueurs);
        Joueur joueurs[] = Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie = new ElementsPartie(joueurs);
        
        IG.creerFenetreJeu("Démo Librairie IG version 1.9",nbJoueurs);
        IG.rendreVisibleFenetreJeu();
        
        Plateau plateau = elementsPartie.getPlateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
        
        IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
		
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				IG.changerPiecePlateau(i, j, plateau.getPiece(i, j).getModelePiece(), plateau.getPiece(i, j).getOrientationPiece());	
			}
		}
        
        for(Joueur all : joueurs) {
        	IG.changerNomJoueur(all.getNumJoueur(), all.getNomJoueur() +" ("+ all.getCategorie() +")");
            IG.changerImageJoueur(all.getNumJoueur(), all.getNumeroImagePersonnage());
            IG.placerJoueurSurPlateau(all.getNumJoueur(), all.getPosLigne(), all.getPosColonne());
        }
        
        String message[]={
				"",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		Objet[] t = elementsPartie.getObjets();
		int [] pos = new int[36];
		boolean b = false;
		int r = 0;
		int y = 0;

		while(r < 18){
			Random rand1 = new Random();
			int l = rand1.nextInt(7);
			int c = rand1.nextInt(7);
			for ( int i = 0;i<pos.length-1;i+=2) {
				if (pos[i]==l && pos[i+1] == c) {
					b = true;
				}
			}
			if ( b == false) {
				t[r].positionneObjet(l, c);
				IG.placerObjetPlateau(t[r].getNumeroObjet(),t[r].getPosLignePlateau(),t[r].getPosColonnePlateau());
				pos[y*2]=l;
				pos[y*2+1]=c;
				y  +=1;
				r +=1;
			}
			b = false;
				
			
			

		}
		System.out.println(r);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		// Test Uniquement
		
		String avert[]={
					"",
					"Test",
					"Clique sur une flèche",
					""
			};
		
		System.out.println(plateau.getPiece(2, 2).getModelePiece());
		IG.afficherMessage(avert);
		IG.miseAJourAffichage();
		int entree=IG.attendreChoixEntree();
		System.out.println("L'entrée est :" + entree);
		elementsPartie.insertionPieceLibre(entree);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
	}

}
