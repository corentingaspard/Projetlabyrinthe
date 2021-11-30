package partie;

import java.util.Random;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet le lancement de la partie avec tous les ÈlÈments du jeu
 *
 */

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les √©l√©ments de la partie.

	/**
	 * 
	 * A Faire (30/05 JC EnCours)
	 * 
	 * Constructeur permettant de cr√©er et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// Element: Joueurs
		for(Joueur all : elementsPartie.getJoueurs()) {
	        IG.changerNomJoueur(all.getNumJoueur(), all.getNomJoueur() +" ("+ all.getCategorie() +")");
	        IG.changerImageJoueur(all.getNumJoueur(), all.getNumeroImagePersonnage());
	        IG.placerJoueurSurPlateau(all.getNumJoueur(), all.getPosLigne(), all.getPosColonne());
	    }
		
		// Element: Plateau
		Plateau plateau = elementsPartie.getPlateau();
	    Piece pieces = elementsPartie.getPieceLibre();
	        
	    IG.changerPieceHorsPlateau(pieces.getModelePiece(), pieces.getOrientationPiece());
			
	    for(int i = 0; i <= 7 - 1; i++) {
			for(int j = 0; j < 7; j++) {
				IG.changerPiecePlateau(i, j, plateau.getPiece(i, j).getModelePiece(), plateau.getPiece(i, j).getOrientationPiece());	
			}
		}
		
		// Element: Objet
		

		IG.rendreVisibleFenetreJeu();
	}

	/**
	 * M√©thode permettant de param√®trer et initialiser les √©l√©ments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des diff√©rents param√®tres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Cr√©ation des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Cr√©ation des √©l√©ments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}
	
	
	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * M√©thode permettant de lancer une partie.
	 */
	public void lancer(){
		String message[]={
				"",
				"Cliquez pour afficher les objets Ö",
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
				IG.placerObjetPlateau(t[r].getNumeroObjet(),l,c);
				pos[y*2]=l;
				pos[y*2+1]=c;
				y  +=1;
				r +=1;
			}
			b = false;
		}
		IG.miseAJourAffichage();
		String message2[]={
				"",
				"Cliquez pour continuer Ö",
				""
		};
		IG.afficherMessage(message2);
		IG.miseAJourAffichage();
		IG.attendreClic();
		int jeu = 0;
		while(jeu != 5) {
            for(Joueur all :elementsPartie.getJoueurs()) {            
                String tour[]={
                        "",
                        "Au tour de " + all.getNomJoueur(),
                        "SÈlectionner une case ...",
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
                
                /* 
                     int entree=IG.attendreChoixEntree();
                    System.out.println("L'entrÈe est :" + entree);
                    elementsPartie.insertionPieceLibre(entree);
                    IG.miseAJourAffichage();
                    IG.attendreClic();
        
                 */
                String avert[]={
    					"",
    					"Clique sur une flËche",
    					""
    			};
    		
                
                IG.afficherMessage(avert);
                IG.miseAJourAffichage();
                int entree=IG.attendreChoixEntree();
                System.out.println("L'entrÈe est :" + entree);
                elementsPartie.insertionPieceLibre(entree);
                IG.miseAJourAffichage();
                IG.attendreClic();
                jeu=jeu+1;
                System.out.println("jeu"+jeu);
            }
        }
    }



	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		Partie partie=new Partie();
		partie.lancer();
		
	}

}