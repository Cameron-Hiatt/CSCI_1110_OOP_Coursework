//Author: Cameron Hiatt
//Date Created: 6-16-2020

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.control.ToggleGroup;

public class Exercise16_1 extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		//Creates a main Border pane to hold all the different sub
		//panes needed for the program
		BorderPane pane = new BorderPane();
		
		//creates a pane to hold the text for the program and the text itself
		Pane paneForText = new Pane();
		Text text = new Text(180, 80, "Programming is fun!");
		paneForText.getChildren().add(text);
		
		//creates a pane to hold the arrow buttons, the buttons themselves,
		//and creates their event handlers so they can move the text
		//left and right
		HBox arrowPane = new HBox();
		Button buttonLeft = new Button("<=");
		Button buttonRight = new Button("=>");
		arrowPane.getChildren().addAll(buttonLeft, buttonRight);
		arrowPane.setAlignment(Pos.CENTER);
		arrowPane.setStyle("-fx-border-color: black");
		buttonLeft.setOnAction(e -> text.setX(text.getX() - 10));
		buttonRight.setOnAction(e -> text.setX(text.getX() + 10));
		
		//Creates HBox and ToggleGroup for the radio buttons
		HBox colorPane = new HBox();
		ToggleGroup colorButtons = new ToggleGroup();
		
		//Create radio buttons
		RadioButton orange = new RadioButton("Orange");
		RadioButton blue = new RadioButton("Blue");
		RadioButton black = new RadioButton("Black");
		RadioButton green = new RadioButton("Green");
		RadioButton red = new RadioButton("Red");
		
		//add buttons to the HBox
		colorPane.getChildren().addAll(blue, red, black, green, orange);
		
		//adds buttons to the toggle group so only one can be selected with 
		//black being selected by default
		orange.setToggleGroup(colorButtons);
		blue.setToggleGroup(colorButtons);
		black.setToggleGroup(colorButtons);
		black.setSelected(true);
		green.setToggleGroup(colorButtons);
		red.setToggleGroup(colorButtons);
		
		//realigns the HBox
		colorPane.setAlignment(Pos.CENTER);
		
		//adds events to the radio buttons on press
		orange.setOnAction(e -> text.setFill(Color.DARKORANGE));
		blue.setOnAction(e -> text.setFill(Color.BLUE));
		black.setOnAction(e -> text.setFill(Color.BLACK));
		green.setOnAction(e -> text.setFill(Color.GREEN));
		red.setOnAction(e -> text.setFill(Color.RED));
	
		
		//adds the various panes to the main pane
		pane.setBottom(arrowPane);
		pane.setCenter(paneForText);
		pane.setTop(colorPane);
		
		Scene scene = new Scene(pane, 500, 200);
		primaryStage.setTitle("Exercise 16-1"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
