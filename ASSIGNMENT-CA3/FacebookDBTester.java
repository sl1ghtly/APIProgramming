public class FacebookDBTester{
	public static void main(String[] args) {
      FacebookDB fbDb = new FacebookDB();
      
      // comment out whatever is needed

      //fbDb.createDatabase();
      
      //String sql = "INSERT INTO user VALUES ('bart.simpson@lyit.ie', 'LetMeIn', 'Bart', 'Simpson') " +
      //             "ON DUPLICATE KEY UPDATE password='LetMeIn', firstname='Bart', lastname='Simpson'";
      
      //fbDb.insertIntoDatabase(sql);
      
      String password = fbDb.getUserPasswordFromDatabase("bart.simpson@lyit.ie");
      // Should display "LetMeIn"
      System.out.println("Password is " + password); 

	}
}