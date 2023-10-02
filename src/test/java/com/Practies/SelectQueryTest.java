package com.Practies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con =null;
		try {
		Driver driver= new  Driver();
		//Register The Driver
		DriverManager.registerDriver(driver);
		//connect to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		// Create statement
		Statement state = con.createStatement();
		String query ="select * from project;";
		//Execute The Qurey
		ResultSet Result = state.executeQuery(query);
		
		while(Result.next()) {
                            String value = Result .getString(1)+" "+Result.getString(2)+" "+Result.getString(3)+" "+Result.getString(4);
			//			System.out.println(Result .getString(1)+" "+Result.getString(2)+" "+Result.getString(3)+" "+Result.getString(4));
                            System.out.println(value);
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
	}

}
