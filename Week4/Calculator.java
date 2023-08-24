import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.List;

// FontDetails IS-A Application ==> Inheritance
public class Calculator extends Application{
   // FontDetails HAS-A Scene that uses BorderPane as its Layout Pane
   private Scene scene;
   private BorderPane sceneLayout;
   
   private TextField tfNum1, tfNum2, tfResult;
   
   private Button btAdd, btSubtract, btMultiply, btDivide;

   @Override
   public void start(Stage primaryStage){
   	////////
      // Build scene
      ////////     
      // Construct the BorderPane node called sceneLayout...
      sceneLayout = new BorderPane();
      
      sceneLayout.setTop(getTopPane());
      sceneLayout.setBottom(getBottomPane());
     
      // Construct scene to contain sceneLayout
      scene=new Scene(sceneLayout);
      
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("Calculator");
      primaryStage.show();
   }
   
   private HBox getTopPane() {
      // declare top pane, set padding and it's allignment
      HBox topPane = new HBox(5);
      topPane.setPadding(new Insets(5));
      topPane.setAlignment(Pos.CENTER);
      
      // declare text fields and set them to x and labels
      
      topPane.getChildren().add(new Label("Number 1"));
      topPane.getChildren().add(tfNum1 = new TextField("10"));
      topPane.getChildren().add(new Label("Number 2"));
      topPane.getChildren().add(tfNum2 = new TextField("10"));
      topPane.getChildren().add(new Label("Result"));
      topPane.getChildren().add(tfResult = new TextField());
      tfResult.setEditable(false);
      
      // example of adding them
      int num1 = Integer.valueOf(tfNum1.getText());
      int num2 = Integer.valueOf(tfNum2.getText());
      tfResult.setText("" + (num1 + num2));
      
      // set width and alignment of inside text
      tfNum1.setPrefWidth(40);
      tfNum2.setPrefWidth(40);
      tfResult.setPrefWidth(60);
      tfNum1.setAlignment(Pos.CENTER_RIGHT);
      tfNum2.setAlignment(Pos.CENTER_RIGHT);
      tfResult.setAlignment(Pos.CENTER_RIGHT);
      
      return topPane;
   }
   
   private GridPane getBottomPane() {
      // declare and construct bottomPane
      GridPane bottomPane = new GridPane();
      bottomPane.setHgap(5);
      bottomPane.setPadding(new Insets(5));
      bottomPane.setAlignment(Pos.CENTER);
      
      // declare columns and set columns to 25%
      
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(25);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(25);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(25);
      ColumnConstraints col4 = new ColumnConstraints();
      col4.setPercentWidth(25);
      bottomPane.getColumnConstraints().addAll(col1, col2, col3, col4);
      
      
      // add buttons into proper rows
      bottomPane.add(btAdd = new Button("_Add"), 0, 0);
      bottomPane.add(btSubtract = new Button("_Subtract"), 1, 0);
      bottomPane.add(btMultiply = new Button("_Multiply"), 2, 0);
      bottomPane.add(btDivide = new Button("_Divide"), 3, 0);
      
      // stretch buttons
      btAdd.setMaxWidth(Double.MAX_VALUE);
      btSubtract.setMaxWidth(Double.MAX_VALUE);
      btMultiply.setMaxWidth(Double.MAX_VALUE);
      btDivide.setMaxWidth(Double.MAX_VALUE);
      
      return bottomPane;
   }
}