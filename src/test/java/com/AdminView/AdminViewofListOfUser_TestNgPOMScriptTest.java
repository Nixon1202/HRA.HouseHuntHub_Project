package com.AdminView;

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
import com.HRA.genericutils.Baseclass;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class AdminViewofListOfUser_TestNgPOMScriptTest extends Baseclass {

	
		
		@Test(groups = "smoke")
		public void AdminViewofListOfUser_TestNgPOMScriptTest() throws Throwable {
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			
			HomePage hp = new HomePage(driver);
			hp.clickOnLogIn();
			LogInPage lp = new LogInPage(driver);
			lp.logIn(USERNAME, PASSWORD);
			System.out.println("Loged into Application");
	
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
        
		
	}
}
