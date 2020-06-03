//Author: Cameron Hiatt
//Date Created: 6-1-2020


public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable 
{
	private double side = 1.0;
	
	Octagon()
	{
		super();
	}
	
	Octagon(double side)
	{
		super();
		this.side = side;
	}
	
	Octagon(double side, String color, boolean filled)
	{
		super(color, filled);
		this.side = side;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public double getArea() 
	{
		double area = 0;
		area = ((2 + (4 / (Math.sqrt(2)))) * this.side * this.side);
		return area;
	}

	@Override
	public double getPerimeter() 
	{
		double perimeter = this.side * 8;
		return perimeter;
	}

	@Override
	public int compareTo(Octagon o) 
	{
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() 
	{
		return "Created on: " + getDateCreated() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\ncolor: " + getColor() + 
				"\nfilled: " + isFilled();
    }

}
