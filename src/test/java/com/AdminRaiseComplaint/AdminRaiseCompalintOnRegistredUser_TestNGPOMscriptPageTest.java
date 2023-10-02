package com.AdminRaiseComplaint;

import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRA.ObjectRepo.ComplaintsPage;
import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.ListofApartmentDetailsPage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.genericutils.Baseclass;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;



public class AdminRaiseCompalintOnRegistredUser_TestNGPOMscriptPageTest extends Baseclass {


	
	@Test(groups = "system")
	public void AdminRaiseCompalintOnRegistredUser_TestNGPOMscriptPageTest() throws Throwable {
			
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnLogIn();
		LogInPage lp = new LogInPage(driver);
		lp.logIn(USERNAME, PASSWORD);
		System.out.println("Loged into Application");
			
			//Admin-Login and Raise a complaint
			
			HomeDashBoardPage hdp = new HomeDashBoardPage(driver);
			hdp.clickDetails_UpdateTab();
			
	
			ListofApartmentDetailsPage lap = new ListofApartmentDetailsPage(driver);
			lap.cickOnComplaint();
			ComplaintsPage cp = new ComplaintsPage(driver);
			String RegisterName ="Mohan";
			String CompDesc="NO CCTV, no 24/7 watersupply";
			cp.raiseAcomplaint(RegisterName, CompDesc);
			
			//Validate
		   
			cp.complaintRaisedValidation(driver);
          
	}

}
