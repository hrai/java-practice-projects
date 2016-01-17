import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Prob42 {
	
	public static void main(String[] args) throws IOException {
		
		String fileContents = readStringFromFile("words.txt");	//Reading file's contents
		String[] strings = splitStrings(fileContents);	//Splitting the string
		ArrayList<Integer> triangleNumbers = listOfTriangleNos(500);
		System.out.println(triangleNumbers);
		int noOfTriangleNos = 0;
		
		for(String s: strings) {
			int sumOfAlphabetValues = 0;
			for(int i = 0; i < s.length(); i++) {	//Adding the values of the alphabet's positions
				sumOfAlphabetValues += valueOfAlphabet(s.charAt(i));
				System.out.println(s.charAt(i));
			}
			
			//Check if the sum is a triangle number
			if(triangleNumbers.contains(sumOfAlphabetValues)) {
				noOfTriangleNos++;
			}
			
		}
		
		System.out.println(noOfTriangleNos);
		
	}
	
	/**
	 * Returns the numeric position of the alphabet.
	 * 
	 * @param alphabet
	 * @return
	 */
	public static int valueOfAlphabet(char alphabet) {
		
		switch(alphabet) {
		
		case 'A': return 1;
		
		case 'B': return 2;
		
		case 'C': return 3;
		
		case 'D': return 4;
		
		case 'E': return 5;
		
		case 'F': return 6;
		
		case 'G': return 7;
		
		case 'H': return 8;
		
		case 'I': return 9;
		
		case 'J': return 10;
		
		case 'K': return 11;
		
		case 'L': return 12;
		
		case 'M': return 13;
		
		case 'N': return 14;
		
		case 'O': return 15;
		
		case 'P': return 16;
		
		case 'Q': return 17;
		
		case 'R': return 18;
		
		case 'S': return 19;
		
		case 'T': return 20;
		
		case 'U': return 21;
		
		case 'V': return 22;
		
		case 'W': return 23;
		
		case 'X': return 24;
		
		case 'Y': return 25;
		
		case 'Z': return 26;
				
		default: return 0;
		
		}
	}

	/**
	 * Returns the contents of a file after reading from it. File path is passed as parameter in String format.
	 * 
	 * @param pathString
	 * @return
	 * @throws IOException
	 */
	public static String readStringFromFile(String pathString) throws IOException {
		Path path = FileSystems.getDefault().getPath("E:\\Eclipse Projects\\ProjectEuler\\src\\", pathString);
		BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		String line, fileContent = "";

		while((line = br.readLine()) != null) {
			fileContent+= line;
		}
		
		return fileContent;
	}

	/**
	 * Returns an array of strings after splitting the string parameter using regex.
	 * 
	 * @param longString
	 * @return
	 */
	public static String[] splitStrings(String longString) {
		return longString.split("\",\"");
	}
	
	public static ArrayList<Integer> listOfTriangleNos(int n) {
		ArrayList<Integer> triangleNos = new ArrayList<Integer>();
		
		for(int i = 0; i <= n; i++) {
			triangleNos.add(i*(i+1)/2);
		}
		
		return triangleNos;
	}
}
