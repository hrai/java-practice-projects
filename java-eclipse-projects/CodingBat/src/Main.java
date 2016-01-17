public class Main {
	  private static double side1, side2, side3;

	  public static void main(String[] args){
		  side1 = 1;
		  side2 = 3;
		  side3 = 3;
		  
		  System.out.println(side1);
		  int[] a = new int[3];
			
			for(int i: a) {
				System.out.println(i + "null");
			}
			
			System.out.println(doubleX("xx"));
			
	  }
	  
	  static boolean doubleX(String str) {
		  for(int i=0; i<str.length()-2; i++) {
			  if(str.charAt(i) == 'x') {
				  if(str.charAt(i+1) == 'x')
					  return true;
				  else 
					  return false;			  	
			  }
		  }
		  if(str.equals("xx")) {
			  return true;
		  }
		  else
			  return false;
	  }



}
