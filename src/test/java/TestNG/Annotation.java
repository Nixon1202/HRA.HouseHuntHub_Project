package TestNG;




import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation {
	
	
	@BeforeSuite
	public void configBS() {
		System.out.println("Connect to DB");
	}
	
     @BeforeClass
     public void configBC(){
 		System.out.println("Launch the Browser");
 	}
	
	@BeforeMethod
	 public void configBM(){
 		System.out.println("LogIn to Application");
 	}
	
	@Test
	 public void ExecuteTest(){
 		System.out.println("Script Execution");
	}
	
	@AfterMethod
	 public void configAM(){
 		System.out.println("LogOut to Application");
 	}
	
	@AfterClass
	 public void configAC(){
 		System.out.println("Close the Browser");
	}
	
	@AfterSuite
	public void configAS(){
 		System.out.println("Close the DB");
	}
}
