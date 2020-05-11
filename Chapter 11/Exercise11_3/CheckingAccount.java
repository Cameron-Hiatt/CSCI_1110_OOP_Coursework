//Author: Cameron Hiatt
//Date Created: 5-7-2020

public class CheckingAccount extends Account
{
	private double overdraftLimit = -500;
	
	CheckingAccount()
	{
		
	}
	
	CheckingAccount(int id, double balance)
	{
		super(id, balance);
	}
	
	CheckingAccount(int id, double balance, double overdraftLimit)
	{
		super(id, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	public double getOverdraftLimit() 
	{
		return overdraftLimit;
	}
	
	public void setOverdraftLimit(double overdraftLimit)
	{
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount)
	{
		double finishedTransaction = 0;
		
		finishedTransaction = getBalance() - amount;
		
		if (finishedTransaction < overdraftLimit)
		{
			System.out.println("\nUnable to process transaction, Overdraft Limit reached.");
		}
		else
			setBalance(finishedTransaction);
	}
	
	@Override
	public String toString() 
	{
		return "\nChecking Account" + "\nAccount ID: " + getID() + "\nBalance: " + getBalance() + "\nMonthly Interest Rate: " + 
				getMonthlyInterestRate() + "\nDate Created: " + getDateCreated() + 
				"\nOverdraft Limit: " + overdraftLimit;
    }
}


