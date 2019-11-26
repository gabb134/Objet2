package exempleCours7;
public class Messager {
     public void afficherMessage(String s) {
        System.out.println("On entre dans la méthode afficherMessage" + " "+s);
        try {    
            Thread.sleep(3000);	//attend 3 secondes avant d’afficher le message

        } catch (InterruptedException e) {
            System.out.println("On a interrompu le messager!");
        }

        System.out.println(s  + " est affiché");	// le message est affiché
    }
}
 

