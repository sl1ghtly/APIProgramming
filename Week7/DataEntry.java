import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class DataEntry extends Application {
   
   //declare scene and border pane
   private Scene scene;
   private BorderPane sceneLayout;
   
   //declare grid pane and text fields
   private GridPane topPane;
   private TextField tfName, tfIDNumber;
   
   //declare text area
   private TextArea taDetails;
   
   @Override
   public void start(Stage primaryStage) {
      //construct border pane and set top pane
      sceneLayout = new BorderPane();
      sceneLayout.setTop(getTopPane());
      
      //construct taDetails text area and set prefered column and row count
      sceneLayout.setCenter(taDetails = new TextArea());
      taDetails.setPrefColumnCount(24);
      taDetails.setPrefRowCount(4);
      
      //construct scene using sceneLayout
      scene = new Scene(sceneLayout);
      
      //set scene, title and show 
      primaryStage.setScene(scene);
      primaryStage.setTitle("DATA ENTRY");
      primaryStage.show();
   }
   
   public GridPane getTopPane() {
      //construct top pane using grid pane
      topPane = new GridPane();
      
      //set columns to 50% width
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(50);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(50);
      topPane.getColumnConstraints().addAll(col1, col2);
      
      topPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
                                       CornerRadii.EMPTY, Insets.EMPTY)));
                                       
      topPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID, new CornerRadii(0),
                                       new BorderWidths(1))));
      
      //construct and add 2 labels, 2 textfields
      topPane.add(new Label("NAME"), 0, 0);
      topPane.add(new Label("ID"), 0, 1);
      topPane.add(tfName = new TextField(), 1, 0);
      topPane.add(tfIDNumber = new TextField(), 1, 1);
      
      //anonymous inner classes for listeners
      tfName.setOnAction(e-> {
         //append text from tfName into taDetails
         taDetails.appendText(tfName.getText() + " ");
         //set focus to tfIDNumber text field
         tfIDNumber.requestFocus();
      });
      
      tfIDNumber.setOnAction(e-> {
         //append text from tfIDNumber into taDetails with new line
         taDetails.appendText("ID: " + tfIDNumber.getText() + ".\n");
         //clear both text fields
         tfName.setText("");
         tfIDNumber.setText("");
         //set focus to tfName text field
         tfName.requestFocus();
      });
      
      return topPane;
   }
}