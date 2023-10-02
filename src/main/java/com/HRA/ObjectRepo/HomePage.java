package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//declaration
	
	@FindBy(xpath ="//a[.='Serch']")
	private WebElement Serch;
	
	@FindBy(xpath ="//a[.='Login']")
	private WebElement Login;
 	
	@FindBy(xpath ="//a[.='Register']")
	private WebElement Register;
	
	@FindBy(xpath = "//a[.='Logo/Home']")
	private WebElement LogInHome;
   //initialization
	
	 

	public void setLogInHome(WebElement logInHome) {
		LogInHome = logInHome;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}

   //Utilization	 
	public WebElement getSerch() {
		return Serch;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getRegister() {
		return Register;
	}
	
	public WebElement getLogInHome() {
		return LogInHome;
	}
	
	
	//Business Library
	
	public void clickOnSearch() {
		Serch.click();
	}
	public void clickOnLogIn() {
		Login.click();
	}
    
	public void clickOnRegister() {
		Register.click();
	}
	
	public void clickOnHomePage() {
		LogInHome.click();
	}

}

    
