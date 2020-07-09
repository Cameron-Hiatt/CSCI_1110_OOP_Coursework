/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-9-2020
*-------------------------------------*/

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest 
{

	@Test
	public void testCalculatePremiumQuote() 
	{
		int[] services = {1, 3, 5, 7, 0, 0, 0, 8};
		int contract = 3;
		int[] result = {2100, 115, 6240};
		assertArrayEquals(Calculator.calculatePremiumQuote(services, contract), result);
		
		int[] services2 = {1, 2, 3, 0, 0, 0, 0, 0};
		int contract2 = 1;
		int[] result2 = {1000, 90, 2080};
		assertArrayEquals(Calculator.calculatePremiumQuote(services2, contract2), result2);
	}
	
	
	@Test
	public void testCalculateindependentQuote() 
	{
		int[] services = {1, 3, 5, 7, 0, 0, 0, 8};
		int contract = 3;
		int[] result = {2600, 165, 8540};
		assertArrayEquals(Calculator.calculateIndependentQuote(services, contract), result);
		
		int[] services2 = {1, 2, 3, 0, 0, 0, 0, 0};
		int contract2 = 1;
		int[] result2 = {1500, 120, 2940};
		assertArrayEquals(Calculator.calculateIndependentQuote(services2, contract2), result2);
	}

}
