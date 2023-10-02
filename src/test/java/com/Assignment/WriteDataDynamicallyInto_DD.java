package com.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class WriteDataDynamicallyInto_DD {

	public static void main(String[] args) throws Throwable {
	for(;;) {	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Name:");
	String Name= sc.nextLine();
	Random ran= new Random();
	int ranDomNum= ran.nextInt(500);
	Connection con = null; 
	int result = 0;
	
	try {
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);	
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
     Statement checkStatement = con.createStatement();
     String checkQuery="Select * from tyss WHERE Name IN ('"+Name+"');";
     ResultSet Result = checkStatement.executeQuery(checkQuery);
     if (!Result.next()) {
    	 Statement insertStatement = con.createStatement();
    	 String insertQuery = "insert into tyss values("+ranDomNum+",'"+Name+"')";
    	 result = insertStatement.executeUpdate(insertQuery);
    	 System.out.println(Name+" is inserted into table");
	} else {
    	System.out.println(Name+" is already present in the table");

	}
	}
     catch (Exception e) {
		// TODO: handle exception
	}
}
	}
}
