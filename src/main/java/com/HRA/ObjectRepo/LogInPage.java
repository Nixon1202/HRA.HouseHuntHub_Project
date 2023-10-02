package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	//declaration
	@FindBy(id = "exampleInputEmail1")
	private WebElement UserNameEdt;
	
	@FindBy(id = "exampleInputPassword1")
	private WebElement PasswordEdt;
	
	@FindBy(name = "login")
	private WebElement SubmitBtn;
	
	//initialization
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	
	//Business Library
	public void logIn(String username, String pwd) {
		UserNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(pwd);
		SubmitBtn.click();
	}
}
