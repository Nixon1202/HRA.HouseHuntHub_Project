package com.Practies;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OlympicRankingTest {

	public static void main(String[] args) throws InterruptedException {
		
		String CountryName="Argentina";
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		

		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		Thread.sleep(10000);
		 driver.findElement(By.id("onetrust-accept-btn-handler")).click();
//		WebElement btn = driver.findElement(By.id("onetrust-accept-btn-handler"));
//		wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
		List<WebElement> allConNames = driver.findElements(By.xpath("//span[@data-cy='country-name' and .='"+CountryName+"']"));
		List<WebElement> GoldMedal = driver.findElements(By.id("//div[@data-cy='medal'and @title='Gold']"));
		List<WebElement> SilverMedal = driver.findElements(By.xpath("//div[@data-cy='medal'and @title='Silver']"));
		List<WebElement> BronzeMedal = driver.findElements(By.xpath("//div[@data-cy='medal'and @title='Bronze']"));
		 
		for (int i =1 ; i<=allConNames.size();i++) 
		{
			String Cname=allConNames.get(i).getText();
			
			if (Cname.equalsIgnoreCase(CountryName)) 
			{
				
				String FinalTable= allConNames.get(i).getText()+" Gold="+ GoldMedal.get(i).getText()+" Silver="+ SilverMedal.get(i).getText()+" Bronze="+ BronzeMedal.get(i).getText();				
				System.out.println(FinalTable);
				break;
			}	
		}
		driver.quit();
	}
		
	}

