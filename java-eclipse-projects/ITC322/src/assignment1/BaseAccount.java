package assignment1;

/**
 * An abstract class to represent a basic Bank Account
 * @author Ken Lodge
 * @version 3.0 21/11/05
 */
public abstract class BaseAccount
    implements Comparable<BaseAccount>
{
    private static int nextAcctNumber = 1;
    protected String owner;
    protected int acctNumber;
    protected double balance;

    /**
     * Constructor, used only by subclasses, sets owner,
     * generates unique account number and zeroes balance.
     * @param name owner's name
     */
    protected BaseAccount(String name)
    {
        owner = name;
        acctNumber = nextAcctNumber++;
        balance = 0.0;
    }

    /**
     * Makes a deposit. Implementations will at least verify
     * the amount is positive before making the deposit.
     * @param amount the amount to deposit
     * @return true if amount is positive otherwise false
     */
    public abstract boolean deposit(double amount);

    /**
     * Implements the Comparable interface, making accounts
     * comparable through alphabetical ordering by owner's name.
     */    
    public int compareTo(BaseAccount rhs) {
    	if(this.owner.compareTo(rhs.owner) < 0) {
    		return -1;
    	}
    	else if(this.owner.compareTo(rhs.owner) > 0) {
    		return 1;
    	}
    	else 
    		return 0;
    }

    /**
     * Override equals to be consistent with compareTo
     * 
     * @return true if objects are equal and false if not
     */    
    public boolean equals(Object rhs) {
    	if(this.compareTo((BaseAccount) rhs) == 0) {
    		if(this.balance == ((BaseAccount) rhs).balance) {
    			if(this.acctNumber == ((BaseAccount) rhs).acctNumber) {
    				return true;    				
    			}
    		}
    	}
    	return false;
    }

    /**
     * @return String representation of the object
     */
    public String toString() {
    	return "The owner of the account is " + owner + ".\n" + 
    			"The account number is " + acctNumber + ".\n" + 
    			"The balance is $" + balance + ".\n";
    }
}