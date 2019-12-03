package application;
public class Tampon {
private int numProduit;
private boolean auTourDeConsommer = false; 

synchronized void consommer() {
	if(!auTourDeConsommer){
		try{
			wait(); 
		}catch (InterruptedException e){
			throw new RuntimeException(" interrompu durant wait");
		}
	}

	System.out.println(" Un consommateur consomme le produit " + numProduit);
	auTourDeConsommer = false;
	notify();
	
}

synchronized void produire (int nouveauProduit) {
	if (auTourDeConsommer){
		try { 
			wait();
			
		}catch (InterruptedException e){
			throw new RuntimeException(" interrompu durant wait");
		}
	}
	numProduit = nouveauProduit;
	System.out.println( " le produit numéro: "+  numProduit + " est disponible");
	auTourDeConsommer = true;
	notify();
	}

}
