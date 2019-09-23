package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercice4 extends Application {
	BorderPane root;
	FlowPane flpane;
	Button btnQuitter;
	Button btnAjouter;
	Button btnInitialiser;
	
	int intCompteur = 0;

	@Override
	public void start(Stage primaryStage) {
		try {

			root = new BorderPane();
			root.setPadding(new Insets(10));
			HBox hbox = new HBox(10);
			flpane = new FlowPane();
			flpane.setPadding(new Insets(10));
			flpane.setVgap(10);
			flpane.setHgap(10);
			Scene scene = new Scene(root, 600, 400);

			Font fontTitre = Font.font("Serif", FontWeight.BOLD, 30);
			Font fontBoutton = Font.font("Serif", FontWeight.BOLD, 20);

			Text txt1 = new Text("Associer des actions aux boutons");

			btnQuitter = new Button("quitter");
			btnAjouter = new Button("ajouter");
			btnInitialiser = new Button("initialiser");

			HBox.setHgrow(btnQuitter, Priority.ALWAYS);
			HBox.setHgrow(btnAjouter, Priority.ALWAYS);
			HBox.setHgrow(btnInitialiser, Priority.ALWAYS);
			btnQuitter.setMaxWidth(Double.MAX_VALUE);
			btnAjouter.setMaxWidth(Double.MAX_VALUE);
			btnInitialiser.setMaxWidth(Double.MAX_VALUE);

			btnQuitter.setFont(fontBoutton);
			btnAjouter.setFont(fontBoutton);
			btnInitialiser.setFont(fontBoutton);
			txt1.setFont(fontTitre);

			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(btnQuitter, btnAjouter, btnInitialiser);

		
			root.setAlignment(txt1, Pos.CENTER);
			root.setBottom(hbox);
			root.setTop(txt1);
			root.setCenter(flpane);

			GestionBouton gb = new GestionBouton();

			btnQuitter.setOnAction(gb);
			btnAjouter.setOnAction(gb);
			btnInitialiser.setOnAction(gb);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercice 4");
			primaryStage.show();
			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private class GestionBouton implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnQuitter)
				Platform.exit();
			else if (e.getSource() == btnAjouter) {
				// Ajouter les boutons
				intCompteur++;
				//System.out.println("allo");
				Button btn = new Button("Bouton "+intCompteur);
				
				flpane.getChildren().add(btn);
				btn.setOnAction(this);
				System.out.println(intCompteur);

			}
			else if(e.getSource()==btnInitialiser) {
				flpane.getChildren().removeAll(flpane.getChildren());
				intCompteur=0;
			}
			else {
				flpane.getChildren().remove(e.getSource());
			}

		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
