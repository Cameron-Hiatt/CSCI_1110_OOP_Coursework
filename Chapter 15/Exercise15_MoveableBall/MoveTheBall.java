//Author: Cameron Hiatt
//Date Created: 6-9-2020

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;

public class MoveTheBall extends Application
{
	CirclePane ball = new CirclePane();

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane = new Pane();
		pane.getChildren().addAll(ball);
		
		HBox buttons = new HBox(5);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		
		LeftHandler leftButtonHandler = new LeftHandler();
		Button buttonLeft = new Button("Left");
		buttonLeft.setOnAction(leftButtonHandler);
		
		RightHandler rightButtonHandler = new RightHandler();
		Button buttonRight = new Button("Right");
		buttonRight.setOnAction(rightButtonHandler);
		
		UpHandler upButtonHandler = new UpHandler();
		Button buttonUp = new Button("Up");
		buttonUp.setOnAction(upButtonHandler);
		
		DownHandler downButtonHandler = new DownHandler();
		Button buttonDown = new Button("Down");
		buttonDown.setOnAction(downButtonHandler);
		
		ball.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.LEFT) 
		{
			ball.moveLeft();
		}
		else if (e.getCode() == KeyCode.RIGHT) 
		{
			ball.moveRight();
		}
		else if (e.getCode() == KeyCode.UP) 
		{
			ball.moveUp();
		}
		else if (e.getCode() == KeyCode.DOWN) 
		{
			ball.setY(ball.getY() + 5);
		}
		});
		
		buttons.getChildren().addAll(buttonLeft, buttonUp, buttonDown, buttonRight);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(buttons);
		BorderPane.setAlignment(buttons, Pos.CENTER);
		
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("Move the Ball"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		ball.getCircle().requestFocus();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	class LeftHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			ball.moveLeft();
		}
	}
	
	class RightHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			ball.moveRight();
		}
	}
	
	class UpHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			ball.moveUp();
		}
	}
	
	class DownHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			ball.moveDown();
		}
	}
	
	class CirclePane extends Pane
	{
		private Circle circle = new Circle(150, 150, 15);
		
		public CirclePane()
		{
			getChildren().add(circle);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
		}
		
		public void moveLeft()
		{
			if (circle.getCenterX() - 5 >= 0)
				circle.setCenterX(circle.getCenterX() - 5);
		}
		
		public void moveRight()
		{
			if (circle.getCenterX() + 5 <= 300)
				circle.setCenterX(circle.getCenterX() + 5);
		}
		
		public void moveUp()
		{
			if (circle.getCenterY() - 5 >= 0)
				circle.setCenterY(circle.getCenterY() - 5);
		}
		
		public void moveDown()
		{
			if (circle.getCenterY() + 5 <= 300)
				circle.setCenterY(circle.getCenterY() + 5);
		}
		public double getY() {
			return circle.getCenterY();
		}
		public void setY(double y) {
			circle.setCenterY(y);
		}
		public Circle getCircle() {
			return circle;
		}
	}

}//End of class MoveTheBall
