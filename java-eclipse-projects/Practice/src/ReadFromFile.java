import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadFromFile {

	public static void main(String[] args) {
		
		//initialising the method
		readFromFile();
	}
	/*
	 * Read the contents of a file and print them on the screen
	 */
	public static void readFromFile() {
		
		try {
			//wrapping the FileReader in BufferedReader
			BufferedReader br = new BufferedReader(new FileReader("E:\\Eclipse Projects\\Practice\\src\\in.txt"));
			
			try {				
				//print all the lines read from the file
				String s;	
				
				//run the loop till the end of the file
				while((s = br.readLine()) != null) {
					//print each line of the file on the console
					System.out.println(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");;
		}
		
	}
}
