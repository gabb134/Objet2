package application;





import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Exercice5 extends Application {

	public void start(Stage primaryStage) {
		try {

			FlowPane root =creerFlowPane();
			Scene scene = new Scene(root);

			primaryStage.setTitle("Exercice5");
			//Le redimensionnement de la fen�tre principale n�est pas possible (m�thode setResizable);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			//Ajustez sa dimension au contenu de la sc�ne (m�thode sizeToScene). 
			primaryStage.sizeToScene();
			primaryStage.show();

			// Le redimensionnement de la fen�tre principale n�est pas possible

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private FlowPane creerFlowPane() {
		//Le panneau racine est de type FlowPane avec une orientation verticale et un
		//espace de 10 pixels entre les lignes. 

		FlowPane flPane = new FlowPane(Orientation.VERTICAL);
		flPane.setVgap(10);
		
		//Les composants sont � une distance de 10 pixels (Haut, droite, bas et gauche) de la
		//bordure du panneau. Utilisez la m�thode setPadding. 
		flPane.setPadding(new Insets(10));
		
	
	//	- Le titre de la fen�tre est Exercice 5 et contient les composants suivants :
	//		- Un champ de texte (TexField)
	//		- Une zone de texte (TextArea)
	//	    - Un bouton Quitter
	//		- Un bouton Effacer
	    TextField txt1 = new TextField("ceci est un champ de texte");
		TextArea area = new TextArea("Ceci est une zone de text \n qui peut avoir plusieurs lignes");
		Button btnQuitter = new Button("Quitter");
		Button btnEffacer = new Button("Effacer");
		
		//Ce champ n�est pas modifiable. Utilisez la m�thode setEditable. 
		txt1.setEditable(false);
		
		//Ajoutez au champ de texte une bordure bleue, rectangulaire, sans arrondis et
		//d��paisseur 5. 
		BorderStrokeStyle styleBleu = new BorderStrokeStyle(StrokeType.CENTERED, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10, 0, null);
		BorderStroke bordureBleu = new BorderStroke(Color.ALICEBLUE.BLUE, styleBleu, CornerRadii.EMPTY, new BorderWidths(4), new Insets(0));
		Border bordure = new Border(bordureBleu);
		txt1.setBorder(bordure);
		
		//Le texte de la zone de texte est sur deux lignes. Utilisez \n pour obtenir l�affichage
		//demand� et comprendre la m�thode setWrapText. 
		area.setWrapText(true);
		
		//Ajoutez une bulle d�aide contextuelle (texte de votre choix) sur la zone de texte.
		//Utilisez la m�thode setTooltip. 
		area.setTooltip(new Tooltip("Ceci est un tooltip"));
		
		//Les deux boutons Quitter et Effacer sont dispos�s sur un HBox. Ils sont espac�s de
		//10 pixels. Notez qu�ils occupent tout l�espace (Utilisez les m�thodes setHgrow de
		//HBox et les m�thodes setMaxWidth sur les boutons) 
		HBox hBox = new HBox(10);
		HBox.setHgrow(btnQuitter, Priority.ALWAYS);
		HBox.setHgrow(btnEffacer, Priority.ALWAYS);
		btnQuitter.setMaxWidth(Double.MAX_VALUE);
		btnEffacer.setMaxWidth(Double.MAX_VALUE);
		Font font = Font.font("Tahoma", FontWeight.BOLD, 20);
		btnQuitter.setFont(font);
		btnEffacer.setFont(font);
		
		//La couleur du texte des boutons est bleue
		btnQuitter.setTextFill(Color.BLUE);
		btnEffacer.setTextFill(Color.BLUE);
		
		//Ajoutez une ic�ne pour le bouton Quitter. Utilisez la m�thode setGraphic.
		//N�oubliez pas d�ajouter l�image � votre dossier ressource. 
		Image image = new Image("exit.GIF");
		ImageView imageView = new ImageView(image);
		btnQuitter.setGraphic(imageView);
		

		hBox.getChildren().addAll(btnQuitter,btnEffacer);
		flPane.getChildren().addAll(txt1,area,hBox);
	//	flPane.getChildren().addAll(btnQuitter,btnEffacer);
		return flPane;
	}
	public static void main(String[] args) {
		launch(args);
	}

}
