package com.Admin_Home_Registration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminIndividualHomeRegistrationTest {
	
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver. manage().window().maximize();
		
	    driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("Register")).click();
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
	    		
}
}
