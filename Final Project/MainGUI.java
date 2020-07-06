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
	public void start(Stage primaryStage) throws Exception 
	{
		
		StackPane pane = new StackPane();
		BorderPane borderPane = new BorderPane();
		VBox firstWindow = new VBox();
		
		//NextPane nextPane = new NextPane();
		
		Label firstWindowGreeting = new Label("Welcome to the Epik Quote Tool!\n\nThis tool is provided to get you the most accurate quote possible on our "
				+ "\nproducts and services. Continue through the following prompts to get your custom quote!");
		firstWindowGreeting.setTextAlignment(TextAlignment.CENTER);
		firstWindowGreeting.setAlignment(Pos.TOP_CENTER);
		
		Button button = new Button("Start");
		
		firstWindow.getChildren().addAll(firstWindowGreeting, button);
		firstWindow.setAlignment(Pos.CENTER);
		
		borderPane.setCenter(firstWindow);
		pane.getChildren().add(borderPane);
		
		button.setOnAction(e -> {
			StackPane pane2 = new StackPane();
			VBox customerTypes = new VBox(10);
			customerTypes.setAlignment(Pos.CENTER); 
			
			Label customerSelectionPrompt = new Label("Please select which type of customer best applies to your company");
			
			RadioButton premiumCust = new RadioButton("Premium Business Customer");
			RadioButton independentCust = new RadioButton("Independent Business Customer");

			
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
