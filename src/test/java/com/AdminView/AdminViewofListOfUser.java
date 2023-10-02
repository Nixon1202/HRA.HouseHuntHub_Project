package com.AdminView;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminViewofListOfUser {


	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		
	    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.xpath("//span[@class='badge badge-pill badge-success']")).click();
	    
		

	}
}
