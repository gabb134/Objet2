package application;

import java.text.DecimalFormat;
import java.time.LocalTime;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Horloge extends Application implements Runnable{

	private Label lblHorloge;
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		try {
			BorderPane root = new BorderPane();
			root.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(0), new Insets(0))));
			root.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(5))));
			Scene scene = new Scene(root,350,120);
			
			 lblHorloge = new Label("00:00:00");
			lblHorloge.setTextFill(Color.RED);
			lblHorloge.setFont(Font.font ("Arial", FontWeight.BOLD,80));
			
			root.setCenter(lblHorloge);
			
			//Fil d'execution courrant
			 System.out.println("Fil courant : " + Thread.currentThread());
			
			 
			 new Thread(this).start();
			 
			 
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.sizeToScene();
			primaryStage.setTitle("Exercice 1");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("Fil courant dans la methode run : " + Thread.currentThread());
			
		 while(true) {
			 try {
	
				 LocalTime tempsActuel = LocalTime.now();
				int intHeure = tempsActuel.getHour();
				int intMinute = tempsActuel.getMinute();
				int intSeconde = tempsActuel.getSecond();
				Thread.sleep(1000);
				
				Platform.runLater(()->{lblHorloge.setText(String.format("%02d:%02d:%02d", intHeure, intMinute, intSeconde)); System.out.println(Thread.currentThread());});
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
			 
		 }
		 
	}

}
