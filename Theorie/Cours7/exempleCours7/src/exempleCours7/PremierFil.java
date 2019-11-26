package exempleCours7;
public class PremierFil {
    public static void main(String args[]) {
        System.out.println("Fil principal : " + Thread.currentThread());// infos fil principal
        Thread sf = new Thread(new SecondFil(), "Second Fil");	// cr�e le second fil
        System.out.println("Second fil : " + sf);	 	// infos du second fil
        sf.start();    				// d�marre le second fil
        
        try {
                Thread.sleep(3000);		// le fil principal dort 3 secondes
        } catch (InterruptedException e) {
            System.err.println("Le fil principal a �t� interrompu dans son sommeil!");
        }
        System.err.println("Fin du fil principal");
    }
}
