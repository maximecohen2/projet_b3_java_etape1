package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class LabelPdf extends AbstractPdf {

	public LabelPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		this.document.add(new Paragraph("Hello World!"));
	}

}
