import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MyFirstScene extends Application{
   // MyFirstScene HAS-A Scene containing a Button
   private Scene scene;
   private Button btOK;
   @Override
   public void start(Stage primaryStage){
      // Construct btOK
      btOK=new Button("OK");

      // Construct scene to contain btOK, and
      // be 400 pixels wide, 300 high
      // containing btOK
      scene=new Scene(btOK,400,300);
 
      // setScene() of primaryStage to scene
      primaryStage.setScene(scene);
      primaryStage.setTitle("The Primary Stage");
      primaryStage.show();
   }

   // main() HAS BEEN OMMITTED, but we could leave it in
}