import fr.epsi.b3.Product;

public interface InterfaceReader {
	public Product getNextProduct() throws ReaderException;
	
	public void open(final String fileName) throws ReaderException;
	
	public void close() throws ReaderException;
}
