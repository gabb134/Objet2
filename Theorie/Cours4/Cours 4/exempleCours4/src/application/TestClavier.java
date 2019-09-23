package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class TestClavier extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Text text = new Text();
			Scene scene = new Scene(root,400,400);
			root.setCenter(text);

			primaryStage.setScene(scene);
			primaryStage.show();

			EventHandler<KeyEvent> gestionClavier = new EventHandler<KeyEvent>(){
				KeyCombination combinaison =new KeyCodeCombination(KeyCode.A, KeyCodeCombination.CONTROL_DOWN );
				@Override
				public void handle(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getEventType()== KeyEvent.KEY_PRESSED){

						text.setText("touche enfoncée: " + e.getCode());

					}
					if (e.getEventType()== KeyEvent.KEY_RELEASED){

						text.setText("touche relâchée: " + e.getCode());
						
				}
	           if (e.getEventType()== KeyEvent.KEY_TYPED){
					
					text.setText("caractère tapé: " + e.getCharacter());
					
			}
	           if (combinaison.match(e)){
	        	   text.setText(" les touches Ctrl et A sont utilisées");
	           }
			}
			};
		
			scene.setOnKeyPressed(gestionClavier);
			scene.setOnKeyReleased(gestionClavier);
			scene.setOnKeyTyped(gestionClavier);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
