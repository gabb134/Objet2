package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Exercice6 extends Application {
	public void start(Stage primaryStage) {

		try {
			// Utilisez des panneaux de mise en page de votre choix pour reproduire
			// l’interface
			// graphique suivante :
			BorderPane root = creerBorderPane();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			// Le titre de la fenêtre est : Exercice 6
			primaryStage.setTitle("Exercice6");

			// Le redimensionnement de la fenêtre n’est pas possible. Utilisez la méthode
			// setResizable
			primaryStage.setResizable(false);

			// Ajustez la taille de la fenêtre à la scène. Utilisez la méthode sizeToScene()
			primaryStage.sizeToScene();

			// Pour afficher la fenêtre
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BorderPane creerBorderPane() {
		BorderPane bdPane = new BorderPane();
		//bdPane.setPrefSize(400, 400);
	
		bdPane.setPadding(new Insets(20));
		

		GridPane gPane = new GridPane();

		Text txt1 = new Text("Interface Graphique Java");

		Font fontTitre = Font.font("Serif", FontWeight.BOLD, 30);
		txt1.setFont(fontTitre);

		RadioButton rb1 = new RadioButton("rouge");
		RadioButton rb2 = new RadioButton("vert");
		RadioButton rb3 = new RadioButton("bleu");

		ToggleGroup tg = new ToggleGroup();

		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		rb1.setSelected(true);

		Font fontRb = Font.font("Serif", FontWeight.BOLD, 20);
		rb1.setFont(fontRb);
		rb2.setFont(fontRb);
		rb3.setFont(fontRb);

		CheckBox cb1 = new CheckBox("gras");
		CheckBox cb2 = new CheckBox("italique");

		cb1.setFont(fontRb);
		cb2.setFont(fontRb);
		cb1.setSelected(true);

		gPane.add(rb1, 0, 0);
		gPane.add(rb2, 0, 1);
		gPane.add(rb3, 0, 2);

		gPane.add(cb1, 1, 0);
		gPane.add(cb2, 1, 1);
		gPane.setAlignment(Pos.CENTER);
		gPane.setVgap(10);
		gPane.setHgap(10);
		BorderPane.setMargin(gPane, new Insets(20, 40, 20, 40));
	//	GridPane.setMargin(bdPane, new Insets(5,10,5,10));

		Button btnMaj = new Button("majuscule");
		Button btnMin = new Button("minuscule");

		HBox hBoxButton = new HBox(10);
		HBox.setHgrow(btnMaj, Priority.ALWAYS);
		HBox.setHgrow(btnMin, Priority.ALWAYS);

		btnMaj.setFont(fontRb);
		btnMin.setFont(fontRb);

		hBoxButton.setAlignment(Pos.CENTER);

		hBoxButton.getChildren().addAll(btnMaj, btnMin);

		bdPane.setTop(txt1);
		bdPane.setBottom(hBoxButton);
		bdPane.setCenter(gPane);

		return bdPane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
