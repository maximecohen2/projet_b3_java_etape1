package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class SheetPdf extends AbstractPdf {

	public SheetPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		
		this.document.newPage();
		
		// Affichage du code de produit
		this.document.add(new Paragraph("Code: " + product.getCode().toUpperCase(), fontNormal));
		this.document.add(new Paragraph(" ", fontNormal));
		this.document.add(new Paragraph(" ", fontNormal));
		
		// Affichage de la categorie
		Font fontCategorie = new Font(Font.FontFamily.TIMES_ROMAN, 20);
		Paragraph categorieLine = new Paragraph("Catégorie: " + product.getCategorie(), fontCategorie);
		categorieLine.setAlignment(Element.ALIGN_RIGHT);
		this.document.add(categorieLine);
		
		// Affichage du titre
		Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 40);
		this.document.add(new Paragraph(product.getNom().substring(0, 1).toUpperCase() + product.getNom().substring(1), fontTitle));
		this.document.add(new Paragraph(" ", fontNormal));
		
		// Affichage de la description
		this.document.add(new Paragraph("Description", fontNormal));
		//this.document.add(new Rectangle(20, 20, 100, 100));
	}

}
