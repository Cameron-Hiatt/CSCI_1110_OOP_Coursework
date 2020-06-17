//Author: Cameron Hiatt
//Date Created: 6-17-2020

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Exercise16_21 extends Application
{
	TextField input = new TextField("0");
	Timeline animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e ->  {

				int userInput = Integer.parseInt(input.getText());
				System.out.println(userInput);
				if (userInput == 1) {
					stop();
				}
				userInput -= 1;
				input.setText(userInput + "");
				
			}));

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		input.setAlignment(Pos.CENTER);
		Scene scene1 = new Scene(input);
		animation.setCycleCount(Timeline.INDEFINITE);
		
		input.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
			{
				animation.play();
			}
		});
		
		primaryStage.setTitle("Exercise 16-21"); // Set the stage title
		primaryStage.setScene(scene1); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	public void stop()
	{
		animation.stop();
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
