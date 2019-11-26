package exempleCours7;
class SecondFil implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.err.println(i);	//on affiche le nombre
                Thread.sleep(1000);	//on attend une seconde
            }
        } catch (InterruptedException e) {
            System.err.println("Second Fil a été interrompu dans son sommeil!");
        }
    
        System.err.println("Fin du second fil.");
    }
}

