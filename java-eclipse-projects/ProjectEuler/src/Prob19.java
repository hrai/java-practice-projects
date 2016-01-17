
public class Prob19 {
	
	//because the 1st of January, 1901 fell on Tuesday
	static int day = 2;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
			int noOfS = 0;// number of sundays
			int m = 0;
			int no = 0;
		
		for(int year = 1901; year<2001; year++) {
			if(isLeap(year)) {	//loop through years
				m++;
				for(int month = 1; month<13; month++) {	//loop through months
					
					switch(month) {	
					
					//The first day of the month indexed as the total number of days since 1st of Jan., 1901
					//which is done by adding the total number of days in previous month to 'day' variable.
					//This ensures that 'day' variable points right to the first day of the month. If that number 
					//is exactly divisible is '7' then the number of Sundays 'noOfS' is increased because we know 
					//that the 7th day in the week is sunday as we started our 'day' on Tuesday which was the 
					//second day in the week.
					case(1): 	
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;
					break;
					
					case(2): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 29;	// 29 days in feb in a leap year
					break;
					
					case(3): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(4): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(5):
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					} day+= 31;break;
					
					case(6): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(7): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(8): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(9): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(10): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(11): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(12): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					}
				}
			}
			else {
				no++;
				for(int month = 1; month<13; month++) {
					
					switch(month) {
					case(1): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;				
					break;
					
					case(2): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 28;	//normal year has 28 days in feb
					break;
					
					case(3): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(4): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(5): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(6): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(7): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(8): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(9): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(10): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					case(11): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 30;break;
					
					case(12): 
					if(day%7 == 0) {
						noOfS++;System.out.println(year);
					}day+= 31;break;
					
					}
				}
			}
			
		}
		System.out.println(noOfS);
	}
	
	public static boolean isLeap(int y) {
		if(y%100 == 0 && y%400 != 0) {
			return false;
		}
		else if(y%4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
