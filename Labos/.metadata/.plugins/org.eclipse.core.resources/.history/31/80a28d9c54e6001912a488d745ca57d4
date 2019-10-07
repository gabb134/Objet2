package application;

import java.util.ArrayList;
import java.util.Collections;

public class Mot{
	private EnumOrientation orientation ;
	private String strIndice;
	private String strMot;
	private Boolean booMelanger;
	private Boolean booSolution;
	private String motSuffle;
	private int intLigne;
	private int intColonne; 
	public EnumOrientation getOrientation() {
		return orientation;
	}

	public String getStrIndice() {
		return strIndice;
	}

	public String getStrMot() {
		return strMot;
	}

	public Mot(EnumOrientation orientation,String strIndice,String strMot) {
		this.orientation = orientation;
		this.strIndice = strIndice;
		this.strMot = strMot;
		this.booMelanger = false;
		this.booSolution = false;
		
		
		this.motSuffle = melangerMot();
		
		
	}
	
	public String melangerMot() {
		
		String motMelnager = "";
		ArrayList<Character> arrMotMelanger = new ArrayList<>();

		for (int i = 0; i < strMot.length(); i++) {
			arrMotMelanger.add(strMot.charAt(i));
		}
		Collections.shuffle(arrMotMelanger);

		for (int i = 0; i < arrMotMelanger.size()  ; i++) {

			motMelnager += arrMotMelanger.get(i);
			

		}
		
		return motMelnager;
		
	}
	
	public Boolean getBooMelanger() {
		return booMelanger;
	}

	public void setBooMelanger(Boolean booMelanger) {
		this.booMelanger = booMelanger;
	}

	public String toString() {
		return orientation+" "+strIndice+" "+strMot;
		
	}

	public Boolean getBooSolution() {
		return booSolution;
	}

	public void setBooSolution(Boolean booSolution) {
		this.booSolution = booSolution;
	}

	public String getMotSuffle() {
		return motSuffle;
	}

	public void setMotSuffle(String motSuffle) {
		this.motSuffle = motSuffle;
	}

	public int getIntLigne() {
		return intLigne;
	}

	public void setIntLigne(int intLigne) {
		this.intLigne = intLigne;
	}

	public int getIntColonne() {
		return intColonne;
	}

	public void setIntColonne(int intColonne) {
		this.intColonne = intColonne;
	}
	

}
