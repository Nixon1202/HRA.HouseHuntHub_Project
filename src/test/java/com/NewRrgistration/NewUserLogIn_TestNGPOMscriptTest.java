package com.NewRrgistration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.ObjectRepo.NewUserRegisterPage;
import com.HRA.genericutils.Baseclass;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class NewUserLogIn_TestNGPOMscriptTest extends Baseclass {

	@BeforeMethod
	public void configBM() throws Throwable {
 	String URL = fLib.getPropertyKeyValue("url");
	driver.get(URL);
	
	System.out.println("Loged into Application");
	}
	
	@Test
	public void NewUserLogIn_TestNGPOMscriptTest() throws Throwable {

		HomePage hp=new HomePage(driver);
		
		
		
	    //Register as a NewUser_Info
		hp.clickOnRegister();
		
		
		NewUserRegisterPage nrp= new NewUserRegisterPage(driver);
		nrp.newUserRegistrationInfo(driver, eLib.getmultipleDataFromExcel("NewUserInfo", 0, 1, driver));
        
		hp.clickOnLogIn();  
//		LogInPage lp =new LogInPage(driver);
//		lp.logIn(username, password);
		
		
		//Validate
		
		String UN = eLib.getDataFromExcel("NewUserInfo", 2, 1);
		String PWD = eLib.getDataFromExcel("NewUserInfo", 5, 1);

		//Validate
         LogInPage lp= new LogInPage(driver);
         lp.logIn(UN, PWD);
         
       //LogOut
 		HomeDashBoardPage hdp = new HomeDashBoardPage(driver);
 		 hdp.clickLogOut();
 		
 		// Exit the Browser
 		 driver.quit();
		
	
		
	}

}
