package com.HRA.ObjectRepo;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class ListofApartmentDetailsPage {
 
	   //declaration
		@FindBy(xpath = "//a[.='Complaint']")
		private WebElement ComplaintBtn;
		
		
		//initialization
		public ListofApartmentDetailsPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
			
		}

		
		//Utilization
		public WebElement getComplaintBtn() {
			return ComplaintBtn;
		}
		
		//Business Library
         
		public void clickOnEdit(WebDriver driver, String OwnerName ) {
			driver.findElement(By.xpath(" \"//*[name() = 'p' and text()='"+OwnerName+"']/ancestor::div[@class='card-block']//a[.='Edit']\"")).click();
		}
	
		public void cickOnComplaint() {
			ComplaintBtn.click();
		}
}
