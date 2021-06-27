package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alerts {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Alerts obj = new Alerts();
		obj.setup();
		
	}
	
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		Alert obj = driver.switchTo().alert();
		System.out.println("err "+obj.getText());
		obj.accept();
		
		

	}

}
