//Author: Cameron Hiatt
//Date Created: 5-23-2020

public class Triangle extends GeometricObject implements Colorable
{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle()
	{
		super();
	}
	
	Triangle(double side1, double side2, double side3)
	{
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	Triangle(double side1, double side2, double side3, String color, boolean filled)
	{
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1()
	{
		return side1;
	}
	
	public double getSide2()
	{
		return side2;
	}
	
	public double getSide3()
	{
		return side3;
	}
	
	@Override
	public void howToColor()
	{
		System.out.println("Color all three sides");
	}
	
	@Override
	public double getArea()
	{
		double area = 0;
		double s = 0;
		
		s = (side1 + side2 + side3) / 2;
		area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		return area;
	}
	
	@Override
	public double getPerimeter()
	{
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	@Override
	public String toString()
	{
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + 
				" side3 = " + side3 + "\nArea: " + getArea() + "\nPerimeter: " +
				getPerimeter() + "\nColor: " + getColor() + "\nFilled: " + isFilled();
	}
}
