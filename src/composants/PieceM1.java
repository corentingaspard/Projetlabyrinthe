package composants;

/**
 * 
 * Cette classe permet de représenter les pièces du jeu de modèle 1.
 * 
 */
public class PieceM1 extends Piece {

	/**
	 * A Faire (11/05/2021 CG Finie)
	 * 
	 * Constructeur permettant de construire une pièce de modèle 1 et d'orientation 0.
	 */
	public PieceM1() {
		super(1,true,false,true,false); 
	}
	/**
	 * A Faire (11/05/2021 CG Finie)
	 * 
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public Piece copy(){
		Piece piece=new PieceM1(); 
		return piece;
	}
}
