import java.io.*;
import java.util.Random;
import java.util.Scanner;

//Author: Cameron Hiatt
//Date Created: 6-22-2020

public class Exercise17_3
{
	public static void main(String[] args) throws IOException 
	{
		Scanner input = new Scanner(System.in);
		int j = 0;
		
		while(j != 3)
		{
			System.out.println("1: Create file with 100 random integers");
			System.out.println("2: Add up file with 100 random integers");
			System.out.println("3: Exit");
			j = input.nextInt();
			
			switch(j)
			{
				case 1: outputToFile();
					break;
				case 2: readAndAddFile();
					break;
				case 3: 
					break;
				default: System.out.println("Invalid input");
			}
		}
		
		input.close();
			
	}
	
	public static void outputToFile() throws IOException
	{
		DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat", true));
		Random rand = new Random();
		
		for (int i = 0; i < 100; i++)
		{
			output.writeInt(rand.nextInt(10000));
		}
		
		System.out.println("Exercise17_03.dat has been written to.\n");
		
		output.close();
	}
	
	public static void readAndAddFile() throws IOException
	{
		DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_03.dat"));
		int sum = 0;
		
		try
		{
			while(true)
			{	
				sum = sum + input.readInt();
			}
		}catch (IOException ex){
			System.out.println("The sum of numbers in the file is: " + sum + "\nEnd of File reached.");
		}
		input.close();
	}
}