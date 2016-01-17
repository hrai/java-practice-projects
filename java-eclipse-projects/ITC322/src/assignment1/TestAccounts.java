package assignment1;

import java.util.Arrays;

/**
 * The Class TestAccounts.
 */
public class TestAccounts
{
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args)
    {
        BaseAccount[] list = new BaseAccount[5];

        list[0] = new SavingsAccount("Fred");
        list[1] = new ChequeAccount("Jim");
        list[2] = new ChequeAccount("Sue");
        list[3] = new SavingsAccount("Jim");
        list[4] = new SavingsAccount("Jill");

        System.out.println("***************************************************************");
        System.out.println("CHEQUE ACCOUNTS - Setting Credit Limit");
        System.out.println();
        
        int i;
        
        // In the following loops do NOT use your knowledge
        // of which member of list[] is of which type
        for (i = 0; i < 5; i++) {
            /* Insert code setting 50.0 credit limits */
        	if(list[i] instanceof ChequeAccount) {
        		((ChequeAccount) list[i]).setCreditLimit(50.0);
        		System.out.println(list[i]);
        	}
        }
        
        separator();
        System.out.println("DEPOSITING MONEY");
        System.out.println();
        
        
        for (i = 0; i < 5; i++) {
            /* Code depositing 20.0 in each account */
        	list[i].deposit(20.0);
            System.out.println(list[i]);
        }
        
        separator();
        System.out.println("WITHDRAWING MONEY");
        System.out.println();
        
        
        for (i = 0; i < 5; i++) {
            /* Code withdrawing 25.0 from each account */
        	BaseAccount acct = list[i];
        	boolean result;
        	
        	if(acct instanceof SavingsAccount) {
        		result = ((SavingsAccount) acct).withdraw(25.0);
        	}
        	else
        		result = ((ChequeAccount) acct).withdraw(25.0);
        	
            System.out.println(list[i]);
            
            if(result)
            	System.out.println("The withdraw has been successful.");
            else
            	System.out.println("There isn't enough fund in the account for withdrawal.");
            
            System.out.println();
        }

        separator();
        System.out.println("ADDING INTEREST");
        System.out.println();
        
        for (i = 0; i < 5; i++) {
            /* Code adding 8.0% interest as applicable */
        	if(list[i] instanceof SavingsAccount) {
        		((SavingsAccount) list[i]).addInterest(8);
        	}
            System.out.println(list[i]);
        }

        separator();
        System.out.println("SORTING THE ACCOUNT BY OWNER'S NAME");
        System.out.println();
        
        /* Code to sort the accounts by owner's name */
        Arrays.sort(list);
        for (i = 0; i < 5; i++) {        	
            System.out.println(list[i]);
        }
        
        System.out.println("***************************************************************");
        
        /* Testing equality of the Account objects. */
        if(list[0].equals(list[3])) {
        	System.out.println("The accounts are equal.");
        }
        else 
        	System.out.println("The accounts aren't equal.");
        
        System.out.println("***************************************************************");
        
    }
    
    /**
     * Prints the separator.
     */
    public static void separator() {

        System.out.println("**********************ACCOUNT DETAILS**************************");
        
    }
    
}

        