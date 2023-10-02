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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminIndividualHomeRegistrationdynamicTest {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fil);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
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
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   driver. manage().window().maximize();
	   
	   //Admin Log-in
	   driver.findElement(By.xpath("//a[.='Login']")).click();
	   driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	   driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
	   driver.findElement(By.name("login")).click();
	    
	   //Click on Register
	   driver.findElement(By.linkText("Register")).click();
	   
	  //read Excel 
	   FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fi);
	    Sheet sh = wb.getSheet("Registration");
	    
	    int count = sh.getLastRowNum();
	    
	    //Add excel values in Key and value form     
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i =1; i<=count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for (Entry<String, String> s: map.entrySet()) {
			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}
		WebElement vacantDD = driver.findElement(By.id("vacant"));
	    Select sel = new Select(vacantDD);
	    sel.selectByVisibleText("Vacant");
	    driver.findElement(By.id("image")).sendKeys("C:\\Users\\Nixon\\OneDrive\\Desktop\\Home.jpg");
	    driver.findElement(By.xpath("//button[.='Submit' and @name='register_individuals']")).click();
	    
	    //Validate
	    String messg= driver.findElement(By.xpath("//h2[.='Register Room']/../child::div")).getText();
	    if(messg.contains("Registration successfull. Thank you")) {
			System.out.println("Registration is succesful");
	    }else {
	    	System.out.println("Registration is Unsuccesful");
		}
	    
		
		
		
		
		
		
		
		
		
		
		
		/*WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		
	    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("Register")).click();
	    
	    //Enter all mandatory fields
	    driver.findElement(By.id("fullname")).sendKeys("Henita");
	    driver.findElement(By.id("mobile")).sendKeys("8762289888");
	    driver.findElement(By.id("alternat_mobile")).sendKeys("8889822768");
	    driver.findElement(By.id("email")).sendKeys("henitanaru@yahoo.in");
	    driver.findElement(By.id("plot_number")).sendKeys("HN1202");
	    driver.findElement(By.id("rooms")).sendKeys("3BHK");
	    driver.findElement(By.id("country")).sendKeys("India");
	    driver.findElement(By.id("state")).sendKeys("Karnataka");
	    driver.findElement(By.id("city")).sendKeys("Vaga city");
	    driver.findElement(By.id("rent")).sendKeys("15000");
	    driver.findElement(By.id("sale")).sendKeys("NA");
	    driver.findElement(By.id("deposit")).sendKeys("80000");
	    driver.findElement(By.id("accommodation")).sendKeys("Covered parking, Electricity backup,CCTV survelliance,24/7 water suppy");
	    driver.findElement(By.id("description")).sendKeys("This is elegant 3BHK home with private entrane, located in near Littleton Academy elementary and High school, Gold Gym");
	    driver.findElement(By.id("landmark")).sendKeys("Near vaga mall");
	    driver.findElement(By.id("address")).sendKeys("BTM, Bengaluru");
	    WebElement vacantDD = driver.findElement(By.id("vacant"));
	    Select sel = new Select(vacantDD);
	    sel.selectByVisibleText("Vacant");
	    driver.findElement(By.id("image")).sendKeys("C:\\Users\\Nixon\\OneDrive\\Desktop\\Home.jpg");
	    driver.findElement(By.name("register_individuals")).click();
	    	*/	
}
}
