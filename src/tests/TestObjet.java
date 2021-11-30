package tests;

import java.util.Random;

import composants.Objet;
import grafix.interfaceGraphique.IG;

/**
 * 
 * Cette classe permet de tester l'attribution des objets sur le plateau
 * 
 */
public class TestObjet {
	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		Objet[] t = Objet.nouveauxObjets();
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
				
			
			/*while (b == true) {
				for (int g = 0 ; g<= l2.length;g++ ) {
					for (int j = 0 ; j<= c2.length;j++ ) {
						if (l != g && c != g ){
							b = false;
							if (b == false) {
								IG.placerObjetPlateau(t[i].getNumeroObjet(),l,c);
								c2[i] = c;
								l2[i] = l;
							}
						}
					}				
				}
				if (b == true) {
					System.out.println("recommence");
					l = rand1.nextInt(7);
					c = rand1.nextInt(7);	

				}
			}*/

		}
		System.out.println(r);
		IG.miseAJourAffichage();
		IG.attendreClic();
	}

}
