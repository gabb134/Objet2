package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ParcoursEvenement extends Application {
	Circle cRouge;
	HBox root;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Ajoutez � votre projet une classe ParcoursEvenement, sous classe de
			// Application
			// Le panneau root doit �tre de type HBox
			// La taille de la fen�tre doit �tre de 400 x 400
			// Le titre de la fen�tre est : �Parcours des �v�nements�
			// Ajoutez un cercle (Circle) de rayon 80 et couleur rouge, au centre du panneau
			// HBox.

			root = new HBox();
			Scene scene = new Scene(root, 400, 400);

			cRouge = new Circle(80);
			cRouge.setStroke(Color.RED);
			cRouge.setFill(Color.RED);
			root.setAlignment(Pos.CENTER);

			// Ajoutez un rectangle (Rectangle) de dimension 150X150 et de couleur CYAN.
			// Les composants sont espac�s de 30 pixels

			Rectangle rect = new Rectangle(150, 150);
			rect.setStroke(Color.CYAN);
			rect.setFill(Color.CYAN);

			// Enregistrez gestionEvenementSouris et filtreEvenementSouris pour l��v�nement
			// MouseEvent.MOUSE_CLICKED sur les n�uds Circle, Stage, Scene et HBox
			EventHandler<MouseEvent> gestionEvenementSouris = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gererEvenement("gestionnaire d'�v�nements de souris a �t� appel�", e);
				}
			};
			EventHandler<MouseEvent> filtreEvenementSouris = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gererEvenement("filtre d'�v�nements de souris a �t� appel�", e);
				}
			};
			cRouge.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			cRouge.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);

			primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);

			scene.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			scene.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);

			root.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			root.addEventHandler(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);

			CheckBox cb1 = new CheckBox();

			cb1.addEventFilter(MouseEvent.MOUSE_CLICKED, filtreEvenementSouris);
			cb1.addEventFilter(MouseEvent.MOUSE_CLICKED, gestionEvenementSouris);

			root.setSpacing(30);
			root.getChildren().addAll(cRouge, rect, cb1);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Parcours des �v�nements");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gererEvenement(String filtreOuGestionnaire, MouseEvent e) {
		System.out.println(filtreOuGestionnaire + "\ntype: " + e.getEventType().getName() + ", Source: "
				+ e.getSource().getClass().getSimpleName() + ", Destination: "
				+ e.getTarget().getClass().getSimpleName() + "\n");

		// if (e.getSource() == cRouge) {
		// e.consume();
		// }
		//if (e.getSource() == root)
		//	e.consume();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
