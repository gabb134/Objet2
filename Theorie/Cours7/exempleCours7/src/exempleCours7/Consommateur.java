package exempleCours7;
public class Consommateur implements Runnable{
Tampon tamp; 
public Consommateur(Tampon tamp) {
	this.tamp= tamp;
	new Thread(this, " Consommateur").start();
	
}
public void run() {
	while(true) {
		tamp.consommer();
	}
}
}
