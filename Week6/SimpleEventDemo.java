import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*; // 1+2+3 import EventHandler & ActionEvent

// SimpleEventDemo IS-A Application ==> Inheritance
public class SimpleEventDemo extends Application{
   // SimpleEventDemo HAS-A Scene that uses FlowPane as its Layout Pane,    
   private Scene scene;
   private FlowPane sceneLayout;
   // and contains one Button called btPressMe
   private Button btPressMe;
   
   @Override
   public void start(Stage primaryStage){
    	////////
      // Build scene
      ////////     
      // Construct the FlowPane node called sceneLayout...
      sceneLayout = new FlowPane();
      sceneLayout.setPadding(new Insets(10, 2, 10, 2));
      sceneLayout.setAlignment(Pos.CENTER);
      
      // ...Construct btPressMe and add it to sceneLayout...
      sceneLayout.getChildren().add(btPressMe= new Button("Press Me!")); 

      // Construct scene to contain sceneLayout & be 300x80 pixels...
      scene=new Scene(sceneLayout,300,80);
 
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("Event Handler Example");
      primaryStage.show();
      
      // 3. Create a listener object and...
      Listener listener = new Listener();
      // register it with btPressMe
      btPressMe.setOnAction(listener); 
   }  
}

// 1. Listener class that implements the EventHandler interface 
class Listener implements EventHandler<ActionEvent>{
   @Override
   // 2. Override the handle() method from the EventHandler interface
   public void handle(ActionEvent e){ 
      System.out.println("That felt good!"); 
   } 
}