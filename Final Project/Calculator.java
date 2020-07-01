/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/

public class Calculator 
{
	/**
	 * The calculatePremiumQuote method does a calculation based on premium prices to decide what unit is needed to 
	 * provide the services requested, that unit's cost, the price that each service will add up to monthly, and the total cost
	 * at the end of the determined contract length that includes both unit price and the total of all payments made during the contract.
	 * It returns an array containing this information.
	 * 
	 * <pre>Example: calculatePremiumQuote({1, 3, 5, 7, 0, 0, 0, 8}, 3) returns {2100, 115, 6240}</pre>
	 *  
	 * @param services (int array, these correspond with different services offered that the user chose earlier.)
	 * @param contract (int, this is a number representing one of 5 possible contract lengths for the services required.)
	 * @return result (int array, this is an array containing unit cost, monthly payment amount, and total cost of contract.)
	 */
	public static int[] calculatePremiumQuote(int[] services, int contract)
	{
		int[] result = new int[3];
		int unitCost = 0;
		int monthlyCost = 0;
		int totalCost = 0;
		int counter = 0;
		int service = 0;
		boolean priChecker = false;
		int[][] productPrice = {	{1000, 1500},//4Port, 4Port PRI cost respectively
									{1600, 2100}};//8Port, 8Port PRI cost respectively
		int[] serviceLength = {12, 24, 36, 48, 60}; //This is in months
		int[][] servicePrice = {	{30, 30, 30, 30, 30, 30, 30, 35},//12 month rate
									{26, 26, 26, 26, 26, 26, 26, 31},//24 month rate
									{22, 22, 22, 22, 22, 22, 22, 27},//36 month rate
									{18, 18, 18, 18, 18, 18, 18, 23},//48 month rate
									{12, 12, 12, 12, 12, 12, 12, 17}};//60 month rate
		
		//for loop to see how many services are requested and determine if a PRI unit is needed
		for(int i = 0; i < services.length; i++)
		{
			if(services[i] > 0)
				counter++;
			if(services[i] == 8)
				priChecker = true;
		}
		
		//if else chain to determine individual unit cost based on how many services were chosen and if there was a PRI service requested
		if(counter > 4 && priChecker == true)
			unitCost = productPrice[1][1];
		else if(counter > 4 && priChecker == false)
			unitCost = productPrice[1][0];
		else if(counter <= 4 && priChecker == true)
			unitCost = productPrice[0][1];
		else if(counter <= 4 && priChecker == false)
			unitCost = productPrice[0][0];
		
		for(int j = 0; j < services.length; j++)
		{
			if(services[j] != 0)
			{
				service = services[j];
				monthlyCost += servicePrice[contract-1][service-1];
			}
		}
		
		totalCost = (monthlyCost * serviceLength[contract-1]) + unitCost;
		
		result[0] = unitCost;
		result[1] = monthlyCost;
		result[2] = totalCost;
		
		
		return result;
	}//end of calculatePremiumQuote method
	
	/**
	 * The calculateIndependentQuote method does a calculation based on independent business prices to decide what unit is needed to 
	 * provide the services requested, that unit's cost, the price that each service will add up to monthly, and the total cost
	 * at the end of the determined contract length that includes both unit price and the total of all payments made during the contract.
	 * It returns an array containing this information.
	 * 
	 * <pre>Example: calculateIndependentQuote({1, 3, 5, 7, 0, 0, 0, 8}, 3) returns {2600, 165, 8540}</pre>
	 *  
	 * @param services (int array, these correspond with different services offered that the user chose earlier.)
	 * @param contract (int, this is a number representing one of 5 possible contract lengths for the services required.)
	 * @return result (int array, this is an array containing unit cost, monthly payment amount, and total cost of contract.)
	 */
 	public static int[] calculateIndependentQuote(int[] services, int contract)
	{
		int[] result = new int[3];
		int unitCost = 0;
		int monthlyCost = 0;
		int totalCost = 0;
		int counter = 0;
		int service = 0;
		boolean priChecker = false;
		int[][] productPrice = {	{1500, 2000},//4Port, 4Port PRI cost respectively
									{2100, 2600}};//8Port, 8Port PRI cost respectively
		int[] serviceLength = {12, 24, 36, 48, 60}; //This is in months
		int[][] servicePrice = {	{40, 40, 40, 40, 40, 40, 40, 45},//12 month rate
									{36, 36, 36, 36, 36, 36, 36, 41},//24 month rate
									{32, 32, 32, 32, 32, 32, 32, 37},//36 month rate
									{28, 28, 28, 28, 28, 28, 28, 33},//48 month rate
									{22, 22, 22, 22, 22, 22, 22, 28}};//60 month rate
		
		//for loop to see how many services are requested and determine if a PRI unit is needed
		for(int i = 0; i < services.length; i++)
		{
			if(services[i] > 0)
				counter++;
			if(services[i] == 8)
				priChecker = true;
		}
		
		//if else chain to determine individual unit cost based on how many services were chosen and if there was a PRI service requested
		if(counter > 4 && priChecker == true)
			unitCost = productPrice[1][1];
		else if(counter > 4 && priChecker == false)
			unitCost = productPrice[1][0];
		else if(counter <= 4 && priChecker == true)
			unitCost = productPrice[0][1];
		else if(counter <= 4 && priChecker == false)
			unitCost = productPrice[0][0];
		
		for(int j = 0; j < services.length; j++)
		{
			if(services[j] != 0)
			{
				service = services[j];
				monthlyCost += servicePrice[contract-1][service-1];
			}
		}
		
		totalCost = (monthlyCost * serviceLength[contract-1]) + unitCost;
		
		result[0] = unitCost;
		result[1] = monthlyCost;
		result[2] = totalCost;
		
		
		return result;
	}//end of calculateIndependentQuote method
}
