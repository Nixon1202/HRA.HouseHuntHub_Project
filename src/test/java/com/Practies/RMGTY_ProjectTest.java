package com.Practies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGTY_ProjectTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con = null;
		String expdata = "TY_PROJ_sdet0212";
		try {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak H R");
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//step1: register the DB
		//Register The Driver
				Driver driver1= new  Driver();
				DriverManager.registerDriver(driver1);
				//connect to database
				con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root", "root");
				// Create statement
				Statement state = con.createStatement();
				String query ="select * from project;";
				//Execute The Qurey
				ResultSet result = state.executeQuery(query);
				
				boolean flag = false;
				while(result.next())
				{
					String actual = result.getString(4);
					if(actual.equalsIgnoreCase(expdata))
					{
						flag = true;
						break;
					}
				}
				if(flag==true)
				{
					System.out.println("project is created");
				}
				else
				{
					System.out.println("project is not created");
				}
	}
			catch (Exception e)
			{
			}
			finally {
				con.close();

			}
}

}
