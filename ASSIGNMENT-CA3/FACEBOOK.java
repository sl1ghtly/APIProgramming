/**
* Class: B.Sc. in Computing
* Description: THE ASSIGNMENT
* Date: 07/04/2022
* @author Eryk Gloginski
* @version 1.0
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Alert.*;

public class FACEBOOK extends Application {
   // declare the Scene and BorderPane sceneLayout
   private Stage window;
   private Scene scene1, scene2;
   private BorderPane sceneLayout;
   
   // declare the GridPane topPane and StackPane imagePane and HBox rightPane
   private GridPane topPane;
   private StackPane imagePane;
   private VBox rightPane;
   
   // declare TextFields and Buttons for topPane
   private TextField txtEmail;
   private PasswordField txtPassword;
   private Button loginButton, signupButton;
   
   // declare TextFields, Button and Label for rightPane
   private TextField fname, lname, ename;
   private PasswordField pword;
   private Button signupButton2;
   private Label signUpLbl;
   
   // declare the image
   private ImageView fbImage;
   
   // declare the db connection
   private FacebookDB fbDb = new FacebookDB();
   
   public void start(Stage primaryStage) {
      // assign primaryStage to window so we can use it in other methods
      window = primaryStage;
   
      // set scene, program title and show it
      primaryStage.setScene(getFirstScene());
      primaryStage.setTitle("FACEBOOK");
      primaryStage.show();
   }
   
   // method to first scene
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
      scene1 = new Scene(sceneLayout);
      return scene1;
   }
   
   // method to get second scene
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
      scene2 = new Scene(sceneLayout);
      return scene2;
   }
   
   // method to get top pane
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
      topPane.add(txtPassword = new PasswordField(), 1, 1);
      topPane.add(loginButton = new Button("Log In"), 2, 0);
      topPane.add(signupButton = new Button("Sign Up"), 2, 1);
      
      // set the buttons to max width
      loginButton.setMaxWidth(Double.MAX_VALUE);
      signupButton.setMaxWidth(Double.MAX_VALUE);
      
      // set button colors
      loginButton.setStyle("-fx-background-color: #f0f8ff; -fx-font-weight: bold;");
      signupButton.setStyle("-fx-background-color: #f0f8ff; -fx-font-weight: bold;");
      
      // set buttons with border
      loginButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      signupButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // when loginButton is pressed
      loginButton.setOnAction(actionEvent -> {
         // if everything is correct, login, 
         System.out.println("Trying to Log in...");
         
         // take login email and login password into variables and get stored password from database
         String logEmail = txtEmail.getText();
         String logPass = txtPassword.getText();
         String password = fbDb.getUserPasswordFromDatabase(logEmail);
         
         // if the login password is the password from database
         if (logPass.equals(password)) {
            // Alert Information Dialog
            Alert logSuccess = new Alert(AlertType.INFORMATION);
            logSuccess.setTitle("Information");
            logSuccess.setHeaderText("Correct Password Entered!");
            logSuccess.setContentText("You have successfully logged in! ");
            logSuccess.showAndWait();
         }
         else {
            // Alert Error Dialog
            Alert logFail = new Alert(AlertType.ERROR);
            logFail.setTitle("Error");
            logFail.setHeaderText("Incorrect Password Entered!");
            logFail.setContentText("Your login attempt was unsuccessful! ");
            logFail.showAndWait();
         }
         
      });
      
      // when signupButton is pressed
      signupButton.setOnAction(actionEvent -> {
         // change scene to second scene
         window.setScene(getSecondScene());
      });
      
      // return topPane for first scene
      return topPane;
   }
   
   // method to get right pane
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
      rightPane.getChildren().add(pword = new PasswordField());
      pword.setPromptText("Enter Password");
      rightPane.getChildren().add(signupButton2 = new Button("Sign Up"));
      
      // set the buttons to max width
      signupButton2.setMaxWidth(Double.MAX_VALUE);
      
      // set button color, label bold text and borders
      signUpLbl.setStyle("-fx-font-weight: bold;");
      signUpLbl.setMaxWidth(Double.MAX_VALUE);
      signUpLbl.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      signupButton2.setStyle("-fx-background-color: #f0f8ff; -fx-font-weight: bold;");
      signupButton2.setBorder(new Border(new BorderStroke(Color.BLACK,
                                       BorderStrokeStyle.SOLID,
                                       new CornerRadii(0),
                                       new BorderWidths(1))));
      
      // when other sign up button is pressed
      signupButton2.setOnAction(actionEvent -> {
         // declare vars to store data
         String dbFname = fname.getText();
         String dbLname = lname.getText();
         String dbEname = ename.getText();
         String dbPword = pword.getText();
         
         if (dbFname.length() < 3 && dbLname.length() < 5 && dbEname.length() < 8 && dbPword.length() < 8) {
            // Alert Error Dialog
            Alert details = new Alert(AlertType.ERROR);
            details.setTitle("Error");
            details.setHeaderText("You do not meet the requirements!");
            details.setContentText("Length: 3 for First Name, 5 for Last Name, 8 for Email and Password. You will return to the login screen.");
            details.showAndWait();
            // return to first scene if stuff is not meeting requirements
            window.setScene(getFirstScene());
         }
         else {
            // create sql string
            String sqlStmt = "INSERT INTO user VALUES ('" + dbEname + "', '" + dbPword + "', '" + dbFname + "', '" + dbLname + "')" +
                          "ON DUPLICATE KEY UPDATE password='" + dbPword + "', firstname='" + dbFname + "', lastname='" + dbLname + "'";
            
            // execute sql statement
            fbDb.insertIntoDatabase(sqlStmt);
            
            // Alert Information Dialog
            Alert info = new Alert(AlertType.INFORMATION);
            info.setTitle("Information");
            info.setHeaderText("Congratulations!");
            info.setContentText("You have successfully signed up! Use your email and password to login! ");
            info.showAndWait();
            
            // change scene back to first after inserting sql string
            window.setScene(getFirstScene());
         }
      });
      
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