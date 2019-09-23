package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class LectureDonnees {
	private int[][] tabNombres;
	private ArrayList<Mot> arrMots = new ArrayList<Mot>();
	private ArrayList<Case> arrCase = new ArrayList<Case>();

	public LectureDonnees(String strFIchier) {
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		String nbLignes = "";
		String strNumeros = "";
		String nbColonnes = "";
		int compteurLignes = 0;
		int intLignes = 0;
		int intColonnes = 0;

		try {
			brFichier = new BufferedReader(new FileReader(strFIchier));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while ((strLigne = brFichier.readLine()) != null) {

				try {
					if (compteurLignes == 0) {
						st = new StringTokenizer(strLigne, ",");

						nbLignes = st.nextToken().trim();// lignes
						nbColonnes = st.nextToken().trim();// colonnes
						intLignes = Integer.parseInt(nbLignes);
						intColonnes = Integer.parseInt(nbColonnes);
						tabNombres = new int[intLignes][intColonnes];

					} else if (compteurLignes > Integer.parseInt(nbLignes)) {
						strNumeros = strLigne.trim();
						// System.out.println(strNumeros);

					} else if (compteurLignes > 0 && compteurLignes <= Integer.parseInt(nbLignes)) {
						StringTokenizer st1;
						st1 = new StringTokenizer(strLigne, ",");// Pour aller lire sans les virgules

						for (int j = 0; j < intColonnes; j++) { // Pour aller remplir le tableau avec la grille
							tabNombres[compteurLignes - 1][j] = Integer.parseInt(st1.nextToken().trim());

							// Voir comment construire les cases ici, lors de la lecture

						}
						// System.out.println(strLigne);

					}

				} catch (NoSuchElementException e) {

				}
				compteurLignes++;
			}

			for (int i = 0; i < tabNombres.length; i++) {
				for (int j = 0; j < tabNombres[i].length; j++) {
					// System.out.print(" " + tabNombres[i][k] + " ");
					int intNombre = tabNombres[i][j];
					Case caseCreer;

					switch (intNombre) {
					case -1:
						
					//caseCreer = new Case(-1, Case.getGpane());
					
					
						
						break;
					case 0:
					//	System.out.println(intNombre);

						break;

					default: //les autres num�ros
					//	System.out.println(intNombre);
						break;
					}
					
				}
				System.out.println();
			}
			// System.out.println(intLignes + " " + intColonnes+"\n"+strNumeros);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

	}

	public void lectureDonneesMot(String strFichierMot) {
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		String strOrientation = "";
		String strIndice = "";
		String strMot = "";

		try {
			brFichier = new BufferedReader(new FileReader(strFichierMot));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while ((strLigne = brFichier.readLine()) != null) {

				try {
					st = new StringTokenizer(strLigne, ";");
					strOrientation = st.nextToken().trim();

					// StringTokenizer st2 = new StringTokenizer(strIndice,"\"");
					strIndice = st.nextToken().trim();
					// strIndice.replace("\"", "");
					// System.out.println(strIndice);
					strMot = st.nextToken().trim();
					System.out.println(strMot);
					// Inserer dans un tableau

				} catch (NoSuchElementException e) {

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void afficherGrille() {
		for (int i = 0; i < tabNombres.length; i++) {
			for (int j = 0; j < tabNombres[i].length; j++) {
				System.out.print(" " + tabNombres[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LectureDonnees l = new LectureDonnees("grilleBible.txt");
		// l.afficherGrille();
		// l.lectureDonneesMot("donneesBible.txt");
	}
}
