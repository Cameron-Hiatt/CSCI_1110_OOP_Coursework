//Author: Cameron Hiatt
//Date Created: 5-26-2020

import java.util.Date;

public abstract class GeometricObject
{
	private String color = "white";
	private boolean filled = false;
	private java.util.Date dateCreated;
	
	//Default Constructor
	protected GeometricObject()
	{
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled)
	{
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	@Override
	public String toString() 
	{
		return "created on " + dateCreated + "\ncolor: " + color + 
				" and filled: " + filled;
    }
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
}