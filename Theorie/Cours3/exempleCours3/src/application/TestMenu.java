package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


/* MenuBar (sous-classe de Control)

   MenuItem (sous-classe de Object)

			Menu

			CheckMenuItem

			RadioMenuItem

			

			CustomMenuItem

				SeparatorMenuItem

	ContextMenu(sous-classe de PopupControl) 
*/


public class TestMenu extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("fenêtre avec menu");
			primaryStage.show();
			
			MenuBar barreDeMenu = new MenuBar();
			
			root.setTop(barreDeMenu);
			
			// menu Fichier avec raccourci clavier 
			Menu menuFichier = new Menu("_Fichier");
			menuFichier.setMnemonicParsing(true);   // vrai par défaut.
			
			
			MenuItem  itemMenuNouveau = new MenuItem("Nouveau");
			
			// utilisation d'un combinaison de touches du clavier 
			MenuItem  itemMenuEnregistrer = new MenuItem("_Enregistrer");
			// itemMenuEnregistrer.setMnemonicParsing(true);
			itemMenuEnregistrer.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
			
			MenuItem  itemMenuQuitter = new MenuItem("Quitter");
			
			menuFichier.getItems().addAll(itemMenuNouveau,itemMenuEnregistrer,new  SeparatorMenuItem(), itemMenuQuitter);
			 
			// Menu Outils
			Menu menuOutils = new Menu("Outils");
			
			Menu menuCouleur = new Menu("Couleur");
			MenuItem itemMenuRouge = new MenuItem("Rouge");
			MenuItem itemMenuVert = new MenuItem("Vert");
			MenuItem itemMenuBleu = new MenuItem("Bleu");
			menuCouleur.getItems().addAll(itemMenuRouge,itemMenuVert,itemMenuBleu);
			menuOutils.getItems().add(menuCouleur);
			
			barreDeMenu.getMenus().addAll(menuFichier, menuOutils);
			  
			// Enregistrements des gestionnaires d'événements
			itemMenuQuitter.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Platform.exit();
				}
				
			});
			
			itemMenuRouge.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					root.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(0)))); 
				}
				
			});
			
			itemMenuEnregistrer.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println(" Menu enregistrer"); 
				}
				
			});
			
			
			// ajout d'un menu Contextuel
			MenuItem itemContextuelQuitter= new MenuItem("Quitter");
			
			itemContextuelQuitter.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Platform.exit();
				}
				
			});
			
			
			ContextMenu menuFichierContextuel = new ContextMenu(itemContextuelQuitter);
			
			primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent e) {
					
					if (e.getButton()== MouseButton.SECONDARY || e.isControlDown()) {
						menuFichierContextuel.show(root, e.getScreenX(), e.getScreenY());		
						}
						else{
							menuFichierContextuel.hide();
						}						
			}		
				});
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
