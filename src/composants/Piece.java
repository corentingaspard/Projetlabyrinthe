package composants;

import java.util.Random;

/**
 * 
 * Cette classe permet de repr�senter les diff�rentes pi�ces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le mod�le de la pi�ce
	private int orientationPiece; 	// L'orientation de la pi�ce
	private boolean[] pointsEntree = new boolean[4]; // Les points d'entr�e indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (11/05/2021 All Finalis�)
	 * 
	 * Constructeur permettant de cr�er une pi�ce d'un mod�le avec l'orientation 0.
	 * @param modelePiece Le mod�le de la pi�ce.
	 * @param pointEntreeHaut Un bool�en indiquant si la pi�ce a un point d'entr�e en haut.
	 * @param pointEntreeDroite Un bool�en indiquant si la pi�ce a un point d'entr�e � droite.
	 * @param pointEntreeBas Un bool�en indiquant si la pi�ce a un point d'entr�e en bas.
	 * @param pointEntreeGauche Un bool�en indiquant si la pi�ce a un point d'entr�e � gauche.
	 */
	public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
		this.modelePiece = modelePiece;
		this.orientationPiece = 0;
		this.pointsEntree[0] = pointEntreeHaut;
		this.pointsEntree[1] = pointEntreeDroite;
		this.pointsEntree[2] = pointEntreeBas;
		this.pointsEntree[3] = pointEntreeGauche;
	}
	
	/**
	 * M�thode retournant un String repr�sentant la pi�ce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (12/05/2021 JC Finalis�)
	 * 
	 * M�thode permettant de rotationner une pi�ce dans le sens d'une horloge.
	 */
	public void rotation(){
		// Fini (M�thode full conditions)
		if(getModelePiece() == 0) {
			if(getOrientationPiece() == 3) {
				pointsEntree[0] = false;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = false;
				setOrientation(0);
			}
			else if(getOrientationPiece() == 0) {
				pointsEntree[0] = false;
				pointsEntree[1] = false;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
				setOrientation(1);
			}
			else if(getOrientationPiece() == 1) {
				pointsEntree[0] = true;
				pointsEntree[1] = false;
				pointsEntree[2] = false;
				pointsEntree[3] = true;
				setOrientation(2);
			}
			else if(getOrientationPiece() == 2) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = false;
				pointsEntree[3] = false;
				setOrientation(3);
			}
		}
		// Fini (M�thode full conditions)
		else if(modelePiece == 1) {
			if(getOrientationPiece() == 0) {
				pointsEntree[0] = false;
				pointsEntree[1] = true;
				pointsEntree[2] = false;
				pointsEntree[3] = true;
				setOrientation(1);
			}
			else if(getOrientationPiece() == 1) {
				pointsEntree[0] = true;
				pointsEntree[1] = false;
				pointsEntree[2] = true;
				pointsEntree[3] = false;
				setOrientation(0);
			}
		}
		// Fini (M�thode full conditions)
		else if(modelePiece == 2) {
			if(getOrientationPiece() == 1) {
				pointsEntree[0] = false;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
				setOrientation(2);
			}
			else if(getOrientationPiece() == 2) {
				pointsEntree[0] = true;
				pointsEntree[1] = false;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
				setOrientation(3);
			}
			else if(getOrientationPiece() == 3) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = false;
				pointsEntree[3] = true;
				setOrientation(0);
			}
			else if(getOrientationPiece() == 0) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = false;
				setOrientation(1);
			}
		}
		
	}
	
	/**
	 * A Faire (10/05/2021 JC Finalis�)
	 * 
	 * M�thode permettant d'orienter une pi�ce vers une orientation sp�cifique.
	 * @param orientationPiece Un entier correspondant � la nouvelle orientation de la pi�ce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece = orientationPiece;
	}

	/**
	 * A Faire (11/05/2021 All Finalis�)
	 * 
	 * M�thode retournant le mod�le de la pi�ce.
	 * @return Un entier corrspondant au mod�le de la pi�ce.
	 */
	public int getModelePiece() {
		return modelePiece;
	}

	/**
	 * A Faire (11/05/2021 All Finalis�)
	 * 
	 * M�thode retournant l'orientation de la pi�ce.
	 * @return un entier retournant l'orientation de la pi�ce.
	 */
	public int getOrientationPiece() {
		return orientationPiece;
	}

	/**
	 * A Faire (11/05/2021 JC Finalis�)
	 * 
	 * M�thode indiquant si il existe un point d'entr�e � une certaine position (0: en haut, 1: � droite, 2: en bas, 3: � gauche).
	 * (Non utilis�) param pointEntree L'indice/la position du point d'entr�e.
	 * @return true si il y a un point d'entr�e, sinon false.
	 */
	public boolean[] getPointsEntree(){
		return pointsEntree;
	}
	
	/**
	 * A Faire (12/05/21 JC Finalis�)
	 * 
	 * M�thode permettant de cr�er un tableau contenant toutes les pi�ces du jeu (les 50 pi�ces).
	 * Le tableau contiendra 20 pi�ces du mod�le 0, 12 pi�ces du mod�le 1 et 18 pi�ces du mod�le 2.
	 * L'orientation de chaque pi�ce sera al�atoire.
	 * @return Un tableau contenant toutes les pi�ces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		Piece pieces[] = new Piece[51];
		// A Compl�ter (A Faire apr�s les classes PieceM0, PieceM1 et PieceM2)
		for (int i = 0; i<= 19 ; i++) {
            pieces[i] = new PieceM0();
            
            Random rand = new Random();
			int r = rand.nextInt(4);
            pieces[i].setOrientation(r);
        }
        for (int i = 20; i<= 31 ; i++) {
        	pieces[i] = new PieceM1();
        	
        	Random rand = new Random();
			int r = rand.nextInt(2);
            pieces[i].setOrientation(r);
        }
        for (int i = 32; i<= 50 ; i++) {
            pieces[i] = new PieceM2();
            
            Random rand = new Random();
			int r = rand.nextInt(4);
            pieces[i].setOrientation(r);
        }
        
        
        // Random list (pieces)
        Random rnd = new Random();
        for (int i = pieces.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          Piece a = pieces[index];
          pieces[index] = pieces[i];
          pieces[i] = a;
        }
		return pieces;
	}
	
	/**
	 * M�thode permettant de cr�er une copie de la pi�ce (un nouvelle objet Java).
	 * @return Une copie de la pi�ce.
	 */
	public abstract Piece copy();
}
