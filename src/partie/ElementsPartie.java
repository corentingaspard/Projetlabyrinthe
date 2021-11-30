package partie;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.
	private List<Integer> aused = new ArrayList<Integer>(); // Liste des objets d�j� attribu�s

	/**
	 * 
	 * A Faire (29/05/2021 JC Fini)
	 *  
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 oièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée �  la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribu�es aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		/*plateau.placerPiecesAleatoierment();
		Objet.nouveauxObjets();*/
		this.joueurs = joueurs;
		plateau = new Plateau();
		pieceLibre = plateau.placerPiecesAleatoierment();
		objets = Objet.nouveauxObjets();
		attribuerObjetsAuxJoueurs();
		
		
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (29/05/2021 all Fini)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	public void attribuerObjetsAuxJoueurs(){
		Random rand = new Random();

		if (joueurs.length == 3) {
			for(Joueur all : joueurs) {
				for(int i = 0; i <= 5; i++) {
					int r = rand.nextInt(18);
					if(aused.contains(r) == true) {
						i--;
					} else {
						IG.changerObjetJoueur(all.getNumJoueur(), r, i);
						aused.add(r);
					}
				}
			}
		}
		if (joueurs.length == 2) {
			for(Joueur all : joueurs) {
				for(int i = 0; i <= 8; i++) {
					int r = rand.nextInt(18);
					if(aused.contains(r) == true) {
						i--;
					} else {
						IG.changerObjetJoueur(all.getNumJoueur(), r, i);
						aused.add(r);
					}
				}
			}
		}
	}

	/**
	 * (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return joueurs; 
	}


	/**
	 * (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return objets; 
	}


	/**
	 *  (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return plateau; 
	}


	/**
	 *  (29/05 Max Fini)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return pieceLibre; 
	}


	/**
	 * (28/05 CG Fini)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return nombreJoueurs; 
	}


	/**
	 * A Faire (09/06 JC Fini)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite �  l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
		int col = 0, lig = 0;
		if(choixEntree == 20) col = 0;
		if(choixEntree == 19) col = 1;
		if(choixEntree == 18) col = 2;
		if(choixEntree == 17) col = 3;
		if(choixEntree == 16) col = 4;
		if(choixEntree == 15) col = 5;
		if(choixEntree == 14) col = 6;
		
		if(choixEntree == 27) lig = 0;
		if(choixEntree == 26) lig = 1;
		if(choixEntree == 25) lig = 2;
		if(choixEntree == 24) lig = 3;
		if(choixEntree == 23) lig = 4;
		if(choixEntree == 22) lig = 5;
		if(choixEntree == 21) lig = 6;
		
		
		if(choixEntree >= 0 && choixEntree <= 6) {
			col = choixEntree;
			int oldMhp = IG.recupererModelePieceHorsPlateau();
			int oldOhp = IG.recupererOrientationPieceHorsPlateau();
			Piece newHP = plateau.getPiece(6, col);
			int newMhp = newHP.getModelePiece();
			int newOhp = newHP.getOrientationPiece();
			/*for(int l = 6; l <= 1; l--) {
				int getMpiece = plateau.getPiece(l - 1, col).getModelePiece();
				int getOpiece = plateau.getPiece(l - 1, col).getOrientationPiece();
				IG.changerPiecePlateau(l, col, getMpiece, getOpiece);
			}*/
			for(int l = 1; l <= 6; l++) {
				int getMpiece = plateau.getPiece(l - 1, col).getModelePiece();
				int getOpiece = plateau.getPiece(l - 1, col).getOrientationPiece();
				IG.changerPiecePlateau(l, col, getMpiece, getOpiece);
			}
			IG.changerPieceHorsPlateau(newMhp, newOhp);
			IG.changerPiecePlateau(0, col, oldMhp, oldOhp);
		}
		if(choixEntree >= 7 && choixEntree <= 13) {
			lig = choixEntree - 7;
			int oldMhp = IG.recupererModelePieceHorsPlateau();
			int oldOhp = IG.recupererOrientationPieceHorsPlateau();
			Piece newHP = plateau.getPiece(lig, 0);
			int newMhp = newHP.getModelePiece();
			int newOhp = newHP.getOrientationPiece();
			IG.changerPieceHorsPlateau(newMhp, newOhp);
			int c = 5;
			while(c >= 0) {
				int getMpiece = plateau.getPiece(lig, c + 1).getModelePiece();
				int getOpiece = plateau.getPiece(lig, c + 1).getOrientationPiece();
				IG.changerPiecePlateau(lig, c, getMpiece, getOpiece);
				System.out.println(c + " " + (c+1));
				c--;
			}
			IG.changerPiecePlateau(lig, 6, oldMhp, oldOhp);
		}
		if(choixEntree >= 14 && choixEntree <= 20) {
			int oldMhp = IG.recupererModelePieceHorsPlateau();
			int oldOhp = IG.recupererOrientationPieceHorsPlateau();
			Piece newHP = plateau.getPiece(0, col);
			int newMhp = newHP.getModelePiece();
			int newOhp = newHP.getOrientationPiece();
			int l = 5;
			while(l >= 0) {		
				int getMpiece = plateau.getPiece(l + 1, col).getModelePiece();
				int getOpiece = plateau.getPiece(l + 1, col).getOrientationPiece();
				IG.changerPiecePlateau(l, col, getMpiece, getOpiece);
				l--;
			}
			IG.changerPieceHorsPlateau(newMhp, newOhp);
			IG.changerPiecePlateau(6, col, oldMhp, oldOhp);
		}
		if(choixEntree >= 21 && choixEntree <= 27) {
			int oldMhp = IG.recupererModelePieceHorsPlateau();
			int oldOhp = IG.recupererOrientationPieceHorsPlateau();
			Piece newHP = plateau.getPiece(lig, 6);
			int newMhp = newHP.getModelePiece();
			int newOhp = newHP.getOrientationPiece();
			for(int c = 1; c <= 6; c++) {
				int getMpiece = plateau.getPiece(lig, c - 1).getModelePiece();
				int getOpiece = plateau.getPiece(lig, c - 1).getOrientationPiece();
				IG.changerPiecePlateau(lig, c, getMpiece, getOpiece);
			}
			IG.changerPieceHorsPlateau(newMhp, newOhp);
			IG.changerPiecePlateau(lig, 0, oldMhp, oldOhp);
		}
	}


	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}