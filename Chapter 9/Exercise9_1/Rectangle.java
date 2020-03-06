//Author: 	Cameron Hiatt
//Date: 	3-5-2020

public class Rectangle 
{
	double width = 1;
	double height = 1;
		
	Rectangle()
	{
	}//end of default Rectangle constructor
	
	Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}//end of 2 arg Rectangle constructor
	
	
	double getArea()
	{
		return this.width * this.height;
	}
	
	double getPerimeter()
	{
		return 2 * this.width + 2 * this.height;
	}
	
	void displayRectangle()
	{
		System.out.println("Width: " + width + "\nHeight: " + height + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter());
	}
}//end of rectangle class