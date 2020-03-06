//Author: 	Cameron Hiatt
//Date: 	3-5-2020

public class RectangleDriver 
{
	public static void main(String[] args) 
	{
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		
		System.out.println("Rectangle 1's information is...");
		rectangle1.displayRectangle();

		System.out.println("\nRectangle 2's information is...");
		rectangle2.displayRectangle();

	}//end of main method
}//end class RectangleDriver