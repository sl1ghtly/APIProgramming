import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class FACEBOOK extends Application {
   // declare the Scene and BorderPane sceneLayout
   private Scene scene;
   private BorderPane sceneLayout;
   
   // declare the GridPane topPane and StackPane imagePane and HBox rightPane
   private GridPane topPane;
   private StackPane imagePane;
   private VBox rightPane;
   
   // declare TextFields and Buttons for topPane
   private TextField txtEmail, txtPassword;
   private Button loginButton, signupButton;
   
   // declare TextFields, Button and Label for rightPane
   private TextField fname, lname, ename, pword;
   private Button sButton;
   private Label signUpLbl;
   
   // declare the image
   private ImageView fbImage;
   
   public void start(Stage primaryStage) {
      // set scene, program title and show it
      primaryStage.setScene(getFirstScene());
      primaryStage.setTitle("FACEBOOK");
      primaryStage.show();
      
      // when signupButton is pressed
      signupButton.setOnAction(actionEvent -> {
         // change scene to second scene
         primaryStage.setScene(getSecondScene());
      });
      
      // when other sign up button is pressed
      //sButton.setOnAction(actionEvent -> {
      //   // change scene to second scene
      //   primaryStage.setScene(getFirstScene());
      //});
   }
   
   // method to get top pane
   private Scene getFirstScene() {
      // create scene layout border pane
      sceneLayout = new BorderPane();
      sceneLayout.setTop(getTopPane());
      sceneLayout.setBottom(getImagePane());
      
      // set border for sceneLayout
      sceneLayout.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // declare scene using sceneLayout and return it
      scene=new Scene(sceneLayout);
      return scene;
   }
   
   private Scene getSecondScene() {
      // create scene layout border pane
      sceneLayout = new BorderPane();
      sceneLayout.setLeft(getImagePane());
      sceneLayout.setRight(getRightPane());
      
      // set border for sceneLayout
      sceneLayout.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // declare scene using sceneLayout and return it
      scene=new Scene(sceneLayout);
      return scene;
   }
   
   private GridPane getTopPane() {
      // declare the topPane to return later
      topPane = new GridPane();
      
      // set columns to 25, 50, 25 width in %
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(25);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(50);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(25);
      
      // add all columns
      topPane.getColumnConstraints().addAll(col1, col2, col3);
      
      // add labels, text fields and buttons
      topPane.add(new Label("Email: "), 0, 0);
      topPane.add(new Label("Password: "), 0, 1);
      topPane.add(txtEmail = new TextField(), 1, 0);
      topPane.add(txtPassword = new TextField(), 1, 1);
      topPane.add(loginButton = new Button("_Log In"), 2, 0);
      topPane.add(signupButton = new Button("_Sign Up"), 2, 1);
      
      // set the buttons to max width
      loginButton.setMaxWidth(Double.MAX_VALUE);
      signupButton.setMaxWidth(Double.MAX_VALUE);
      
      // set button colors
      loginButton.setStyle("-fx-background-color: #f0f8ff;");
      signupButton.setStyle("-fx-background-color: #f0f8ff;");
      
      // set buttons with border
      loginButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      signupButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // return topPane for first scene
      return topPane;
   }
   
   private VBox getRightPane() {
      // declare the topPane to return later
      rightPane = new VBox();
      
      // add labels, text fields with prompt text and button
      rightPane.getChildren().add(signUpLbl = new Label("Sign Up"));
      rightPane.getChildren().add(fname = new TextField());
      fname.setPromptText("Enter First Name");
      rightPane.getChildren().add(lname = new TextField());
      lname.setPromptText("Enter Last Name");
      rightPane.getChildren().add(ename = new TextField());
      ename.setPromptText("Enter Email Address");
      rightPane.getChildren().add(pword = new TextField());
      pword.setPromptText("Enter Password");
      rightPane.getChildren().add(sButton = new Button("_Sign Up"));
      
      // set the buttons to max width
      sButton.setMaxWidth(Double.MAX_VALUE);
      
      // set button color, label bold text and borders
      signUpLbl.setStyle("-fx-font-weight: bold;");
      signUpLbl.setMaxWidth(Double.MAX_VALUE);
      signUpLbl.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      sButton.setStyle("-fx-background-color: #f0f8ff; -fx-font-weight: bold;");
      sButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // return rightPane for second scene
      return rightPane;
   }

   
   // method to get image pane
   private StackPane getImagePane() {
      // declare the topPane to return later
      imagePane = new StackPane();
      
      // declare the image and add it to the imagePane
      fbImage = new ImageView("images\\facebook.png");
      imagePane.getChildren().add(fbImage);
      
      // set the border on the imagePane
      imagePane.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // return imagePane for both scenes
      return imagePane;
   }
   
}