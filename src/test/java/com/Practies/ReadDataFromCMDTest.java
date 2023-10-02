package com.Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCMDTest {

	@Test
	public void cmdTest() {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String LOGINURL = System.getProperty("loginurl");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		//Launch the browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(LOGINURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		System.out.println(BROWSER);
		System.out.println(LOGINURL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
