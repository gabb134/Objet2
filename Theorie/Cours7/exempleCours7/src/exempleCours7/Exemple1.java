package exempleCours7;

public class Exemple1 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		t.setName("Fil principal");    // on change le nom du fil pour "Fil principal"

		try {
		    Thread.sleep(4000);	// on fait dormir le fil courant pour 4000 millisecondes.
		} catch (InterruptedException e) {
		    System.out.println("Un autre fil a interrompu celui qui dort!");
		}

		System.out.println("Le fil principal est " + t);
	}
}

