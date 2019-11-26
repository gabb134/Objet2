package exempleCours7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ThreadEtJavaFX extends Application {
	ProgressBar pBarre;
	ProgressIndicator pInd ;
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(" dans start: nom =  " + Thread.currentThread().getName()) ;
		System.out.println(" dans start: id= " + Thread.currentThread().getId()) ;
		TilePane tlPane = new TilePane();
		tlPane.setPrefColumns(2);
		// création de la barre de progression
		 pBarre = new ProgressBar();
		 pInd = new ProgressIndicator();
		
		pBarre.setMaxWidth(Double.MAX_VALUE);
		Button bouton = new Button("démarrer le traitement");
		bouton.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR,20));
		tlPane.getChildren().addAll(pBarre,pInd,bouton);
		bouton.setOnAction(e-> {System.out.println(" dans setOnAction sommes nous dans Application thread?"  + Platform.isFxApplicationThread()) ;System.out.println(" dans setOnAction: nom =  " + Thread.currentThread().getName()) ;
		System.out.println("dans setOnAction: id= "+ Thread.currentThread().getId()) ;
		
									/*for (int i=0; i<100;i++){
									//System.out.println(" i= "+(float) i/100);
									final int j =i;
									pBarre.setProgress((float) j/100);
		
									// faire une pause pour simuler un traitement long
									try {
										Thread.sleep(100);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
									}*/
		                            new ThreadCalcul().start(); 
		                            });
		Scene scene = new Scene(tlPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Les threads et JavaFX");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.println(" dans main sommes nous dans Application thread?"  + Platform.isFxApplicationThread()) ;
		System.out.println(" dans main: nom =  " + Thread.currentThread().getName()) ;
		System.out.println(" dans main: id= " + Thread.currentThread().getId()) ;
		launch(args);
	}

	private class ThreadCalcul extends Thread {
		public void run() {
			//System.out.println(" dans calcul thread: sommes-nous dans EDT " + SwingUtilities.isEventDispatchThread());
			System.out.println(" dans calcul thread: " + Thread.currentThread().getName()) ;
			System.out.println(" dans calcul thread: id =" + Thread.currentThread().getId()) ;	
			//traitement  long...
			for (int i=0; i<101;i++){
				System.out.println(" i= "+ i);
				final int j=i;
			  Platform.runLater( ()->{pBarre.setProgress((float)j/100); pInd.setProgress((float)j/100);});
				//pBarre.setProgress((float)j/100);
			// faire une pause pour simuler un traitement long
			   try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	
}
}