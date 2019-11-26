package exempleCours7;
class AppelDeMessager implements Runnable {
    Messager m; 
    String s;

    public AppelDeMessager(Messager m, String s) {
        this.m = m;
        this.s = s;
        new Thread(this).start();
    }

    public void run() {
       // synchronized(m) {
    	    
            m.afficherMessage(s); 
       //}
        // System.out.println("en dehors synchro: "+ s + ": "+ Thread.currentThread().getName() );
    }
 }

