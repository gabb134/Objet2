package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.stage.Stage;

public class Methode2 extends Application  {
	Button btnRouge;
	Button btnJaune;
	Button btnBleu;
	BorderPane root;
	
	Color couleur;
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
			
			GestionBouton gb = new GestionBouton();
		
			btnJaune.setOnAction(gb);
			btnBleu.setOnAction(gb);
			btnRouge.addEventHandler(ActionEvent.ACTION, gb);
			
			
			
			
		
			
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
private class GestionBouton implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent e) {
		Color couleur; 
		// TODO Auto-generated method stub
		if (e.getSource()== btnRouge){
			 couleur = Color.RED;}
		
			else {if (e.getSource()== btnJaune){ couleur = Color.YELLOW;}
			    else
				couleur = Color.BLUE;}
		
		root.setBackground(new Background(new BackgroundFill(couleur, new CornerRadii(10), new Insets(0)))); 
		
	}
}
}