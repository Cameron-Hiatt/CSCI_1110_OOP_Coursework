//Author: Cameron Hiatt
//Date Created: 5-7-2020

import java.util.Date;

public class Account 
{
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();
	
	Account()
	{	
	}//end of default constructor
	
	Account(int id, double balance)
	{
		this.id = id;
		this.balance = balance;
	}//end of 2 arg constructor
	
	public int getID()
	{
		return id;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public double getMonthlyInterestRate()
	{
		return getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest()
	{
		return getMonthlyInterestRate() * getBalance();
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public void withdraw(double amount)
	{
		double finishedTransaction = 0;
		
		finishedTransaction = getBalance() - amount;
		
		if (finishedTransaction < 0)
		{
			System.out.println("\nUnable to process transaction, insufficient funds to withdraw " + amount);
		}
		else
			setBalance(finishedTransaction);
	}
	
	public void deposit(double amount)
	{
		double finishedTransaction = 0;
		finishedTransaction = getBalance() + amount;
		setBalance(finishedTransaction);
	}
	
	@Override
	public String toString() 
	{
		return "\nAccount ID: " + getID() + "\nBalance: " + getBalance() + "\nMonthly Interest Rate: " + 
				getMonthlyInterestRate() + "\nDate Created: " + getDateCreated();
    }
	
}// end of Account class