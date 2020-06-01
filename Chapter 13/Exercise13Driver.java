//Author: Cameron Hiatt
//Date: 6-1-2020

public class Exercise13Driver
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Octagon octagon1 = new Octagon(4.0, "Blue", true);
		Octagon octagon2 = (Octagon)octagon1.clone();
		
		System.out.println(octagon1.toString());
		
		
		
		System.out.println("Octagon1 compared to copy of Octagon1 results: " + octagon1.compareTo(octagon2));
		
		
	}
}
