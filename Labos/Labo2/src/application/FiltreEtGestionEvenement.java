package application;

import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FiltreEtGestionEvenement extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox root = new HBox();
			Scene scene = new Scene(root, 400, 400);

			Circle cRouge = new Circle(80);
			cRouge.setStroke(Color.RED);
			cRouge.setFill(Color.RED);
			root.setAlignment(Pos.CENTER);
			root.getChildren().add(cRouge);


			EventHandler<MouseEvent> gestionSouris = new EventHandler<MouseEvent>() {

				public void handle(MouseEvent e) {
					System.out.println("gestionnaire ou filtre d'événements de souris a été appelé");
				}
			};
			EventHandler<MouseEvent> gestionEvenementSouris = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
				gererEvenement("gestionnaire d'événements de souris a été appelé", e);
				}
			};
			EventHandler<MouseEvent> filtreEvenementSouris = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
				gererEvenement("filtre d'événements de souris a été appelé", e);
				}
			};
			
			
		
			
			cRouge.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionSouris);
			cRouge.addEventFilter(MouseEvent.MOUSE_CLICKED, gestionSouris);
			cRouge.removeEventFilter(MouseEvent.MOUSE_CLICKED, gestionSouris);
			cRouge.removeEventHandler(MouseEvent.MOUSE_CLICKED, gestionSouris);
			
			cRouge.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			cRouge.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Filtre et gestion d’événements");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void gererEvenement(String filtreOuGestionnaire, MouseEvent e) {
	
			System.out.println(filtreOuGestionnaire+"\ntype: "+e.getEventType().getName()+", Source: "+e.getSource().getClass().getSimpleName()+", Destination: "+e.getTarget().getClass().getSimpleName());

		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
