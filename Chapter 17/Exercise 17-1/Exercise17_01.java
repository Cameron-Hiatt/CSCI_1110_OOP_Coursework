import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

//Author: Cameron Hiatt
//Date Created: 6-22-2020

public class Exercise17_01 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
			PrintWriter output = new PrintWriter(new FileOutputStream("Exercise17_01.txt", true));
			Random rand = new Random();
		
		for (int i = 0; i < 100; i++)
		{
			output.write(rand.nextInt(10000) + " ");
		}
		
		output.close();
	}
}
