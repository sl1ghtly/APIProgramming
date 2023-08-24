import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Template extends Application
{
   // declare items you will interact with
   private Scene scene;
   private BorderPane sceneLayout;
   private Label lbl;
   private Button btHappy, btUnsure, btSad;
      
   @Override
   public void start(Stage primaryStage)
   {
      // construct sceneLayout
      sceneLayout = new BorderPane();
      
      // construct scene
      scene = new Scene(sceneLayout);
      
      // set scene and title
      primaryStage.setScene(scene);
      primaryStage.setTitle("Template");
      primaryStage.show();
   }
}