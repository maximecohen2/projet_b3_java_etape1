import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFile {
	private BufferedReader buffer;
	
	public void open(final String fileName) throws FileNotFoundException {
		this.buffer = new BufferedReader(new FileReader(fileName));
	}
	
	public String[] readDataLine() throws IOException {
		String line;
		String[] data;
		try {
			if ((line = this.buffer.readLine()) == null) {
				return null;
			}
			data = line.split(";");
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return data;
	}
	
	public void close() throws IOException {
		if (this.buffer != null) {
			this.buffer.close();
		}
	}
}
