package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDashBoardPage {

	//declaration
	@FindBy(linkText = "Home")
	private WebElement HomeTab;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterTab;
	
	@FindBy(linkText = "Details/Update")
	private WebElement Details_UpdateTab;
	
	@FindBy(linkText = "Send SMS")
	private WebElement SenSMSTab;
	
	@FindBy(linkText = "Complaint List")
	private WebElement ComplaintListTab;
		
	
	@FindBy(xpath = "//span[@class='badge badge-pill badge-success']/ancestor::b[text()='Registered Users: ']")
	private WebElement RegisteredUserLnk;
	
	@FindBy(xpath = "//span[@class='badge badge-pill badge-success']/ancestor::b[text()='Rooms for Rent: ']")
	private WebElement RoomforRentLnk;
   
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement LogOutBtn;
	
	
	//initialization
    public HomeDashBoardPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
    }

    
    //Utilization
	public WebElement getHomeTab() {
		return HomeTab;
	}

	public WebElement getRegisterTab() {
		return RegisterTab;
	}

	public WebElement getDetails_UpdateTab() {
		return Details_UpdateTab;
	}

	public WebElement getSenSMSTab() {
		return SenSMSTab;
	}

	public WebElement getComplaintListTab() {
		return ComplaintListTab;
	}

	public WebElement getRegisteredUserLnk() {
		return RegisteredUserLnk;
	}

	public WebElement getRoomforRentLnk() {
		return RoomforRentLnk;
	}


	public WebElement getLogOutBtm() {
		return LogOutBtn;
	}
    
	
	//Business Library
    public void clickRegisterTab() {
    	RegisterTab.click();
		
	}
    
    public void clickDetails_UpdateTab() {
          Details_UpdateTab.click();    
    
	}
    
    public void clickRegisteredUserLnk()  {
 	   RegisteredUserLnk.click();
    }
    
    public void clickRoomforRentLnk() {
		RoomforRentLnk.click();
	}
    
    public void clickLogOut() {
	   LogOutBtn.click();
	   
	
}
    

}
