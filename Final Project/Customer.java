import java.util.Scanner;

/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/


public class Customer 
{
	/**
	 * The premiumCustomer method prompts the user for information based on their answer given in the main method. 
	 * The main difference in this method from future methods is that it calls a specific calculation method for a premium quote 
	 * rather than an independent business quote.
	 * 
	 * <pre>Example: premiumCustomer();</pre>
	 */
	public static void premiumCustomer()
	{
		Scanner input = new Scanner(System.in);
		
		int[] quote = new int[3];
		String[] productName =  {"4Port", "4Port PRI", "8Port","8Port PRI"};
		int[] productPrice = {1000, 1500, 1600, 2100};//8Port, 8Port PRI cost respectively
		
		String[] serviceName = {"Telephone Line", "Fax Line", "Fire Alarm", "Security Alarm", "Elevator Alarm", "Internet Failover", "Emergency Call Box", "PRI Telephone Line"};

		int[] userSelection = new int[8];
		int userContract = 0;
		boolean validity = false;
		int unitType = 0;
		
		System.out.println("Please select the services to be used up to 8 total");
		System.out.println("__________________________________________________________________"
				+ "_______________________________________________________________________");
		System.out.println("Input the number next to the desired service followed by a space, "
				+ "then press enter when all desired services (up to 8 total) are selected");
		System.out.println("Example: 1 2 3 8 0 0 0 0");
		System.out.println("__________________________________________________________________"
				+ "_______________________________________________________________________");
		System.out.println("0. No Service\n"
						 + "1. Telephone Line\n"
						 + "2. Fax Line\n"
						 + "3. Fire Alarm\n"
						 + "4. Security Alarm\n"
						 + "5. Elevator Alarm\n"
						 + "6. Internet Failover\n"
						 + "7. Emergency Call Box\n"
						 + "8. PRI Telephone Line\n");
		
		//A do while loop that will repeat until valid integer input is given from the user
		do
		{
			validity = true;
			System.out.print("Your input: ");
			for(int i = 0; i < userSelection.length; i++)
				userSelection[i] = input.nextInt();
			
			//for loop that checks validity of user's input
			for(int j = 0; j < userSelection.length; j++)
				if(userSelection[j] < 0 || userSelection[j] > 8)
					validity = false;
			
			//Displays error message if invalid input was found
			if(validity == false)
				System.out.println("One or more of your inputs was invalid, please try again.");
			
		}while(validity == false);
		
		System.out.println("Please select how long this service contract will be");
		System.out.println("_______________________________________________________________");
		System.out.println("Input one of the numbers next to the projected contract length");
		System.out.println("_______________________________________________________________");
		System.out.println("1. 12 Months\n"
					 	 + "2. 24 Months\n"
						 + "3. 36 Months\n"
						 + "4. 48 Months\n"
						 + "5. 60 Months\n"
						 + "6. Exit Program\n");
		System.out.print("Your input: ");
		
		//a do while loop that contains a nested while loop to prevent any invalid input from being accepted and exiting the program early
		do
		{
			while(!input.hasNextInt())
			{
				input.next();
				System.out.print("Invalid input\nPlease enter a number between 1-5: ");
			}
			userContract = input.nextInt();
			
			if(userContract == 6)
				System.exit(0);
			
			if(userContract > 5 || userContract < 1)
				System.out.print("Invalid input\nPlease enter a number between 1-5: ");
			
		}while(userContract > 5 || userContract < 1);
		
		quote = Calculator.calculatePremiumQuote(userSelection, userContract);
		
		for(int j = 0; j < productPrice.length; j++)
			if(quote[0] == productPrice[j])
				unitType = j;
		
		System.out.println("Based on your needs of the following services:");
		for(int i = 0; i < userSelection.length; i++)
			if(userSelection[i] != 0)
				System.out.print(serviceName[userSelection[i] - 1] + ", ");
			System.out.println("\n");
			System.out.println("Your Custom quote prices come out to the following");
			System.out.println("Unit model needed:" + productName[unitType] + "\nUnit Price: $" + quote[0]);
			System.out.println("Monthly Cost: $" + quote[1]);
			System.out.println("Total Cost at end of contract: $" + quote[2]);
			
			input.close();
		
	}//End of premiumCustomer method
	
