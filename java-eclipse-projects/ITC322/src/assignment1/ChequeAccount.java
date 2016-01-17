package assignment1;

/**
 * The Class ChequeAccount.
 */
public class ChequeAccount extends BaseAccount {
	
	/** The credit limit. */
	private double creditLimit;
	
	/**
	 * Instantiates a new cheque account.
	 *
	 * @param name the name of account holder
	 */
	public ChequeAccount(String name) {
		super(name);
		creditLimit = 0;
	}

	/* (non-Javadoc)
	 * @see assignment1.BaseAccount#deposit(double)
	 */
	@Override
	public boolean deposit(double amount) {
		if(amount > 0) {
			balance += amount - 0.30;
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
			if((balance - amount - 0.30 + creditLimit) > 0) {
				balance -= (amount + 0.30);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sets the new credit limit.
	 * @param creditLimit new creditLimit value
	 */
	public void setCreditLimit(double creditLimit) {
		if(creditLimit > 0) {
			this.creditLimit = creditLimit;
		}
	}
	
}
