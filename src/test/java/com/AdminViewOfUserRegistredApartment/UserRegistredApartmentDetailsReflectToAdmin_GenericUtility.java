package com.AdminViewOfUserRegistredApartment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.HRA.genericutils.DatabaseUtility;
import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.FileUtility;
import com.HRA.genericutils.JavaUtility;
import com.HRA.genericutils.WebDriverUtils;

public class UserRegistredApartmentDetailsReflectToAdmin_GenericUtility {
	public static void main(String[] args) throws Throwable {
		
		String Name= "James B";
		String expectedResult ="Owner Name: "+Name+"";
		
		WebDriverUtils wLib = new WebDriverUtils();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		DatabaseUtility dlib = new DatabaseUtility();
		WebDriver driver= new ChromeDriver();
		
		
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		driver. manage().window().maximize();
		wLib.pageLoadTimeOut(driver, 15);
		wLib.maximizeTheBrowser(driver);
		
		String URL= fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWROD = fLib.getPropertyKeyValue("password");
		
	    driver.get(URL);
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("James007");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("james");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.xpath("//a[.='Apartment Registration']")).click();
	    
	    
	    eLib.getmultipleDataFromExcel("ApartmentDetails", 1, 0, driver);
	    
	/*    //Enter all mandatory fields
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='apartment_name']")).sendKeys("Eco Eden Residence");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='mobile']")).sendKeys("9481186007");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='alternat_mobile']")).sendKeys("7006811949");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='email']")).sendKeys("edenresidence@gmail.com");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='plot_number']")).sendKeys("GS36");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='country']")).sendKeys("India");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='state']")).sendKeys("Karnatka");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='city']")).sendKeys("Mysuru");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='landmark']")).sendKeys("Near Nexus_mall");
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='address']")).sendKeys("Eco Eden Residence, NH Nagar");
	  */  
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='image']")).sendKeys("C:\\Users\\Nixon\\OneDrive\\Desktop\\Home.jpg");
	   
	    driver.findElement(By.name("register_apartment")).click();
	  
	    Thread.sleep(2000);
	    // Log_out as User
	    driver.findElement(By.xpath("//a[.='James B ']/../following-sibling::li/a")).click();
	    
//	    //Admin View
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWROD);
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.xpath("//b[text()='Rooms for Rent: '] ")).click();
	    WebElement OwnerName = driver.findElement(By.xpath("//*[name() = 'p' and text()='"+Name+"']"));
	    String actualResult = OwnerName.getText();
	    System.out.println(actualResult);
	    if (actualResult.equalsIgnoreCase(expectedResult)) {
	    	System.out.println("Registration Successfull");
		}else {
			System.out.println("Registration Unsuccessfull");
		}
		}	    
	    
	    
   
	}


