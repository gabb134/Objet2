package application;

public class TestThread implements Runnable {
	
	private Compteur cpt;
	private Boolean blnc;

	
	public TestThread(Compteur cpt, Boolean blnc) {
		super();
		this.cpt = cpt;
		this.blnc = blnc;
		//cree et lance le thread en cours
		new Thread(this).start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				if(blnc)
				cpt.inc();
				else
					cpt.dec();
				
				
				Thread.sleep((int)Math.random()*1000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compteur monCompteur = new Compteur(1);
		TestThread thread1 = new TestThread(monCompteur, true);
		TestThread thread2 = new TestThread(monCompteur, false);
		
		
		//monCompteur.
	}


}
