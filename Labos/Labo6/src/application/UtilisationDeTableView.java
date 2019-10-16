package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UtilisationDeTableView extends Application {

	private final TableView<Etudiant> table = new TableView<Etudiant>();
	private final ObservableList<Etudiant> donnees = FXCollections.observableArrayList(new Etudiant(1, "Gabriel", "Marrero1", 80.5),new Etudiant(2, "Mohamed", "Guelleh2", 87.9),new Etudiant(3, "cedric", "Kouma3", 94.3),new Etudiant(4, "Steven", "Garnier4", 78.9));
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group root = new Group();

		Scene scene = new Scene(root);
		VBox vbox = new VBox();
		Font font = Font.font("Arial", FontWeight.NORMAL, 20);
		Text txt = new Text("Exemple d'utilisation d'une table");
		TextField txtFieldNumDa = new TextField();
		TextField txtFieldNom = new TextField();
		TextField txtFieldPrenom = new TextField();
		TextField txtFieldMoyenne = new TextField();
		
		Button btnAjouter = new Button("Ajouter");
		HBox hbox = new HBox(5);
		
		

		
		TableColumn<Etudiant, Integer> colonneNumDA = new TableColumn<Etudiant,Integer>("Numéro de DA");
		TableColumn<Etudiant, String> colonnePrenom = new TableColumn<Etudiant,String>("Prenom");
		TableColumn<Etudiant, String> colonneNom = new TableColumn<Etudiant,String>("Nom");
		TableColumn<Etudiant, Double> colonneMoyenne = new TableColumn<Etudiant,Double>("Moyenne");
		
	
		
		vbox.setSpacing(5);
	
		txt.setFont(font);
		
		txtFieldNumDa.setPromptText("Numéro de DA");
		txtFieldNom.setPromptText("Nom");
		txtFieldPrenom.setPromptText("prénom");
		txtFieldMoyenne.setPromptText("Moyenne");
		
		
		HBox.setHgrow(txtFieldNumDa, Priority.ALWAYS);
		HBox.setHgrow(txtFieldNom, Priority.ALWAYS);
		HBox.setHgrow(txtFieldPrenom, Priority.ALWAYS);
		HBox.setHgrow(txtFieldMoyenne, Priority.ALWAYS);
		
		txtFieldNumDa.setPrefWidth(80);
		txtFieldNom.setPrefWidth(80);
		txtFieldPrenom.setPrefWidth(80);
		txtFieldMoyenne.setPrefWidth(80);
		
		colonneNumDA.setPrefWidth(120);
		colonnePrenom.setPrefWidth(120);
		colonneNom.setPrefWidth(120);
		colonneMoyenne.setPrefWidth(120);
		
		colonneNumDA.setMaxWidth(Double.MAX_VALUE);
		colonnePrenom.setMaxWidth(Double.MAX_VALUE);
		colonneNom.setMaxWidth(Double.MAX_VALUE);
		colonneMoyenne.setMaxWidth(Double.MAX_VALUE);
		
		
		colonneNumDA.setCellValueFactory(new PropertyValueFactory<>("numDA"));
		colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colonneNom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		colonneMoyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
		
		
		table.setItems(donnees);
		
		
		table.getColumns().addAll(colonneNumDA,colonneNom,colonnePrenom,colonneMoyenne);
		
		hbox.getChildren().addAll(txtFieldNumDa,txtFieldNom,txtFieldPrenom,txtFieldMoyenne,btnAjouter);
		vbox.getChildren().addAll(txt,table,hbox);
		root.getChildren().addAll(vbox);
		
		
		btnAjouter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//System.out.println(txtFieldNumDa.getText());
				
				if(!txtFieldNumDa.getText().isEmpty() && !txtFieldNom.getText().isEmpty()&&!txtFieldPrenom.getText().isEmpty()&&!txtFieldMoyenne.getText().isEmpty() ) {
					donnees.add(new Etudiant(Integer.parseInt(txtFieldNumDa.getText().trim()), txtFieldNom.getText(), txtFieldPrenom.getText(), Double.parseDouble(txtFieldMoyenne.getText().trim())));
					txtFieldNumDa.clear();
					txtFieldNom.clear();
					txtFieldPrenom.clear();
					txtFieldMoyenne.clear();
				}
				
				
			}
		});
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("les listes observables et le contrôle TableView");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
