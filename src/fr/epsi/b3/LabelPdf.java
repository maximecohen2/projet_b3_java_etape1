package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
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
		Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		if (this.labelId % 16 == 0) {
			this.document.add(this.table);
			this.document.newPage();
			this.table  = new PdfPTable(2);
		}
		
		/*if (this.labelId % 2 == 0) {
			
		} else {
			
		}*/
		
		Paragraph codeLine = new Paragraph(QrCode.generate(product.getCode()) + product.getCode() + product.getNom() + product.getPrixTTC() + "€ TTC (" + product.getPrixHT() + "€HT )",fontNormal);
		System.out.print(QrCode.generate(product.getCode()));
		PdfPCell cell = new PdfPCell(codeLine);
		this.table.addCell(cell);
		
		this.labelId++;
	}

}
