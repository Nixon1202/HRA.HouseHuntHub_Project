package com.HRA.genericutils;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LogInPage;


public class Baseclass {

	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtils wLib = new WebDriverUtils();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public static WebDriver Sdriver;
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("Connected to DB");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Launching chrome browser");
		} else if(BROWSER.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            System.out.println("Launching firefox browser");
		}else if(BROWSER.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            System.out.println("Lauching Edge browser");
		}
		else {
			System.out.println("Invalid Browser");
		}
		wLib.pageLoadTimeOut(driver, 15);
		wLib.maximizeTheBrowser(driver);
		System.out.println("Browser is Launched");
		 Sdriver = driver;
		String URL = fLib.getPropertyKeyValue("url");
			
		driver.get(URL);
	}
	
//	@BeforeMethod(alwaysRun = true)
//	public void configBM() throws Throwable {
//		
//	String USERNAME = fLib.getPropertyKeyValue("username");
//	String PASSWORD = fLib.getPropertyKeyValue("password");
//	
//	HomePage hp = new HomePage(driver);
//	hp.clickOnLogIn();
//	LogInPage lp = new LogInPage(driver);
//	lp.logIn(USERNAME, PASSWORD);
//	System.out.println("Loged into Application");
//	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		HomeDashBoardPage hdp= new HomeDashBoardPage(driver);
		hdp.clickLogOut();
		System.out.println("LogOut of the Application");
	}
	
	@AfterClass(alwaysRun = true)
	public void  configAC() {
		driver.quit();
		System.out.println("Close the Browser");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		dLib.closeDB();
		System.out.println("Close the DB");
	}

	
}
