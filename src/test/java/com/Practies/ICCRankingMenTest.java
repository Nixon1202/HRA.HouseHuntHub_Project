package com.Practies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCRankingMenTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		String Team="India";
		driver.manage().window().maximize();
		//launch URL
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 List<WebElement> TeamName = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2][text()='India']"));
          List<WebElement> TeamStatus = driver.findElements(By.xpath("//table/tbody/tr[*]/td[@class='rankings-block__banner--matches']/following-sibling::td[@class='rankings-block__banner--points']/following-sibling::td[@class='rankings-block__banner--rating u-text-right']"));	
	for (WebElement lv : TeamStatus) {
		String SelectedTeam= lv.getText();
		if(SelectedTeam.equalsIgnoreCase(Team)) {
			System.out.println(lv.getText());
		}
	}
	
	}

}
