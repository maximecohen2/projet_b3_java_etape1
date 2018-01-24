import java.io.IOException;

import com.itextpdf.text.DocumentException;

import fr.epsi.b3.LabelPdf;
import fr.epsi.b3.Product;
import fr.epsi.b3.ProductManager;
import fr.epsi.b3.SheetPdf;

public final class ProductsToPdf {
	
	private ProductManager productManager;
	private String category;
	private float tva;
	
	public ProductsToPdf(String category, float tva) {
		this.productManager = new ProductManager();
		this.category = category;
		this.tva = tva;
	}
	
	public void addPdfs(Parser parser) {
		if (parser.getLabelFile() != null) {
			this.productManager.addPdf(new LabelPdf(parser.getLabelFile()));
		}
		if (parser.getSheetFile() != null) {
			this.productManager.addPdf(new SheetPdf(parser.getSheetFile()));
		}
	}
	
	private void addProduct(Product product) throws DocumentException {
		product.setTva(this.tva);
		if (this.category == null || product.isCategory(this.category)) {
			this.productManager.addProduct(product);
		}
	}
	
	
	private void convertCsvToPdf(CsvFile csv) throws IOException, NumberFormatException, DocumentException {
		Product product;

		while ((product = csv.getNextProduct()) != null) {
			addProduct(product);
		}
		productManager.closePdfs();
	}
	
	
	public static void main(String[] args){
		Parser parser;
		CsvFile csv = null;
		ProductsToPdf generator;
		
		try {
			parser = new Parser();
			csv = new CsvFile();
			parser.parseParameters(args);
			csv.open(parser.getInputFile());
			generator = new ProductsToPdf(parser.getCategory(), parser.getTva());
			generator.addPdfs(parser);
			generator.convertCsvToPdf(csv);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			try {
				if (csv != null) {
					csv.close();
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
