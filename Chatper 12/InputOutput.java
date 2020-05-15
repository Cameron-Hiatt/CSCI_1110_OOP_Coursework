//Author: Cameron Hiatt
//Date Created: 5-14-2020

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class InputOutput
{
	//creates a print writer variable for later if it is needed
	private static PrintWriter output;

	public static void main(String args[]) throws IOException
	{
		
		java.io.File file = new java.io.File("Exercise12_15.txt");
		
		//creates a file if the file is not already found and opens it for writing
		if(!file.exists())
			output = new PrintWriter(file);
		
		Random randNum = new Random();
		Scanner input = new Scanner(file);
		ArrayList<Integer> fileInts = new ArrayList<Integer>();
		int counter = 1;
		
		//if a new file was created, it fills it with random integers and sorts them, otherwise it
		//just sorts the integers already found in the file using an array list
		if(file.length() == 0)
		{
			while (counter < 101)
			{
				output.print(randNum.nextInt() + "\t");
				if (counter % 5 == 0)
					output.println();
				counter++;
			}
			output.close();
			
			while(input.hasNext())
				fileInts.add(input.nextInt());
			
			Collections.sort(fileInts);

		}
		else
		{
			while(input.hasNext())
				fileInts.add(input.nextInt());
			
			Collections.sort(fileInts);
		}
		
		counter = 0;
		
		for (int i = 0; i < fileInts.size(); i++)
		{
			System.out.println(++counter + ". " + "\t" + fileInts.get(i));
		}
		
		input.close();
		
	}
}
