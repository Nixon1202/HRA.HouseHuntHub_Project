package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRA.genericutils.FileUtility;

public class SoftAssertTest {
	
	@Test
	private void softaccertTest1() throws Throwable {
		String Exp = "Apppliaction";
		WebDriver driver = new ChromeDriver();
		FileUtility fLib = new FileUtility();
		String URL = fLib.getPropertyKeyValue("url");
		driver.get(URL);
		String Act = driver.getTitle();
		System.out.println(Act);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Act, Exp);
		System.out.println("Application Launched");
		System.out.println("Execution Ends");
		driver.quit();
        sa.assertAll();
	}

}
