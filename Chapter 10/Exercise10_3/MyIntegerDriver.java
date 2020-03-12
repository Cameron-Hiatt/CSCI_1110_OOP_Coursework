//Author: Cameron Hiatt
//Date created:	3-11-2020


public class MyIntegerDriver 
{
	public static void main(String[] args) 
	{
		MyInteger integerObject1 = new MyInteger(5);
		MyInteger integerObject2 = new MyInteger(17);
		char[] charArray = {'1', '4', '7', '2', '5'};
		String numericString = "7124583";
		
		System.out.println(integerObject1.isEven());
		System.out.println(integerObject1.isOdd());
		System.out.println(integerObject1.isPrime());
		
		System.out.println();
		
		System.out.println(MyInteger.isEven(12));
		System.out.println(MyInteger.isOdd(12));
		System.out.println(MyInteger.isPrime(12));
		
		System.out.println();
		
		System.out.println(MyInteger.isEven(integerObject1));
		System.out.println(MyInteger.isOdd(integerObject1));
		System.out.println(MyInteger.isPrime(integerObject1));
		
		System.out.println();
		
		System.out.println(integerObject1.equals(5));
		System.out.println(integerObject1.equals(integerObject2));
		
		System.out.println();
		
		System.out.println(MyInteger.parseInt(charArray));
		System.out.println(MyInteger.parseInt(numericString));
		
		
		
	}//end of main method
}//end of MyIntegerDriver