package tests;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de tester l'utilisation des méthodes pour attribuer les paramètres aux joueurs
 * 
 */
public class TestJoueur{
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
        
        /*
        IG.changerNomJoueur(0, (String)parametres[1] +" ("+ (String)parametres[2] +")");
        IG.changerImageJoueur(0,((Integer)parametres[3]).intValue());
        IG.changerNomJoueur(1, (String)parametres[4] +" ("+ (String)parametres[5] +")");
        IG.changerImageJoueur(1,((Integer)parametres[6]).intValue());
        IG.changerNomJoueur(2, (String)parametres[7] +" ("+ (String)parametres[8] +")");
        IG.changerImageJoueur(2,((Integer)parametres[9]).intValue());
        */
        
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
        
        IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
		
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				Piece piecePlateau = plateau.placerPiecesAleatoierment();
				IG.changerPiecePlateau(i, j, piecePlateau.getModelePiece(), piecePlateau.getOrientationPiece());	
			}
		}
        
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametres);
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
		
		for(Joueur all : joueurs) {			
			String tour[]={
					"",
					"Au tour de " + all.getNomJoueur(),
					"Sélectionner une case ...",
					""
			};
			
			IG.afficherMessage(tour);
			IG.miseAJourAffichage();
			
			if(all.getCategorie().equals("Ordinateur")){
				IG.placerJoueurSurPlateau(all.getNumJoueur(), all.getPosLigne(), all.getPosColonne());
				
			} else {
				int[] choixCase = all.choisirCaseArrivee(null);
				IG.placerJoueurSurPlateau(all.getNumJoueur(), choixCase[0], choixCase[1]);	
				
			}
			IG.afficherMessage(tour);
			IG.miseAJourAffichage();			
		}
    }
}