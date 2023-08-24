/**
* Class: B.Sc. in Computing
* Description: A JDBCFacebookDB class - Contains methods to work with the Facebook database
* Date: 12/03/2022
* @author Maria Boyle
* @version 1.0
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class FacebookDB implements DBOperations{
   // JDBC database URL, user name and password
	private final String DB_URL = "jdbc:mysql://localhost/";
   private final String DB_URL_FB = "jdbc:mysql://localhost/facebook";
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
   
   private Connection conn;
   
   // Constructor
   public FacebookDB(){
      conn=null;
   }

   ////
   // createConnection() - Opens a connection to DB_URL
   ////
   public void createConnection(String dbUrl){
		try{
			// STEP 1 - Open a connection
			//          Use the DriverManager.getConnection() method to create a Connection object,
			//          which represents a physical connection with the database server.
		   conn = DriverManager.getConnection(dbUrl, USER_NAME, PASSWORD);
		   System.out.println("COMPLETE - Connection obtained...");
      }
		catch (SQLException e) {
			System.out.println("Cannot create connection.\n" + e.getMessage());
		}
   }
   
   ////
   // createDatabase() - Calls createConnection(), creates a database called facebook with a table called user
   ////
   public void createDatabase(){
		try{
         // createConnection() to localhost
         createConnection(DB_URL);

 	      // Create Statement object		    
  	      Statement stmt = conn.createStatement();
 	      System.out.println("COMPLETE - Statement object created...");
          
	      // Execute Update to Create a Database called facebook
		   String createDatabase = "CREATE DATABASE IF NOT EXISTS facebook"; 
		   stmt.executeUpdate(createDatabase);
		   System.out.println("COMPLETE - Update executed and facebook database created...");
          
		   // Execute Update to Create a Table called user
		   String createTable = "CREATE TABLE IF NOT EXISTS user " +
	                            "(emailaddress VARCHAR(24) not NULL, " +
	                            " password VARCHAR(18), " + 
	                            " firstname VARCHAR(20), " + 
	                            " lastname VARCHAR(20), " + 
	                            " PRIMARY KEY (emailaddress))"; 

		   stmt.executeUpdate("USE facebook");
		   stmt.executeUpdate(createTable);
		   System.out.println("COMPLETE - Update executed and user table added to facebook database...");
         
         // Call closeConnection() method to close the connection
         closeConnection();
      }
		catch (SQLException e){
			System.out.println("Problem with SQL.\n" + e.getMessage());
		}
   }

   ////
   // closeConnection() - Closes the connection
   ////
   public void closeConnection(){   
		try{
			if(conn != null){
            conn.close();
		      System.out.println("COMPLETE - Connection closed.");				
         }
		}
		catch (SQLException e){
			System.out.println("Could not close connection.\n" + e.getMessage());
		}
   }
   
   ////
   // ADD PART A HERE
   // insertIntoDatabase() - Calls createConnection() to connect to facebook database, 
   //                      - and executes an sqlString to inserts a user into the user table in the facebook database
   ////
   public void insertIntoDatabase(String fbSqlStmt){
      try{
         // It should connect to the facebook database
         createConnection(DB_URL_FB);
         Statement stmt = conn.createStatement();
         
         // Create the SQL INSERT string
         // If the user already exists in the user table, that users details should simply be updated
         // Execute the SQL INSERT string to insert a user
         stmt.executeUpdate(fbSqlStmt);
         
         // InsertIntoDatabase() should close() the connection to the facebook database when finished
         closeConnection();
      }
      catch (SQLException e){
			System.out.println("Could not close connection.\n" + e.getMessage());
		}
   }
   ////
   // ADD PART C HERE
   // getUserPasswordFromDatabase() - Calls createConnection() to connect to facebook database, 
   //                               - Selects all users with a required emailaddress (at most one should exist),
   //                               - and gets and returns that users password
   ////
   public String getUserPasswordFromDatabase(String fbEmail){
      // declare password variable
      String password = "default";
      try{
         // It should connect to the facebook database
         createConnection(DB_URL_FB);
         
         // declare the query variable that will be used
         String theQuery = "SELECT password FROM user WHERE emailaddress = '" + fbEmail + "'";
         Statement stmt = conn.createStatement();
         
         // query the database for all users with the required fbEmail and return the password
         ResultSet results = stmt.executeQuery(theQuery);
         while (results.next()) {
            password = results.getString("password");
         }
         
         // InsertIntoDatabase() should close() the connection to the facebook database when finished and return the password
         closeConnection();
      }
      catch (SQLException e){
			System.out.println("Could not close connection.\n" + e.getMessage());
		}
      return password;
   }

}