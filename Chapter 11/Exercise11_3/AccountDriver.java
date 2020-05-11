//Author: Cameron Hiatt
//Date Created: 3-6-2020

public class AccountDriver
{
	public static void main(String[] args)
	{
		Account account1 = new Account(1122, 20000);
		CheckingAccount account2 = new CheckingAccount(6194, 3895);
		Account account3 = new SavingsAccount(2489, 790568);
		
		account1.setAnnualInterestRate(0.045);
		account2.setAnnualInterestRate(0.045);
		account3.setAnnualInterestRate(0.045);
		
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
		
		System.out.println("\nTrying to withdraw too much from generic account and savings account, showing"
				+ " overdraft limit works on checking account.");
		account1.withdraw(20001);
		account2.withdraw(3995);
		account3.withdraw(790569);
		
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
		
		System.out.println("\nTrying to withdraw 1 dollar more than the overdraft limit from checking.");
		account2.withdraw(401);
		
		System.out.println(account2);
		
	}//end of main method
}//end of AccountDriver class