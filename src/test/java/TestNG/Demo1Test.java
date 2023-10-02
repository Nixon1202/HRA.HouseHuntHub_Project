package TestNG;

import org.testng.annotations.Test;

import com.HRA.genericutils.Baseclass;

public class Demo1Test extends Baseclass{
	@Test(groups = "smoke")
	public void demo1() {
		System.out.println("demo1");
	}
}
