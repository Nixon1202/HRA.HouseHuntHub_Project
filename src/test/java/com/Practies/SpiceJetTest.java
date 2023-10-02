package com.Practies;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetTest {

	public static void main(String[] args) throws InterruptedException {
		String OriginName= "Bengaluru";
		String DestinationName= "Delhi";
		String MonthAndYear="September-2023";
		int Date=10;
		String ReturnMonthAndYear="November-2023";
		int ReturnDate=9;
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.spicejet.com/");
		//driver.findElement(By.xpath("//div[.='round trip']")).click();
	    driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		
		Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and .='"+OriginName+"']"))).click().perform();
        Thread.sleep(2000);
        act.moveToElement(driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and .='"+DestinationName+"']"))).click().perform();
 
//        driver.findElement(By.xpath("//div[.='Departure Date']")).click();
         act.moveToElement(driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+MonthAndYear+"']/descendant::div[text()='"+Date+"']"))).click().perform();
		Thread.sleep(1000);
         driver.findElement(By.xpath("//div[.='Return Date']")).click();
     
        for(;;) {
            try {
            	driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+ReturnMonthAndYear+"']/descendant::div[text()='"+ReturnDate+"']")).click();
   			break;
   		} catch (Exception e) {
   			driver.findElement(By.xpath("//*[name()='path' and @fill='#A0A0A0' ]/ancestor::div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']"));
   		}
            }
		
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		for(int i=1;i<5;i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		}
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		driver.findElement(By.xpath("//div[text()='USD']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();

	}

}
