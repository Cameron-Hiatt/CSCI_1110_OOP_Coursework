//Author: Cameron Hiatt
//Date Created: 6-23-2020

import java.io.*;
import java.util.Scanner;


public class Exercise17_14 
{
	private static DataOutputStream output;
	private static DataInputStream input;

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		int selection = 0;
		String fileName;
		String encryptedFile;
		String decryptedFile;
		
		System.out.println("Select one of the following");
		System.out.println("1: Encrypt a File");
		System.out.println("2: Decrypt a File");
		System.out.println("3: Exit program");
		selection = userInput.nextInt();
		
		switch (selection)
		{
			case 1: System.out.println("\nEnter the file name to be encrypted");
					fileName = userInput.next();
					System.out.println("\nEnter the desired file name after encryption");
					encryptedFile = userInput.next();
					encrypt(fileName, encryptedFile);
					break;
			case 2: System.out.println("\nEnter the file name to be decrypted");
					fileName = userInput.next();
					System.out.println("\nEnter the desired file name after decryption");
					decryptedFile = userInput.next();
					decrypt(fileName, decryptedFile);
					break;
			case 3: System.exit(0);
					break;
			default:System.out.println("Invalid input");
		}
		userInput.close();
	}
	
	public static void encrypt(String s1, String s2)
	{
		try 
		{
			output = new DataOutputStream(new FileOutputStream(s2));
			input = new DataInputStream(new FileInputStream(s1));
			byte b;
			
			while (true)
			{
				b = input.readByte();
				b += 5;
				output.writeByte(b);
			}
			
		} catch (IOException e) {
			System.out.println("Encryption Complete");
		}
	}
	
	public static void decrypt(String s1, String s2)
	{
		try {
			input = new DataInputStream(new FileInputStream(s1));
			output = new DataOutputStream(new FileOutputStream(s2));
			byte b;
			
			while (true)
			{
				b = input.readByte();
				b -= 5;
				output.writeByte(b);
			}
		} catch (IOException e) {
			System.out.println("Decryption Complete");
		}
	}
}
