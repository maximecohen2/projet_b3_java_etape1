import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import fr.epsi.b3.Product;

public class CsvFile implements InterfaceReader{
	private BufferedReader buffer;
	
	public void open(final String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		this.buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
	}
	
	public Product getNextProduct() throws IOException {
		String line;
		String[] data;
		Product product = new Product();
		if ((line = this.buffer.readLine()) == null) {
			return null;
		}
		data = line.split(";");
		product.setData(data[0], data[1], data[2], data[3], Float.valueOf(data[4].replace(',', '.')));
		return product;
	}
	
	public void close() throws IOException {
		if (this.buffer != null) {
			this.buffer.close();
		}
	}
}
