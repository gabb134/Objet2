package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javafx.scene.layout.GridPane;

public class LectureDonnees {
	private int[][] tabNombres;
	private ArrayList<Mot> arrMots = new ArrayList<Mot>();
	//private ArrayList<Case> arrCase = new ArrayList<Case>();
	private Case [][] tabCase;
	//GridPane gpane;
/* Mettre les Commentaires  */
	public LectureDonnees(String strFIchier,String strFichierMot) {
		//this.gpane = gpane;
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
						tabCase = new Case[intLignes][intColonnes];
						
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

			/*for (int i = 0; i < tabNombres.length; i++) {
				for (int j = 0; j < tabNombres[i].length; j++) {
					// System.out.print(" " + tabNombres[i][k] + " ");
					int intNombre = tabNombres[i][j];
					// grille, liste de mots
					
					
				//	Case caseCreer = new Case(intNombre,i,j); //objet qui envoie le nombre , les lignes et le colonne a la classe casecreer
					//gpane.getChildren().add(caseCreer.creerHbox());
				//	arrCase.add(caseCreer);
					
				}
				System.out.println();
			}*/
			// System.out.println(intLignes + " " + intColonnes+"\n"+strNumeros);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		//LEcture du deuxieme fichier
		
		BufferedReader brFichier1 = null;
		String strLigne1;
		StringTokenizer st1;
		EnumOrientation orientation = null;
		String strIndice = "";
		String strMot = "";

		try {
			brFichier1 = new BufferedReader(new FileReader(strFichierMot));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while ((strLigne1 = brFichier1.readLine()) != null) {

				try {
					st1 = new StringTokenizer(strLigne1, ";");
					switch(st1.nextToken()) {
					case "V":
						orientation = EnumOrientation.VERTICAL;
						break;
					case "H":
						orientation = EnumOrientation.HORIZONTALE;
						break;
					
					}

					// StringTokenizer st2 = new StringTokenizer(strIndice,"\"");
					strIndice = st1.nextToken().trim();
					// strIndice.replace("\"", "");
					// System.out.println(strIndice);
					strMot = st1.nextToken().trim();
					//System.out.println(strMot);
					// Inserer dans un tableau
					//System.out.println(orientation);
					Mot mot = new Mot(orientation, strIndice, strMot);
					arrMots.add(mot);
					//System.out.println(orientation);

				} catch (NoSuchElementException e) {

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	public void melangerLettre() {
		//System.out.println(arrMots.get(2).getStrMot());
		
		
	}
	


	public Case[][] getTabCase() {
		return tabCase;
	}



	public int[][] getTabNombres() {
		return tabNombres;
	}



	public void setTabNombres(int[][] tabNombres) {
		this.tabNombres = tabNombres;
	}



	public ArrayList<Mot> getArrMots() {
		return arrMots;
	}



	public void setArrMots(ArrayList<Mot> arrMots) {
		this.arrMots = arrMots;
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
		LectureDonnees l = new LectureDonnees("grilleTechnologie.txt","donneesTechnologie.txt");
		/// l.afficherGrille();
		// l.lectureDonneesMot("donneesBible.txt");
		//l.melangerLettre();
	}
}
