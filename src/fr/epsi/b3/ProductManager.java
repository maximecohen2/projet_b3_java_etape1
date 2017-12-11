package fr.epsi.b3;

import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class ProductManager {
	private ArrayList<AbstractPdf> pdfFiles = new ArrayList<AbstractPdf>();
	
	public void addPdf(AbstractPdf newPdf) {
		newPdf.open();
		this.pdfFiles.add(newPdf);
	}
	
	public void addProduct(final Product newProduct) throws DocumentException {
		for (AbstractPdf pdf : this.pdfFiles) {
			pdf.addProduct(newProduct);
		}
	}
	
	public void closePdfs() throws DocumentException {
		for (AbstractPdf pdf : this.pdfFiles) {
			pdf.close();
		}
	}

}
