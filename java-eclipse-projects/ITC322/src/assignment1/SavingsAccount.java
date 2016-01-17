package assignment1;

/**
 * The Class SavingsAccount.
 */
public class SavingsAccount extends BaseAccount {
	
	/**
	 * Instantiates a new savings account.
	 *
	 * @param name the name
	 */
	public SavingsAccount(String name) {
		super(name);
	}
	
	/* (non-Javadoc)
	 * @see assignment1.BaseAccount#deposit(double)
	 */
	@Override
	public boolean deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Withdraw an amount from the account after amount is checked for 
	 * positivity.
	 * @param amount the amount to withdraw
	 * @return true if balance is positive and transaction is successful
	 * otherwise false
	 */
	public boolean withdraw(double amount) {
		if(amount > 0) {
			if(balance >= amount) {
				balance -= amount;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Increases balance according to the interest rate. Prior to adding 
	 * interest, the rate is checked if it is positive.
	 * @param interestRate the current interest rate on the account
	 * @return true if rate is positive and transaction is successful 
	 * else false
	 */
	public boolean addInterest(double interestRate) {
		if(interestRate > 0) {
			balance += (interestRate/100 * balance);
			return true;
		}
		return false;
	}
}
