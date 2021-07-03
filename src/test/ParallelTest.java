package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void Test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		//WebDriver is a interface
	    WebDriver driver1 = new ChromeDriver();
		//driver = new FirefoxDriver();
		
	    driver1.manage().window().maximize();
	    driver1.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
	    driver1.get("https://www.simplilearn.com/");
		Thread.sleep(10000);
	}
	
	@Test
	public void Test2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		//WebDriver is a interface
	    WebDriver driver2 = new FirefoxDriver();
		//driver = new FirefoxDriver();
		
	    driver2.manage().window().maximize();
	    driver2.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
	    driver2.get("https://www.simplilearn.com/");
		Thread.sleep(10000);
	}

}
