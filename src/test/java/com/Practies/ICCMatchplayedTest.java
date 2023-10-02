package com.Practies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCMatchplayedTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//launch URL
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> No_Matchs = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]"));
		List<WebElement> Teams = driver.findElements(By.xpath("//td[3][@class='table-body__cell u-center-text' and text()<40]/../descendant::td[2]/span[@class='u-hide-phablet']"));
            
		for(int i=0; i<Teams.size();i++)
		{
			System.out.println(Teams.get(i).getText()+"---------"+No_Matchs.get(i).getText());
		}
		driver.quit();
	}

}
