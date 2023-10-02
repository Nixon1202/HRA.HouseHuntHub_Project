package com.Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_CalenderPopupTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int date = 31;
		//launch browser
		WebDriver driver= new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//launch URL
		driver.get("https://www.ksrtc.in/oprs-web/");
		// wait for pafe load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//identify the element & click
		driver.findElement(By.id("txtJourneyDate")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='"+date+"']")).click();
		
		

	}

}
