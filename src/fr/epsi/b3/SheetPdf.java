package fr.epsi.b3;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

public class SheetPdf extends AbstractPdf {

	public SheetPdf(String fileName) {
		super(fileName);
	}

	@Override
	public void addProduct(Product product) throws DocumentException {
		Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		
		this.document.newPage();
		
		// Affichage du code de produit
		this.document.add(new Paragraph("Code: " + product.getCode().toUpperCase(), fontNormal));
		this.document.add(new Paragraph(" ", fontNormal));
		this.document.add(new Paragraph(" ", fontNormal));
		
		// Affichage de la categorie
		Font fontCategorie = new Font(Font.FontFamily.TIMES_ROMAN, 20);
		Paragraph categorieLine = new Paragraph("Catégorie: " + product.getCategorie(), fontCategorie);
		categorieLine.setAlignment(Element.ALIGN_RIGHT);
		this.document.add(categorieLine);
		
		// Affichage du titre
		Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 40);
		this.document.add(new Paragraph(product.getNom().substring(0, 1).toUpperCase() + product.getNom().substring(1), fontTitle));
		this.document.add(new Paragraph(" ", fontNormal));
		
		// Affichage de la description
		this.document.add(new Paragraph("Description", fontNormal));
		
		PdfPTable table = new PdfPTable(1);
        PdfPCell cell1 = new PdfPCell(new Paragraph(product.getDescription(),fontNormal));
        table.setSpacingBefore(10f);
        cell1.setFixedHeight(400);
        table.setWidthPercentage(100);
        table.addCell(cell1);
		this.document.add(table);
		
		
		//affichage du montant
		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		cell1 = new PdfPCell(new Paragraph(""));
		PdfPCell cell2 = new PdfPCell(new Paragraph(""));
		PdfPCell cell3 = new PdfPCell(new Paragraph("Montant HT: ", fontNormal));
		PdfPCell cell4 = new PdfPCell(new Paragraph(Math.round(product.getPrixHT()) + ",00€"));
		
		cell4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		PdfPCell cell5 = new PdfPCell(new Paragraph(""));
		PdfPCell cell6 = new PdfPCell(new Paragraph(""));
		PdfPCell cell7 = new PdfPCell(new Paragraph("TVA: ", fontNormal));
		PdfPCell cell8 = new PdfPCell(new Paragraph(product.getTva() + "%"));
		
		cell8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		PdfPCell cell9 = new PdfPCell(new Paragraph(""));
		PdfPCell cell10 = new PdfPCell(new Paragraph(""));
		PdfPCell cell11 = new PdfPCell(new Paragraph("Montant TTC: ", fontNormal));
		PdfPCell cell12 = new PdfPCell(new Paragraph(Math.round(product.getPrixTTC()) + ",00€"));
		cell12.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		cell1.setBorder(Rectangle.NO_BORDER);
		cell2.setBorder(Rectangle.NO_BORDER);
		cell3.setBorder(Rectangle.NO_BORDER);
		cell4.setBorder(Rectangle.NO_BORDER);
		cell5.setBorder(Rectangle.NO_BORDER);
		cell6.setBorder(Rectangle.NO_BORDER);
		cell7.setBorder(Rectangle.NO_BORDER);
		cell8.setBorder(Rectangle.NO_BORDER);
		cell9.setBorder(Rectangle.NO_BORDER);
		cell10.setBorder(Rectangle.NO_BORDER);
		cell11.setBorder(Rectangle.NO_BORDER);
		cell12.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		table.addCell(cell7);
		table.addCell(cell8);
		table.addCell(cell9);
		table.addCell(cell10);
		table.addCell(cell11);
		table.addCell(cell12);
		this.document.add(table);
		
	}

}
