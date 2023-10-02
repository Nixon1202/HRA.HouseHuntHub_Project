package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathPractie {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		List<WebElement> userList = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td/a[@target='_blank']"));
		for (WebElement lv : userList) {
			String UserName = lv.getText();
			System.out.println(UserName);
		}
		driver.quit();
	}

}
