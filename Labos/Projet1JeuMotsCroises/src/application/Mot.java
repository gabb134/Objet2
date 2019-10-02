package application;


public class Mot{
	private EnumOrientation orientation ;
	private String strIndice;
	private String strMot;
	private Boolean booMelanger;
	private Boolean booSolution;
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
	

}
