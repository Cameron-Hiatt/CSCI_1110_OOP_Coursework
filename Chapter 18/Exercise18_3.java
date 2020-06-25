//Author: Cameron Hiatt
//Date Created: 6-24-2020

import java.util.Scanner;

public class Exercise18_3 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("To find the greatest common divisor, "
				+ "enter two numbers.");
		System.out.print("Enter number 1: ");
		int n1 = input.nextInt();
		System.out.print("Enter number 2: ");
		int n2 = input.nextInt();
		
		System.out.println("The Greatest Common Divisor of "
				+ n1 + " and " + n2 + " is " + gcd(n1, n2));
		
		input.close();
	}
	
	public static int gcd(int n1, int n2)
	{	
		if (n1 % n2 == 0)
			return n2;
		else
			return gcd(n2, (n1 % n2));
	}
}
