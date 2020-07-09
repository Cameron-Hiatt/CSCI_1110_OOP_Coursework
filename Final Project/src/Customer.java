/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-9-2020
*-------------------------------------*/

import java.util.Date;


public class Customer 
{
	private String name;
	private String contactNumber;
	private String contactEmail;
	private java.util.Date dateCreated;
	
	/**
	 * The default constructor for Customer class. It assigns default values for name, number, and email. Also assigns new date for dateCreated.
	 */
	Customer()
	{
		name = "John Smith";
		contactNumber = "123-456-7890";
		contactEmail = "johnsmith@youremailhere.com";
		dateCreated = new java.util.Date();
	}
	
	/**
	 * A three argument constructor for Customer class. It receives three strings; name, number, and email respectively and assigns the values associated with those to 
	 * name, contactNumber, and contactEmail. Also assigns new date for dateCreated.
	 * 
	 * @param name	(String, the user's name)
	 * @param number	(String, the user's phone number)
	 * @param email	(String, the user's email)
	 */
	Customer(String name, String number, String email)
	{
		this.name = name;
		this.contactNumber = number;
		this.contactEmail = email;
		dateCreated = new java.util.Date();
	}
	
	/**
	 * getName is the getter method for the Customer class variable name.
	 * 
	 * @return name (String, returns customer object's name.)
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * getNumbre is the getter method for the Customer class variable contactNumber.
	 * 
	 * @return contactNumber (String, customer object's contact number.)
	 */
	public String getNumber()
	{
		return this.contactNumber;
	}
	
	/**
	 * getEmail is the getter method for the Customer class variable contactEmail.
	 * 
	 * @return contactEmail (String, customer object's contact email)
	 */
	public String getEmail()
	{
		return contactEmail;
	}
	
	/**
	 * getDateCreated is the getter method for the Customer class variable dateCreated.
	 * 
	 * @return dateCreated (java.util.date, the date that a customer object was created)
	 */
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}
	
	/**
	 * setName is the setter method for the Customer class variable name.
	 * 
	 * @param name (String, the user's name)
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * setNumber is the setter method for the Customer class variable contactNumber.
	 * 
	 * @param number (String, the user's phone number)
	 */
	public void setNumber(String number)
	{
		this.contactNumber = number;
	}
	
	/**
	 * setEmail is the setter method for the Customer class variable contactEmail.
	 * 
	 * @param email (String, the user's email address)
	 */
	public void setEmail(String email)
	{
		this.contactEmail = email;
	}
	
	/**
	 * toString is Customer's to string method that overrides object's. It returns the Customer object's name, number, email, and date created in one String upon being called.
	 * 
	 * @return "Name: " + getName() + "\nNumber: " + getNumber() + "\nEmail: " + getEmail() + "\nDate Generated: " + getDateCreated() + "\n\n" (String, returns object's info as one string)
	 */
	@Override
	public String toString()
	{
		return "Name: " + getName() + "\nNumber: " + getNumber() + "\nEmail: " + getEmail() + "\nDate Generated: " + getDateCreated() + "\n\n";
	}
	
}
