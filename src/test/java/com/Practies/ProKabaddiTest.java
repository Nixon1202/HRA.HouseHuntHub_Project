package com.Practies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.prokabaddi.com/standings");
		List<WebElement> AllTeams = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data team']"));
	    List<WebElement> AllMatches = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-play']"));                            
	    List<WebElement> WonMatches = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-won' ]"));
	    List<WebElement> LostMatches = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-lost' ]"));
	    List<WebElement> DrawMatches = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-draw' ]"));
	     
	    String Team = "Bengaluru Bulls";
		System.out.println("Name of the team| Matches Played | Matches Won | Matches Lost | Matches Draw");
		
		for(int i=0; i<AllTeams.size();i++) {
			
			String TeamName=AllTeams.get(i).getText();
			if (TeamName.equalsIgnoreCase(Team)) {
				
				String PointBoard= AllTeams.get(i).getText()+" | "+AllMatches.get(i).getText()+" | "+WonMatches.get(i).getText()+" | "+LostMatches.get(i).getText()+" | "+DrawMatches.get(i).getText();				
	            System.out.println(PointBoard);		
			
			}
			
		}
		driver.quit();
	    
	
	
	
	
	
	}
	
	
	
}
