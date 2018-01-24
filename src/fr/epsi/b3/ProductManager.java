package fr.epsi.b3;

import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class ProductManager {
	private ArrayList<InterfaceGenerator> pdfFiles = new ArrayList<>();
	
	public void addPdf(InterfaceGenerator newPdf) {
		newPdf.open();
		this.pdfFiles.add(newPdf);
	}
	
	public void addProduct(final Product newProduct) throws DocumentException {
		for (InterfaceGenerator pdf : this.pdfFiles) {
			pdf.addProduct(newProduct);
		}
	}
	
	public void closePdfs() throws DocumentException {
		for (InterfaceGenerator pdf : this.pdfFiles) {
			pdf.close();
		}
	}

}
