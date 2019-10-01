package application;

import java.util.ArrayList;

import com.sun.javafx.geom.AreaOp.IntOp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InterfaceMotCroises extends Application {
	// Variables de classe
	private BorderPane root;
	private BorderPane bpaneCentre;
	// BorderPane bpaneDroite;
	private GridPane gpane;
	private MenuItem itemReglesDuJeu;
	private MenuItem itemThemeSport;
	private MenuItem itemThemeBible;
	private MenuItem itemThemeTech;
	private MenuItem itemQuitter;
	private Text txtNomTheme;
	private VBox vboxDroite;
	private VBox vboxGauche;
	private GridPane gpaneCase;
	HBox hboxtxtTheme;
	Text textBinevenue;
	HBox hboxTextBienvenue;
	HBox hboxTextIndice;
	TextField txtReponse;
	private int[][] tabNombres;
	private ArrayList<Mot> arrMots;

	Button btnLettres;
	Button btnSolution;
	Button btnOk;
	Button btnAide;
	Case c1;
	Case caseCreer;
	int intCoorX = 0;
	int intCoorY = 0;
	Case[][] tabCase;
	Case caseParcours;
	ArrayList<Case> arrCase = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			Scene scene = new Scene(root, 1000, 800);
			// CONSTRUCTION DE L'INTERFACE
			bpaneCentre = new BorderPane(); // Pour la partie du milieu
			// La partie a droite du root(vbox)
			// Pour le vbox a droite
			vboxDroite = new VBox(); // Pour la partie de droite
			vboxGauche = new VBox();
			// Text textBinevenue = new Text("Bienvenue! Pour jouer, cliquez sur un \nnum�ro
			// dans la grille, �crivez le mot et\ncliquer sur OK ou apuyyez sur la \ntouche
			// Entr�e (Entrer) pour continuer");
			textBinevenue = new Text(
					"Bienvenue! Pour jouer, cliquez sur un num�ro dans la grille, �crivez le mot et cliquer sur OK ou apuyyez sur la touche Entr�e (Entrer) pour continuer");
			Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);

			hboxTextBienvenue = new HBox();
			hboxTextBienvenue.setPrefWidth(150);
			hboxTextBienvenue.setMaxSize(60, 30);
			textBinevenue.setFont(font);
			textBinevenue.setTextAlignment(TextAlignment.CENTER);
			textBinevenue.setWrappingWidth(350);
			vboxDroite.setMargin(hboxTextBienvenue, new Insets(15));

			txtNomTheme = new Text("Mots crois�s par Gabriel Marrero");
			hboxtxtTheme = new HBox();
			hboxtxtTheme.getChildren().add(txtNomTheme);
			hboxtxtTheme.setAlignment(Pos.CENTER);
			vboxGauche.getChildren().add(hboxtxtTheme);

			Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
			txtNomTheme.setFont(font3);
			// bpaneCentre.setAlignment(txtNomTheme, Pos.CENTER);
			// bpaneCentre.setTop(txtNomTheme);

			// Pour le gridpane de a droite(Dans le vbox)
			gpane = new GridPane(); // Pour la partie de droite en bas
			gpane.setPadding(new Insets(5));
			// gpane.setGridLinesVisible(true);
			gpane.setAlignment(Pos.CENTER);
			gpane.setVgap(7);
			gpane.setHgap(7);
			BorderStroke bordureBleu = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
					new BorderWidths(5), new Insets(0));
			Border bordure = new Border(bordureBleu);
			gpane.setBorder(bordure);
			vboxDroite.setMargin(gpane, new Insets(60));
			// bpaneCentre.setMargin(gpane, new Insets(125));
			gpane.setMaxSize(250, 70);
			vboxDroite.setMaxWidth(Double.MAX_VALUE);
			// gpane.setMargin(child, value);
			vboxDroite.setAlignment(Pos.CENTER_RIGHT);

			HBox hboxIcone = new HBox();
			btnLettres = new Button("LETTRES");
			btnSolution = new Button("SOLUTION");
			btnOk = new Button("OK");
			btnAide = new Button("AIDE");
			txtReponse = new TextField();
			Text txtVotreScore = new Text("VOTRE SCORE");
			Text txtMaximum = new Text("MAXIMUM");
			VBox vboxMax = new VBox(7);
			VBox vboxVotreScore = new VBox(7);
			HBox hboxMax = new HBox(5);
			HBox hboxVotreScore = new HBox(5);
			TextField txtFieldvotreSocre = new TextField("0");
			TextField txtFieldmaximum = new TextField("125");

			BorderStroke bordureNoir = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5),
					new BorderWidths(2), new Insets(0));
			Border borduregGpane = new Border(bordureNoir);
			Background couleurFill = new Background(
					new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(5), new Insets(0)));
			Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
			Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 10);

			btnLettres.setFont(font);
			btnLettres.setMaxSize(150, 20);
			btnSolution.setFont(font);
			btnSolution.setMaxSize(150, 20);
			btnOk.setFont(font);
			btnAide.setFont(font);
			txtVotreScore.setFont(font2);
			txtMaximum.setFont(font2);

			txtReponse.setBorder(borduregGpane);
			// txtReponse.setMaxHeight(500);
			// txtReponse.setPrefSize(10, 2);
			txtReponse.setMaxSize(220, -10);
			txtReponse.setEditable(false);
			btnLettres.setBorder(borduregGpane);
			btnSolution.setBorder(borduregGpane);
			btnOk.setBorder(borduregGpane);
			btnAide.setBorder(borduregGpane);

			vboxVotreScore.setBackground(couleurFill);
			vboxVotreScore.setPadding(new Insets(5));
			vboxVotreScore.setPrefWidth(10);
			vboxVotreScore.setSpacing(2);
			hboxVotreScore.getChildren().add(txtVotreScore);
			hboxVotreScore.setAlignment(Pos.CENTER);
			vboxVotreScore.getChildren().addAll(hboxVotreScore, txtFieldvotreSocre);
			txtVotreScore.setTextAlignment(TextAlignment.CENTER);
			txtFieldvotreSocre.setFont(font1);
			txtFieldvotreSocre.setAlignment(Pos.CENTER);
			txtFieldvotreSocre.setEditable(false);

			vboxMax.setBackground(couleurFill);
			vboxMax.setPadding(new Insets(5));
			vboxMax.setPrefWidth(10);
			vboxMax.setSpacing(2);
			hboxMax.getChildren().add(txtMaximum);
			hboxMax.setAlignment(Pos.CENTER);
			txtMaximum.setTextAlignment(TextAlignment.CENTER);
			vboxMax.getChildren().addAll(hboxMax, txtFieldmaximum);

			txtFieldmaximum.setFont(font1);
			txtFieldmaximum.setAlignment(Pos.CENTER);
			txtFieldmaximum.setEditable(false);
			// txtReponse.setPrefHeight(10);

			gpane.add(txtReponse, 0, 0, 2, 1);
			gpane.add(btnLettres, 0, 1);
			gpane.add(btnSolution, 1, 1);
			gpane.add(btnOk, 0, 2, 2, 1);
			GridPane.setHalignment(btnOk, HPos.CENTER);
			gpane.add(vboxVotreScore, 0, 3);
			gpane.add(vboxMax, 1, 3);
			GridPane.setHalignment(vboxVotreScore, HPos.CENTER);
			GridPane.setHalignment(vboxMax, HPos.CENTER);
			gpane.add(btnAide, 0, 4, 2, 1);
			GridPane.setHalignment(btnAide, HPos.CENTER);

			root.setCenter(vboxGauche);
			root.setRight(vboxDroite);
			vboxDroite.setSpacing(200);
			hboxTextBienvenue.getChildren().add(textBinevenue);
			// hboxTextIndice = new HBox(5);
			vboxDroite.getChildren().addAll(hboxTextBienvenue, gpane);

			// BARRE DE MENU
			Menu menuThemes = new Menu("_Th�mes");
			Menu menuAide = new Menu("Aide");
			menuThemes.setMnemonicParsing(true);

			itemThemeSport = new MenuItem("Le sport");
			itemThemeBible = new MenuItem("La Bible");
			itemThemeTech = new MenuItem("La technologie");
			itemReglesDuJeu = new MenuItem("R�lges du jeu");
			itemQuitter = new MenuItem("Quitter");

			itemReglesDuJeu.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
			itemQuitter.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

			MenuBar barreDeMenu = new MenuBar();
			root.setTop(barreDeMenu);

			menuThemes.getItems().addAll(itemThemeBible, itemThemeTech, itemThemeSport);
			menuAide.getItems().addAll(itemReglesDuJeu, new SeparatorMenuItem(), itemQuitter);

			barreDeMenu.getMenus().addAll(menuThemes, menuAide);

			// LA GESTION DES EVENEMENTS DU MENU
			itemReglesDuJeu.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

					AfficherMenuRegle();
				}
			});
			itemQuitter.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Platform.exit();

				}
			});

			itemThemeBible.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// vboxGauche = new VBox();
					txtNomTheme = new Text("La Bible");
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
					txtNomTheme.setFont(font);
					// vboxGauche.setAlignment(txtNomTheme, Pos.CENTER);
					// bpaneCentre.setTop(txtNomTheme);

					vboxGauche.getChildren().clear();
					hboxtxtTheme.getChildren().clear();
					hboxtxtTheme.getChildren().add(txtNomTheme);
					hboxtxtTheme.setAlignment(Pos.CENTER);
					vboxGauche.getChildren().add(hboxtxtTheme);

					LectureDonnees lBible = new LectureDonnees("grilleBible.txt", "donneesBible.txt");

					GestionGrille(lBible);

				}
			});
			itemThemeTech.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					txtNomTheme = new Text("La technologie");
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
					txtNomTheme.setFont(font);
					// bpaneCentre.setAlignment(txtNomTheme, Pos.CENTER);
					// bpaneCentre.setTop(txtNomTheme);

					vboxGauche.getChildren().clear();
					hboxtxtTheme.getChildren().clear();
					hboxtxtTheme.getChildren().add(txtNomTheme);
					hboxtxtTheme.setAlignment(Pos.CENTER);
					vboxGauche.getChildren().add(hboxtxtTheme);
					LectureDonnees lTech = new LectureDonnees("grilleTechnologie.txt", "donneesTechnologie.txt");
					GestionGrille(lTech);

				}
			});
			itemThemeSport.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

					txtNomTheme = new Text("Le sport");
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
					txtNomTheme.setFont(font);
					// bpaneCentre.setAlignment(txtNomTheme, Pos.CENTER);
					// bpaneCentre.setTop(txtNomTheme);

					vboxGauche.getChildren().clear();
					hboxtxtTheme.getChildren().clear();
					hboxtxtTheme.getChildren().add(txtNomTheme);
					hboxtxtTheme.setAlignment(Pos.CENTER);
					vboxGauche.getChildren().add(hboxtxtTheme);

					LectureDonnees lSport = new LectureDonnees("grilleSport.txt", "donneesSport.txt");

					GestionGrille(lSport);

				}
			});
			btnAide.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

					AfficherMenuRegle();
				}

			});

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Mots crois�s");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GestionGrille(LectureDonnees l) {

		// POUR LA GRILLE LES CASES ET LES CERCLES DES NUMEROS
		gpaneCase = new GridPane();
		// root.setLeft(vboxGauche);
		gpaneCase.setPadding(new Insets(10));
		// gpaneCase.setGridLinesVisible(true);
		gpaneCase.setAlignment(Pos.CENTER);
		gpaneCase.setVgap(2);
		gpaneCase.setHgap(2);
		// root.setMargin(gpaneCase, new Insets(30));
		vboxGauche.getChildren().addAll(gpaneCase);
		hboxTextBienvenue.getChildren().clear();
		hboxTextBienvenue.getChildren().addAll(textBinevenue);

		// ((Text)hboxTextBienvenue.getChildren().get(0)).setText(value);
		btnOk.setDisable(true);

		tabNombres = l.getTabNombres();
		arrMots = l.getArrMots();
		tabCase = l.getTabCase();
		/*
		 * for(Mot m:arrMots) { //System.out.println(m); }
		 */

		for (int i = 0; i < tabNombres.length; i++) {

			for (int j = 0; j < tabNombres[i].length; j++) {

				int intNombre = tabNombres[i][j];

				int intNombreCercleGrille = 0;
				if (intNombre != -1 && intNombre != 0) {
					intNombreCercleGrille = intNombre;
				}
				caseCreer = new Case(intNombre, i, j, intNombreCercleGrille); // objet qui envoie le nombre , les
																				// lignes et le colonne a la classe
				tabCase[i][j] = caseCreer; // tableau de case pour parcourir *CL� pour faire le projet // case

				gpaneCase.add(caseCreer, j, i);

				arrCase.add(caseCreer);

			}
			System.out.println();
		}

		// System.out.println(arrMots.get(2));
		for (Case c : arrCase) {
			int intNombre = c.getIntNombreCercleGrille();
			if (intNombre != -1 && intNombre != 0) {

				System.out.println(intNombre);
				c.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					// int intNombre = c.getIntNombreCercleGrille();

					Mot motCourant = arrMots.get(intNombre - 1);
					String strMot = motCourant.getStrMot();
					String strIndice = motCourant.getStrIndice();

					Text txtIndice = new Text(strIndice);
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);

					@Override
					public void handle(MouseEvent e) {
						// TODO Auto-generated method stub
						// System.out.println("gestionnaire d'evenements enregistr� avec
						// addEventHandler\n"+"Nombre s�l�ctionn� :"+intNombre+"\n");

						txtIndice.setFont(font);
						txtIndice.setTextAlignment(TextAlignment.CENTER);
						txtIndice.setWrappingWidth(350);
						btnOk.setDisable(false);
						// System.out.println("Mot : " + strMot);
						hboxTextBienvenue.getChildren().clear();
						hboxTextBienvenue.getChildren().addAll(txtIndice);
						// HBox c = (HBox) e.getSource();
						caseParcours = (Case) e.getSource();

						// (Case) c = e.getSource();
						for (Node n : gpaneCase.getChildren()) {
							if (GridPane.getRowIndex(n) == c.getIntLigne()) {
								// System.out.println(c.getIntLigne());
								intCoorX = c.getIntLigne();
								// c1.getTxtCase().setText("a");

							}
							if (GridPane.getColumnIndex(n) == c.getIntColonne()) {
								intCoorY = c.getIntColonne();

							}

						}
						System.out.println("Coordonn�es x:" + intCoorX + "\nCoordonn�es y:" + intCoorY);

						if (motCourant.getOrientation() == EnumOrientation.HORIZONTALE) {

							// intCoorY += 1;
							caseParcours.requestFocus();

						}
						if (motCourant.getOrientation() == EnumOrientation.VERTICAL) {

							// intCoorX += 1;
							caseParcours.requestFocus();

						}

					}

				});
				c.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent e) {
						// TODO Auto-generated method stub
						// caseCreer.setTxtCase(new Text(""+e.getCode()));;
						// caseCreer.getTxtCase().setText(""+e.getText());
						Mot motCourant = arrMots.get(intNombre - 1);
						if (!e.getCode().isLetterKey()) {

						} else {
						

							if (motCourant.getOrientation() == EnumOrientation.HORIZONTALE) {

								intCoorY += 1;
								caseParcours.requestFocus();

							}
							if (motCourant.getOrientation() == EnumOrientation.VERTICAL) {

								intCoorX += 1;
								caseParcours.requestFocus();

							}
							System.out.println(e.getCode());
							for (Case caseEcrire : arrCase) {
								if (caseEcrire.getIntLigne() == intCoorX && caseEcrire.getIntColonne() == intCoorY) {

									caseEcrire.getTxtCase().setText("" + e.getCode());
									System.out.println(
											"Coordonn�es x apres:" + intCoorX + "\nCoordonn�es y apres:" + intCoorY);
								}
							}

						}

						if (e.getCode() == KeyCode.BACK_SPACE) {
							if (motCourant.getOrientation() == EnumOrientation.HORIZONTALE) {

								intCoorY -= 1;
								caseParcours.requestFocus();

							}
							if (motCourant.getOrientation() == EnumOrientation.VERTICAL) {

								intCoorX -= 1;
								caseParcours.requestFocus();

							}
							System.out.println(e.getCode());
							for (Case caseEcrire : arrCase) {
								if (caseEcrire.getIntLigne() == intCoorX && caseEcrire.getIntColonne() == intCoorY) {

									caseEcrire.getTxtCase().setText("");
									System.out.println("Coordonn�es x apres:" + intCoorX + "\nCoordonn�es y apres:" + intCoorY);
								}
							}
						}

					}
				});

			}
		}

		btnLettres.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				// System.out.println(strmo);
				/*Mot motCourant1;
				String strMot1 = "";
				String strIndice1;
				for (Case caseLettre : arrCase) {
					int intNombre = caseLettre.getIntNombreCercleGrille();
					if (intNombre != -1 && intNombre != 0) {
						motCourant1 = arrMots.get(intNombre - 1);
						strMot1 = motCourant1.getStrMot();
						strIndice1 = motCourant1.getStrIndice();
						System.out.println(strMot1);
					}
				}*/

			}

		});
		btnSolution.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void AfficherMenuRegle() {
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		String text = "R�gles du jeu";
		alertInfo.setTitle("R�gles du jeu");
		alertInfo.setHeaderText(text.toString().toUpperCase());
		alertInfo.setContentText(
				" * Quand vous cliquez sur un num�ro, vous obtenez l�indice (texte descriptif) du mot recherch�.  Vous pouvez avoir la solution, pour le mot en cours, en cliquant sur le bouton correspondant.\n\n * Le bouton Lettres vous fournit, en d�sordre, toutes les lettres du mot recherch�. Pour r�pondre, vous �crivez le mot dans la grille correspondante et vous validez � l�aide du bouton OK ou la touche Entr�e du clavier.\n\n * Dans le cas d�une mauvaise r�ponse, la solution vous est donn�e. Le bouton Ok est sans effet si la grille du mot courant n�est pas compl�te. Vous pouvez supprimer les caract�res entr�s � l�aide de la touche retour arri�re (<-) de votre clavier.\n\n * Noter que les caract�res des mots valid�s ne peuvent �tre effac�s. Si vous essayez un autre mot avant d�avoir valid� le mot courant, ce dernier est remis � son �tat initial (toutes les lettres entr�es sont effac�es) et le nouveau mot devient le mot courant.  \n\n* Si vous demandez les lettres et d�cidez de r�pondre plus tard, le programme doit se souvenir que vous avez d�j� vu les lettres pour vous attribuer, le cas �ch�ant, les points en cons�quence. Notez que le programme vous redonnera la m�me s�quence de lettres lors des prochains essais.");
		alertInfo.showAndWait();
	}

	public GridPane getgpaneCase() {
		return gpaneCase;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
