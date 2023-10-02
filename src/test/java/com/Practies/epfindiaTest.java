package com.Practies;

import java.io.IOException;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class  epfindiaTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		 
		ArrayList<String> link = new ArrayList<String>();
		
		for(int i=0; i< listlinks.size();i++) {
			String eachlink= listlinks.get(i).getAttribute("href");
			
		      URL url= null;
		      int statusCode=0;
		      
		      try {
				url= new URL(eachlink);
				
				url= new URL(eachlink);
				HttpsURLConnection httpsConn= (HttpsURLConnection)url.openConnection();
				
				statusCode=httpsConn.getResponseCode();
				if (statusCode>=400) {
					link.add(eachlink+"---->"+statusCode);
					link.add(eachlink+"---->"+statusCode);
				}}
				
			catch (Exception e) {
				{
					link.add(eachlink);
					
				}
				System.out.println(eachlink+"---->"+statusCode);
			}
			
		}
		

	}

}
