package com.Practies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCRankingTest {

	public static void main(String[] args) {
		String Countryname="Scotland";

		//launch browser
		WebDriver driver= new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//launch URL
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		// wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 List<WebElement> Cou = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		for (WebElement Lv : Cou) {
			String teaam= Lv.getText();
			if (teaam.equals(Countryname)) {
				System.out.println(Countryname+"is present");
			}
 
	}
	}}
