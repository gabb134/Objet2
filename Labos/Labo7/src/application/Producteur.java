package application;
public class Producteur implements Runnable {
	Tampon tamp;
	public  Producteur( Tampon tamp){
		this.tamp = tamp;
		new Thread(this, "Producteur").start();
		
	}
public void run() {
	int i = 0;
	while (true) { tamp.produire(i++);
    }
  }
}
