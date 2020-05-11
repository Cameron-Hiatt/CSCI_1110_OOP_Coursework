//Author: Cameron Hiatt
//Date Created: 5-7-2020

public class SavingsAccount extends Account
{
	SavingsAccount()
	{
		
	}
	
	SavingsAccount(int id, double balance)
	{
		super(id, balance);
	}
	
	@Override
	public String toString() 
	{
		return "\nSavings Account" + "\nAccount ID: " + getID() + "\nBalance: " + getBalance() + "\nMonthly Interest Rate: " + 
				getMonthlyInterestRate() + "\nDate Created: " + getDateCreated();
    }
}
