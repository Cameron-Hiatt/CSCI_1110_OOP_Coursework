/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.util.*;  
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import java.io.*;

public class MainGUI extends Application
{
	
	//static variables to be used throughout the program, this allows for them to extend to all possible branches of the UI 
	//rather than making duplicates as someone may progress through different branches of the UI 
	public static int contractLength = 0;
	public static int contractLengthNum = 0;
	public static String[] productName =  {"4Port", "4Port PRI", "8Port","8Port PRI"};
	public static int[] premiumProductPrice = {1000, 1500, 1600, 2100};
	public static int[] independentProductPrice = {1500, 2000, 2100, 2600};
	public static int unitType = 0;
	public static String[] serviceName = {"Telephone Line", "Fax Line", "Fire Alarm", "Security Alarm", "Elevator Alarm", "Internet Failover", "Emergency Call Box", "PRI Telephone Line"};
	public static ArrayList<String> requestedServices = new ArrayList<String>();//Creating arraylist  
	public static Customer customer;
	
	
	/**
	 * The start method is the main method for controlling this program's User Interface. It has multiple nested scenes that the user moves through as they input information
	 * that make up the overall program UI. It returns void. 
	 */
	public void start(Stage primaryStage) throws Exception 
	{
		//Creates the opening window 
		StackPane pane = new StackPane();
		BorderPane borderPane = new BorderPane();
		VBox firstWindow = new VBox();
		firstWindow.setSpacing(10.0);
		
		//creates the greeting upon running the program
		Label firstWindowGreeting = new Label("Welcome to the Epik Quote Tool!\n\nThis tool is provided to get you the most accurate quote possible on our "
				+ "\nproducts and services. Continue through the following prompts to get your custom quote!");
		firstWindowGreeting.setTextAlignment(TextAlignment.CENTER);
		firstWindowGreeting.setAlignment(Pos.TOP_CENTER);
		
		Button button = new Button("Start");
		
		firstWindow.getChildren().addAll(firstWindowGreeting, button);
		firstWindow.setAlignment(Pos.CENTER);
		
		borderPane.setCenter(firstWindow);
		pane.getChildren().add(borderPane);
		
		//starts the program and opens up a new scene, displaying the user with a choice of what customer they are, the lambda functions are nested
		//because there were some bugs with the font of the words in the VBox and my instructor said do it like this since it is working
		//and she was unable to determine why the font was getting messed up through other ways of doing it.
		button.setOnAction(e -> {
			StackPane pane2 = new StackPane();
			VBox customerTypes = new VBox(10);
			customerTypes.setAlignment(Pos.CENTER);
			
			Label customerSelectionPrompt = new Label("Please input your information\nand select which type of customer best applies to your company");
			
			HBox name = new HBox(4);
			name.setAlignment(Pos.CENTER);
			Label nameLabel = new Label("Name: ");
			TextField nameInput = new TextField("Your Name Here");
			nameInput.setAlignment(Pos.CENTER);
			name.getChildren().addAll(nameLabel, nameInput);
			
			HBox number = new HBox(4);
			number.setAlignment(Pos.CENTER);
			Label numberLabel = new Label("Phone Number: ");
			TextField numberInput = new TextField("Ex. 222-222-2222");
			numberInput.setAlignment(Pos.CENTER);
			number.getChildren().addAll(numberLabel, numberInput);
			
			HBox email = new HBox(4);
			email.setAlignment(Pos.CENTER);
			Label emailLabel = new Label("Email: ");
			TextField emailInput = new TextField("Your Email Here");
			emailInput.setAlignment(Pos.CENTER);
			email.getChildren().addAll(emailLabel, emailInput);
			
			RadioButton premiumCust = new RadioButton("Premium Business Customer");
			RadioButton independentCust = new RadioButton("Independent Business Customer");
			
			//if premium customer is selected, this creates the next scene that will make 8 input menus for the user to determine desired product amounts.
			premiumCust.setOnAction(e3 -> {
				StackPane pane3 = new StackPane();
				VBox services = new VBox(5);
				
				customer = new Customer(nameInput.getText(), numberInput.getText(), emailInput.getText());
				
				//Hboxes containing the service title and a text field that allows the user to input how many of those services they need
				HBox telephoneService = new HBox(4);
				telephoneService.setAlignment(Pos.CENTER);
				Label telephoneLabel = new Label("1. Telephone");
				TextField telephoneInput = new TextField("0");
				telephoneInput.setAlignment(Pos.CENTER);
				telephoneService.getChildren().addAll(telephoneLabel, telephoneInput);
				
				HBox faxLine = new HBox(4);
				faxLine.setAlignment(Pos.CENTER);
				Label faxLabel = new Label("2. Fax Line");
				TextField faxInput = new TextField("0");
				faxInput.setAlignment(Pos.CENTER);
				faxLine.getChildren().addAll(faxLabel, faxInput);
				
				HBox fireAlarm = new HBox(4);
				fireAlarm.setAlignment(Pos.CENTER);
				Label fireLabel = new Label("3. Fire Alarm");
				TextField fireInput = new TextField("0");
				fireInput.setAlignment(Pos.CENTER);
				fireAlarm.getChildren().addAll(fireLabel, fireInput);
				
				HBox securitySystem = new HBox(4);
				securitySystem.setAlignment(Pos.CENTER);
				Label securityLabel = new Label("4. Security System");
				TextField securityInput = new TextField("0");
				securityInput.setAlignment(Pos.CENTER);
				securitySystem.getChildren().addAll(securityLabel, securityInput);
				
				HBox elevatorAlarm = new HBox(4);
				elevatorAlarm.setAlignment(Pos.CENTER);
				Label elevatorLabel = new Label("5. Elevator Alarm");
				TextField elevatorInput = new TextField("0");
				elevatorInput.setAlignment(Pos.CENTER);
				elevatorAlarm.getChildren().addAll(elevatorLabel, elevatorInput);
				
				HBox internetFailover = new HBox(4);
				internetFailover.setAlignment(Pos.CENTER);
				Label internetLabel = new Label("6. Internet Failover");
				TextField internetInput = new TextField("0");
				internetInput.setAlignment(Pos.CENTER);
				internetFailover.getChildren().addAll(internetLabel, internetInput);
				
				HBox emergencyCallBox = new HBox(4);
				emergencyCallBox.setAlignment(Pos.CENTER);
				Label callBoxLabel = new Label("7. Emergency Call Box");
				TextField callBoxInput = new TextField("0");
				callBoxInput.setAlignment(Pos.CENTER);
				emergencyCallBox.getChildren().addAll(callBoxLabel, callBoxInput);
				
				HBox priLine = new HBox(4);
				priLine.setAlignment(Pos.CENTER);
				Label priLabel = new Label("8. PRI Telephone Line");
				TextField priInput = new TextField("0");
				priInput.setAlignment(Pos.CENTER);
				priLine.getChildren().addAll(priLabel, priInput);
				
				Button nextButton = new Button("Next");
				
				services.setAlignment(Pos.CENTER); 
				
				Label servicesPrompt = new Label("Please enter in the number of services needed for each"
						+ "\nservice up to 8 total services, then press next. (leave value as 0 if that service is not needed)");
				servicesPrompt.setTextAlignment(TextAlignment.CENTER);
				
				//this button will move to the next scene of the UI and also accept the user input given for the desired services
				nextButton.setOnAction(e4 -> {
					int iterateVar = 0;
					ArrayList<Integer> neededServicesHolder = new ArrayList<Integer>();//Creating arraylist  
					ToggleGroup monthButtons = new ToggleGroup();
					
					//these blocks of code take each text field value and adds it to an array list so that it can be used later in calculating the pricing
					// of their overall plan. It also adds the name of that service to an array list of strings to be used later in displaying the 
					// services the user chose for the quote
					iterateVar = Integer.parseInt(telephoneInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(1);
							requestedServices.add(serviceName[0]);
						}
							
					iterateVar = Integer.parseInt(faxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(2);
							requestedServices.add(serviceName[1]);
						}
					
					iterateVar = Integer.parseInt(fireInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(3);
							requestedServices.add(serviceName[2]);
						}
					
					iterateVar = Integer.parseInt(securityInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(4);
							requestedServices.add(serviceName[3]);
						}
					
					iterateVar = Integer.parseInt(elevatorInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(5);
							requestedServices.add(serviceName[4]);
						}
					
					iterateVar = Integer.parseInt(internetInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(6);
							requestedServices.add(serviceName[5]);
						}
					
					iterateVar = Integer.parseInt(callBoxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(7);
							requestedServices.add(serviceName[6]);
						}
					
					iterateVar = Integer.parseInt(priInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(8);
							requestedServices.add(serviceName[7]);
						}
					
					//adds 0's to fill the rest of the array up to 8, this is important for the calculator to run correctly
					if (neededServicesHolder.size() != 8)
					{
						do
						{
							neededServicesHolder.add(0);
						}while(neededServicesHolder.size() < 8);
					}
					
					//copies contents of an arraylist over to a normal array so that it can utilize the methods already made in Customer class
					int[] neededServices = new int[neededServicesHolder.size()];
					for(int j = 0; j < neededServicesHolder.size(); j++)
						neededServices[j] = neededServicesHolder.get(j);
					
					//beginning of this scene's UI that asks how long the user plans to contract for
					StackPane pane4 = new StackPane();
					VBox months = new VBox(5);
					Label monthsPrompt = new Label("Please select how long this service contract will be");
					months.setAlignment(Pos.CENTER);
					
					//radio buttons that are then set in a toggle group (so only one can be selected at a time) that display the contract plans available
					RadioButton option1 = new RadioButton("12 Months");
					RadioButton option2 = new RadioButton("24 Months");
					RadioButton option3 = new RadioButton("36 Months");
					RadioButton option4 = new RadioButton("48 Months");
					RadioButton option5 = new RadioButton("60 Months");
					
					option1.setToggleGroup(monthButtons);
					option2.setToggleGroup(monthButtons);
					option3.setToggleGroup(monthButtons);
					option4.setToggleGroup(monthButtons);
					option5.setToggleGroup(monthButtons);
					
					//this assigns a number to the contractLength variable based on their decision, this is important for the calculator to run correctly
					option1.setOnAction(e6 -> contractLength = 1);
					option2.setOnAction(e7 -> contractLength = 2);
					option3.setOnAction(e8 -> contractLength = 3);
					option4.setOnAction(e9 -> contractLength = 4);
					option5.setOnAction(e10 -> contractLength = 5);
					
					//the following opens the new scene that will display the final quote, this also sets off the calculation of the prices based on the users
					//previous decisions
					Button nextButton2 = new Button("Next");
					nextButton2.setOnAction(e5 -> {
						int[] quote = new int[8];
						quote = Calculator.calculatePremiumQuote(neededServices, contractLength).clone();
						
						//this switch statement assigns their contract length to a variable to be used in the display of the users quote. 
						switch (contractLength)
						{
							case 1: contractLengthNum = 12;
								break;
							case 2: contractLengthNum = 24;
								break;
							case 3: contractLengthNum = 36;
								break;
							case 4: contractLengthNum = 48;
								break;
							case 5: contractLengthNum = 60;
								break;
						}
						
						//this finds the type of unit needed and puts it in a variable to be used in displaying the quote
						for(int j = 0; j < premiumProductPrice.length; j++)
							if(quote[0] == premiumProductPrice[j])
								unitType = j;
						
						//string and for loop to be used in displaying the requested services previously by the user
						String needs = new String();
						
						for(int i = 0; i < requestedServices.size(); i++)
							needs += "-" + requestedServices.get(i) + "\n";
						
						//displays the quote in an asthetic way
						StackPane pane5 = new StackPane();
						VBox quotePricing = new VBox(5);
						Label quoteTitle = new Label("Based on your needs of the following services\n" + needs + "\nYour custom quote is as follows:");
						Label unitModelNeeded = new Label("Unit model needed:					" + productName[unitType]);
						Label unitPrice = new Label("Unit model price:						$" + quote[0]);
						Label monthlyCost = new Label("Monthly Cost:							$" + quote[1]);
						Label totalCost = new Label("Total Cost at end of " + contractLengthNum + " month contract:	$" + quote[2]);
						
						quotePricing.setAlignment(Pos.CENTER_LEFT);
						quotePricing.setPadding(new Insets(30, 50, 50, 150));
						
						//final variables so they can be used in saving the text file below. Wouldn't let me use the normal variables unless they were final
						final String needs2 = needs;
						final int[] quoteTxt = quote.clone();
						
						Button saveButton = new Button("Save to Text File");
						saveButton.setOnAction(e11 -> {
							try {
								PrintWriter output = new PrintWriter(new FileOutputStream(customer.getName() + "EpikQuote.txt", false));
								output.write(customer.toString());
								output.write("Based on your needs of the following services\n" + needs2 + "\nYour custom quote is as follows:\n");
								output.write("Unit model needed:						" + productName[unitType] + "\n");
								output.write("Unit model price:						$" + quoteTxt[0] + "\n");
								output.write("Monthly Cost:							$" + quoteTxt[1] + "\n");
								output.write("Total Cost at end of " + contractLengthNum + " month contract:	$" + quoteTxt[2]);
								output.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							
							Label thankYou = new Label("Thank you for using the Epik quote tool! \n"
									+ "Your quote has been saved,\nyou may exit out of the window now.");
							quotePricing.setAlignment(Pos.CENTER);
							quotePricing.setPadding(new Insets(10, 50, 50, 50));
							quotePricing.getChildren().clear();
							quotePricing.getChildren().add(thankYou);
						});
						
						quotePricing.getChildren().addAll(quoteTitle, unitModelNeeded, unitPrice, monthlyCost, totalCost, saveButton);
						pane5.getChildren().add(quotePricing);
						Scene scene4 = new Scene(pane5, 600, 400);
						primaryStage.setScene(scene4); // Place the scene in the stage
						
					});//end of premium customer calculation action e5
					
					months.getChildren().addAll(monthsPrompt, option1, option2, option3, option4, option5, nextButton2);
					pane4.getChildren().add(months);
					Scene scene3 = new Scene(pane4, 600, 400);
					primaryStage.setScene(scene3); // Place the scene in the stage
				
				});//end of next button action e4
				
				services.getChildren().addAll(servicesPrompt, telephoneService, faxLine, fireAlarm, securitySystem, 
						elevatorAlarm, internetFailover, emergencyCallBox, priLine, nextButton);
				pane3.getChildren().add(services);
				Scene scene2 = new Scene(pane3, 600, 400);
				primaryStage.setScene(scene2); // Place the scene in the stage
			});// end of premium customer interface
			
			//if independent customer is selected, this creates the next scene that will make 8 input menus for the user to determine desired product amounts.
			independentCust.setOnAction(e3 -> {
				StackPane pane3 = new StackPane();
				VBox services = new VBox(5);
				
				customer = new Customer(nameInput.getText(), numberInput.getText(), emailInput.getText());
				
				//Hboxes containing the service title and a text field that allows the user to input how many of those services they need
				HBox telephoneService = new HBox(4);
				telephoneService.setAlignment(Pos.CENTER);
				Label telephoneLabel = new Label("1. Telephone");
				TextField telephoneInput = new TextField("0");
				telephoneInput.setAlignment(Pos.CENTER);
				telephoneService.getChildren().addAll(telephoneLabel, telephoneInput);
				
				HBox faxLine = new HBox(4);
				faxLine.setAlignment(Pos.CENTER);
				Label faxLabel = new Label("2. Fax Line");
				TextField faxInput = new TextField("0");
				faxInput.setAlignment(Pos.CENTER);
				faxLine.getChildren().addAll(faxLabel, faxInput);
				
				HBox fireAlarm = new HBox(4);
				fireAlarm.setAlignment(Pos.CENTER);
				Label fireLabel = new Label("3. Fire Alarm");
				TextField fireInput = new TextField("0");
				fireInput.setAlignment(Pos.CENTER);
				fireAlarm.getChildren().addAll(fireLabel, fireInput);
				
				HBox securitySystem = new HBox(4);
				securitySystem.setAlignment(Pos.CENTER);
				Label securityLabel = new Label("4. Security System");
				TextField securityInput = new TextField("0");
				securityInput.setAlignment(Pos.CENTER);
				securitySystem.getChildren().addAll(securityLabel, securityInput);
				
				HBox elevatorAlarm = new HBox(4);
				elevatorAlarm.setAlignment(Pos.CENTER);
				Label elevatorLabel = new Label("5. Elevator Alarm");
				TextField elevatorInput = new TextField("0");
				elevatorInput.setAlignment(Pos.CENTER);
				elevatorAlarm.getChildren().addAll(elevatorLabel, elevatorInput);
				
				HBox internetFailover = new HBox(4);
				internetFailover.setAlignment(Pos.CENTER);
				Label internetLabel = new Label("6. Internet Failover");
				TextField internetInput = new TextField("0");
				internetInput.setAlignment(Pos.CENTER);
				internetFailover.getChildren().addAll(internetLabel, internetInput);
				
				HBox emergencyCallBox = new HBox(4);
				emergencyCallBox.setAlignment(Pos.CENTER);
				Label callBoxLabel = new Label("7. Emergency Call Box");
				TextField callBoxInput = new TextField("0");
				callBoxInput.setAlignment(Pos.CENTER);
				emergencyCallBox.getChildren().addAll(callBoxLabel, callBoxInput);
				
				HBox priLine = new HBox(4);
				priLine.setAlignment(Pos.CENTER);
				Label priLabel = new Label("8. PRI Telephone Line");
				TextField priInput = new TextField("0");
				priInput.setAlignment(Pos.CENTER);
				priLine.getChildren().addAll(priLabel, priInput);
				
				Button nextButton = new Button("Next");
				
				services.setAlignment(Pos.CENTER); 
				
				Label servicesPrompt = new Label("Please enter in the number of services needed for each"
						+ "\nservice up to 8 total services, then press next. (leave value as 0 if that service is not needed)");
				servicesPrompt.setTextAlignment(TextAlignment.CENTER);
				
				//this button will move to the next scene of the UI and also accept the user input given for the desired services
				nextButton.setOnAction(e4 -> {
					int iterateVar = 0;
					ArrayList<Integer> neededServicesHolder = new ArrayList<Integer>();//Creating arraylist  
					ToggleGroup monthButtons = new ToggleGroup();
					
					//these blocks of code take each text field value and adds it to an array list so that it can be used later in calculating the pricing
					// of their overall plan. It also adds the name of that service to an array list of strings to be used later in displaying the 
					// services the user chose for the quote
					iterateVar = Integer.parseInt(telephoneInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(1);
							requestedServices.add(serviceName[0]);
						}
							
					iterateVar = Integer.parseInt(faxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(2);
							requestedServices.add(serviceName[1]);
						}
					
					iterateVar = Integer.parseInt(fireInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(3);
							requestedServices.add(serviceName[2]);
						}
					
					iterateVar = Integer.parseInt(securityInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(4);
							requestedServices.add(serviceName[3]);
						}
					
					iterateVar = Integer.parseInt(elevatorInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(5);
							requestedServices.add(serviceName[4]);
						}
					
					iterateVar = Integer.parseInt(internetInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(6);
							requestedServices.add(serviceName[5]);
						}
					
					iterateVar = Integer.parseInt(callBoxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(7);
							requestedServices.add(serviceName[6]);
						}
					
					iterateVar = Integer.parseInt(priInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
						{
							neededServicesHolder.add(8);
							requestedServices.add(serviceName[7]);
						}
					
					//adds 0's to fill the rest of the array up to 8, this is important for the calculator to run correctly
					if (neededServicesHolder.size() != 8)
					{
						do
						{
							neededServicesHolder.add(0);
						}while(neededServicesHolder.size() < 8);
					}
					
					//copies contents of an arraylist over to a normal array so that it can utilize the methods already made in Customer class
					int[] neededServices = new int[neededServicesHolder.size()];
					for(int j = 0; j < neededServicesHolder.size(); j++)
						neededServices[j] = neededServicesHolder.get(j);
					
					StackPane pane4 = new StackPane();
					VBox months = new VBox(5);
					Label monthsPrompt = new Label("Please select how long this service contract will be");
					months.setAlignment(Pos.CENTER);
					
					RadioButton option1 = new RadioButton("12 Months");
					RadioButton option2 = new RadioButton("24 Months");
					RadioButton option3 = new RadioButton("36 Months");
					RadioButton option4 = new RadioButton("48 Months");
					RadioButton option5 = new RadioButton("60 Months");
					
					option1.setToggleGroup(monthButtons);
					option2.setToggleGroup(monthButtons);
					option3.setToggleGroup(monthButtons);
					option4.setToggleGroup(monthButtons);
					option5.setToggleGroup(monthButtons);
					
					option1.setOnAction(e6 -> contractLength = 1);
					option2.setOnAction(e7 -> contractLength = 2);
					option3.setOnAction(e8 -> contractLength = 3);
					option4.setOnAction(e9 -> contractLength = 4);
					option5.setOnAction(e10 -> contractLength = 5);
					
					Button nextButton2 = new Button("Next");
					nextButton2.setOnAction(e5 -> {
						int[] quote = new int[8];
						quote = Calculator.calculateIndependentQuote(neededServices, contractLength).clone();
						
						switch (contractLength)
						{
							case 1: contractLengthNum = 12;
								break;
							case 2: contractLengthNum = 24;
								break;
							case 3: contractLengthNum = 36;
								break;
							case 4: contractLengthNum = 48;
								break;
							case 5: contractLengthNum = 60;
								break;
						}
						
						for(int j = 0; j < independentProductPrice.length; j++)
							if(quote[0] == independentProductPrice[j])
								unitType = j;
						
						String needs = new String();
						
						for(int i = 0; i < requestedServices.size(); i++)
							needs += "-" + requestedServices.get(i) + "\n";
						
						StackPane pane5 = new StackPane();
						VBox quotePricing = new VBox(5);
						Label quoteTitle = new Label("Based on your needs of the following services\n" + needs + "\nYour custom quote is as follows:");
						Label unitModelNeeded = new Label("Unit model needed:					" + productName[unitType]);
						Label unitPrice = new Label("Unit model price:						$" + quote[0]);
						Label monthlyCost = new Label("Monthly Cost:							$" + quote[1]);
						Label totalCost = new Label("Total Cost at end of " + contractLengthNum + " month contract:	$" + quote[2]);
						
						quotePricing.setAlignment(Pos.CENTER_LEFT);
						quotePricing.setPadding(new Insets(30, 50, 50, 150));
						
						//final variables so they can be used in saving the text file below. Wouldn't let me use the normal variables unless they were final
						final String needs2 = needs;
						final int[] quoteTxt = quote.clone();
						
						//this button when pressed will save the quote given to a text file called EpikQuote.txt, it will overwrite said file if one already exists
						Button saveButton = new Button("Save to Text File");
						saveButton.setOnAction(e11 -> {
							try {
								PrintWriter output = new PrintWriter(new FileOutputStream(customer.getName() + "EpikQuote.txt", false));
								output.write(customer.toString());
								output.write("Based on your needs of the following services\n" + needs2 + "\nYour custom quote is as follows:\n");
								output.write("Unit model needed:						" + productName[unitType] + "\n");
								output.write("Unit model price:						$" + quoteTxt[0] + "\n");
								output.write("Monthly Cost:							$" + quoteTxt[1] + "\n");
								output.write("Total Cost at end of " + contractLengthNum + " month contract:	$" + quoteTxt[2]);
								output.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							
							Label thankYou = new Label("Thank you for using the Epik quote tool! \n"
									+ "Your quote has been saved,\nyou may exit out of the window now.");
							quotePricing.setAlignment(Pos.CENTER);
							quotePricing.setPadding(new Insets(10, 50, 50, 50));
							quotePricing.getChildren().clear();
							quotePricing.getChildren().add(thankYou);
						});
						
						quotePricing.getChildren().addAll(quoteTitle, unitModelNeeded, unitPrice, monthlyCost, totalCost, saveButton);
						pane5.getChildren().add(quotePricing);
						Scene scene4 = new Scene(pane5, 600, 400);
						primaryStage.setScene(scene4); // Place the scene in the stage
						
					});//end of calculation for independent customer quote
					
					months.getChildren().addAll(monthsPrompt, option1, option2, option3, option4, option5, nextButton2);
					pane4.getChildren().add(months);
					Scene scene3 = new Scene(pane4, 600, 400);
					primaryStage.setScene(scene3); // Place the scene in the stage
				
				});//end of next button action e4
				
				services.getChildren().addAll(servicesPrompt, telephoneService, faxLine, fireAlarm, securitySystem, 
						elevatorAlarm, internetFailover, emergencyCallBox, priLine, nextButton);
				pane3.getChildren().add(services);
				Scene scene2 = new Scene(pane3, 600, 400);
				primaryStage.setScene(scene2); // Place the scene in the stage
			});//end of independent customer interface
			
			customerTypes.getChildren().addAll(customerSelectionPrompt, name, number, email, premiumCust, independentCust);
			pane2.getChildren().add(customerTypes);
			Scene scene1 = new Scene(pane2, 600, 400);
			primaryStage.setScene(scene1); // Place the scene in the stage
		});
		
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Epik Quote Tool"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * The main method exists because some IDEs require having it in order to run a javafx GUI. This was written using the Eclipse IDE and thus it needed the main for the start method to run. 
	 * 
	 * @param args (String array, main method accepts command line arguments)
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
