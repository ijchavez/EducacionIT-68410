package clase6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Database {
	String dbUrl;
	String username;
	String password;
	
	static String selectQuery = "select * from Personas;";
	static String selectMinorThan28Query = "select * from Personas where edad < 28;";
	static String insertQuery = "INSERT INTO Personas (nombre, apellido, edad, email, telefono) VALUES(?, ?, ?, ?, ?);";
	
	static Connection con;
	@BeforeTest 
	public void irUrl() throws IOException, SQLException, ClassNotFoundException {
		dbUrl = "jdbc:mysql://localhost:3306/mydb";
		username = "root";
		password = "su contraseña";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dbUrl,username,password);
	}
	@Test
	public void dbSelectTest() throws ClassNotFoundException, SQLException, IOException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);

		while (rs.next()){
			 String id = rs.getString(1);
			 String name = rs.getString(2);
			 String lastName = rs.getString(3);
			 String age = rs.getString(4);
			 String email = rs.getString(5);
		     String phone = rs.getString(6);
			 
		     System.out.println(id + " " + name + " " + lastName + " " + age + " " + email + " " + phone);
		
		}

	}
	@Test
	public void dbInsertTest() throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement pmtm = con.prepareStatement(insertQuery);
		pmtm.setString(1, "Martin");
		pmtm.setString(2, "Suarez Helmann");
		pmtm.setInt(3, 44);
		pmtm.setString(4, "martinsuarez@email.com");
		pmtm.setString(5, "661-116-1166");
		
		int affectedRows = pmtm.executeUpdate();
		Assert.assertTrue(affectedRows > 0);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);

		while (rs.next()){
			 String id = rs.getString(1);
			 String name = rs.getString(2);
			 String lastName = rs.getString(3);
			 String age = rs.getString(4);
			 String email = rs.getString(5);
		     String phone = rs.getString(6);
			 
		     if(name.equals("Martin")) {
		    	 if(lastName.equals("Suarez Helmann")) { 		 
		    		 System.out.println(id + " " + name + " " + lastName + " " + age + " " + email + " " + phone);		    
		    	 }
		     }
		
		}

	}
	@AfterTest
	public void tearDown() throws SQLException {
		con.close();

	}
	
}
