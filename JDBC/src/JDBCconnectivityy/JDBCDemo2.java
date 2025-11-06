package JDBCconnectivityy;

import java.sql.DriverManager; 
import java.sql.Connection;
import java.sql.Statement;

public class JDBCDemo2 {
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/rohit";
	private static final String DBUSERNAME ="demo_user";
	private static final String DBPASSWORD = "demo_pass";
	
	private static final String QUERY = "insert into employee values(3,400000,'Nishant')";
	
	public static void main(String[] args) throws Exception{
		// Step:1 - First of all load the driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step:2 - Get the connection
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
		
		// Step:3 - Create the statement
		Statement stmt = con.createStatement(); 
		
		// Step:4 - Execute and the result
		int affectedRow = stmt.executeUpdate(QUERY);
		
		System.out.println("rowaffected :"+affectedRow);
		System.out.println("Succesfully executed.....");
		
		// Step:5 - Close the connection
		con.close();
		
	}

}
