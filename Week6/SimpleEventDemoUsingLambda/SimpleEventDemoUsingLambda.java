import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.event.*; 

// SimpleEventDemoUsingLambda IS-A Application ==> Inheritance
public class SimpleEventDemoUsingLambda extends Application{
  // SimpleEventDemoUsingLambda HAS-A Scene that uses HBox as its Layout Pane...   
   private Scene scene;
   private HBox sceneLayout;
 
   // ...and has two Buttons
   private Button btOK, btCancel;

   @Override
   public void start(Stage primaryStage){
    	////////
      // Build scene
      ////////     
      // Construct the HBox node called sceneLayout...
      sceneLayout = new HBox(5);
      sceneLayout.setAlignment(Pos.CENTER);
      sceneLayout.getChildren().add(btOK=new Button("OK"));
      sceneLayout.getChildren().add(btCancel=new Button("Cancel"));
      // Construct scene to contain sceneLayout & be 100x60 pixels...
      scene=new Scene(sceneLayout,250,60);

      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("Handle Event");
      primaryStage.show();

      // Create and register anonymous inner class listener using lambda
      btOK.setOnAction(e->{    //Anonymous Class
         System.out.println("The OK button is clicked!");
      });
     
      // Create and register anonymous inner class listener using lambda
      btCancel.setOnAction(e->{//Anonymous Class
         System.out.println("The Cancel button is clicked!");
      });
   }
}