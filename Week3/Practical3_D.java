import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Practical3_D extends Application
{
   // declare items you will interact with
   private Scene scene;
   private BorderPane sceneLayout;
   private Label lbl;
   private Button btHappy, btUnsure, btSad;
      
   @Override
   public void start(Stage primaryStage)
   {
      // construct sceneLayout usint setTop and edit the label
      sceneLayout = new BorderPane();
      sceneLayout.setTop(lbl = new Label("Rate your Experience!"));
      BorderPane.setAlignment(lbl, Pos.CENTER);
      lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
      
      // construct buttons in sceneLayout
      sceneLayout.setLeft(btHappy = new Button("", new ImageView("image\\happy.png")));
      sceneLayout.setCenter(btUnsure = new Button("", new ImageView("image\\unsure.png")));
      sceneLayout.setRight(btSad = new Button("", new ImageView("image\\sad.png")));
      
      // set background of buttons
      btHappy.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
      btUnsure.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
      btSad.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
      
      // construct scene
      scene = new Scene(sceneLayout);
      
      // set scene and title
      primaryStage.setScene(scene);
      primaryStage.setTitle("Shopping Rater");
      primaryStage.show();
   }
}