package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class UtilisationDeListView extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 500, 200);
			root.setHgap(5);
			root.setVgap(5);
			root.setPadding(new Insets(10, 10, 10, 10));

			ColumnConstraints colonne1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
			ColumnConstraints colonne2 = new ColumnConstraints(110);
			ColumnConstraints colonne3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);

			colonne1.setHgrow(Priority.ALWAYS);
			colonne3.setHgrow(Priority.ALWAYS);

			Label lblListeSource = new Label("Liste source");
			Label lblListeDestination = new Label("Liste destination");

			final ObservableList<String> lstCouleurs = FXCollections.observableArrayList("noir", "bleu", "cyan",
					"rouge", "gris", "vert", "rose", "jaune");
			final ListView<String> listeSourceListView = new ListView<>(lstCouleurs);

			final ObservableList<String> lstVide = FXCollections.observableArrayList();
			final ListView<String> listeDestination = new ListView<>(lstVide);

			Button btnDeplacer = new Button("déplacer>>>");

			// listeSourceListView.setPrefSize(120,100);

			root.add(lblListeSource, 0, 0);
			root.add(lblListeDestination, 2, 0);
			root.add(listeSourceListView, 0, 1);
			root.add(btnDeplacer, 1, 1);
			root.add(listeDestination, 2, 1);

			/*
			 * btnDeplacer.setOnAction(new EventHandler<ActionEvent>() {
			 * 
			 * @Override public void handle(ActionEvent e) { // TODO Auto-generated method
			 * stub String couleur =
			 * listeSourceListView.getSelectionModel().getSelectedItem();
			 * 
			 * System.out.println(couleur);
			 * 
			 * //if(listeSourceListView.getSelectionModel().getSelectedItems()!=null) {
			 * //listeSourceListView.getSelectionModel().clearSelection();
			 * 
			 * listeSourceListView.getItems().remove(listeSourceListView.getSelectionModel()
			 * .getSelectedIndex());
			 * 
			 * listeDestination.getItems().add(couleur); //}
			 * 
			 * 
			 * } });
			 */

			listeSourceListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

			btnDeplacer.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					ObservableList<String> listeSelectionnee = listeSourceListView.getSelectionModel().getSelectedItems();

					
					System.out.println(listeSelectionnee);
					
				
					listeDestination.getItems().addAll(listeSelectionnee);
					listeSourceListView.getItems().removeAll(listeSelectionnee);
					listeSourceListView.getSelectionModel().clearSelection();
				}
			});

			// GridPane.setHalignment(lblListeSource, Pos.);

			root.getColumnConstraints().addAll(colonne1, colonne2, colonne3);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Les listes observables et le contrôle ListView");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
