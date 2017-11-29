package fr.epsi.b3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractPdf {
	protected Document document;
	protected String fileName;
	protected PdfWriter writer;
	
	public AbstractPdf(String fileName) {
		this.document = new Document();
		this.fileName = fileName;
	}
	
	public void open() {
		try {
			File f = new File(this.fileName);
			File pDir = f.getParentFile();
			if (pDir != null && !pDir.exists()) {
				pDir.mkdirs();
			}
			this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(f));
			document.open();
		} catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void close() {
		document.close();
	}
	
	public abstract void addProduct(Product product) throws DocumentException;
	
}
