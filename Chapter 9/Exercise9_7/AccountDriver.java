//Author: Cameron Hiatt
//Date Created: 3-6-2020

import java.util.Date;

public class AccountDriver
{
	public static void main(String[] args)
	{
		Account account1 = new Account(1122, 20000);
		
		account1.setAnnualInterestRate(0.045);
		
		account1.withdraw(2500);
		account1.deposit(3000);
		
		System.out.printf("After withdrawing 2500 and depositing 3000, your balance is: $%.2f\n", account1.getBalance());
		System.out.println("\nMonthly interest: $" + account1.getMonthlyInterest());
		System.out.println("This account was created on: " + account1.getDateCreated());
		
	}//end of main method
}//end of AccountDriver class