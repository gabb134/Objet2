package application;

//import java.awt.Color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
//import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class Exercice3 extends Application {

	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root, 400, 400);
			
			primaryStage.setTitle("Exercice3");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Pour avoir les couleurs
			BackgroundFill bgFillVert = new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), new Insets(40));
			BackgroundFill bgFillRouge = new BackgroundFill(Color.RED, new CornerRadii(25), new Insets(60));
			Background bg  = new Background(bgFillVert,bgFillRouge);
			
			//Pour l'image
			Image image = new Image("hydrangeas.PNG");
			BackgroundSize bgTaille  = new BackgroundSize(100, 100, false, false, false, false);
			BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgTaille);
			Background bg1 = new Background(bgImage);
			
			//Pour avoir l'image et les couleurs
			
			Background bg3  = new Background(new BackgroundFill[]{bgFillVert,bgFillRouge}, new BackgroundImage[] {bgImage});
			
			BorderStrokeStyle styleBleu = new BorderStrokeStyle(StrokeType.CENTERED, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10, 0, null);
			BorderStrokeStyle styleCyan = new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10, 0, null);

			BorderStroke bordureBleu = new BorderStroke(Color.ALICEBLUE.BLUE, styleBleu, CornerRadii.EMPTY, new BorderWidths(30), new Insets(20));
			BorderStroke bordureCyan = new BorderStroke(Color.ALICEBLUE.CYAN, styleCyan, new CornerRadii(15), new BorderWidths(16), new Insets(15));

			Border bordure = new Border(bordureBleu,bordureCyan);
			//root.setBackground(bg);
			//root.setBackground(bg1);
			root.setBackground(bg3);
			root.setBorder(bordure);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
