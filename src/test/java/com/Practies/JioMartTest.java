package com.Practies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) {
		
		String Tab1="Groceries";
		String Opt ="Fruits & Vegetables";
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
	    WebElement e1 = driver.findElement(By.xpath("//a[.='"+Tab1+"']")); 
	    act.moveToElement(e1).perform();
	    act.moveToElement(driver.findElement(By.xpath("//ul[@class='header-nav-l2 custom-scrollbar']/descendant::a[.='"+Opt+"']"))).perform();
	    List<WebElement> listEle = driver.findElements(By.xpath("//a[@id='nav_level3_229']/../.."));
	    for (WebElement lv : listEle) {
			System.out.println(lv.getText());
		}
	    
	    driver.quit();
	}

}
