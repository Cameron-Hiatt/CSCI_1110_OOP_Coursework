//Author: Cameron Hiatt
//Date Created: 3-6-2020

import java.util.Date;
import java.util.Scanner;
import javax.print.*;

public class AccountDriver
{
	public static void main(String[] args)
	{
		Account[] accounts = new Account[10];
		Scanner input = new Scanner(System.in);
		int userInput = 0;
		int accountActionAmount = 0;
		boolean validator = true;
		int atmStatus = 0;
		int userAccount = 999;
		
		//creates each of 10 accounts with starting balance of 100
		for(int i = 0; i < accounts.length; i++)
		{
			accounts[i] = new Account(i, 100);
		}
		
		//main while loop that keeps the atm running always
		while(atmStatus == 0)
		{
			//do while for entering valid account ID's
			do
			{
				System.out.print("Enter account ID: ");
				userAccount = input.nextInt();
				
				validator = false;
				
				for(int j = 0; j < accounts.length; j++)
				{
					if(userAccount == accounts[j].getID())	
						validator = true;	
				}
				
				if(validator == false)
					System.out.println("Invalid ID");

			}while(validator == false);
			
			System.out.println("ACCOUNT FOUND");
			userInput = 0;
		
			//while loop to ensure so long as they don't press exit, they can manipulate their account as desired
			while(userInput != 4)
			{
				System.out.print("\n1.View Current Balance\n2.Make Deposit \n3.Withdraw From Account\n4.Exit\nSelection: ");
				userInput = input.nextInt();
				switch (userInput)
				{
					case 1: System.out.print("\nCurrent balance in this account is: " + accounts[userAccount].getBalance());
							break;
							
					case 2: System.out.print("\nAmount to be deposited: ");
							accountActionAmount = input.nextInt();
							accounts[userAccount].setBalance(accounts[userAccount].getBalance() + accountActionAmount);
							break;
							
					case 3:	System.out.print("\nAmount to be withdrawn: ");
							accountActionAmount = input.nextInt();
							accounts[userAccount].setBalance(accounts[userAccount].getBalance() - accountActionAmount);
							break;
							
					case 4: System.out.println("Thank you\n");
							break;
							
					default:System.out.println("\nInvalid selection");
							break;
				}//end of switch userInput
			}//end userInput while loop
		}// end of atmStatus while loop	
	}//end of main method
}//end of AccountDriver class