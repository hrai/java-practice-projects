import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prob22 {
	
	static String[] ar;
	static ArrayList<String> s = new ArrayList<String>();
	static int count = 0;
	static int sum = 0;
	
	public static void main(String[] args) {
		
		
		try {
			File f = new File("E:\\Eclipse Projects\\names.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str;
			
			//read and save the strings to the arraylist
			while((str = br.readLine()) != null) {
				ar = str.split(",");
				for(String arr: ar) {
					System.out.println(arr);
				}
				s.addAll(Arrays.asList(ar));
			}
			
			//sorting the array
			Collections.sort(s);
			
			//calculating the total of all the name scores in the file
			for(int i=0; i<s.size(); i++) {
				sum+= posSum(s.get(i), i+1);
			}
			
			//print the sum
			System.out.println(sum);
			br.close();//close buffered reader
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//sum of position of string and it's characters
	private static int posSum(String s, int n) {
		int result = 0;
		int pos = 0;
		
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case 'A':  
				pos = 1;
				break;
			case 'B':  
				pos = 2;
				break;
			case 'C':  
				pos = 3;
				break;
			case 'D':
				pos = 4;
				break;
			case 'E':
				pos = 5;
				break;
			case 'F':
				pos = 6;
				break;
			case 'G':
				pos = 7;
				break;
			case 'H':
				pos = 8;
				break;
			case 'I': 
				pos = 9;
				break;
			case 'J':
				pos = 10;
				break;
			case 'K':
				pos = 11;
				break;
			case 'L': 
				pos = 12;
				break;
			case 'M':
				pos = 13;
				break;
			case 'N':
				pos = 14;
				break;
			case 'O':
				pos = 15;
				break;
			case 'P':
				pos = 16;
				break;
			case 'Q':
				pos = 17;
				break;
			case 'R':
				pos = 18;
				break;
			case 'S':
				pos = 19;
				break;
			case 'T':
				pos = 20;
				break;
			case 'U':
				pos = 21;
				break;
			case 'V':
				pos = 22;
				break;
			case 'W':
				pos = 23;
				break;
			case 'X':
				pos = 24;
				break;
			case 'Y':
				pos = 25;
				break;
			case 'Z':
				pos = 26;
				break;
			default:
				pos = 0;
				break;
			}
			
			//adding the position of the character
			result+= pos;
		}
		return result*n;
	}
}
