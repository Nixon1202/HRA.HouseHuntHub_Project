package com.AdminView;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class AdminViewofListOfUser_POMScriptTest {


	public static void main(String[] args) throws Throwable {
		
		WebDriverUtils wLib = new WebDriverUtils();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		DatabaseUtility dlib = new DatabaseUtility();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		
		//Launching Browser
		WebDriver driver= null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			 
		    }else if (BROWSER.equalsIgnoreCase("FireFox")) {
			
		    	driver=new FirefoxDriver();
		    }
			else {
					System.out.println("Invalid Browser");
				}
		
		//Enter URL
		driver.get(URL);
		wLib.pageLoadTimeOut(driver, 15);
		wLib.maximizeTheBrowser(driver);
		
		//Admin-Login and view List Of Registered User
		HomePage hp=new HomePage(driver);
		hp.clickOnLogIn();
		LogInPage lp = new LogInPage(driver);
		lp.logIn(USERNAME, PASSWORD);
		HomeDashBoardPage hdp = new HomeDashBoardPage(driver);
		hdp.clickRegisteredUserLnk();
		
		//Validate
		String ExpTilte= "List Of Usres";
		String PageTitle = driver.findElement(By.xpath("//h2[.='List Of Usres']")).getText();
        if (PageTitle.equalsIgnoreCase(ExpTilte)) {
			System.out.println("Admin is able to view list of Registered Users");
		} else {
			System.out.println("Admin is not able to view list of Registered Users");

		}
        
		//LogOut
		 hdp.clickLogOut();
		
		// Exit the Browser
		 driver.quit();
	}
}
