import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

// Microwave IS-A Application ==> Inheritance
public class Microwave extends Application{
   // Microwave HAS-A Scene that uses BorderPane as its Layout Pane
   private Scene scene;
   private BorderPane sceneLayout;
    
   // Microwave contains two sub layouts:-
   // A BorderPane layout called p2, and
   private BorderPane p2;
   // a GridPane layout called p1 
   private GridPane p1;

   // tmpBtn is a Button object for all the Button's in the GUI
   private Button tmpBtn;

   @Override
   public void start(Stage primaryStage){
      ////////
      // Build p1
      ////////
		// Construct the GridPane node called p1 and...
	   p1 = new GridPane();
      // Break the columns into percentage widths of 33,34,33
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(33.3);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(33.3);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(33.3);  
      p1.getColumnConstraints().addAll(col1,col2,col3);

      // ...add buttons to p1
      // row 1
      int col=0;
      for(int i = 1; i <= 3; i++){
         p1.add(tmpBtn=new Button("" + i),col++,0);
         // allow Button to grow to fill max width of cell
         tmpBtn.setMaxWidth(Double.MAX_VALUE);
      }
      // row 2
      col=0;
      for(int i = 4; i <= 6; i++){
         p1.add(tmpBtn=new Button("" + i),col++,1);
         // allow Button to grow to fill max width of cell
         tmpBtn.setMaxWidth(Double.MAX_VALUE);
      }
      // row 3
      col=0;
      for(int i = 7; i <= 9; i++){
         // allow Button to grow to fill max width of cell
         p1.add(tmpBtn=new Button("" + i),col++,2);
         tmpBtn.setMaxWidth(Double.MAX_VALUE);
      }
      
      tmpBtn=new Button("" + 0);
      // allow Button to grow to fill max width of cell     
      tmpBtn.setMaxWidth(Double.MAX_VALUE);
      p1.add(tmpBtn,0,3);
      tmpBtn=new Button("Start");
      // allow Button to grow to fill max width of cell
      tmpBtn.setMaxWidth(Double.MAX_VALUE);
      p1.add(tmpBtn,1,3);
      tmpBtn=new Button("Stop");
      // allow Button to grow to fill max width of cell
      tmpBtn.setMaxWidth(Double.MAX_VALUE);
      p1.add(tmpBtn,2,3);

      ////////
      // Build p2
      ////////
      // Construct the BorderPane node called p2 and...
      p2 = new BorderPane();
		// ...add a TextField and p1 to p2
      p2.setTop(new TextField("Time to be displayed here"));
      p2.setCenter(p1);

    	////////
      // Build scene
      ////////     
      // Construct the BorderPane node called sceneLayout...
      sceneLayout = new BorderPane();
      // Construct and add Button to left of sceneLayout, and...
      sceneLayout.setLeft(tmpBtn=new Button("Food to be placed here"));
      // ...add p2 to center of sceneLayout
      sceneLayout.setCenter(p2);     
      // allow Button to grow to fill max height of cell
      tmpBtn.setMaxHeight(Double.MAX_VALUE);

      // Construct scene to contain sceneLayout
      scene=new Scene(sceneLayout);

      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("The Front of a Microwave Oven");
      primaryStage.show();
   }
}