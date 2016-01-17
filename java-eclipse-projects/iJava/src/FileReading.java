

import java.util.*;
import java.io.*;

public class FileReading {

	private static TreeSet<String> ts;
	private static File file;
	
	public static void main(String[] args) {

		ts = new TreeSet<String>();
		
		if(args != null) {
			file = new File(args[0]);
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line = br.readLine()) != null) {
					addStringsToSet(line);
				}
				
				//Print set items on the screen
				if(!ts.isEmpty()) {
					for(String s: ts) {
						System.out.println(s);
					}
				}
				
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private static void addStringsToSet(String line) {
		String[] array = line.split(" ");
		
		
		for(String s: array) {
			System.out.println(s);
			ts.add(s);
		}
		
	}
}
