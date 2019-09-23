package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class OrdreExecutionGestionEvenement extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			//Ajoutez � votre projet une classe ParcoursEvenement, sous classe de Application
			// Le panneau root doit �tre de type HBox
			// La taille de la fen�tre doit �tre de 400 x 400
			// Le titre de la fen�tre est : �Parcours des �v�nements�
			// Ajoutez un cercle (Circle) de rayon 80 et couleur rouge, au centre du panneau
			//HBox. 

			HBox root = new HBox();
			Scene scene = new Scene(root, 400, 400);

			Circle cRouge = new Circle(80);
			cRouge.setStroke(Color.RED);
			cRouge.setFill(Color.RED);
			root.setAlignment(Pos.CENTER);
			root.getChildren().add(cRouge);
		
		
			//Utilisez une classe anonyme pour enregistrer � l�aide de la m�thode
			//addEventHandler un gestionnaire d��v�nements (clic de souris) sur le n�ud Circle.
			//La m�thode handle() de cette classe affiche le message : � gestionnaire
			//d��v�nements enregistr� avec addEventHandler �
			
			cRouge.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent> () {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					System.out.println("gestionnaire d'�v�nements enregistr� avec addEventHandler");

				}
			});
			// Utilisez une classe anonyme pour enregistrer � l�aide de la m�thode
			//setOnMouseClicked() un gestionnaire d��v�nements sur le n�ud Circle. La
			//m�thode handle() de cette classe affiche le message : � gestionnaire
			//d��v�nements enregistr� avec setOnMouseClicked �
			cRouge.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					System.out.println("gestionnaire d'�v�nements enregistr� avec setOnMouseClicked");

				}
				
			});
			//Utilisez une classe anonyme pour enregistrer � l�aide de la m�thode
			//addEventHandler un gestionnaire d��v�nements pour n�importe quel �v�nement
			//de souris (MouseEvent.ANY) sur le n�ud Circle. La m�thode handle() de cette
			//classe affiche le message : � le gestionnaire MouseEvent.ANY a d�tect�
			//l��v�nement : � suivi du type de l��v�nement (e.getEventType) seulement s�il
			//s�agit d�un clic de souris. Ceci nous �vitera des affichages inutiles. 
			
			cRouge.addEventHandler(MouseEvent.ANY,new EventHandler<MouseEvent> () {

				@Override
				
				
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					
					if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
						System.out.println("le gestionnaire MouseEvent.ANY a d�tect� l��v�nement : "+event.getEventType().getName());
					
						

					}

				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ordre d�ex�cution des gestionnaires d��v�nements pour un n�ud");
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
