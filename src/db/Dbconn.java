package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconn {

	public static   Connection conGet() {
		 Connection	con = null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
