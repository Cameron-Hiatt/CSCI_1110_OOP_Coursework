import java.util.Random;

//Author: Cameron Hiatt
//Date Created: 5-26-2020

public class Exercise13Driver
{
	public static void main(String[] args)
	{
		Triangle[] array1 = new Triangle[5];
		Random rand = new Random();
		int side1 = 0;
		int side2 = 0;
		int side3 = 0;
		
		
		for (int i = 0; i < array1.length; i++)
		{
			side1 = rand.nextInt(20) + 10;
			side2 = rand.nextInt(20) + 10;
			side3 = rand.nextInt(20) + 10;
			array1[i] = new Triangle(side1, side2, side3);
		}
		
		for (int j = 0; j < array1.length; j++)
		{
			System.out.println("Area of triangle " + (j + 1) + " is: " + array1[j].getArea());
			array1[j].howToColor();
			System.out.println();
		}
	}
}
