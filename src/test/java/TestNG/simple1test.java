package TestNG;

import org.testng.annotations.Test;

import com.HRA.genericutils.Baseclass;

public class simple1test extends Baseclass {
	@Test(groups = {"smoke","regression"})
	
	public void simple1() {
		System.out.println("simple1");
	}
}
