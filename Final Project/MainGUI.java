/*-------------------------------------* 
|Author:   	Cameron Hiatt 
|Date:		7-1-2020
*-------------------------------------*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

public class MainGUI extends Application
{
	public void start(Stage primaryStage) throws Exception 
	{
		
		StackPane pane = new StackPane();
		BorderPane firstWindow = new BorderPane();
		
		Label firstWindowGreeting = new Label("Welcome to the Epik Quote Tool!\nThis tool is provided to get you the most accurate quote possible on our "
				+ "\nproducts and services. Continue through the following prompts to get your custom quote!");
		firstWindowGreeting.setTextAlignment(TextAlignment.CENTER);
		
		
		Button button = new Button("Start");
		button.setOnAction(e -> ERPQuoteTool.start());
		
		firstWindow.setTop(firstWindowGreeting);
		firstWindow.setCenter(button);
		
		pane.getChildren().add(firstWindow);
		
		
		
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setTitle("Epik Quote Tool"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
