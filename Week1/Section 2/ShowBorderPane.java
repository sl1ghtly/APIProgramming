import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ShowBorderPane extends Application{
   // ShowBorderPane HAS-A Scene that uses BorderPane as its Layout Pane    
   private Scene scene;
   private BorderPane sceneLayout;
   @Override
   public void start(Stage primaryStage){
      // Create a BorderPane node called sceneLayout
      sceneLayout = new BorderPane();
      
      // Add nodes to sceneLayout
      // (we are adding a StackPane containing a Label to top and bottom, and
      //  a Button to Left, Right, and Center)
      StackPane top = new StackPane(new Label("This is the TOP!"));
      top.setStyle("-fx-border-color: red");
      top.setPadding(new Insets(10,2,10,2));     

      StackPane bottom = new StackPane(new Label("This is the BOTTOM!"));
      bottom.setStyle("-fx-border-color: red");
      bottom.setPadding(new Insets(10,2,10,2));         

      sceneLayout.setTop(top);
      sceneLayout.setLeft(new Button("This is the LEFT!"));
      sceneLayout.setCenter(new Button("This is the CENTER!"));
      sceneLayout.setRight(new Button("This is the RIGHT!"));          
      sceneLayout.setBottom(bottom);

      // Construct scene to contain sceneLayout, and...
      scene=new Scene(sceneLayout);

      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);
      primaryStage.setTitle("ShowBorderPane");
      primaryStage.show();
   }
}