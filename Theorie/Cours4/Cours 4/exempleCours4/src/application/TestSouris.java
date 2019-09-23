package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestSouris extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Circle cercle = new Circle(80);
		cercle.setFill(Color.CYAN);
		Scene scene = new Scene(root,400,400);
		root.setCenter(cercle);
		primaryStage.setTitle("Les événements de la souris");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		EventHandler<MouseEvent>  gestionSouris =  new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				if (e.getEventType()== MouseEvent.MOUSE_CLICKED){
				    //System.out.println(e.getSource().getClass().getSimpleName());
					System.out.println("Clic de souris");}
					
				if (e.getEventType()== MouseEvent.MOUSE_PRESSED){
					System.out.println("Souris enfoncée");
				}
					if (e.getEventType()== MouseEvent.MOUSE_RELEASED){
						System.out.println("Souris relâchée");
					}
					
					if (e.getButton()== MouseButton.SECONDARY) {
						System.out.println("Clic droit");
					}
					
					if (e.getEventType()== MouseEvent.MOUSE_DRAGGED ){
						System.out.println("MouseDragged: " + e.getX()+ "," +e.getY());
					}
					
				}		
				
		};
		cercle.addEventHandler(MouseEvent.MOUSE_CLICKED,gestionSouris);
		cercle.addEventHandler(MouseEvent.MOUSE_DRAGGED, gestionSouris);
		cercle.addEventHandler(MouseEvent.MOUSE_PRESSED,gestionSouris);
		cercle.addEventHandler(MouseEvent.MOUSE_RELEASED,gestionSouris);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
