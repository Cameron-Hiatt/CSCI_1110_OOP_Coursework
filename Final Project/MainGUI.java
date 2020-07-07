/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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

/*---------------------------------------------------------------------------------------------------------------------* 
|TO DO LIST:
|	> Make MainGUI.java the main driver <
|	> Separate the methods and such out into a more organized format while retaining how it works right now <
|	> Make Calculator class with methods to calculate the proper customer prices <
|	> Make Radio Buttons only select one at a time (if selecting one doesn't trigger the new window prompts)
|	> Create a GUI that replaces the UI that goes on in the current program 
*----------------------------------------------------------------------------------------------------------------------*/

public class MainGUI extends Application
{
	
	public static int contractLength = 0;
	public static String[] productName =  {"4Port", "4Port PRI", "8Port","8Port PRI"};
	public static int[] premiumProductPrice = {1000, 1500, 1600, 2100};
	public static int[] independentProductPrice = {1500, 2000, 2100, 2600};
	public static int unitType = 0;
	
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
			
			Label customerSelectionPrompt = new Label("Please select which type of customer best applies to your company");
			
			RadioButton premiumCust = new RadioButton("Premium Business Customer");
			RadioButton independentCust = new RadioButton("Independent Business Customer");
			
			//if premium customer is selected, this creates the next scene that will make 8 input menus for the user to determine desired product amounts.
			premiumCust.setOnAction(e3 -> {
				StackPane pane3 = new StackPane();
				VBox services = new VBox(5);
				
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
				
				//this takes the user input amounts and puts them in to an array that will be sent to the Customer class which will then aid in calculating a premium quote.
				nextButton.setOnAction(e4 -> {
					int iterateVar = 0;
					ArrayList<Integer> neededServicesHolder = new ArrayList<Integer>();//Creating arraylist  
					ToggleGroup monthButtons = new ToggleGroup();
					
					iterateVar = Integer.parseInt(telephoneInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(1);
					
					iterateVar = Integer.parseInt(faxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(2);
					
					iterateVar = Integer.parseInt(fireInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(3);
					
					iterateVar = Integer.parseInt(securityInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(4);
					
					iterateVar = Integer.parseInt(elevatorInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(5);
					
					iterateVar = Integer.parseInt(internetInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(6);
					
					iterateVar = Integer.parseInt(callBoxInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(7);
					
					iterateVar = Integer.parseInt(priInput.getText());
					if(iterateVar != 0)
						for(int i = 0; i < iterateVar; i++)
							neededServicesHolder.add(8);
					
					//adds 0's to fill the rest of the array up to 8, this is important for the calculator to run correclty
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
					
					option1.setOnAction(e6 -> contractLength = 12);
					//do this for the rest tomorrow
					
					Button nextButton2 = new Button("Next");
					nextButton2.setOnAction(e5 -> {
						int[] quote = Customer.premiumCustomer(neededServices, contractLength).clone();
						System.out.println("Your Custom quote prices come out to the following");
						System.out.println("Unit model needed:" + productName[unitType] + "\nUnit Price: $" + quote[0]);
						System.out.println("Monthly Cost: $" + quote[1]);
						System.out.println("Total Cost at end of contract: $" + quote[2]);
						
					});
					
					months.getChildren().addAll(monthsPrompt, option1, option2, option3, option4, option5, nextButton2);
					pane4.getChildren().add(months);
					Scene scene3 = new Scene(pane4, 600, 400);
					primaryStage.setScene(scene3); // Place the scene in the stage
				
				});
				
				services.getChildren().addAll(servicesPrompt, telephoneService, faxLine, fireAlarm, securitySystem, 
						elevatorAlarm, internetFailover, emergencyCallBox, priLine, nextButton);
				pane3.getChildren().add(services);
				Scene scene2 = new Scene(pane3, 600, 400);
				primaryStage.setScene(scene2); // Place the scene in the stage
			});
			
			customerTypes.getChildren().addAll(customerSelectionPrompt, premiumCust, independentCust);
			pane2.getChildren().add(customerTypes);
			Scene scene1 = new Scene(pane2, 600, 400);
			primaryStage.setScene(scene1); // Place the scene in the stage
		});
		
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Epik Quote Tool"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
