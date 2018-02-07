package fr.epsi.b3;


import java.io.IOException;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class LabelPdf extends AbstractPdf {

	private int labelId = 0;
	
	private PdfPTable table;
	
	public LabelPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 12);
		Font fontReduce = new Font(Font.FontFamily.TIMES_ROMAN, 9);
		if (this.labelId % 16 == 0) {
			this.document.newPage();
			this.table = new PdfPTable(2);
		}
		
		try {
			Image qr = QrCode.generate(product.getCode(),40);
			qr.scalePercent(150f);
			Paragraph PdtPrix = new Paragraph(String.format("%.2f",product.getPrixTTC()) + "� TTC (" + String.format("%.2f",product.getPrixHT()) + "� HT )",fontReduce);
			Paragraph PdtCode = new Paragraph(product.getCode(),fontNormal);
			Paragraph PdtNom = new Paragraph(product.getNom(),fontNormal);
			PdfPCell cell = new PdfPCell();
			
			PdfPTable ttable = new PdfPTable(2);
			PdfPCell tcell1 = new PdfPCell(qr);
			PdfPCell tcell2 = new PdfPCell();
			tcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			tcell2.addElement(PdtCode);
			tcell2.addElement(PdtNom);
			tcell2.addElement(PdtPrix);
			
			tcell1.setBorder(Rectangle.NO_BORDER);
			tcell2.setBorder(Rectangle.NO_BORDER);
			
			float[] columnWidths = {1f, 2f};
			ttable.setWidths(columnWidths);
			
			ttable.addCell(tcell1);
			ttable.addCell(tcell2);
			cell.addElement(ttable);
			
			this.table.addCell(cell);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.labelId++;
		if (this.labelId % 16 == 0) {
			this.document.add(this.table);
		}
	}
	
	public void close() throws DocumentException {
		if (this.labelId % 16 != 0) {
			this.document.add(this.table);
		}
		super.close();
	}
}
