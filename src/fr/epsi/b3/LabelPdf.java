package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class LabelPdf extends AbstractPdf {

	private int labelId = 0;
	
	public LabelPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		if (this.labelId % 16 == 0) {
			this.document.newPage();
			
		}
		
		if (this.labelId % 2 == 0) {
			QrCode.generate("");
		} else {
			
		}
		
		this.labelId++;
	}

}
