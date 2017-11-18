package productManager;

public class Product {
	private float tva = 20;
	private String code;
	private String nom;
	private String description;
	private String categorie;
	private float prixHT;
	private float prixTTC;
	
	public Product(float tva) {
		this.tva = tva;
	}
	
	public void setData(String code, String nom, String description, String categorie, float prixHT) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prixHT = prixHT;
		this.prixTTC = (this.prixHT / 100)*this.tva + this.prixHT;
	}

	public float getTva() {
		return tva;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public String getCategorie() {
		return categorie;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public float getPrixTTC() {
		return prixTTC;
	}
	
	

}
