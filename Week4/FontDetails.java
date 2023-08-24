import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.List;

// FontDetails IS-A Application ==> Inheritance
public class FontDetails extends Application {
   // FontDetails HAS-A Scene that uses BorderPane as its Layout Pane
   private Scene scene;
   private BorderPane sceneLayout;
   private TextArea taMessage;
   
   @Override
   public void start(Stage primaryStage) {
   	////////
      // Build scene
      ////////     
      // Construct the BorderPane node called sceneLayout...
      sceneLayout = new BorderPane();
      //setTop() sceneLayout to getTopPane()
      sceneLayout.setTop(getTopPane());
      
      //set the text area and set rows, columns and text wrap
      taMessage = new TextArea("Welcome to Java");
      taMessage.setPrefRowCount(3);
      taMessage.setPrefColumnCount(20);
      taMessage.setWrapText(true);
      sceneLayout.setCenter(taMessage);
      
      //setBottom() sceneLayout to getBottomPane()
      sceneLayout.setBottom(getBottomPane());
      
      // set bottom check boxes
      
      // Construct scene to contain sceneLayout
      scene = new Scene(sceneLayout);
      
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("Set Font Details");
      primaryStage.show();
   }
   
   private HBox getTopPane() {
      // Declare and construct topPane, it uses HBox and has,
      HBox topPane = new HBox(5);
      topPane.setPadding(new Insets(10));

      // two Labels, and two ComboBoxes
      ComboBox cbFontName, cbFontSize;

      // add controls to topPane
      topPane.getChildren().add(new Label("Font Name"));
      topPane.getChildren().add(cbFontName=new ComboBox());
      topPane.getChildren().add(new Label("Font Size"));
      topPane.getChildren().add(cbFontSize=new ComboBox());

      // font names and add them all and set default value
      List<String> fontnames = Font.getFontNames();
      cbFontName.getItems().addAll(fontnames);
      cbFontName.setValue("SansSerif");
      
      // font sizes and add them all and set default value
      for (int i = 1; i <= 100; i++) {
         cbFontSize.getItems().add(i);
      }
      cbFontSize.setValue(12);

      return topPane;
   }
   
   private HBox getBottomPane() {
      //declare and construct bottomPane
      HBox bottomPane = new HBox(5);
      bottomPane.setPadding(new Insets(10));
      bottomPane.setAlignment(Pos.CENTER);
      
      //declare buttons and add them to scene
      CheckBox cbBold, cbItalic;
      cbBold = new CheckBox("_Bold");
      cbItalic = new CheckBox("_Italic");
      
      bottomPane.getChildren().add(cbBold);
      bottomPane.getChildren().add(cbItalic);
      
      return bottomPane;
   }
}