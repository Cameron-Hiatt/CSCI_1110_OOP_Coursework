//Author: Cameron Hiatt
//Date Created: 5-23-2020

import java.util.Scanner;

public class TriangleDriver
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double side1 = 0;
		double side2 = 0;
		double side3 = 0;
		String color = "white";
		boolean filled = false;
		
		
		System.out.println("Please enter the following info to create"
				+ " a triangle.");
		
		System.out.print("\nSide 1 length: ");
		side1 = input.nextDouble();
		
		System.out.print("\nSide 2 length: ");
		side2 = input.nextDouble();
		
		System.out.print("\nSide 3 length: ");
		side3 = input.nextDouble();
		
		System.out.print("\nTriangle's Color: ");
		color = input.next();
		
		System.out.print("\nTriangle is filled, true/false: ");
		filled = input.nextBoolean();
		
		Triangle triangle = new Triangle(side1, side2, side3, color, filled);
		
		System.out.println("\nThe information of your triangle is as follows\n");
		
		System.out.println(triangle);
		
		input.close();
	}
}
