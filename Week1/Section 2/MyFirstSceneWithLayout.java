import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class MyFirstSceneWithLayout extends Application{
   // MyFirstSceneWithLayout HAS-A Scene,
   // that uses HBox as its layout & contains two Buttons
   private Scene scene;
   private HBox sceneLayout;
   private Button btOne, btTwo;
   @Override
   public void start(Stage primaryStage){
      // Construct the HBox node called sceneLayout
      sceneLayout=new HBox();
      // Construct and add btOne to sceneLayout
      sceneLayout.getChildren().add(btOne=new Button("ONE"));
     // Construct and add btTwo to sceneLayout
      sceneLayout.getChildren().add(btTwo=new Button("TWO"));
      // Construct scene to contain sceneLayout, and...
      // be 400 pixels wide, 300 high
      scene=new Scene(sceneLayout,400,300);
 
      // setScene() of primaryStage to scene
      primaryStage.setScene(scene);
      primaryStage.setTitle("The Primary Stage");
      primaryStage.show();
   }

   // main() HAS BEEN OMMITTED, but we could leave it in
}