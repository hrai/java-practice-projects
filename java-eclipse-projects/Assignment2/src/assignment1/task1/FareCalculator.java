package assignment1.task1;

import java.util.*;//importing util package

public class FareCalculator {
 
    public static void main(String[] args) {
        cal();//calling 'cal' method
        
    }
        
    /*
     * Takes input and calculates the fares
     */
    public static void cal(){
            //declaring variables
            int numAccom = 0;
            int numUnaccom = 0; 
            int totalTakings = 0;
            int group=1, child, adult, senior;
            
            Scanner input = new Scanner(System.in);

            //determining the number of accommodated and unaccommodated children
            while(group == 1){                
                System.out.print("Enter a group? (Yes=1/No=0): ");
                group = input.nextInt();//saving the input to 'group' variable
                
                if(group==0)break;//breaks out of while loop if group's value is 0
                
                System.out.print("Enter the number of children (age 6-15): ");
                child = input.nextInt();//saving the input to 'child' variable

                System.out.print("Enter the number of adults (age 16-59): ");
                adult = input.nextInt();//saving the input to 'adult' variable

                System.out.print("Enter the number of seniors (age 60+): ");
                senior = input.nextInt();//saving the input to 'senior' variable
                
                //saving the total fare of each group to variable fare
                int fare = fares(adult, senior, child, numAccom, numUnaccom);
            
                System.out.printf("Total entry charge is $%d\n", fare);
                
                //calculating the total takings
                totalTakings+=fare;
                
                fare = 0; //setting the value of fare back to 0 for recalculations
                numUnaccom = 0; //setting the value of numUnaccom back to 0
            };
            
            input.close();
            
            //printing the total takings
            System.out.printf("Total takings: $%d\n",totalTakings);
            
    }
    
    /*
     * Calculates and returns the fare of each group
     */
    public static int fares(int adult, int senior, int child, int numAccom, int numUnaccom){
            //declaring variable
            int totalPrice = 0;
            
            //determining how many children can get discount
            if((adult+senior)>0 && child>0){
                    if(child>(adult+senior)){
                        numAccom = adult+senior;
                        numUnaccom = child - numAccom ;
                    }
                    else numAccom = child;
                }
                
                //calculating the total cost
            return totalPrice += (numAccom*2)+(numUnaccom*5)+(adult*10)+(senior*8);
            
    }
}
