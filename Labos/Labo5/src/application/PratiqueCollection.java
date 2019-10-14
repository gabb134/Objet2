package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.ls.LSInput;

public class PratiqueCollection {
	
	//private ArrayList<Document> listDoc = new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		
		 ArrayList<Document> listDoc = new ArrayList<>();
		Document d1 = new Document  (1,"aabb", "auteur1");
		 Document d2 = new Document (2,"aaab", "auteur2");
		 Document d3 = new Document (3,"bbaa", "auteur3");
		 Document d4 = new Document (4,"abaa", "auteur4");
		 Document d5 = new Document (1,"aabb", "auteur1");
		 Document d6 = new Document (2,"aaaa", "auteur2");
		 Document d7 = new Document (2,"abaa", "auteur2"); 
		 
		 listDoc.add(d1);
		 listDoc.add(d2);
		 listDoc.add(d3);
		 listDoc.add(d4);
		 listDoc.add(d5);
		 listDoc.add(d6);
		 listDoc.add(d7);
		 listDoc.add(d3);
		 
		 
		 
		// for (Document doc: listDoc){ System.out.println(doc); } 

		
		 HashSet<Document> ensDoc = new HashSet<Document>(listDoc);
		 
		 Iterator<Document> i = ensDoc.iterator();
		 System.out.println("*Avant le tri*");
		 while(i.hasNext())
			 System.out.println(i.next());
		 
		 Collections.sort(listDoc);
		 
		/* while(i.hasNext())
			 System.out.println(i.next());*/
		 System.out.println();
		 System.out.println("*Apres le tri par titre*");
		 for (Document doc: listDoc){ System.out.println(doc); }
		 
		 Collections.sort(listDoc,new TriParAuteur());
		 
		 System.out.println();
		 System.out.println("*Apres le tri par auteur en décroissant*");
		 for (Document doc: listDoc){ System.out.println(doc); }
		 
		 Collections.sort(listDoc, new TriParAuteurEtParTitre().reversed());
		
		 System.out.println();
		 System.out.println("*Apres le tri par titre et par auteur*");
		 for (Document doc: listDoc){ System.out.println(doc); }

		 
	}

}
