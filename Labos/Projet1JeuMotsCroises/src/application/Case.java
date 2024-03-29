package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Case extends HBox{/*Classe qui permet de construire mes cases */

	/* Mettre les Commentaires  */
	//GridPane gpane;
	private int intNb1;
	private HBox hboxCase;
	//private HBox hboxCercle;
	private int intLigne;
	private Boolean booValider;
	
	public HBox getHboxCase() {
		return hboxCase;
	}

	private Text txtCase ;

	public Text getTxtCase() {
		return txtCase;
	}
	public void setTxtCase(Text txtCase) {
		this.txtCase = txtCase;
	}

	private int intColonne;
	public int getIntLigne() {
		return intLigne;
	}
	public int getIntColonne() {
		return intColonne;
	}

	public void setIntLigne(int intLigne) {
		this.intLigne = intLigne;
	}
	public void setIntColonne(int intColonne) {
		this.intColonne = intColonne;
	}

	private int intNombreCercleGrille;

	public Case (int intNb1,int intLigne,int intColonne,int intNombreCercleGrille) {
		this.intNb1 = intNb1;
		this.intLigne = intLigne;
		this.intColonne = intColonne;
		this.intNombreCercleGrille = intNombreCercleGrille;
		 
		//this.gpane = gpane;

		this.hboxCase = new HBox(1);
			
		this.setPrefSize(30, 30);
		
		this.booValider = false;
			
			//hboxCercle = new HBox(1);
			//hboxCercle.setPrefSize(15, 15);			
			
			 txtCase = new Text();
			Text txtCercle = new Text(String.valueOf(intNombreCercleGrille));

		
		//txtCase//txtCase.setMaxSize(8, 2);
		BorderStroke bordureNoirCase = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7), new BorderWidths(2), new Insets(0));
		Border bordureCase = new Border(bordureNoirCase);
		BorderStroke bordureNoirCercle = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(4), new Insets(0));
		Border bordureCercle = new Border(bordureNoirCercle);
		Background couleurFill = new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(5), new Insets(0)));
		
		
		Background couleurFillCercle = new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0)));
		
		Font fontText = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
		
		switch (intNb1) {
		case -1: // quand c'est vide
			
			
			break;
		case 0:// les cases
			
			
		this.setBorder(bordureCase);
		this.getChildren().addAll(txtCase);
		this.setBackground(couleurFill);
		this.setAlignment(Pos.CENTER);
		txtCase.setFont(fontText);
		
		txtCase.setTextAlignment(TextAlignment.CENTER);

			break;

		default: //les autres num�ros les cercles noirs
		
			//hboxCase.setPrefSize(15, 15);
			this.setBackground(couleurFillCercle);
			this.getChildren().addAll(txtCercle);
			this.setAlignment(Pos.CENTER);
			txtCercle.setFill(Color.WHITE);
			
			
			break;
		}
		
	
	}
	public int getIntNombreCercleGrille() {
		return intNombreCercleGrille;
	}
	public HBox creerHbox() { //methode qui cree les hbox selon les donnees dans la grille
		
		
		return hboxCase; 
	}



	public int getIntNb1() {
		return intNb1;
	}
	public Boolean getBooValider() {
		return booValider;
	}
	public void setBooValider(Boolean booValider) {
		this.booValider = booValider;
	}
	
	

}
