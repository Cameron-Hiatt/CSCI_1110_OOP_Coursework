import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class AnimationTest extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane = new Pane();
		Polygon pentagon = new Polygon();
		pentagon.setFill(Color.WHITE);
		pentagon.setStroke(Color.BLACK);
		pentagon.getPoints().addAll(new Double[]{
			    75.0, 175.0,
			    200.0, 90.0,
			    325.0, 175.0,
			    280.0, 300.0,
			    120.0, 300.0,});
		
		Rectangle rectangle = new Rectangle (0, 0, 25, 50);
		rectangle.setFill(Color.CYAN);
		rectangle.setStroke(Color.BLACK);
		
		pane.getChildren().addAll(pentagon, rectangle);
		
		FadeTransition ft = new FadeTransition(Duration.millis(8000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.01);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.play();
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(8000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		pane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.SECONDARY)
			{
				pt.pause();
				ft.pause();
			}
			else if(e.getButton() == MouseButton.PRIMARY)
			{
				pt.play();
				ft.play();
			}
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("AnimationTest");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {launch(args);}
}	
	
