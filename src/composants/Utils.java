package composants;

import java.util.Date;
import java.util.Random;

/**
 * 
 * Classe contenant quelques fonctions utilitaires.
 * 
 */
public class Utils {
	
	private static Random generateur=new Random((new Date().getTime()));

	/**
	 * (10/05/21 JC Finalis�)
	 * 
	 * M�thode permettant de g�n�rer al�atoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant �tre retourn�.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	public static int genererEntier(int max){
		return generateur.nextInt(max);
	}
	/**
	 *  (10/05/21 JC Finalis�)
	 * 
	 * M�thode permettant de g�n�rer un tableau d'entiers dont la longueur longTab est donn�e en param�tre.
	 * Le tableau g�n�r� doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit �tre al�atoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 plac�s al�atoirement dans le tableau.
	 */
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[] = new int[longTab];
		for (int i = 0; i <= longTab-1; i++) {
            tab[i] = genererEntier(longTab - 1);
        }
		
		return tab;
	}
	/**
	 * Programme testant la m�thode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");

	}

}
