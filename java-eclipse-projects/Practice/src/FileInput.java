import java.io.*;
import java.util.*;

public class FileInput {

	public static void main(String[] args) {
		
		//initialising the method
		readFile();
		
	}
	
	public static void readFile() {
		
		try {
			//create scanner object to read from the file
			Scanner scan = new Scanner(new FileReader("E:\\Eclipse Projects\\Practice\\src\\in.txt"));
						
			System.out.println(scan.nextInt());
			System.out.println(scan.nextDouble());
			
			//reads from where scanner left off reading double value till the end of line
			//which generates a new line
			scan.nextLine();	
			
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		
		
		
	}
	
}
