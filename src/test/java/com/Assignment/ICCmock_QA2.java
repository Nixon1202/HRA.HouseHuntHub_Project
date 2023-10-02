package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ICCmock_QA2 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
	    String Rank = "182";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
    	 List<WebElement> result = driver.findElements(By.xpath("//tbody/descendant::td[contains(.,'"+Rank+"')]/preceding::td[3]/child::span[@class='u-hide-phablet']"));
         for(WebElement lv:result) {
    	 System.out.println(lv.getText());
         }	
		
//         driver.quit();

}
}
