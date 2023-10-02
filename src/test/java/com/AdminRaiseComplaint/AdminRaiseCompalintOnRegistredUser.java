package com.AdminRaiseComplaint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminRaiseCompalintOnRegistredUser {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriver driver= new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver. manage().window().maximize();
			
		    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		    driver.findElement(By.xpath("//a[.='Login']")).click();
		    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
		    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
		    driver.findElement(By.name("login")).click();
		    driver.findElement(By.linkText("Details/Update")).click();
		   // Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[.='Complaint']")).click();
	        driver.findElement(By.id("name")).sendKeys("Heshika1");
	        driver.findElement(By.id("cmp")).sendKeys("No water supply, No CCTV");
	        driver.findElement(By.xpath("//button[.='Submit']")).click();

	}

}
