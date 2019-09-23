package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Methode3 extends Application{
	
		Button btnRouge;
		Button btnJaune;
		Button btnBleu;
		BorderPane root;
		
		@Override
		public void start(Stage fenetre){
			try {
				 root = new BorderPane();
				Scene scene = new Scene(root,400,400);
				Font font=  Font.font("Serif", FontWeight.BOLD, 20);
				
				btnJaune= new Button("jaune");
				btnBleu= new Button("bleu");
				btnRouge= new Button("rouge");
				
				btnJaune.setFont(font);
				btnRouge.setFont(font);
				btnBleu.setFont(font);
				
				btnJaune.setMaxWidth(Double.MAX_VALUE);
				btnBleu.setMaxWidth(Double.MAX_VALUE);
				btnRouge.setMaxWidth(Double.MAX_VALUE);
				
				// Utilisation de classes anonymes 
				btnJaune.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						root.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(10), new Insets(0)))); 
					}});
				
				btnBleu.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						root.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(10), new Insets(0)))); 
					}});
				
				
				/*btnRouge.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						root.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(0)))); 
					}});*/
				
				// Utilisation d'une lambda-Expression
				btnRouge.setOnAction(e->root.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(0))))); 
					
				GridPane grPane = new GridPane();
				GridPane.setHgrow(btnJaune, Priority.ALWAYS);
				GridPane.setHgrow(btnRouge, Priority.ALWAYS);
				GridPane.setHgrow(btnBleu, Priority.ALWAYS);
				
				grPane.add(btnJaune,0,0);
				grPane.add(btnRouge,1,0);
				grPane.add(btnBleu,2,0);
				grPane.setHgap(10);
				root.setBottom(grPane);
				fenetre.setTitle(" Gestion des boutons");
				fenetre.setScene(scene);
				fenetre.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}

}
