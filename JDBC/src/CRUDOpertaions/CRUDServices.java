package CRUDOpertaions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDServices {
	private static final String DBURL = "jdbc:mysql://localhost:3306/student";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASSWORD = "demo_pass";
	
	public  void insertData(int id , String name,String department,String city) throws SQLException {
		final String INSERT = "insert into sudentdata(id , name , department,city) values("+id+",'"+name+"','"+department+"','"+city+"')";
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
		Statement stmt = con.createStatement();
		int rowInsert = stmt.executeUpdate(INSERT);
		if(rowInsert>0) {
			System.out.println(rowInsert+" affected!");
		}else {
			System.out.println("insertion failed");
		}
	}
	
	public void  showData() throws SQLException {
		final String QUERY = "select * from sudentdata";
		
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			System.out.println(
				rs.getInt("id")+"  "+
				rs.getString("name")+"  "+
			rs.getNString("department")+"  "+
			rs.getString("city")
			);
		}
		
		con.close();
	}
	
	public void deleteData(int id) throws SQLException {
		final String DELETE = "delete from sudentdata where id="+id;
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
		Statement stmt = con.createStatement();
		int rowDelete = stmt.executeUpdate(DELETE);
		
		if(rowDelete>0) {
			System.out.println(rowDelete+" deleted!");
		}
		else {
			System.out.println("deletion failed");
		}
	}
	
}
