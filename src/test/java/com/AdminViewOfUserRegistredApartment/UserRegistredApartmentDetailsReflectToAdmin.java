package com.AdminViewOfUserRegistredApartment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistredApartmentDetailsReflectToAdmin {
	public static void main(String[] args) throws Throwable {
		String expectedOwnerNmae ="Owner Name: James B";
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver. manage().window().maximize();
		
	    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("James007");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("james");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.xpath("//a[.='Apartment Registration']")).click();
	    
	    
	    //Enter all mandatory fields
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
	    
	    driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='image']")).sendKeys("C:\\Users\\Nixon\\OneDrive\\Desktop\\Home.jpg");
	   
	    driver.findElement(By.name("register_apartment")).click();
	  
	    Thread.sleep(2000);
	    // Log_out as User
	    driver.findElement(By.xpath("//a[.='James B ']/../following-sibling::li/a")).click();
	    
//	    //Admin View
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.xpath("//b[text()='Rooms for Rent: '] ")).click();
	    WebElement OwnerName = driver.findElement(By.xpath("//*[name() = 'p' and text()='Henita']"));
	    String NameText = OwnerName.getText();
	    System.out.println(NameText);
	    if (NameText.equalsIgnoreCase(expectedOwnerNmae)) {
	    	System.out.println("Registration Successfull");
		}else {
			System.out.println("Registration Unsuccessfull");
		}
		}	    
	    
	    
   
	}


