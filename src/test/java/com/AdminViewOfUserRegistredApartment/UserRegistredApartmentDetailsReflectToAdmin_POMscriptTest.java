package com.AdminViewOfUserRegistredApartment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.ObjectRepo.ApartmentRegistrationPage;
import com.HRA.ObjectRepo.HomeDashBoardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LogInPage;
import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class UserRegistredApartmentDetailsReflectToAdmin_POMscriptTest {
	public static void main(String[] args) throws Throwable {
		
		String Name= "James B";
		String expectedResult ="Owner Name: "+Name+"";
		
		WebDriverUtils wLib = new WebDriverUtils();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		DatabaseUtility dlib = new DatabaseUtility();
		
		
		
		
		
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		driver. manage().window().maximize();
		
		String URL= fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWROD = fLib.getPropertyKeyValue("password");
		String RUN = "James007";
		String RPWD = "james";
		
		
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
		
	    driver.get(URL);
		wLib.pageLoadTimeOut(driver, 15);
		wLib.maximizeTheBrowser(driver);
	    HomePage hp= new HomePage(driver);
		   hp.clickOnLogIn();
		   
		LogInPage lp= new LogInPage(driver);
		   lp.logIn(RUN, RPWD);
		   
		HomeDashBoardPage hdp = new HomeDashBoardPage(driver);
		 hdp.clickRegisterTab();
		
		ApartmentRegistrationPage ap= new ApartmentRegistrationPage(driver);
		ap.clickOnApartmentRegistration();
	    
	    ap.newApartmentRegistrationInfo(driver, eLib.getmultipleDataFromExcel("ApartmentDetails", 0, 1, driver));
	    
	
	    Thread.sleep(2000);
	    // Log_out as User
	    driver.findElement(By.xpath("//a[.='James B ']/../following-sibling::li/a")).click();
	    
	    //Admin LogIn and View
	      hp.clickOnLogIn();
	      lp.logIn(USERNAME, PASSWROD);
	      hdp.clickRoomforRentLnk();
	    
	    //Validate
	    WebElement OwnerName = driver.findElement(By.xpath("//*[name() = 'p' and text()='"+Name+"']"));
	    String actualResult = OwnerName.getText();
	    System.out.println(actualResult);
	    if (actualResult.equalsIgnoreCase(expectedResult)) {
	    	System.out.println("Registration Successfull");
		}else {
			System.out.println("Registration Unsuccessfull");
		}
	    
	  //LogOut
		 hdp.clickLogOut();
		
		// Exit the Browser
		 driver.quit();
		}	    
	    
	    
   
	}


