package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		DragDrop obj = new DragDrop();
		obj.setup();
		
	}
	
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement from = driver.findElement(By.xpath("//li[@id='credit2']//a"));
		
		WebElement destination = driver.findElement(By.xpath("//*[@id='bank']//li"));
		Actions action = new Actions(driver);
		action.dragAndDrop(from, destination).build().perform();;
		

	}
}
