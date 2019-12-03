package application;

public class Compteur {
	
	private int intCompteur = 0;

	public Compteur(int intCompteur) {
		super();
		this.intCompteur = intCompteur;
	}

	
	synchronized void inc() {
		intCompteur++;
		System.out.println("Increment du compteur :"+intCompteur);
	}
	synchronized void dec() {
		intCompteur--;
		System.out.println("Decrement du compteur :"+intCompteur);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
