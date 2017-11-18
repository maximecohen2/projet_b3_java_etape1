package productManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractPdf {
	private Document document;
	private String fileName;
	
	public AbstractPdf(String fileName) {
		this.document = new Document();
		this.fileName = fileName;
	}
	
	public void openPdf() {
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(this.fileName));
			document.open();
		} catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void closePdf() {
		document.close();
	}
	
	public abstract void addProduct(Product product);
	
}
