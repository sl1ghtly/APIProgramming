import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// ShowImage IS-A Application ==> Inheritance
public class ShowImage extends Application{
   // ShowImage HAS-A Scene using HBox as its Layout Pane    
   private Scene scene;
   private HBox sceneLayout;
   @Override
   public void start(Stage primaryStage){
      // ...Construct the HBox node called sceneLayout, with spacing of 10 between nodes...
      sceneLayout = new HBox(10);
   
      Image image = new Image("image\\us.gif");
      sceneLayout.getChildren().add(new ImageView(image));

      ImageView imageUsingImageView = new ImageView("image\\us.gif");
      imageUsingImageView.setFitHeight(100);
      imageUsingImageView.setFitWidth(200);
      sceneLayout.getChildren().add(imageUsingImageView);

      ImageView rotatedImage = new ImageView("image\\us.gif");
      rotatedImage.setRotate(90);
      sceneLayout.getChildren().add(rotatedImage);

      // Construct scene to contain sceneLayout
      scene=new Scene(sceneLayout,520,150);

      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("ShowImage");
      primaryStage.show();
   }
}