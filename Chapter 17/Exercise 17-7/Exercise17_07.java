/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */

//Modifier: Cameron Hiatt
//Modified Date: 6-22-2020
import java.io.*;

public class Exercise17_07 {
    private static ObjectInputStream input;

	public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
        outputData();
    }
    
    public static void outputData()
    {
    	try
    	{
    		input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
    		Loan loanHolder;
    		int counter = 0;
    		
    		while(true)
    		{
    			loanHolder = (Loan)input.readObject();
    			System.out.println("Loan " + ++counter + ": " + loanHolder.getLoanAmount());
    		}
    		
    	}catch(IOException | ClassNotFoundException e)
    	{
    		System.out.println("End of file has been reached.");
    	}
    }
}

