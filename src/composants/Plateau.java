package composants;

/**
 * Cette classe permet de gérer un plateau de jeu constitué d'une grille de pièces (grille de 7 lignes sur 7 colonnes).
 *
 */
public class Plateau {

	private Piece plateau[][]; // La grille des pi�ces.

	/**
	 * A Faire (15/05/2021 JC finalis�)
	 * 
	 * Constructeur permettant de construire un plateau vide (sans pièces) et d'une taille de 7 lignes sur 7 colonnes.
	 */
	public Plateau() {
		this.plateau= new Piece[7][7];
	}

	/**
	 * A Faire (15/05/2021 TG finalis�)
	 * 
	 * Méthode permettant de placer une pièce sur le plateau.
	 * 
	 * @param piece La pièce à placer.
	 * @param lignePlateau La ligne du plateau sur laquelle sera placée la pièce (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau sur laquelle sera placée la pièce (une entier entre 0 et 6).
	 */
	public void positionnePiece(Piece piece,int lignePlateau,int colonnePlateau){
		plateau[lignePlateau][colonnePlateau]=piece;
	}

	/**
	 * A Faire (15/05/2021 TG + aide de JC finalis�)
	 * 
	 * Méthode retournant une pièce se trouvant sur le plateau à un emplacement spécifique.
	 * 
	 * @param lignePlateau La ligne du plateau  (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau (un entier entre 0 et 6).
	 * @return La pièce se trouvant sur la ligne lignePlateau et la colonne colonnePlateau. Si il n'y a pas de pièce, null est retourné.
	 */
	public Piece getPiece(int lignePlateau,int colonnePlateau){
		return this.plateau[lignePlateau][colonnePlateau];
		/*Piece piece = plateau[lignePlateau][colonnePlateau];
		System.out.println(plateau);
		System.out.println(piece);
		return piece;*/
	}

	/**
	 * 
	 * A Faire (15/05/2021 JC � v�rif)
	 *  
	 * M�thode permettant de placer al�atoirment 49 pi�ces du jeu sur le plateau.
	 * L'orientation des pi�ces est al�atoire. Les pi�ces utilis�es doivent �tre des nouvelles pi�ces g�n�r�es � partir de la m�thode Piece.nouvellesPieces.
	 * Parmi les 50 pi�ces du jeu, la pi�ce qui n'a pas �t� plac�e sur le plateau est retourn�e par la m�thode.
	 * 
	 * @return La seule pi�ce qui n'a pas �t� plac�e sur le plateau
	 */
	public Piece placerPiecesAleatoierment(){
		Piece pieces[] = Piece.nouvellesPieces();
		int t = 0;
		for(int i = 0; i <= 6; i++) {
			for(int j = 0; j <= 6; j++) {
				plateau[i][j] = pieces[t];
				t++;
				System.out.println(i + " " + j);
			}
		}
		return pieces[50];
	}
		


	/**
	 * 
	 * Méthode utilitaire permettant de tester si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes d'une grille de 7 lignes sur 7 colonnes.
	 *  
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les les positions passées en paramètre sont les positions de deux cases différentes et adjacentes d'une grille de 7 lignes sur 7 colonnes, false sinon.
	 */
	private static boolean casesAdjacentes(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if ((posLigCase1<0)||(posLigCase2<0)||(posLigCase1>6)||(posLigCase2>6)) return false;
		if ((posColCase1<0)||(posColCase2<0)||(posColCase1>6)||(posColCase2>6)) return false;
		int distLigne=posLigCase1-posLigCase2;
		if (distLigne<0) distLigne=-distLigne;
		int distColonne=posColCase1-posColCase2;
		if (distColonne<0) distColonne=-distColonne;
		if ((distLigne>1)||(distColonne>1)||((distColonne+distLigne)!=1))
			return false;
		return true;
	}

