package com.Admin_Home_Registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hpsf.HPSFPropertiesOnlyDocument;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.IndividualHomeRegistrationPage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class AdminIndividualHomeRegistrationUsing_POMscriptTest {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriverUtils wLib = new WebDriverUtils();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		DatabaseUtility dlib = new DatabaseUtility();
		

		/*	FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fil);*/
		
		//fetching the values from property file
		
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
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   wLib.implicitwait(driver, 15);	   
//	   driver. manage().window().maximize();
	   wLib.maximizeTheBrowser(driver);
	   
	   //Admin Log-in

	   HomePage hp= new HomePage(driver);
	   hp.clickOnLogIn();
	   
	   LogInPage lp= new LogInPage(driver);
	   lp.logIn(USERNAME, PASSWORD);
	    
	   //Click on Register
        HomeDashBoardPage hdp= new HomeDashBoardPage(driver);
	    hdp.clickRegisterTab();
	   

	    //Add excel values in Key and value form     
		     
		IndividualHomeRegistrationPage ihp= new IndividualHomeRegistrationPage(driver);
		ihp.homeRegistrationInfo(driver,eLib.getmultipleDataFromExcel("Registration", 0, 1, driver) , "Vacant");
		

        //SubmitRegistration 
	    ihp.clickOnSubmitRegistration();
	    
	   
	    //Validate
	    String messg= driver.findElement(By.xpath("//h2[.='Register Room']/../child::div")).getText();
	    if(messg.contains("Registration successfull. Thank you")) {
			System.out.println("Registration is succesful");
	    }else {
	    	System.out.println("Registration is Unsuccesful");
		}
	    
		//LogOut
		 hdp.clickLogOut();
		
		// Exit the Browser
		 driver.quit();
		
		
		
	}
}
