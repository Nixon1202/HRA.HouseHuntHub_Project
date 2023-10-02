package com.Practies;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo_CalenderPopupTest {

	public static void main(String[] args) {
		
		String MonthName="May";
		String year = "2024";
		int date = 1;
		
		//launch browser
		WebDriver driver= new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//launch URL
		driver.get("https://www.goibibo.com/");
		// wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		//driver.findElement(By.xpath("//div[.='"+MonthName +" 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
	    String actual ="//div[.='"+MonthName +""+year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
	    String nextArrow= "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
		for(;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
				
			}
			
		}
		driver.findElement(By.xpath("(//span[.='Done']")).click();
	 
	}

}
