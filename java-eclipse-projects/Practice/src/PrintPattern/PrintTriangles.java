package PrintPattern;

public class PrintTriangles {

	public static void printA(int size) {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("# ");
			}
			//print line at the end of each row
			System.out.println();
		}
	}
	
	public static void printB(int size) {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<(size-i); j++) {
				System.out.print("# ");
			}
			
			//print new line at the end of each row
			System.out.println();
		}
		
		/*
		 * This code also produces the same result
		 * for(int i=0; i<size; i++) {
			for(int j=i; j<size; j++) {
				System.out.print("# ");
			}
			
			//print new line at the end of each row
			System.out.println();
		}
		 */
	}
	
	public static void printC(int size) {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				
				if(j<i) {
					//print the blanks before '#'
					System.out.print("  ");
				}
				else
					System.out.print("# ");
			}
			
			//print new line at the end of each row
			System.out.println();
		}
	}
	
	public static void printD(int size) {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				
				if(j<((size-1)-i)) {	//(size-1) gives the column number
					
					//print the blanks before '#'
					System.out.print("  ");
				}
				else
					System.out.print("# ");
			}
			
			//print a line at the end of each row
			System.out.println();
		}
	}
	
	public static void printJ(int size) {
		int index = size/2;
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				//print the lines of the triangle
				if(Math.abs(col-index)<=index) {
					System.out.print("# ");
					index-= 2;
				}
				else
					System.out.print("  ");
				
			}
			
			//print a new line after every row
			System.out.println();
		}
	}
}
