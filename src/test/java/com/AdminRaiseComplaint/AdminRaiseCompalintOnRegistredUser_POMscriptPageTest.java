package com.AdminRaiseComplaint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.ObjectRepo.ComplaintsPage;
import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.ListofApartmentDetailsPage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class AdminRaiseCompalintOnRegistredUser_POMscriptPageTest {

	public static void main(String[] args) throws Throwable {
		   
	    	WebDriverUtils wLib = new WebDriverUtils();
		    FileUtility fLib = new FileUtility();
		    JavaUtility jLib = new JavaUtility();
		    ExcelUtility eLib = new ExcelUtility();
		    DatabaseUtility dlib = new DatabaseUtility();
		
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
			wLib.pageLoadTimeOut(driver, 15);
			wLib.maximizeTheBrowser(driver);
			
			//Admin-Login and Raise a complaint
			HomePage hp=new HomePage(driver);
			hp.clickOnLogIn();
			LogInPage lp = new LogInPage(driver);
			lp.logIn(USERNAME, PASSWORD);
			HomeDashBoardPage hdp = new HomeDashBoardPage(driver);
			hdp.clickDetails_UpdateTab();
			ListofApartmentDetailsPage lap = new ListofApartmentDetailsPage(driver);
			lap.cickOnComplaint();
			ComplaintsPage cp = new ComplaintsPage(driver);
			String RegisterName ="Mohan";
			String CompDesc="NO CCTV, no 24/7 watersupply";
			cp.raiseAcomplaint(RegisterName, CompDesc);
			
			//Validate
			String Expmesg = "Sent Successfully"; 
			String Actmesg = driver.findElement(By.xpath("//div[.='Sent Successfully']")).getText();
		    if (Actmesg.equalsIgnoreCase(Expmesg)) {
				System.out.println("Cpmalint is Sent Successfully");
			} else {
				System.out.println("Cpmalint is not Sent Successfully");
			}
            
		  //LogOut
			 hdp.clickLogOut();
			
		  // Exit the Browser
		     driver.quit();

	}

}
