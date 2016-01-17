package assignment1;

import java.util.*;

/*******************************************************************
 * BankAccount class has the attributes for a normal bank account
 * like name and balance.
 * @author Nick
 *
 *******************************************************************/
abstract class BankAccount {

	private String firstName;
	private String lastName;
	private double initialBalance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public BankAccount(String firstName, String lastName, double initialBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.initialBalance = initialBalance;
	}
	
	//Setters and Getters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getInitialBalance() {
		return initialBalance;
	}
	
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	/* Add transaction */
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	/* Get transaction list */
	public List<Transaction> getTransactionList() {
		return transactions;
	}
	
	//abstract method
	public abstract void generateInterest();
}


/*******************************************************************
 * SavingAccount class has the attributes for a savings bank account
 * like interest and interestRate. There is an arraylist which holds
 * the transation objects.
 * The method in super class is overridden.
 * @author Nick
 *
 *******************************************************************/
class SavingAccount extends BankAccount {
	
	private double interest;
	private static double interestRate;
	
	/* Constructor with arguments */
	public SavingAccount(String firstName, String lastName, double initialBalance) {
		super(firstName, lastName, initialBalance);
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		SavingAccount.interestRate = interestRate;
	}

	/* Generate the interest */
	public void generateInterest() {
		interest = super.getInitialBalance() * interestRate; 
	}
	
	@Override
	public void setInitialBalance(double initialBalance) {
		super.setInitialBalance(interest + initialBalance);
	}
	
}

class Transaction {
	private Calendar date;
	private SavingAccount sender;
	private SavingAccount receiver;
	private double amount;
	
	/* Constructor */
	public Transaction(Calendar date, SavingAccount sender2, SavingAccount receiver2, double amount) {
		this.date = date;
		this.sender = sender2;
		this.receiver = receiver2;
		this.amount = amount;
	}
	
	/* Accessor and mutator methods */
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public SavingAccount getSender() {
		return sender;
	}

	public void setSender(SavingAccount sender) {
		this.sender = sender;
	}

	public SavingAccount getReceiver() {
		return receiver;
	}

	public void setReceiver(SavingAccount receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}	
}

public class Tester {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Creating saving accounts
		SavingAccount sender = new SavingAccount("Harris", "Pent", 208.30);
		SavingAccount receiver = new SavingAccount("Peter", "Cart", 392.02);
		
		System.out.println("Please enter the amount of money you want to transfer: ");
		double transferAmount = scanner.nextDouble();
		
		/* Checking if the transfer of funds is possible */
		if(transferFund(sender, receiver, transferAmount)) {
			System.out.println("Transer successful.");
		}
		else 
			System.out.println("Transfer unsuccessful.");
		
		/* Printing transaction details */
		if(!receiver.getTransactionList().isEmpty()) {
			for(Transaction t: receiver.getTransactionList()) {
				System.out.println("Sender's name is " + ((BankAccount) t.getSender()).getFirstName() + " " + t.getSender().getLastName() + 
						" and he transferred $"+ transferAmount + ".");
			}
		}
	}
	
	public static boolean transferFund(SavingAccount sender, SavingAccount receiver, double amount) {
		Calendar c = Calendar.getInstance();
		
		//Check if the sender has sufficient fund
		if(sender.getInitialBalance() < amount) {
			System.out.println("Insufficient balance. Transaction failed.");
		}
		else {
			//setting new balance
			sender.setInitialBalance(sender.getInitialBalance() - amount);
			receiver.setInitialBalance(receiver.getInitialBalance() + amount);
			
			//Creating new transaction object
			Transaction t1 = new Transaction(c, sender, receiver, amount);
		
			//Adding transaction to sender and receiver accounts
			sender.addTransaction(t1);
			receiver.addTransaction(t1);
			
			return true;
		}
		return false;		
	}
}

