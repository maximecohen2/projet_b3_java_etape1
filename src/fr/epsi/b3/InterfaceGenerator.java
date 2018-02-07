package fr.epsi.b3;

import com.itextpdf.text.DocumentException;

public interface InterfaceGenerator {
	public void open();
	
	public void close() throws DocumentException;
	
	public void addProduct(Product product) throws DocumentException;
}
