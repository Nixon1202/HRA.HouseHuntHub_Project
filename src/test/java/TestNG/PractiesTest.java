package TestNG;

import org.testng.annotations.Test;

public class PractiesTest  {

	@Test(enabled = false)
	public void createTest() {
		int x[]= {1,2,3};
		System.out.println(x[5]);
		System.out.println("------Create Data-------");
	}
	@Test(dependsOnMethods = "createTest")
	public void editTest() {
		System.out.println("-----Modify the Data------");
	}
	
	@Test(priority = 2)
	public void deleteTest() {
		System.out.println("------Delete the Data------");
	}
}
