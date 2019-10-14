package application;

import java.util.Comparator;

public class TriParAuteurEtParTitre implements Comparator<Document>{

	
	
	
	
	@Override
	public int compare(Document o1, Document o2) {
		// TODO Auto-generated method stub'
		
		int intRetour = 0;
		int intTitreCompare = o1.getTitre().compareTo(o2.getTitre());
		int intAuteurCompare = o1.getAuteur().compareTo(o2.getAuteur());
		
		if(intTitreCompare==0) {
			intRetour = ((intAuteurCompare==0) ? intTitreCompare:intAuteurCompare);
		}else {
			intRetour = intTitreCompare;
		}
	
		
		return intRetour;
	}


	

}
