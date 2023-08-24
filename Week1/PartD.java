import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class PartD extends Application
{
   // PartD HAS-A Scene that uses HBox as its layout
   private Scene scene;
   private HBox sceneLayout;
   // Declare label
   private Label lbl;
   // Declare buttons
   private Button okBt, cancelBt;
   
   @Override
   public void start(Stage primaryStage)
   {
      // Construct sceneLayout
      sceneLayout = new HBox();
      // Add a Label to sceneLayout
      sceneLayout.getChildren().add(lbl = new Label("Enter Data Here: "));
      // Add a TextField and 2 buttons to sceneLayout
      sceneLayout.getChildren().add(new TextField("Type Data"));
      sceneLayout.getChildren().add(okBt = new Button("Ok"));
      sceneLayout.getChildren().add(cancelBt = new Button("Cancel"));
      // Set text color of the buttons to BLUE
      okBt.setTextFill(Color.BLUE);
      cancelBt.setTextFill(Color.BLUE);
      // Create border
      lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));

      // Construct scene using sceneLayout
      scene = new Scene(sceneLayout, 350, 100);
      // Set the scene
      primaryStage.setScene(scene);
      // Set title and show the app
      primaryStage.setTitle("My First JavaFX Stage");
      primaryStage.show();
   }
}