	/**
	 * 
	 * A Faire (15/05/2021 TG et CG � verifier)
	 * 
	 * Méthode permettant de tester si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes 
	 * de la grille de jeu et qu'il est possible de passer d'une cas à l'autre compte tenu des deux pièces posées sur les deux cases du plateau.
	 * 
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes de la grille de jeu et qu'il est possible de passer d'une cas à l'autre compte tenu des deux pièces posées sur les deux cases du plateau, false sinon.
	 */
	private boolean passageEntreCases(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if (casesAdjacentes(posLigCase1, posColCase1, posLigCase2, posColCase2)==true) {
			boolean[] entree1=this.plateau[posLigCase1][posColCase1].getPointsEntree();
			boolean[] entree2=this.plateau[posLigCase2][posColCase2].getPointsEntree();

			if (posLigCase1<posLigCase2) {
				if (entree1[2]== true && entree2[0] == true) {
					return true;
				
				}
			}

			if (posLigCase2<posLigCase1) {
				if (entree2[2]== true && entree1[0] == true) {
					return true;
				
				}
			}

			if (posColCase1<posColCase2) {
				if (entree1[1]== true && entree2[3] == true) {
					return true;
				
				}
			}

			if (posColCase1<posColCase2) {
				if (entree2[1]== true && entree1[3] == true) {
					return true;
				
				}
			}
		}
		return false;	
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de retourner un �ventuel chemin entre deux cases du plateau compte tenu des pi�ces pos�es sur le plateau.
	 * Dans le cas o� il n'y a pas de chemin entre les deux cases, la valeur null est retourn�e.
	 * Dans le cas o� il existe un chemin, un chemin possible est retourn� sous forme d'un tableau d'entiers � deux dimensions.
	 * La premi�re dimension correspond aux cases du plateau à emprunter pour aller de la case de d�part � la case d'arriv�e.
	 * Dans ce tableau, chaque case est un tableau de deux entiers avec le premier entier qui correspond � la ligne de la case et
	 * le second entier qui correspond � la colonne de la case. La premi�re case d'un chemin retourn� correspond toujours 
	 * � la case (posLigCaseDep,posColCaseDep) et la derni�re case correspond toujours �la case (posLigCaseArr,posColCaseArr).
	 *
	 * @param posLigCaseDep La ligne de la case de d�part (un entier compris entre 0 et 6).
	 * @param posColCaseDep La colonne de la case de d�part (un entier compris entre 0 et 6).
	 * @param posLigCaseArr La ligne de la case d'arriv�e (un entier compris entre 0 et 6).
	 * @param posColCaseArr La colonne de la case d'arriv�e (un entier compris entre 0 et 6).
	 * @return null si il n'existe pas de chemin entre les deux case, un chemin sinon.
	 */
	public int[][] calculeChemin(int posLigCaseDep,int posColCaseDep,int posLigCaseArr,int posColCaseArr){
		int resultat[][] = new int[7][7];
		/*for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				resultat[i][j]=0;
			}
		}
		return resultat;*/
		
		System.out.println(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep + 1,posColCaseDep));
		System.out.println(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep - 1,posColCaseDep));
		System.out.println(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep,posColCaseDep + 1));
		System.out.println(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep - 1,posColCaseDep));	
        /*while ((posLigCaseDep != posLigCaseArr) && (posColCaseDep != posColCaseArr)) {
          
        	if(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep + 1,posColCaseDep)==true) {
        		posLigCaseDep = posLigCaseDep + 1 ;
        		resultat = new int [posLigCaseDep][posColCaseDep];        
                }
        	if(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep - 1 , posColCaseDep)==true) {
        		posLigCaseDep = posLigCaseDep - 1;
        		resultat = new int [posLigCaseDep][posColCaseDep];
                }
        	if(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep, posColCaseDep + 1)==true) {
        		posColCaseDep=posColCaseDep + 1;
        		resultat = new int [posLigCaseDep][posColCaseDep];
                }
        	if(passageEntreCases(posLigCaseDep, posColCaseDep, posLigCaseDep, posColCaseDep - 1)==true) {
        		posColCaseDep=posColCaseDep - 1;
        		resultat = new int [posLigCaseDep][posColCaseDep];
                }
        	else {
        		resultat = null;
                    
                }
                
         }*/
        return resultat;
    }

	/**
	 * 
	 * Méthode permettant de calculer un chemin détaillé (chemin entre sous-cases) à partir d'un chemin entre cases.
	 *  
	 * @param chemin Un tableau représentant un chemin de cases.
	 * @param numJoueur Le numéro du joueur pour lequel nous souaitons construire un chemin détaillé.
	 * 
	 * @return Le chemin détaillé correspondant au chemin de positions de pièces données en paramètre et pour le numéro de joueur donné.
	 */
	public int[][] calculeCheminDetaille(int[][] chemin,int numJoueur){
		if (chemin.length==1)
			return new int[0][0];
		int[][] cheminDetaille=new int[chemin.length*5][4];
		int pos=0;
		int col,lig,colS,ligS;
		for (int i=0;i<chemin.length-1;i++){
			lig=chemin[i][0];
			col=chemin[i][1];
			ligS=chemin[i+1][0];
			colS=chemin[i+1][1];
			if (ligS<lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
			}
			else if (ligS>lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
			} else if (colS<col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
			} else if (colS>col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
			}
		}
		cheminDetaille[pos][0]=chemin[chemin.length-1][0];
		cheminDetaille[pos][1]=chemin[chemin.length-1][1];
		cheminDetaille[pos][2]=1;
		cheminDetaille[pos++][3]=1;

		int debut=0;
		if ((numJoueur==0)&&((cheminDetaille[pos-2][2]==0)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==1)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==2)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==0))) pos--;
		if ((numJoueur==0)&&((cheminDetaille[1][2]==0)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==1)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==2)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==0))) debut++;

		int[][] resultat=new int[pos-debut][4];
		for (int i=debut;i<pos;i++)
			for (int j=0;j<4;j++)
				resultat[i-debut][j]=cheminDetaille[i][j];
		return resultat;	
	}

	/**
	 * 
	 * Méthode retournant une copie du plateau avec des copies de ses pièces.
	 * 
	 * @return Une copie du plateau avec une copie de toutes ses pièces.
	 */
	public Plateau copy(){
		Plateau plateau=new Plateau();
		for (int ligne=0;ligne<7;ligne++)
			for (int colonne=0;colonne<7;colonne++)
				plateau.positionnePiece((this.plateau[ligne][colonne]).copy(), ligne, colonne);
		return plateau;
	}

}
