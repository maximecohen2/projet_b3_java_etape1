import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import fr.epsi.b3.Product;

public interface InterfaceReader {
	public Product getNextProduct() throws IOException;
	
	public void open(final String fileName) throws FileNotFoundException, UnsupportedEncodingException;
	
	public void close() throws IOException;
}
