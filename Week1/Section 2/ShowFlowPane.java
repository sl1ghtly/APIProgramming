import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;

public class ShowFlowPane extends Application{
   // ShowFlowPane HAS-A Scene that uses FlowPane as its Layout Pane    
   private Scene scene;
   private FlowPane sceneLayout;
   @Override
   public void start(Stage primaryStage){
      // Construct the FlowPane node called sceneLayout, with HORIZONTAL Orientation, 
      // and gaps of 5 and 5 horizontally and vertically between components
      sceneLayout = new FlowPane(Orientation.HORIZONTAL, 5, 5);
      sceneLayout.setPadding(new Insets(10, 2, 10, 2));

      // Add nodes to sceneLayout (we are adding 5 Buttons from 1 to 5, and 5 Buttons with OK...
		// Loop around 5 times, each time...
      for (int i = 1; i <= 5; i++){
			// ...construct and add a Button with the label i,
         sceneLayout.getChildren().add(new Button(String.valueOf(i)));
			// and add an OK button
			sceneLayout.getChildren().add(new Button("OK"));
		}

       // Construct scene to contain sceneLayout, and...
      scene=new Scene(sceneLayout);
      
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);
      primaryStage.setTitle("ShowFlowPane");
      primaryStage.show();
   }
}