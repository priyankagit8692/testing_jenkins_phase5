package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
	}
	
	@Test
	public void test1() {
		System.out.println("Inside test1");
	}
	
	//@Test(enabled = false) // this test suit will be disabled
	@Test
	public void test2() {
		System.out.println("Inside test2");
	}
	
	@Test(groups = "RegressionTest")
	public void creditTest1() {
		System.out.println("Inside credit test 1");
	}
	
	@Test(groups = "RegressionTest")
	public void creditTest2() {
		System.out.println("Inside credit test 2");
	}

	@Test(groups = "Smoke")
	public void creditTest3() {
		System.out.println("Inside credit test 3");
	}
	
	@Test(groups = "Smoke")
	public void loanTest1() {
		System.out.println("Inside loan test 1");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After Method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test");
	}

}
