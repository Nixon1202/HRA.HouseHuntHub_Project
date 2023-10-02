package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegistrationPage {
 
	//declaration
	@FindBy(xpath = "//a[.='Apartment Registration']")
	private WebElement ApartmentRegistrationLnk;
	
	@FindBy(xpath ="//h2[text()='Apartment Room']/../descendant::input[@id='apartment_name']")
	private WebElement ApartmentNameEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='mobile']")
	private WebElement ApartmentMobileNumEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='alternat_mobile']" )
    private WebElement ApartmentAlternatMobileEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='email']")
	private WebElement ApartmentEmailEdt ;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='plot_number']")
	private WebElement Apartmentplot_numberEdt ;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='country']")
	private WebElement Apartment_CountryEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='state']")
	private WebElement Apartment_StateEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='city']" )
	private WebElement Apartment_CityEdt ;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='landmark']")
	private WebElement Apartment_LandmarkEdt;
	
	@FindBy(xpath ="//h2[text()='Apartment Room']/../descendant::input[@id='address']" )
	private WebElement Apartment_AddressEdt;
	
	@FindBy(xpath = "//h2[text()='Apartment Room']/../descendant::input[@id='image']" )
	private WebElement Apartment_ImageBtn ;
	
	@FindBy (xpath = "//a[.='Add More(Plat Number/Description)']")
    private WebElement AddMoreApartmentBtn;
	
	@FindBy (xpath = "//a[.='Delete']")
	private WebElement Apartment_Delete; 
	
	@FindBy(name = "register_apartment")
	private WebElement Apartment_SubmitBtn ;
	
	//initialization
    public ApartmentRegistrationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

    //Utilization
	public WebElement getApartmentRegistrationLnk() {
		return ApartmentRegistrationLnk;
	}

	public WebElement getApartmentNameEdt() {
		return ApartmentNameEdt;
	}

	public WebElement getApartmentMobileNumEdt() {
		return ApartmentMobileNumEdt;
	}

	public WebElement getApartmentAlternatMobileEdt() {
		return ApartmentAlternatMobileEdt;
	}

	public WebElement getApartmentEmailEdt() {
		return ApartmentEmailEdt;
	}

	public WebElement getApartmentplot_numberEdt() {
		return Apartmentplot_numberEdt;
	}

	public WebElement getApartment_CountryEdt() {
		return Apartment_CountryEdt;
	}

	public WebElement getApartment_StateEdt() {
		return Apartment_StateEdt;
	}

	public WebElement getApartment_CityEdt() {
		return Apartment_CityEdt;
	}

	public WebElement getApartment_LandmarkEdt() {
		return Apartment_LandmarkEdt;
	}

	public WebElement getApartment_AddressEdt() {
		return Apartment_AddressEdt;
	}

	public WebElement getApartment_ImageBtn() {
		return Apartment_ImageBtn;
	}
    
	public WebElement getAddMoreApartmentBtn() {
		return AddMoreApartmentBtn;
	}
	
	
	public WebElement getApartment_Delete() {
		return Apartment_Delete;
	}

	public WebElement getApartment_SubmitBtn() {
		return Apartment_SubmitBtn;
	} 
    
    
	//Business Library
   
	public void clickOnApartmentRegistration() {
	ApartmentRegistrationLnk.click();

	}
    
	 public void newApartmentRegistrationInfo(WebDriver driver, HashMap<String, String> map ) {
			
			for(Entry<String, String> s:map.entrySet())
			{
				
		           	 driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		            
		               
			}
			Apartment_SubmitBtn.click();
			
	 }

}

