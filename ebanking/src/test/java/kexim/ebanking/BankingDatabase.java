package kexim.ebanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BankingDatabase {
	public static ResultSet getDBTableContent(String url, String usrname, String password, String query) {
		ResultSet rs = null;
		try {

			// register database driver class dynamically
			Class.forName("com.mysql.jdbc.Driver");
			// create connection to the database
			Connection con = DriverManager.getConnection(url, usrname, password);
			// hashcode gets the object reference value
			 System.out.println(con.hashCode());
			// create statement class object
			Statement statement = con.createStatement();
			// execute queries and result will be stored in resultset class object
			rs = statement.executeQuery(query);
			
			// close data base connection
//			con.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
