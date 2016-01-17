
public class MultiplicationTable {
	
	public static void main(String[] args) {
		
		int countHyphen;
		
		//print first row
		System.out.print(" * ");
		System.out.print("| ");
		countHyphen = 5;
		
		for(int i=1; i<10; i++) {
			if(i<10) {
				System.out.print(" ");
				countHyphen++;
			}
			System.out.print(" " + i + " ");
			//increase countHyphen
			countHyphen+= (new Integer(i)).toString().length() + 2;
		}
		
		//print second row
		System.out.println();
		for(int i=0; i<=countHyphen; i++) {
			System.out.print("-");
		}
		
		//print the table
		System.out.println();
		
		for(int i=1; i<10; i++) {
			System.out.print(" " + i + " | ");
			
			for(int num=1; num<10; num++) {
				int product = num*i;
				
				if(product<10) {
					System.out.print(" ");
				}
				
				System.out.print(" " + product + " ");
			}
			System.out.println();//print a new line at the end of each table
		}
	}
}
