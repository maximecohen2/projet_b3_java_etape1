package fr.epsi.b3;

public class Product {
	private float tva;
	private String code;
	private String nom;
	private String description;
	private String categorie;
	private float prixHT;
	private float prixTTC;
	
	public void setData(String code, String nom, String description, String categorie, float prixHT) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prixHT = prixHT;
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

	public float getTva() {
		return tva;
	}
	
	public void setTva(float tva) {
		this.prixTTC = (prixHT / 100) * tva + prixHT;
		this.tva = tva;
	}
	
	public boolean isCategory(String category) {
		return this.categorie.equals(category);
	}
}
