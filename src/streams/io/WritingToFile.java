package streams.io;

import java.io.*;

public class WritingToFile {

	public static void main(String args[]) {
		try {
		    String str = "Hello xxx, \n I am writing to say Hi";
		    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RajaRatnamKatta\\eclipse-workspace\\DS\\src\\streams\\io\\sample.txt"));
		    writer.write(str);
		    
		    writer.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Read or write failed");
		}
	}

}
