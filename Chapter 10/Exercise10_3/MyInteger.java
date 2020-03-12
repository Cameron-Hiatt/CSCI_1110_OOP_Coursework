//Author: Cameron Hiatt
//Date created:	3-11-2020


public class MyInteger
{
	int value = 0;
	
	MyInteger(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public boolean isEven()
	{
		if(this.value % 2 == 0)
			return true;
		else
			return false;
	}
	
	public boolean isOdd()
	{
		if(this.value % 2 != 0)
			return true;
		else
			return false;
	}
	
	public boolean isPrime()
	{
		if(this.value < 2)
			return false;
			
		if(this.value == 2)
			return true;
			
		for(int i = 2; i < this.value; i++)
		{
			if(this.value % i == 0)
				return false;
		}
		
		return true;
	}
	
	static boolean isEven(int value)
	{
		if(value % 2 == 0)
			return true;
		else
			return false;
	}
	
	static boolean isOdd(int value)
	{
		if(value % 2 != 0)
			return true;
		else
			return false;
	}
	
	static boolean isPrime(int value)
	{
		if(value < 2)
			return false;
			
		if(value == 2)
			return true;
			
		for(int i = 2; i < value; i++)
		{
			if(value % i == 0)
				return false;
		}
		
		return true;
	}

	static boolean isEven(MyInteger integer)
	{
		if(integer.getValue() % 2 == 0)
			return true;
		else
			return false;
	}
	
	static boolean isOdd(MyInteger integer)
	{
		if(integer.getValue() % 2 != 0)
			return true;
		else
			return false;
	}
	
	static boolean isPrime(MyInteger integer)
	{
		if(integer.getValue() < 2)
			return false;
			
		if(integer.getValue() == 2)
			return true;
			
		for(int i = 2; i < integer.getValue(); i++)
		{
			if(integer.getValue() % i == 0)
				return false;
		}
		
		return true;
	}
	
	public boolean equals(int value)
	{
		if(this.value == value)
			return true;
		else
			return false;	
	}
	
	public boolean equals(MyInteger integer)
	{
		if(integer.getValue() == this.value)
			return true;
		else
			return false;
	}
	
	static int parseInt(char[] charArray)
	{
		String string = new String(charArray);
		int answer = 0;
		int convertedInt = 0;
		
		for(int i = 0; i < string.length(); i++)
		{
			convertedInt = string.charAt(i) - 48;
			answer = answer * 10 + convertedInt;
		}
		return answer;
	}
	
	static int parseInt(String string)
	{
		int convertedInt = 0;
		int answer = 0;
		
		for(int i = 0; i < string.length(); i++)
		{
			convertedInt = string.charAt(i) - 48;
			answer = answer * 10 + convertedInt;
		}
		return answer;
	}
	
}//end of MyInteger