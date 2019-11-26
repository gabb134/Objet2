package exempleCours7;
public class TestProducteurConsommateur {

	public static void main(String[] args) {
		Tampon tamp = new Tampon();
		new Consommateur(tamp);
		new Producteur(tamp);
	}
}
