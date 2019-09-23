package application;

import java.time.format.SignStyle;

import com.sun.javafx.css.Size;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercice5 extends Application {
	BorderPane root;
	Button btnMaj;
	Button btnMin;
	Text txt1;
	RadioButton rbRouge;
	RadioButton rbVert;
	RadioButton rbBleu;
	CheckBox cbGras;
	CheckBox cbItalique;

	public void start(Stage primaryStage) {

		try {

			root = new BorderPane();
			Scene scene = new Scene(root, 500, 400);

			root.setPadding(new Insets(20));

			GridPane gPane = new GridPane();

			txt1 = new Text("Interface Graphique Java");

			Font fontTitre = Font.font("Serif", FontWeight.BOLD, 30);
			txt1.setFont(fontTitre);
			root.setAlignment(txt1, Pos.CENTER);

			rbRouge = new RadioButton("rouge");
			rbVert = new RadioButton("vert");
			rbBleu = new RadioButton("bleu");

			ToggleGroup tg = new ToggleGroup();

			rbRouge.setToggleGroup(tg);
			rbVert.setToggleGroup(tg);
			rbBleu.setToggleGroup(tg);
			// rbRouge.setSelected(true);

			Font fontRb = Font.font("Serif", FontWeight.BOLD, 20);
			rbRouge.setFont(fontRb);
			rbVert.setFont(fontRb);
			rbBleu.setFont(fontRb);

			cbGras = new CheckBox("gras");
			cbItalique = new CheckBox("italique");

			cbGras.setFont(fontRb);
			cbItalique.setFont(fontRb);
			cbGras.setSelected(true);

			gPane.add(rbRouge, 0, 0);
			gPane.add(rbVert, 0, 1);
			gPane.add(rbBleu, 0, 2);

			gPane.add(cbGras, 1, 0);
			gPane.add(cbItalique, 1, 1);
			gPane.setAlignment(Pos.CENTER);
			gPane.setVgap(10);
			gPane.setHgap(10);
			BorderPane.setMargin(gPane, new Insets(20, 40, 20, 40));

			btnMaj = new Button("majuscule");
			btnMin = new Button("minuscule");

			HBox hBoxButton = new HBox(10);
			HBox.setHgrow(btnMaj, Priority.ALWAYS);
			HBox.setHgrow(btnMin, Priority.ALWAYS);

			btnMaj.setFont(fontRb);
			btnMin.setFont(fontRb);

			hBoxButton.setAlignment(Pos.CENTER);

			hBoxButton.getChildren().addAll(btnMaj, btnMin);

			root.setTop(txt1);
			root.setBottom(hBoxButton);
			root.setCenter(gPane);

			GestionBouton gb = new GestionBouton();
			GestionCouleur gc = new GestionCouleur();
			GestionFont gf = new GestionFont();

			btnMaj.setOnAction(gb);
			btnMin.setOnAction(gb);
			rbRouge.setOnAction(gc);
			rbVert.setOnAction(gc);
			rbBleu.setOnAction(gc);
			cbGras.setOnAction(gf);
			cbItalique.setOnAction(gf);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercice6");

			primaryStage.setResizable(false);

			primaryStage.sizeToScene();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private class GestionBouton implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnMaj) {
				txt1.setText(txt1.getText().toUpperCase());
			} else if (e.getSource() == btnMin) {
				txt1.setText(txt1.getText().toLowerCase());
			}
		}

	}

	private class GestionCouleur implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == rbRouge) {
				txt1.setFill(Color.RED);
			} else if (e.getSource() == rbVert) {
				txt1.setFill(Color.GREEN);
			} else if (e.getSource() == rbBleu) {
				txt1.setFill(Color.BLUE);
			}

		}

	}

	private class GestionFont implements EventHandler<ActionEvent> {
		FontWeight styleGras;
		FontPosture styleItalique;
		Font font;

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			CheckBox source = (CheckBox) e.getSource();
			if (source == cbGras) {
				if (source.isSelected()) {

					styleGras = FontWeight.BOLD;

				} else {
					styleGras = FontWeight.NORMAL;

				}

			} else if (source == cbItalique) {
				if (source.isSelected()) {
					styleItalique = FontPosture.ITALIC;

				} else {
					styleItalique = FontPosture.REGULAR;

				}
			}
			font = Font.font(txt1.getFont().getFamily(), styleGras, styleItalique, 20);
			txt1.setFont(font);

		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
