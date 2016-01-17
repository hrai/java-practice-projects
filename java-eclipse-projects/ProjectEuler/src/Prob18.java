import java.io.*;

public class Prob18 {

	private static int[][] arr;
	
	public static void main(String[] args) {
		
		//reading file's contents and storing them into an array named as 'arr'
		readAndStoreNumbers();
		
		//applying the bottom-up algorithm to calculate the path with largest value
		for(int i=arr.length-1; i>0; i--) {
			for(int col=0; col<arr[i].length-1; col++) {
				arr[i-1][col] = Math.max(arr[i][col]+arr[i-1][col],arr[i][col+1]+arr[i-1][col]);
			}
		}
		
		//printing the first element in the array which is the largest value path
		System.out.println(arr[0][0]);
		
	}
	
	//reading the contents of the file into an array
	public static void readAndStoreNumbers() {
		//initialising the new object
		arr = new int[15][]; 
		
		try{
			//create file reader
			File f = new File("E:\\Eclipse Projects\\triangle.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			//read from file
			String nums;
			int index = 0;
			while((nums = br.readLine()) != null) {
				String[] numbers = nums.split(" ");
				arr[index] = new int[numbers.length];	//initialising the second array
				
				//store the numbers into 'arr' after converting into integers
				for(int i=0; i<arr[index].length; i++) {
					arr[index][i] = Integer.parseInt(numbers[i]);
				}
				index++;
			}
			
			//Closing the buffered reader
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
