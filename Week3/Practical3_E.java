import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class Practical3_E extends Application
{
   // declare scene layout
   private Scene scene;
   private BorderPane sceneLayout;
   // declare 2 sub panes (top and bottom)
   private GridPane p1;
   private FlowPane p2;
   
   // declare objects you will edit
   private Label lblAmount, lblYears, lblRate, lblFuture;
   private TextField textAmount, textYears, textRate, textFuture;
   private Button btCalc;
      
   @Override
   public void start(Stage primaryStage)
   {
      // construct columns for gridpane scene layout
      p1 = new GridPane();
      p1.add(lblAmount = new Label("Investment Amount: "), 0, 0);
      p1.add(lblYears = new Label("Years: "), 0, 1);
      p1.add(lblRate = new Label("Annual Interest Rate: "), 0, 2);
      p1.add(lblFuture = new Label("Future Value: "), 0, 3);
      p1.add(textAmount = new TextField(), 1,0);
      p1.add(textYears = new TextField(), 1,1);
      p1.add(textRate = new TextField(), 1,2);
      p1.add(textFuture = new TextField(), 1,3);
      
      textAmount.setAlignment(Pos.CENTER_RIGHT);
      textYears.setAlignment(Pos.CENTER_RIGHT);
      textRate.setAlignment(Pos.CENTER_RIGHT);
      textFuture.setAlignment(Pos.CENTER_RIGHT);
      
      // set colum constraints to 50/50
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(50);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(50);
      p1.getColumnConstraints().addAll(col1,col2);
      
      // construct flowpane with button
      p2 = new FlowPane();
      p2.setAlignment(Pos.CENTER_RIGHT);
      p2.getChildren().add(btCalc = new Button("_Calculate"));
      
      // construct sceneLayout
      sceneLayout = new BorderPane();
      sceneLayout.setTop(p1);
      sceneLayout.setBottom(p2);
      
      // construct scene
      scene = new Scene(sceneLayout);
      
      // set scene and title
      primaryStage.setScene(scene);
      primaryStage.setTitle("Interest Calculator");
      primaryStage.show();
   }
}