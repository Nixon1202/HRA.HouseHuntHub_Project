package com.HRA.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintsPage {
	
	@FindBy(id = "name")
	private WebElement FullNameEtb;
	
	@FindBy(id = "cmp")
	private WebElement ComplaintDecriptionEtb;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement ComplaintSubmitBtn;
	
	public ComplaintsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getFullNameEtb() {
		return FullNameEtb;
	}

	public WebElement getComplaintDecriptionEtb() {
		return ComplaintDecriptionEtb;
	}

	public WebElement getComplaintSubmitBtn() {
		return ComplaintSubmitBtn;
	}

	public void raiseAcomplaint(String un, String des) {
		FullNameEtb.sendKeys(un);
		ComplaintDecriptionEtb.sendKeys(des);
		ComplaintSubmitBtn.click();
	}
	
	//Validate
	public String complaintRaisedValidation(WebDriver driver) {
	String Expmesg = "Sent Successfully"; 
	String Actmesg = driver.findElement(By.xpath("//div[.='Sent Successfully']")).getText();
    if (Actmesg.equalsIgnoreCase(Expmesg)) {
		System.out.println("Cpmalint is Sent Successfully");
	} else {
		System.out.println("Cpmalint is not Sent Successfully");
	}
	return Actmesg;
}

}

