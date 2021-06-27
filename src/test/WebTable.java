package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebTable webTable = new WebTable();
		webTable.setup();
		
	}
	
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("rows:"+rows.size());
		
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("cols:"+cols.size());
		
		WebElement ele = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println("ele:"+ele.getText());
		
		Thread.sleep(4000);
//		for(int i=1;i<=7;i++) {
//			for(int j=1;j<=3;j++) {
//				Thread.sleep(1000);
//				WebElement ele1 = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[i]/td[j]"));
//				System.out.print("ele:"+ele1.getText()+" ");
//			}
//			System.out.println();
//		}
		
		WebElement loc = driver.findElement(By.xpath("//h2[text()='HTML Table - Add a Border']"));
		JavascriptExecutor var1 = (JavascriptExecutor)driver;
		var1.executeScript("arguments[0].scrollIntoView();",loc);
		
		
		
		
		
	}
	
	

}
