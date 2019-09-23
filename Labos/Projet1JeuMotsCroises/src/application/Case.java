package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Case {

	GridPane gpane;
	int intNb1;

	public Case(int intNb1, GridPane gpane) {
		this.intNb1 = intNb1;
		this.gpane = gpane;

		gpane = new GridPane();
		gpane.setPadding(new Insets(5));
		//gpane.setGridLinesVisible(true); 
		gpane.setAlignment(Pos.CENTER);
		gpane.setVgap(2);
		gpane.setHgap(2);
		
		
		
	}

	public GridPane getGpane() {
		return gpane;
	}

	public int getIntNb1() {
		return intNb1;
	}
	
	

}
