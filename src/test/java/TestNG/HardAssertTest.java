package TestNG;

import static org.testng.Assert.*;


import org.testng.annotations.Test;

public class HardAssertTest {
    @Test
	private void hardassertTest1() {
		System.out.println("step-1");
		System.out.println("step-2");
		assertEquals("A", "B");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	@Test
	private void hardassertTest2() {
		System.out.println("step-5");
		System.out.println("step-6");
		assertEquals("x", "x");
		System.out.println("step-7");
		System.out.println("step-8");

	}
	
	@Test
	private void hardassertTest3() {
          int m=5;
          assertNotNull(m);
	}
}
