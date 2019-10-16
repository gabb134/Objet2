package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class PratiqueJavaFXObservableList {

	public static void main(String[] args) {
		ArrayList<String> listDoc = new ArrayList<String>();
		ObservableList<String> listeObservable = FXCollections.observableList(listDoc);

		listeObservable.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(ListChangeListener.Change<? extends String> c) {
				// TODO Auto-generated method stub
				System.out.println("Modification detectee "+ c);
				while(c.next()) {
					System.out.println("Ajout?"+c.wasAdded());
					System.out.println("Suppression?"+c.wasRemoved());
					System.out.println();
				}
			}

		});
		listeObservable.add("chaine1");
		System.out.println("Taille : "+listeObservable.size()+listeObservable.toString());
		listDoc.add("chaine2");
		System.out.println("Taille : "+listeObservable.size()+listeObservable.toString());
		listeObservable.add("chaine3");
		System.out.println("Taille : "+listeObservable.size()+listeObservable.toString());
		listeObservable.remove(0);
		System.out.println("Taille : "+listeObservable.size()+listeObservable.toString());
	}
}
