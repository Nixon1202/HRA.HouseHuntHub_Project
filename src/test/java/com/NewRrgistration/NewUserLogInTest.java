package com.NewRrgistration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewUserLogInTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		
	    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		driver.findElement(By.xpath("//a[.='Register']")).click();
		driver.findElement(By.id("fullname")).sendKeys("James B");
		driver.findElement(By.id("username")).sendKeys("James007");
		driver.findElement(By.id("mobile")).sendKeys("8944653852");
		driver.findElement(By.id("email")).sendKeys("jamesbond007@gmail.com");
		driver.findElement(By.id("password")).sendKeys("james");
		driver.findElement(By.id("c_password")).sendKeys("james");
		driver.findElement(By.xpath("//button[@name='register']")).click();
		
		
	}

}