	/**
	 * The independentCustomer method prompts the user for information based on their answer given in the main method. 
	 * The main difference in this method from future methods is that it calls a specific calculation method for an independent quote 
	 * rather than a premium business quote.
	 * 
	 * <pre>Example: independentCustomer();</pre>
	 */
 	public static void independentCustomer()
	{
 		Scanner input = new Scanner(System.in);
		
		int[] quote = new int[3];
		String[] productName =  {"4Port", "4Port PRI", "8Port","8Port PRI"};
		int[] productPrice = {1500, 2000, 2100, 2600};//8Port, 8Port PRI cost respectively
		
		String[] serviceName = {"Telephone Line", "Fax Line", "Fire Alarm", "Security Alarm", "Elevator Alarm", "Internet Failover", "Emergency Call Box", "PRI Telephone Line"};

		int[] userSelection = new int[8];
		int userContract = 0;
		boolean validity = false;
		int unitType = 0;
		
		System.out.println("Please select the services to be used up to 8 total");
		System.out.println("__________________________________________________________________"
				+ "_______________________________________________________________________");
		System.out.println("Input the number next to the desired service followed by a space, "
				+ "then press enter when all desired services (up to 8 total) are selected");
		System.out.println("Example: 1 2 3 8 0 0 0 0");
		System.out.println("__________________________________________________________________"
				+ "_______________________________________________________________________");
		System.out.println("0. No Service\n"
						 + "1. Telephone Line\n"
						 + "2. Fax Line\n"
						 + "3. Fire Alarm\n"
						 + "4. Security Alarm\n"
						 + "5. Elevator Alarm\n"
						 + "6. Internet Failover\n"
						 + "7. Emergency Call Box\n"
						 + "8. PRI Telephone Line\n");
		
		//A do while loop that will repeat until valid integer input is given from the user
		do
		{
			validity = true;
			System.out.print("Your input: ");
			for(int i = 0; i < userSelection.length; i++)
				userSelection[i] = input.nextInt();
			
			//for loop that checks validity of user's input
			for(int j = 0; j < userSelection.length; j++)
				if(userSelection[j] < 0 || userSelection[j] > 8)
					validity = false;
			
			//Displays error message if invalid input was found
			if(validity == false)
				System.out.println("One or more of your inputs was invalid, please try again.");
			
		}while(validity == false);
		
		System.out.println("Please select how long this service contract will be");
		System.out.println("_______________________________________________________________");
		System.out.println("Input one of the numbers next to the projected contract length");
		System.out.println("_______________________________________________________________");
		System.out.println("1. 12 Months\n"
					 	 + "2. 24 Months\n"
						 + "3. 36 Months\n"
						 + "4. 48 Months\n"
						 + "5. 60 Months\n"
						 + "6. Exit Program\n");
		System.out.print("Your input: ");
		
		//a do while loop that contains a nested while loop to prevent any invalid input from being accepted and exiting the program early
		do
		{
			while(!input.hasNextInt())
			{
				input.next();
				System.out.print("Invalid input\nPlease enter a number between 1-5: ");
			}
			userContract = input.nextInt();
			
			if(userContract == 6)
				System.exit(0);
			
			if(userContract > 5 || userContract < 1)
				System.out.print("Invalid input\nPlease enter a number between 1-5: ");
			
		}while(userContract > 5 || userContract < 1);
		
		quote = Calculator.calculateIndependentQuote(userSelection, userContract);
		
		for(int j = 0; j < productPrice.length; j++)
			if(quote[0] == productPrice[j])
				unitType = j;
		
		System.out.println("Based on your needs of the following services:");
		for(int i = 0; i < userSelection.length; i++)
			if(userSelection[i] != 0)
				System.out.print(serviceName[userSelection[i] - 1] + ", ");
			System.out.println("\n");
			System.out.println("Your Custom quote prices come out to the following");
			System.out.println("Unit model needed:" + productName[unitType] + "\nUnit Price: $" + quote[0]);
			System.out.println("Monthly Cost: $" + quote[1]);
			System.out.println("Total Cost at end of contract: $" + quote[2]);
		
			input.close();
		
	}//end of independentCustomer method
}
