import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class ShowGridPane extends Application{
   // ShowGridPane HAS-A Scene that uses GridPane as its Layout Pane    
   private Scene scene;
   private GridPane sceneLayout;
   @Override
   public void start(Stage primaryStage){
      // Construct the GridPane node called sceneLayout
      sceneLayout = new GridPane();
      // set HGap to 5, VGap to 2, and padding of 10,2,10,2 to top, right, bottom, left of sceneLayout
      sceneLayout.setHgap(5);
      sceneLayout.setVgap(2);  
      sceneLayout.setPadding(new Insets(10, 2, 10, 2));

      // Add nodes to sceneLayout (we are adding 5 Buttons from 1 to 5, and 5 Buttons with OK...
		// Loop around 5 times, each time...
      int row=0;
      for (int i = 1; i <= 5; i++){
			// ...construct and add a Button with the label i, to col 0, row row
         sceneLayout.add(new Button(String.valueOf(i)), 0, row);
			// and also add an OK button, to col 1, row row, then increment row
			sceneLayout.add(new Button("OK"), 1, row++);
		}

      // Construct scene to contain sceneLayout, and be 200 pixels wide, 250 high, and...
      scene=new Scene(sceneLayout);
 
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);
      primaryStage.setTitle("ShowGridPane");
      primaryStage.show();
   }
}