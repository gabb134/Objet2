package application;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

public class PratiqueJavaFXObservableMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Document> map = new HashMap<Integer, Document>();
		ObservableMap<Integer, Document> mapObervable = FXCollections.observableMap(map);

		mapObervable.addListener(new MapChangeListener<Integer, Document>() {

			@Override
			public void onChanged(Change<? extends Integer, ? extends Document> c) {
				// TODO Auto-generated method stub
				System.out.println("Modification detectee "+ c);
			
					System.out.println("Ajout?"+c.wasAdded());
					System.out.println("Suppression?"+c.wasRemoved());
					System.out.println();
				
			}

		});
		
		Document d1 = new Document(1, "gabo", "klk");
		Document d2 = new Document(2, "Guelleh", "test");
		Document d3 = new Document(3, "Steven", "rester");
		
		
		mapObervable.put(1, d1);
		System.out.println("Taiile : "+mapObervable.size()+"\n"+mapObervable.toString());
		mapObervable.put(2, d2);
		System.out.println("Taiile : "+mapObervable.size()+"\n"+mapObervable.toString());
		mapObervable.put(3, d3);
		System.out.println("Taiile : "+mapObervable.size()+"\n"+mapObervable.toString());
		mapObervable.remove(2, d2);
		System.out.println("Taiile : "+mapObervable.size()+"\n"+mapObervable.toString());
		
		System.out.println();
		System.out.println("Valeurs \n"+map.values());
	}

}
