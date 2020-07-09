/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-9-2020
*-------------------------------------*/

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest 
{

	@Test
	public void testGetName() 
	{
		String name = "Cameron Hiatt";
		String number = "222-222-2222";
		String email = "camH@gmail.com";
		Customer testCustomer = new Customer(name, number, email);
		assertEquals(testCustomer.getName(), name);
	}
	
	
	@Test
	public void testGetNumber() 
	{
		String name = "Cameron Hiatt";
		String number = "222-222-2222";
		String email = "camH@gmail.com";
		Customer testCustomer = new Customer(name, number, email);
		assertEquals(testCustomer.getNumber(), number);
	}
	
	@Test
	public void testGetEmail() 
	{
		String name = "Cameron Hiatt";
		String number = "222-222-2222";
		String email = "camH@gmail.com";
		Customer testCustomer = new Customer(name, number, email);
		assertEquals(testCustomer.getEmail(), email);
	}
	
	@Test
	public void testToString() 
	{
		String name = "Cameron Hiatt";
		String number = "222-222-2222";
		String email = "camH@gmail.com";
		Customer testCustomer = new Customer(name, number, email);
		String toStringHolder = testCustomer.toString();
		assertEquals(testCustomer.toString(), toStringHolder);
	}

}