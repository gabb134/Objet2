package application;

public class Document implements Comparable<Document> {

	private int numero;
	private String auteur;
	private String titre;

	public Document(int numero, String auteur, String titre) {
		super();
		this.numero = numero;
		this.auteur = auteur;
		this.titre = titre;
	}

	public int hashCode() {

		return (new Integer(numero).hashCode() + titre.hashCode() + auteur.hashCode());
		
	}

	public boolean equals(Object d) {

		return this.numero == getNumero() && this.titre.equals(getTitre()) && this.auteur.equals(getAuteur());

	}

	public String toString() {

		return "Numéro: " + numero + "\nAuteur: " + auteur + "\nTitre: " + titre + "\n";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Document o) {
		// TODO Auto-generated method stub

		return this.titre.compareTo(o.getTitre());
	}

}
