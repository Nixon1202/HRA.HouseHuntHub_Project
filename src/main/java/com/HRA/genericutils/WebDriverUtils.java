package com.HRA.genericutils;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Count;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * @author Nixon
 * This class contains all the WebDriverUtilities
 * @param driver
 */

public class WebDriverUtils {
	
	/**
	 * 
	 * This method is used Launch the Browser 
	 * @param driver
	 */
	public void webDriverLaunch(WebDriver driver1) {
		WebDriver driver = new ChromeDriver();
	}
	
	/**
	 * 
	 * This method is used maximize the window 
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) 
	{
	driver.manage().window().maximize();
	}
	/**
	 * 
	 * This method is used minimize the window 
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver){
	driver.manage().window().minimize();	
	}
	
	public void pageLoadTimeOut(WebDriver driver, int duration) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(duration));
	}
	
	/**
	 *
	 * This method will wait until the element in the page gets load
	 * @param driver
	 */
	public void implicitwait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		
	}
	/**
	 * 
	 * This method will wait until the element in the page gets load until expected condition id met
	 * @param driver
	 */
	
	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedurl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	/**
	 * 
	 * This method will wait until the Title gets load 
	 * @param driver
	 */
	
      public void waitUntilTitleLoads(WebDriver driver, int duration, String expectedTitle) {
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
      }
      /**
  	 * 
  	 * This method will wait until Element to be visible in the page   
  	 * @param driver
  	 */ 
      public void ignoreNoSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
     /**
      * This method will wait until the element to be visible in the page
      * @param element
      * @throws InterruptedException
      */
      public void customWait (WebElement element) throws InterruptedException
      {
    	  int count=0;
    	  while(count<20) {
    		  try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
    	  }
      }
      /**
       *  This method will select a drop_down element based on the index value
       * @param element
       * @param index
       * @return
       */
    	 public void selectDropDown(WebElement element, int index) {
    		 Select sel = new Select(element);
    		 sel.selectByIndex(index);
    	 }
    	 /**
    	  * This method will select a drop_down element based on the value
    	  * @param element
    	  * @param index
    	  * @return
    	  */
    	 public void selectDropDown(WebElement element, String value) {
    		 Select sel = new Select(element);
    		 sel.selectByValue(value);
    	 }
    	 /**
    	  * 
    	  * @param text
    	  * @param element
    	  * @return
    	  */
    	 
    	 public void selectDropDown(String text, WebElement element) {
    		 Select sel = new Select(element);
    		 sel.selectByVisibleText(text);
		
	}
    	 /**
    	  * This method will help MoveToAnElement
    	  * @param driver
    	  * @param element
    	  */
    	 public void mousehoveroElement(WebDriver driver, WebElement element)
    	 {
    		 Actions action = new Actions(driver);
    		 action.moveToElement(element).click().perform();
    	 }
    	 
    	 
    	 /**
    	  * This method will help dragAnddrop the element
    	  * @param driver
    	  * @param driver
    	  * @param element
    	  */
    	 public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
    	 {
    		 Actions action = new Actions(driver);
    		 action.dragAndDrop(src, dst).perform();
    	 }
    	 
    	 /**
    	  * This method will help doubleClick the element
    	  * @param driver
    	  * @param driver
    	  * @param element
    	  */
    	 public void doubleClick(WebDriver driver, WebElement element)
    	 {
    		 Actions action = new Actions(driver);
    		 action.doubleClick(element).perform();
    	 }
    	 
    	 /**
    	  * This method will help rightClick 
    	  * @param driver
    	  * @param driver
    	  * @param element
    	  */
    	 public void rightClick(WebDriver driver)
    	 {
    		 Actions action = new Actions(driver);
    		 action.contextClick().perform();
    	 }
    	 
    	 /**
    	  * This method will help rightClick the element
    	  * @param driver
    	  * @param driver
    	  * @param element
    	  */
    	 
    	 public void rightClick(WebDriver driver, WebElement element)
    	 {
    		 Actions action = new Actions(driver);
    		 action.contextClick(element).perform();
    	 }
    	 /**
    	  * This method is used to perform clickOnEnterKey
    	  * @param driver
    	  * @param element
    	  */
    	 
    	 public void clickOnEnterKey(WebDriver driver, WebElement element)
    	 {
    		 Actions action = new Actions(driver);
    		 action.sendKeys(Keys.ENTER).perform();
    	 }
    	
    	 /**
    	  * The method is used to release the enter key
    	  * @param driver
    	  * @throws Throwable
    	  */
    	 public void enterRelease(WebDriver driver) throws Throwable {
    		 Robot rb = new Robot();
    		 rb.keyRelease(KeyEvent.VK_ENTER);
    	 }
    	 
    	 
    	 /**
    	  * This method is used to switch from one frame to another using index value
    	  * @param driver
    	  * @param index
    	  */
    	 public void switchFrame(WebDriver driver, int index) {
    		 driver.switchTo().frame(index);
    	
}
        /**
         * 	  * This method is used to switch from one frame to another using ID
         * @param driver
         * @param id
         */
    	 public void switchFrame(WebDriver driver, String id) {
    		 driver.switchTo().frame(id);
    	 }
    	 
    	 /**
    	  * This method is used switch from one frame to another using web element
    	  * @param driver
    	  * @param element
    	  */
    	 public void switchFrame(WebDriver driver, WebElement element) {
    		 driver.switchTo().frame(element);
    	 }
    	 
    	 /**
    	  * This method is used switch to main frame
    	  * @param driver
    	  */
    	 public void switchTOMainFrame(WebDriver driver){
    		 driver.switchTo().defaultContent();
    	 }
    	/**
    	 * This method is used to accept alert popup
    	 * @param driver
    	 * @param expectedMsg
    	 */
    	 public void acceptAlertPopup(WebDriver driver, String expectedMsg) {
    		 Alert alt = driver.switchTo().alert();
			if (alt.getText().equalsIgnoreCase(expectedMsg)) {
				System.out.println("Alert Message is Verified");
			}else {
				System.out.println("Alert Message is not Verified");
			}
			alt.accept();
		}
    	 /**
    	  * This method is used to dismiss alert popup
    	  * @param driver
    	  * @param expectedMsg
    	  */
    	 public void dismissAlertPopup(WebDriver driver, String expectedMsg) {
    		 Alert alt = driver.switchTo().alert();
			if (alt.getText().equalsIgnoreCase(expectedMsg)) {
				System.out.println("Alert Message is Verified");
			}else {
				System.out.println("Alert Message is not Verified");
			}
			alt.dismiss();
		}
    	 /**
    	  * This method is used to swicht to from one window to another based on Title
    	  * @param driver
    	  * @param expectedTitle
    	  */
    	 public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
    		{
    			Set<String> set = driver.getWindowHandles();
    			for(String str:set)
    			{
    				driver.switchTo().window(str);
    				String title = driver.getTitle();
    				if(title.contains(expectedTitle))
    				{
    					break;
    				}
    			}
    		}
    	
    	 /**
    	  * This method is used to switch from one window to another based on URL
    	  * @param driver
    	  * @param expectedUrl
    	  */
    	 public void switchWindowBasedOnUrl(WebDriver driver, String expectedUrl)
 		{
 		Set<String> set = driver.getWindowHandles();
 		Iterator<String> it = set.iterator();
 		while(it.hasNext())
 		{
 			String wid = it.next();
 			driver.switchTo().window(wid);
 			String url = driver.getCurrentUrl();
 			if(url.contains(expectedUrl))
 	        {
 				break;
			 }
 		}
 	}
    	/**
    	 * This method is used to take screenshot whenever test script getting failed 
    	 * @param driver
    	 * @param screenShotName
    	 * @return
    	 */
    	 public static String takeScreenShot(WebDriver driver, String screenShotName) {
    		 TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
    		  File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
    		  String path = "./screenShots/"+screenShotName+JavaUtility.getSystemDateInFormat()+".png";
    		  File dst = new File(path);
    		  	try {
					Files.copy(src, dst);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
    		  return path;
    	 }
    	 
    	 /**
    	  * This method is used to scrollTo perticular element 
    	  * @param driver
    	  * @param element
    	  */
    	  public void scroolToPerticularElement(WebDriver driver, WebElement element) {
          JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("arguments[0].scrollIntoView()", element);
    	 }
    	  
    	  public void  scrollBarActon(WebDriver driver, int x, int y) {
    		  JavascriptExecutor js = (JavascriptExecutor)driver;
    		  js.executeScript("Window.scrollBy("+x+","+y+")", "");
			
		}
}


