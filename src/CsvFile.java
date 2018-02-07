import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import fr.epsi.b3.Product;

public class CsvFile implements InterfaceReader{
	private BufferedReader buffer;
	
	public void open(final String fileName) throws ReaderException {
		try {
			this.buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			throw new ReaderException(e);
		}
	}
	
	public Product getNextProduct() throws ReaderException{
		String line;
		String[] data;
		Product product = new Product();
		try {
			if ((line = this.buffer.readLine()) == null) {
				return null;
			}
		} catch (IOException e) {
			throw new ReaderException(e);
		}
		data = line.split(";");
		product.setData(data[0], data[1], data[2], data[3], Float.valueOf(data[4].replace(',', '.')));
		return product;
	}
	
	public void close() throws ReaderException {
		if (this.buffer != null) {
			try {
				this.buffer.close();
			} catch (IOException e) {
				throw new ReaderException(e);
			} 
		}
	}
}
