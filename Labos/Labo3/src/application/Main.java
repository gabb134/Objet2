package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	MenuItem itemCopier;
	MenuItem itemColler;
	MenuItem itemCouper;
	String textCopier;
	TextArea txtArea;
	BorderPane root;
	RadioMenuItem itemMenuNoir;
	RadioMenuItem itemMenuRouge;
	RadioMenuItem itemMenuVert;
	RadioMenuItem itemMenuBleu;

	CheckMenuItem itemMenuGras;
	CheckMenuItem itemMenuItalique;

	RadioMenuItem itemMenuArial;
	RadioMenuItem itemMenuSerif;
	RadioMenuItem itemMenuSansSerif;

	@Override
	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);

			txtArea = new TextArea();

			String couleurs[] = { "noir", "rouge", "vert", "bleu" };
			Color valeursCouleurs[] = { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE };
			RadioMenuItem optionsCouleursTexte[] = new RadioMenuItem[valeursCouleurs.length];
			String nomsStyle[] = { "Gras", "Italique" };
			CheckMenuItem optionStyle[] = new CheckMenuItem[nomsStyle.length];

			MenuBar barreDeMenu = new MenuBar();

			root.setTop(barreDeMenu);
			root.setCenter(txtArea);
			// menu Fichier avec raccourci clavier
			Menu menuFichier = new Menu("_Fichier");
			menuFichier.setMnemonicParsing(true); // vrai par d�faut.

			MenuItem itemMenuAPropos = new MenuItem("� propos de ...");

			// MenuItem.setMnemonicParsing(true);
			itemMenuAPropos.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

			MenuItem itemMenuQuitter = new MenuItem("Quitter");
			itemMenuQuitter.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
			menuFichier.getItems().addAll(itemMenuAPropos, new SeparatorMenuItem(), itemMenuQuitter);

			// Menu Edition
			Menu menuEdition = new Menu("Edition");

			Menu menuCouleurBordure = new Menu("Couleur de la bordure");
			Menu menuPolice = new Menu("Police");

			Menu menuFormat = new Menu("_Format");
			itemMenuNoir = new RadioMenuItem("Noir");
			itemMenuRouge = new RadioMenuItem("Rouge");
			itemMenuVert = new RadioMenuItem("Vert");
			itemMenuBleu = new RadioMenuItem("Bleu");

			itemMenuArial = new RadioMenuItem("Arial");
			itemMenuSerif = new RadioMenuItem("Serif");
			itemMenuSansSerif = new RadioMenuItem("SansSerif");
			itemMenuGras = new CheckMenuItem("Gras");
			itemMenuItalique = new CheckMenuItem("Italique");

			ToggleGroup tgFormat = new ToggleGroup();
			ToggleGroup tgCouleurs = new ToggleGroup();

			itemMenuArial.setToggleGroup(tgFormat);
			itemMenuSerif.setToggleGroup(tgFormat);
			itemMenuSansSerif.setToggleGroup(tgFormat);

			itemMenuNoir.setToggleGroup(tgCouleurs);
			itemMenuRouge.setToggleGroup(tgCouleurs);
			itemMenuVert.setToggleGroup(tgCouleurs);
			itemMenuBleu.setToggleGroup(tgCouleurs);

			itemCopier = new MenuItem("Copier");
			itemColler = new MenuItem("Coller");
			itemCouper = new MenuItem("Couper");

			menuCouleurBordure.getItems().addAll(itemMenuNoir, itemMenuRouge, itemMenuVert, itemMenuBleu);
			menuPolice.getItems().addAll(itemMenuArial, itemMenuSerif, itemMenuSansSerif, new SeparatorMenuItem(),
					itemMenuGras, itemMenuItalique);
			menuEdition.getItems().addAll(itemCopier, itemColler, itemCouper);
			menuFormat.getItems().addAll(menuCouleurBordure, menuPolice);

			barreDeMenu.getMenus().addAll(menuFichier, menuEdition, menuFormat);

			itemMenuQuitter.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Platform.exit();
				}
			});
			itemMenuAPropos.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Alert alertInfo = new Alert(AlertType.INFORMATION);

					alertInfo.setTitle("Message");
					alertInfo.setHeaderText(null);
					alertInfo.setContentText("Ceci est un exemple d'utilisation des menus");
					alertInfo.showAndWait();
				}

			});

			GestionEdition gEdition = new GestionEdition();
			GestionStyle gStyle = new GestionStyle();
			GestionFormat gFormat = new GestionFormat();

			itemCopier.setOnAction(gEdition);
			itemColler.setOnAction(gEdition);
			itemCouper.setOnAction(gEdition);

			itemMenuGras.setOnAction(gStyle);
			itemMenuItalique.setOnAction(gStyle);

			itemMenuBleu.setOnAction(gFormat);
			itemMenuNoir.setOnAction(gFormat);
			itemMenuRouge.setOnAction(gFormat);
			itemMenuVert.setOnAction(gFormat);

			itemMenuArial.setOnAction(gFormat);
			itemMenuSerif.setOnAction(gFormat);
			itemMenuSansSerif.setOnAction(gFormat);

			primaryStage.setTitle("Utilisation des menus");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class GestionEdition implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

			if (event.getSource() == itemCopier) {
				// System.out.println("copier");
				txtArea.copy();
			} else if (event.getSource() == itemColler) {
				txtArea.paste();
				// System.out.println("Coller");
			} else if (event.getSource() == itemCouper) {
				txtArea.cut();
				// System.out.println("Couper");
			}

			// System.out.println("text copié : " + txtArea.paste());
		}

	}

	private class GestionStyle implements EventHandler<ActionEvent> {
		FontWeight styleGras;
		FontPosture styleItalique;

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			CheckMenuItem source = (CheckMenuItem) event.getSource();

			if (source == itemMenuGras) {
				if (itemMenuGras.isSelected() == true) {

					styleGras = FontWeight.BOLD;

				} else {
					styleGras = FontWeight.NORMAL;

				}
			} else if (source == itemMenuItalique) {
				if (itemMenuItalique.isSelected() == true) {
					styleItalique = FontPosture.ITALIC;

				} else {
					styleItalique = FontPosture.REGULAR;

				}
			}

			Font font = Font.font(txtArea.getFont().getFamily(), styleGras, styleItalique, 15);
			txtArea.setFont(font);

		}
	}

	private class GestionFormat implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String strFamily = "";
			Color couleur = null;
			
			if(event.getSource()==itemMenuSerif) {
				strFamily = "Serif";
			}
			else if(event.getSource()==itemMenuSansSerif) {
				strFamily = "SansSerif";
			}
			else if(event.getSource()==itemMenuArial) {
				strFamily = "Arial";
			}
			
			if(event.getSource()==itemMenuNoir) {
				couleur = couleur.BLACK;
			}
			else if(event.getSource()==itemMenuVert) {
				couleur = couleur.GREEN;
			}
			else if(event.getSource()==itemMenuBleu) {
				couleur = couleur.BLUE;
			}
			else if(event.getSource()==itemMenuRouge) {
				couleur = couleur.RED;
			}
			
			
			
			
			
			Font fontFamily = Font.font(strFamily);
			txtArea.setFont(fontFamily);
			
			BorderStroke bordureBleu = new BorderStroke(couleur, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10), new Insets(0));
			Border bordure = new Border(bordureBleu);
			txtArea.setBorder(bordure);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
