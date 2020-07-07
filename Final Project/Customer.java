import java.util.Scanner;

/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/


public class Customer 
{
	public static String[] productName =  {"4Port", "4Port PRI", "8Port","8Port PRI"};
	public static int[] premiumProductPrice = {1000, 1500, 1600, 2100};
	public static int[] independentProductPrice = {1500, 2000, 2100, 2600};
	
	/**
	 * The premiumCustomer method prompts the user for information based on their answer given in the main method. 
	 * The main difference in this method from future methods is that it calls a specific calculation method for a premium quote 
	 * rather than an independent business quote.
	 * 
	 * <pre>Example: premiumCustomer();</pre>
	 */
	public static int[] premiumCustomer(int[] userInput, int contractLength)
	{
		
		int[] quote = new int[3];

		int[] userSelection = userInput.clone();
		int userContract = 0;
		
		userContract = contractLength;
		
		quote = Calculator.calculatePremiumQuote(userSelection, userContract).clone();
		
		return quote;
		/*
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
		*/
		
	}//End of premiumCustomer method
	
	/**
	 * The independentCustomer method prompts the user for information based on their answer given in the main method. 
	 * The main difference in this method from future methods is that it calls a specific calculation method for an independent quote 
	 * rather than a premium business quote.
	 * 
	 * <pre>Example: independentCustomer();</pre>
	 */
 	public static int[] independentCustomer(int[] userInput, int contractLength)
	{
		
		int[] quote = new int[3];
		
		int[] userSelection = new int[8];
		int userContract = 0;
		int unitType = 0;
		
		userSelection = userInput.clone();
		userContract = contractLength;
		
		quote = Calculator.calculateIndependentQuote(userSelection, userContract);
		
		for(int j = 0; j < independentProductPrice.length; j++)
			if(quote[0] == independentProductPrice[j])
				unitType = j;
		
		return quote;
		/*
		System.out.println("Based on your needs of the following services:");
		for(int i = 0; i < userSelection.length; i++)
			if(userSelection[i] != 0)
				System.out.print(serviceName[userSelection[i] - 1] + ", ");
			System.out.println("\n");
			System.out.println("Your Custom quote prices come out to the following");
			System.out.println("Unit model needed:" + productName[unitType] + "\nUnit Price: $" + quote[0]);
			System.out.println("Monthly Cost: $" + quote[1]);
			System.out.println("Total Cost at end of contract: $" + quote[2]);
		
			//input.close();
			 */
		
	}//end of independentCustomer method
 	
}
