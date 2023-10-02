package com.Practies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NOSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int result=0;
		try {
		Driver driver= new Driver();
		//Register The Driver
		DriverManager.registerDriver(driver);
		//connect to database
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		// Create statement
		Statement state = con.createStatement();
		//Execute The Query/Update
		String query = "insert into project values('API','Sachin','Bengaluru',1),('Manual','Ashish','Bengaluru',1);";
        result = state.executeUpdate(query);
	}
catch (Exception e) {
	// TODO: handle exception
}
		finally {
			if (result>0) {
				System.out.println("data is presnt");
			}else {
				System.out.println("data is not updated");
			}
		}
}
}