package com.Practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadandWriteInPropertyFile{
 public static void main(String[] args) throws Throwable {
	 Properties prop = new Properties();
	 prop.setProperty("username", "admin");
	 prop.setProperty("password", "admin");
	 prop.setProperty("url", "http://rmgtestingserver/domain/House_Rental_Application/");
	 prop.setProperty("browser", "chrome");
	 
	 //Write data
	 FileOutputStream fout = new FileOutputStream("./src/test/resources/commondata1.properties.txt");
	 prop.store(fout, "Write Data");
	 fout.close();
	 
	 //read data
	 FileInputStream fin = new FileInputStream("./src/test/resources/commondata1.properties.txt");
	 prop.load(fin);
	 
	 String USERNAME = prop.getProperty("username");
	 String PASSWORD = prop.getProperty("password");
	 String URL = prop.getProperty("url");
	 String BROWSER= prop.getProperty("brower");
	 
	 WebDriver driver= new ChromeDriver();
	 driver.get(URL);
//	 driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
	    driver.findElement(By.name("login")).click();
			 
	 
}
}
