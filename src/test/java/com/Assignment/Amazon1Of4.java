package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon1Of4 {
	public static void main(String[] args) {
		
	WebDriver driver= new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/s?k=iphone+14+pro+max&crid=3GYOTL14H1E5D&sprefix=iphone+14+pr%2Caps%2C219&ref=nb_sb_ss_ts-doa-p_2_12");
    List<WebElement> first4 = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']/descendant::div[@class='sg-row']/descendant::span[@class='a-size-medium a-color-base a-text-normal'][position() <=4]"));
    for (int i = 0; i <4; i++) {
		System.out.println(first4.get(i).getText());
	}
	driver.quit();
	
	}
}