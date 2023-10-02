package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegisterPage {
	
	//
	@FindBy(id = "fullname")
	private WebElement NRFullNameEdt;
	
	@FindBy(id = "username")
	private WebElement NRusernameEdt;
	
	@FindBy(id = "mobile" )
	private WebElement NRmobileNumEdt ;
	
	@FindBy(id = "email" )
	private WebElement NRemailEdt;
	
	@FindBy(id = "password" )
	private WebElement NRpasswordEdt;
	
	@FindBy(id ="c_password" )
	private WebElement NRconfirmPWDEdt ;
	
	@FindBy(xpath ="//button[@name='register']" )
	private WebElement NR_SubmitBtn;
	
	public NewUserRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//
	public WebElement getNRFullNameEdt() {
		return NRFullNameEdt;
	}

	public WebElement getNRusernameEdt() {
		return NRusernameEdt;
	}

	public WebElement getNRmobileNumEdt() {
		return NRmobileNumEdt;
	}

	public WebElement getNRemailEdt() {
		return NRemailEdt;
	}

	public WebElement getNRpasswordEdt() {
		return NRpasswordEdt;
	}

	public WebElement getNRconfirmPWDEdt() {
		return NRconfirmPWDEdt;
	}

	public WebElement getNR_SubmitBtn() {
		return NR_SubmitBtn;
	}
	
	//
	 
	public void NewUserRegisteration(String FullName, String UserName, String MobileNum, String Email, String PWD, String CPWD) {
		NRFullNameEdt.sendKeys(FullName);
		NRusernameEdt.sendKeys(UserName);
		NRmobileNumEdt.sendKeys(MobileNum);
		NRemailEdt.sendKeys(Email);
		NRpasswordEdt.sendKeys(PWD);
		NRconfirmPWDEdt.sendKeys(CPWD);
		NR_SubmitBtn.click();
	}
  public void newUserRegistrationInfo(WebDriver driver, HashMap<String, String> map ) {
		
		for(Entry<String, String> s:map.entrySet())
		{
			
	           	 driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
	            
	           	 		
		}
		
		NR_SubmitBtn.click();	
  }
}
