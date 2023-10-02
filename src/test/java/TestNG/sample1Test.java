package TestNG;

import org.testng.annotations.Test;

import com.HRA.genericutils.Baseclass;

public class sample1Test extends Baseclass {
@Test(groups = "regression")
public void sample1() {
	System.out.println("sample1");
}
}
