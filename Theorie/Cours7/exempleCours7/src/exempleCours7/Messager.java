package exempleCours7;
public class Messager {
     public void afficherMessage(String s) {
        System.out.println("On entre dans la m�thode afficherMessage" + " "+s);
        try {    
            Thread.sleep(3000);	//attend 3 secondes avant d�afficher le message

        } catch (InterruptedException e) {
            System.out.println("On a interrompu le messager!");
        }

        System.out.println(s  + " est affich�");	// le message est affich�
    }
}
 

