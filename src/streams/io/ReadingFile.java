package streams.io;

import java.io.*;

public class ReadingFile {

	public static void main(String args[]) {
		try {
			FileInputStream infile = new FileInputStream("C:\\Users\\RajaRatnamKatta\\eclipse-workspace\\DS\\src\\streams\\io\\NewFile.html");
			byte buffer[] = new byte[50];
			int nBytesRead;
			do {
				nBytesRead = infile.read(buffer);
				System.out.write(buffer, 0, nBytesRead);
			} while (nBytesRead == buffer.length);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Read failed");
		}
	}
}
