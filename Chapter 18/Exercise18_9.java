//Author: Cameron Hiatt
//Date Created: 6-25-2020

import java.util.Scanner;

public class Exercise18_9 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String s;
		String s2;
	
		System.out.print("Type a string to be reversed: ");
		s = input.next();
		
		s2 = reverseDisplay(s);
		
		System.out.println("Reversed string is " + s2);
		
		input.close();
		
	}
	
	public static String reverseDisplay(String value)
	{
		if (value.isEmpty())
			return value;
		else
			return reverseDisplay(value.substring(1)) + value.charAt(0);
	}
	
}
