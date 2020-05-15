//Author: Cameron Hiatt
//Date Created: 5-14-2020

import java.util.Scanner;
import java.util.Random;

public class OutOfBounds
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int[] array = new int[100];
		Random randNum = new Random();
		int userInput = 0;
		int loopVar = 0;
		
		for(int i = 0; i < array.length; i++)
			array[i] = randNum.nextInt();
		
		do
		{
			System.out.print("Enter a number between 0 and 99: ");
			userInput = input.nextInt();
			
			try
			{
				System.out.println("Array Index at " + userInput + " is " + array[userInput]);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Out of Bounds");
			}
			
			System.out.println("Enter 0 to continue or 1 to exit: ");
			loopVar = input.nextInt();
			
		}while(loopVar != 1);
		
		input.close();
		
	}//end of main method
}//end of class OutOfBounds
