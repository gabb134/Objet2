package application;

import java.util.Comparator;

public class TriParAuteur implements Comparator<Document>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Document o1, Document o2) {
		// TODO Auto-generated method stub
		return o1.getAuteur().compareTo(o2.getAuteur());
	}
	

}
