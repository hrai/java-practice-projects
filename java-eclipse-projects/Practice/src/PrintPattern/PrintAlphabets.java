package PrintPattern;

public class PrintAlphabets {

	public static void printO(int size) {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				
				//print upper bar && lower bar
				if(row == 0 || row == size-1) {
					System.out.print("# ");
				}
				
				//print the side bars
				else if(col == 0 || col == size-1) {
					System.out.print("# ");
				}
				else 
					System.out.print("  ");
			}
			
			//print a line after every row
			System.out.println();
		}
		
	}
	
	public static void printReverseZ(int size) {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				//print the top and bottom bars
				if(row == 0 || row == size-1) {
					System.out.print("# ");
				}
				
				//print the diagonals
				else if(row == col) {
					System.out.print("# ");
				}
				else
					System.out.print("  ");
			}
			
			//print a new line after every row
			System.out.println();
			}
	}
	
	public static void printZ(int size) {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				//print the top and bottom bars
				if(row == 0 || row == size-1) {
					System.out.print("# ");
				}
				
				//print the diagonal
				
				//because size is 7 and numbering of column 
				//starts from 0 so '-1' has to be added to the 
				//equation
				else if(row == (size-1-col)) {	
					System.out.print("# ");
				}
				else
					System.out.print("  ");
				
			}
			
			//print a new line after every row
			System.out.println();			
		}
		
	}

	public static void printXInLines(int size) {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				//print the top and bottom bars
				if(row == 0 || row == size-1) {
					System.out.print("# ");
				}
				
				//print the 'X'
				else if(row == col || row == (size-1-col)) {
					System.out.print("# ");
				}
				else 
					System.out.print("  ");
			}
			
			//print a new line after every row
			System.out.println();
		}
		
	}
	
	public static void printXInBox(int size) {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				//print the bars
				if(row == 0 || row == size-1) {
					System.out.print("# ");
				}
				
				//print the 'X' and the side, vertical bars
				else if(col == 0 || col == row || row == (size-1-col) || col == size-1) {
					System.out.print("# ");
				}
				else
					System.out.print("  ");
			}
			
			//print a new line after every row
			System.out.println();
		}
		
	}



}
