import java.io.IOException;

import com.itextpdf.text.DocumentException;

import fr.epsi.b3.LabelPdf;
import fr.epsi.b3.Product;
import fr.epsi.b3.ProductManager;
import fr.epsi.b3.SheetPdf;

public final class ProductsToPdf {
	
	private static void addPdf(Parser parser, ProductManager productManager) {
		if (parser.getLabelFile() != null) {
			productManager.addPdf(new LabelPdf(parser.getLabelFile()));
		}
		if (parser.getSheetFile() != null) {
			productManager.addPdf(new SheetPdf(parser.getSheetFile()));
		}
	}
	
	
	private static void addProduct(Parser parser, ProductManager productManager, String data[]) throws DocumentException {
		Product product = new Product();
		
		if (parser.getCategory() == null ||
				(parser.getCategory() != null && data[3].equals(parser.getCategory()))) {
			product.setData(data[0], data[1], data[2], data[3], Float.valueOf(data[4].replace(',', '.')), parser.getTva());
			productManager.addProduct(product);
		}
	}
	
	
	private static void convertCsvToPdf(Parser parser, CsvFile csv) throws IOException, NumberFormatException, DocumentException {
		ProductManager productManager;
		String[] data;
		
		productManager = new ProductManager();
		addPdf(parser, productManager);
		while ((data = csv.readDataLine()) != null) {
			if (data.length == 5) {
				addProduct(parser, productManager, data);
			}
		}
		productManager.closePdfs();
	}
	
	
	public static void main(String[] args){
		Parser parser;
		CsvFile csv = null;
		
		try {
			parser = new Parser();
			csv = new CsvFile();
			parser.parseParameters(args);
			csv.open(parser.getInputFile());
			convertCsvToPdf(parser, csv);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(3);
		} finally {
			if (csv != null) {
				try {
					csv.close();
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
	}
}
