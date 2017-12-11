import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CsvFile {
	private BufferedReader buffer;
	
	public void open(final String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		this.buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
	}
	
	public String[] readDataLine() throws IOException {
		String line;
		String[] data;
		if ((line = this.buffer.readLine()) == null) {
			return null;
		}
		data = line.split(";");
		return data;
	}
	
	public void close() throws IOException {
		if (this.buffer != null) {
			this.buffer.close();
		}
	}
}
