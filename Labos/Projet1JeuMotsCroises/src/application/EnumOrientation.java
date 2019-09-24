package application;

public enum EnumOrientation { HORIZONTALE("H"),VERTICAL("V");
	
	private String strOrientation;
	
	EnumOrientation(String strOrientation) {
        this.strOrientation = strOrientation;
    }

	public String getStrOrientation() {
		return strOrientation;
	}
	

}
