package CSUTutorials;

/* Account class*/
public class Account {
	
	private String name;
	private int accID;
	protected double bal;
	private int count = 0;
	
	/* Default empty constructor */
	public Account() {}
	
	/* Parameterised constructor */
	public Account(String name, double bal) {
		this.name = name;
		this.accID = ++count;
		this.bal = bal;
	}
	
	/* Mutator method for deposit */
	public boolean saveDeposit(int accID, double deposit) {
		
		//deposit only if the account ID is correct and the deposit amount is positive
		if(this.accID == accID && deposit > 0) {
			bal+= deposit;
			return true;
		}
		else 
			return false;
	}
}

/* InterestBearing interface */
interface InterestBearing {
	boolean addInterest(double rate);
}

/* SavingsAccount class */
class SavingsAccount extends Account implements InterestBearing {
	
	public boolean addInterest(double interestRate) {
		
		//add interest only if the balance and the interest rate are positive
		if(this.bal > 0 && interestRate > 0) {
			bal+= interestRate * bal;
			return true;
		}
		else
			return false;		
	}
}
