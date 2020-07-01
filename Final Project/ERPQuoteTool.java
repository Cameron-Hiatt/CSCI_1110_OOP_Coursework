/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		February 27th, 2020
|Modified:	July 1st, 2020
*-------------------------------------*/

import java.util.Scanner;

/*---------------------------------------------------------------------------------------------------------------------* 
|TO DO LIST:
|	> Make MainGUI.java the main driver <
|	> Separate the methods and such out into a more organized format while retaining how it works right now <
|	> Make Calculator class with methods to calculate the proper customer prices <
|	> Create a GUI that replaces the UI that goes on in the current program 
*----------------------------------------------------------------------------------------------------------------------*/


/**
 * <h1>JavaDoc Test</h1>
 * <p>The ERPQuoteTool class is a mock up quote generator for the Epik company.
 * The prices here are not actual prices and this is meant to be a type of what could be used as a tool to help
 * generate quotes for potential customers on products and services they need. </p>
 * 
 * <p>Created: February 25th, 2020</p>
 * @author Cameron Hiatt
 *
 */
public class ERPQuoteTool 
{	
	public static void start()
	{
		Scanner input = new Scanner(System.in);
		int customerType = 0;
		
		System.out.print("Welcome to the Epik Quote Tool!\nThis tool is provided to get you the most accurate quote possible on our");
		System.out.println(" products and services. Continue through the following prompts to get your custom quote!\n");
		
		System.out.println("Please select one of the following that applies to your company (Key in the number beside your option and press enter)");
		System.out.println("1. Premium Business Customer");
		System.out.println("2. Independent Business Customer");
		System.out.println("3. Exit\n");
		System.out.print("Answer: ");
		
		//a do while loop that contains a nested while loop to prevent any invalid input from being accepted and exiting the program early
		do
		{
			while(!input.hasNextInt())
			{
				input.next();
				System.out.print("Invalid input\nPlease enter a 1, 2, or 3: ");
			}
			customerType = input.nextInt();
			
			if(customerType == 3)
				System.exit(0);
			
			if(customerType > 2 || customerType < 1)
				System.out.print("Invalid input\nPlease enter a 1, 2, or 3: ");
			
		}while(customerType > 2 || customerType < 1);
		
		//passes control to 1 of 2 methods that calculate different pricing on the quote depending on the customer
		if(customerType == 1)
			Customer.premiumCustomer();
		else
			Customer.independentCustomer();
		
		input.close();
		
	}//end of main method
}//end of ERPQuoteTool class
