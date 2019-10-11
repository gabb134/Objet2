package application;

public class Document {

	
	private int numero;
	private String auteur;
	private String titre;
	
	

	public Document(int numero, String auteur, String titre) {
		super();
		this.numero = numero;
		this.auteur = auteur;
		this.titre = titre;
	}

	public String toString() {
		
		return "Numéro: "+numero+"\nAuteur: "+auteur+"\nTitre: "+titre+"\n";
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

}
