import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.cli.ParseException;

public final class ProductsToPdf {
	
	public static void main(String[] args) throws ParseException, IOException{
		Parser parser = new Parser();
		CsvFile csv = new CsvFile();
		
		try {
			parser.parseParameters(args);
			csv.open(parser.getInputFile());
			String[] data;
			while ((data = csv.readData()) != null) {
				if (data.length == 5) {
					System.out.println(Arrays.toString(data));
					// DO SOMETHING !
				} else {
					System.err.println("Warning: Invalid CSV file line");
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(3);
		} finally {
			csv.close();
		}
	}
}
