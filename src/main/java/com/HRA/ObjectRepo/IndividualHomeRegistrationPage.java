package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRA.genericutils.WebDriverUtils;

public class IndividualHomeRegistrationPage extends WebDriverUtils {

	//declaration
	@FindBy(id = "fullname")
	private WebElement FullNameEdt;
	
	@FindBy(id = "mobile")
	private WebElement MobileNumEdt;
	
	@FindBy(id = "alternat_mobile")
	private WebElement AlernatNumEdt;
	
	@FindBy(id = "email")
	private WebElement EmailEdt;
	
	@FindBy(id = "plot_number")
	private WebElement PlotNumberEdt;
	
	@FindBy(id = "rooms")
	private WebElement RoomsEdt;
	
	@FindBy(id = "country")
	private WebElement CountryEdt;
	
	@FindBy(id = "state")
	private WebElement StateEdt;
	
	@FindBy(id = "city")
	private WebElement City;
	
	@FindBy(id = "rent")
	private WebElement RentEdt;
	
	@FindBy(id = "sale")
	private WebElement SaleEdt;
	
	@FindBy(id = "deposit")
	private WebElement DepositEdt;
	
	@FindBy(id = "accommodation")
	private WebElement AccommodationEdt;

	@FindBy(id = "description")
	private WebElement DescriptionEdt;
	
	@FindBy(id = "landmark")
	private WebElement LandmarkEdt;
	
	@FindBy(id = "address")
	private WebElement AddressEdt;

	@FindBy(id = "vacant")
	private WebElement VacentOrOccupied_DD;
	
	@FindBy(id = "image")
	private WebElement Home_ImageBtn;
	
	@FindBy(name = "register_individuals")
	private WebElement Home_SubmitBtn;
	
	//initialization
	public IndividualHomeRegistrationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	
	//Utilization
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getMobileNumEdt() {
		return MobileNumEdt;
	}

	public WebElement getAlernatNumEdt() {
		return AlernatNumEdt;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPlotNumberEdt() {
		return PlotNumberEdt;
	}

	public WebElement getRoomsEdt() {
		return RoomsEdt;
	}

	public WebElement getCountryEdt() {
		return CountryEdt;
	}

	public WebElement getStateEdt() {
		return StateEdt;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getRentEdt() {
		return RentEdt;
	}

	public WebElement getSaleEdt() {
		return SaleEdt;
	}

	public WebElement getDepositEdt() {
		return DepositEdt;
	}

	public WebElement getAccommodationEdt() {
		return AccommodationEdt;
	}

	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}

	public WebElement getLandmarkEdt() {
		return LandmarkEdt;
	}

	public WebElement getAddressEdt() {
		return AddressEdt;
	}

	public WebElement getVacentOrOccupied_DD() {
		return VacentOrOccupied_DD;
	}

	public WebElement getImage() {
		return Home_ImageBtn;
	}

	public WebElement getSubmitBtn() {
		return Home_SubmitBtn;
	}
 
	
	//Business Library
	public void homeRegistrationInfo(WebDriver driver, HashMap<String, String> map , String VisTex) {
		
		for(Entry<String, String> s:map.entrySet())
		{
			
	           	 driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
	            
	               
		}
			
		selectDropDown(VisTex, VacentOrOccupied_DD);
	}
	
	public void clickOnSubmitRegistration() {
		Home_SubmitBtn.click();
	}
	
	
	
	
}
