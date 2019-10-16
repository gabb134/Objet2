package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Etudiant {
	 
	private  final SimpleIntegerProperty numDA;
	private final SimpleStringProperty nom;
	private final SimpleStringProperty prenom;
	private final SimpleDoubleProperty moyenne;
	
		
public  Etudiant(int numDA, String nom, String prenom, double moyenne) {
		
		this.numDA = new SimpleIntegerProperty(numDA);
		this.nom = new SimpleStringProperty (nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.moyenne = new SimpleDoubleProperty(moyenne);
	}

public final SimpleIntegerProperty numDAProperty() {
	return this.numDA;
}



public final int getNumDA() {
	return this.numDAProperty().get();
}



public final void setNumDA(final int numDA) {
	this.numDAProperty().set(numDA);
}



public final SimpleStringProperty nomProperty() {
	return this.nom;
}



public final java.lang.String getNom() {
	return this.nomProperty().get();
}



public final void setNom(final java.lang.String nom) {
	this.nomProperty().set(nom);
}



public final SimpleStringProperty prenomProperty() {
	return this.prenom;
}



public final java.lang.String getPrenom() {
	return this.prenomProperty().get();
}



public final void setPrenom(final java.lang.String prenom) {
	this.prenomProperty().set(prenom);
}



public final SimpleDoubleProperty moyenneProperty() {
	return this.moyenne;
}



public final double getMoyenne() {
	return this.moyenneProperty().get();
}



public final void setMoyenne(final double moyenne) {
	this.moyenneProperty().set(moyenne);
}


}
