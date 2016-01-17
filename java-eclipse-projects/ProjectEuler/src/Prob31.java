/* Defines the total ways to make 200 pences using the given coinSizes */
public class Prob31 {
	
	public static void main(String[] args) {
		int target = 200;//
		int[] coinSizes = {1,2,5,10,20,50,100,200};
		int[] ways = new int[target+1];//it's 'target+1' because counting starts at 0
		ways[0] = 1;//set the first value in the array
		
		for(int i = 0; i<coinSizes.length; i++) {//looping through the coin sizes
			for(int j = coinSizes[i]; j<=target; j++) {//looping from the coin size till the target
				ways[j]+= ways[j-coinSizes[i]];
			}
		}
		
		System.out.println(ways[target]);//last element in the array
	}
}
//help can be fount at
//"http://users.softlab.ntua.gr/~ttsiod/euler31.html"
