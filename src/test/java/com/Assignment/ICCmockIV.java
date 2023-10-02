package com.Assignment;

import java.time.Duration;

import org.apache.commons.math3.optim.nonlinear.vector.jacobian.AbstractLeastSquaresOptimizer;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ICCmockIV {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/rankings-predictor/test");
		driver.findElement(By.xpath("//div[.='Accept']")).click();
		
		Actions act = new Actions(driver); 
		act.moveToElement(driver.findElement(By.xpath("//div[@class='rankings-predictor__counter']"))).perform();
		driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team='team1']/descendant::a[@class='btn up']")).click();
//		driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team-id='14']/descendant::a[@class='btn up']")).click();     
		driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team-id='11']/descendant::a[@class='btn up']")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//th[.='Team']"))).perform();
		String Rating = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText();
		Thread.sleep(2000);
		System.out.println("The team Rating---->"+Rating);
		driver.quit();
		
	}

}
