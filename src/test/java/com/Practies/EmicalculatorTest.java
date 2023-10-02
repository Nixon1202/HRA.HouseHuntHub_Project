package com.Practies;

import java.time.Duration;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmicalculatorTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//th[.='Year']"))).perform();
		Thread.sleep(2000);
		 	
		
		   
     WebElement Node = driver.findElement(By.xpath("//*[@fill='#B8204C' and @class='highcharts-point' ][2]"));
     act.moveToElement(Node).perform();
     System.out.println(Node.getText());
     Thread.sleep(1000);
     WebElement TooltipText = driver.findElement(By.xpath("//*[name()= 'tspan' and text() = 'Year : 2032']/.."));
     Thread.sleep(2000);
     System.out.println(TooltipText.getText()); 
     
	}

}
