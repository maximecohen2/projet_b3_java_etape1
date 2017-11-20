package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class SheetPdf extends AbstractPdf {

	public SheetPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		this.document.newPage();
		this.document.add(new Paragraph("Code: " + product.getCode().toUpperCase()));
	}

}
