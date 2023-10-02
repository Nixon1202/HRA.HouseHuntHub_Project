package com.Practies;

import java.time.Duration;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		String Month="October";
         int date= 12; 
		//launch browser
		WebDriver driver= new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		// wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//launch URL
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		Actions Act = new Actions(driver);         
        // Thread.sleep(3000);
         Act.moveByOffset(0, 80).click().perform();
         Thread.sleep(3000);
         
         driver.findElement(By.xpath("//span[.='Departure']")).click();
//         Thread.sleep(1000);
//         
//         driver.findElement(By.xpath("//div[.='September 2023']/ancestor::div[@role='grid']//descendant::p[.='"+date+"']")).click();
//           String actual= "//div[.='"+Month+" 2023']/ancestor::div[@role='grid']//descendant::p[.='"+date+"']";
//          Thread.sleep(1000);   
//           String nextArrow= "//span[@aria-label='Next Month']";         
         for(;;) {
         try {
			driver.findElement(By.xpath("//div[.='"+Month+" 2023']/ancestor::div[@role='grid']//descendant::p[.='"+date+"']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
         }
         
          
	    
}
}
