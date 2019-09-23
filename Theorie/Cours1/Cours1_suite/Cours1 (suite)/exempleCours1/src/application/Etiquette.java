package application;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Etiquette extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			FlowPane root = new FlowPane(Orientation.VERTICAL);
			
			// Par défaut les noeuds sont alignés de gauche à droite. 
			//flPane.setAlignment(Pos.TOP_CENTER);
			
			root.setPadding(new Insets(10,5,10,5));
			root.setVgap(20);
			root.setHgap(20);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Le composant Label");
			
			Font font = new Font("Arial", 20);
			Insets inset = new Insets(5);
			Label l1 = new Label ("étiquette avec texte et bordure");
			l1.setFont(font);
			l1.setTextFill(Color.BLUE);
			
			// ajouter une bordure
			l1.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			
			Image image = new Image(getClass().getResourceAsStream("java.GIF"));
	
			
			//Label l2 = new Label(" Etiquette avec une image et texte à droite", new ImageView(image));
			// autre façon
			
			Label l2 = new Label("texte à droite");
			l2.setGraphic(new ImageView(image));
			l2.setFont(font);
			l2.setTextFill(Color.BLUE);
			
					
			//espace entre texte et image. 
			l2.setGraphicTextGap(10);
			
			Label l3 = new Label("texte en dessous");
			l3.setGraphic(new ImageView(image));
			l3.setFont(font);
			l3.setTextFill(Color.BLUE);
			l3.setGraphicTextGap(10);
			l3.setContentDisplay(ContentDisplay.TOP);
             //essayer d'autres dipositions
			
			Label l4 = new Label("étiquette qui subit une transformation (rotation)");
			
			l4.setFont(font);
			l4.setTextFill(Color.BLUE);
			l4.setGraphicTextGap(10);
		    l4.setRotate(270);
			
			// ajout des composants 
			root.getChildren().addAll(l1,l2,l3,l4);
	
			FlowPane.setMargin(l1,  inset);
			FlowPane.setMargin(l2,  inset);
			FlowPane.setMargin(l3,  inset);
			FlowPane.setMargin(l4,  inset);
			
			// pour avoir une fenêtre ajustée aux composants
			primaryStage.sizeToScene();
			
			//interdire le redimensionement. 
	       //primaryStage.setResizable(false);
			primaryStage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
