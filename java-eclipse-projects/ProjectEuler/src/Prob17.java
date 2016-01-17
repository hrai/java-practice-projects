
public class Prob17 {

	public static void main(String[] args) {
		
		String s = "";
		int count = 0;
		
		for(int num = 0; num <= 1000; num++) {
			int i = num;
			
			if(i <= 20) 	//Words for less than 20
				s+= numToString(i);
			else if(i < 100) {	//Words for less than 100 and greater than 20
				if(i/10 == 1)	//Checking for 11 to 19
					s+= numToString(i);
				else {	//Checking for 20 to 99
					s+= numToString(i-(i%10));
					s+= numToString(i%10);
				}
				
			}
			else if(i == 100) {	//Word for 100
				s+= "one hundred ";
			}
			else if(i < 1000) {	//Words for numbers between 101 to 999
				s+= numToString(i/100);
				s+= numToString(100);
				i%= 100;	//Reducing three digit number to two digit number
				
				if(i != 0) {	//Check if the number is a multiple of 100
					s+= "and";
					
					if(i/10 == 1)	//Checking for 11 to 19
						s+= numToString(i);
					else {	//Checking for 20 to 99
						s+= numToString(i-(i%10));
						s+= numToString(i%10);
					}
				}
			}
			else //Calculate for one thousand
				s+= numToString(i);
		}
		
		//Count the number of alphabets
		for(int i = 0; i < s.length(); i++) {
			if(Character.isAlphabetic(s.charAt(i))) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	public static String numToString(int num) {
		
		switch(num) {
			
			case 1: return "one ";
			
			case 2: return "two ";
			
			case 3: return "three ";
			
			case 4: return "four ";
			
			case 5: return "five ";
			
			case 6: return "six ";
			
			case 7: return "seven ";
			
			case 8: return "eight ";
			
			case 9: return "nine ";
			
			case 10: return "ten ";
			
			case 11: return "eleven ";	
			
			case 12: return "twelve ";
			
			case 13: return "thirteen ";
			
			case 14: return "fourteen ";
			
			case 15: return "fifteen ";
			
			case 16: return "sixteen ";
			
			case 17: return "seventeen ";
			
			case 18: return "eighteen ";
			
			case 19: return "nineteen ";
			
			case 20: return "twenty ";
			
			case 30: return "thirty ";
			
			case 40: return "forty ";
			
			case 50: return "fifty ";
			
			case 60: return "sixty ";
			
			case 70: return "seventy ";
			
			case 80: return "eighty ";
			
			case 90: return "ninety ";
			
			case 100: return "hundred ";
			
			case 1000: return "one thousand ";
			
			default: return " ";
			
		}
	}
}
