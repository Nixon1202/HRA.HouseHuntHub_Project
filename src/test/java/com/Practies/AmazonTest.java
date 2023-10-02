package com.Practies;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTest {

	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in);
		String BrandName=Sc.next();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//div[@id='brandsRefinements']/descendant::*[text()='"+BrandName+"']")).click();
		List<WebElement> MobileNames = driver.findElements(By.xpath("//span[@class='a-price-whole'][ number(translate(text(),',',''))<20000]/ancestor::div[@class='sg-col-inner']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
	     
		for (WebElement lv : MobileNames) {
			System.out.println(lv.getText());
		}
	  driver.quit();
	}

}
