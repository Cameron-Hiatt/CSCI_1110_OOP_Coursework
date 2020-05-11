//Author: Cameron Hiatt
//Date Created: 5-4-2020

import java.util.Date;

public class GeometricObject
{
	private String color = "white";
	private boolean filled = false;
	private java.util.Date dateCreated;
	
	//Default Constructor
	GeometricObject()
	{
		dateCreated = new java.util.Date();
	}
	
	//2 Argument Constructor
	GeometricObject(String color, boolean filled)
	{
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	@Override
	public String toString() 
	{
		return "created on " + dateCreated + "\ncolor: " + color + 
				" and filled: " + filled;
    }
	
}
