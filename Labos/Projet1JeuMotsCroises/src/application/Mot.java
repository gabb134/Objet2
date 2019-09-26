package application;


public class Mot{
	private EnumOrientation orientation ;
	private String strIndice;
	private String strMot;
	
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
	}
	
	public String toString() {
		return orientation+" "+strIndice+" "+strMot;
		
	}
	

}
