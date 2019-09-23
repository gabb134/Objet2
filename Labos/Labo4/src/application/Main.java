package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane(Orientation.VERTICAL);
			TilePane tilePane = new TilePane();
			// HBox hbox = new HBox();
			Scene scene = new Scene(root, 400, 480);
			Pane pane = new Pane();

			root.setPadding(new Insets(20));
			root.setVgap(30);
			// root.setHgap(30);

			// root.setMargin(rectangle, new Insets(top, right, bottom, left));

			Circle cercle = new Circle(80);
			Rectangle rectangle = new Rectangle(150, 150);

			cercle.setStroke(Color.AQUA);
			cercle.setFill(Color.AQUA);

			rectangle.setStroke(Color.AQUA);
			rectangle.setFill(Color.AQUA);
			

			BorderStrokeStyle styleBleu = new BorderStrokeStyle(StrokeType.CENTERED, StrokeLineJoin.MITER,
					StrokeLineCap.BUTT, 10, 0, null);
			BorderStroke bordureBleu = new BorderStroke(Color.ALICEBLUE.BLUE, BorderStrokeStyle.SOLID,
					CornerRadii.EMPTY, new BorderWidths(10), new Insets(0));
			Border bordure = new Border(bordureBleu);
			pane.setBorder(bordure);

			//pane.getChildren().add(text);

			tilePane.setAlignment(Pos.CENTER);
			// tilePane.setVgap(10);
			tilePane.setHgap(10);

			tilePane.getChildren().addAll(cercle, rectangle);

			root.getChildren().addAll(tilePane, pane);

			cercle.requestFocus();

			EventHandler<KeyEvent> gestionClavier = new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource() == cercle) {
						if (e.getCode() == KeyCode.C) {

							// text.setText("touche enfoncée: " + e.getCode());
							cercle.setStroke(Color.RED);
							cercle.setFill(Color.RED);
							rectangle.requestFocus();
							rectangle.setStroke(Color.AQUA);
							rectangle.setFill(Color.AQUA);
						}
					} else if (e.getSource() == rectangle) {
						if (e.getCode() == KeyCode.R) {
							rectangle.setStroke(Color.RED);
							rectangle.setFill(Color.RED);
							cercle.setStroke(Color.AQUA);
							cercle.setFill(Color.AQUA);
							cercle.requestFocus();
						}
					}

				}

			};

			EventHandler<MouseEvent> gestionSouris = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					// TODO Auto-generated method stub

					if (e.getSource() == cercle) {
						if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
							cercle.setStroke(Color.YELLOW);
							cercle.setFill(Color.YELLOW);
						}
					} else if (e.getSource() == rectangle) {
						if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
							rectangle.setStroke(Color.YELLOW);
							rectangle.setFill(Color.YELLOW);

						} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
							rectangle.setStroke(Color.AQUA);
							rectangle.setFill(Color.AQUA);
						}
					}
					else if(e.getSource()==pane) {
						if(e.getButton() == MouseButton.PRIMARY) {
							Text text = new Text();
							text.setText("vous avez cliqué droit sur le panneau");
							text.setLayoutX(e.getX());
							text.setLayoutY(e.getY());
							text.setFill(Color.WHITE);
							text.setStroke(Color.PURPLE);
							Font font = Font.font("Serif", FontWeight.BOLD, 15);
							text.setFont(font);
							pane.getChildren().add(text);
							
						}
						else if (e.getButton() == MouseButton.SECONDARY) {
							pane.getChildren().clear();
						}
					}
				}

			};

			// scene.setOnKeyPressed(gestionClavier);
			cercle.setOnKeyPressed(gestionClavier);
			rectangle.setOnKeyPressed(gestionClavier);
			cercle.setOnMouseClicked(gestionSouris);
			rectangle.setOnMouseEntered(gestionSouris);
			rectangle.setOnMouseExited(gestionSouris);
			pane.setOnMouseClicked(gestionSouris);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Gestion de la souris et du clavier ");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
