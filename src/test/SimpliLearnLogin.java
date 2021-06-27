package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

@Listeners(TestListenerExample.class)
public class SimpliLearnLogin {
	//WebDriver is a interface
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * SimpliLearnLogin loginTest = new SimpliLearnLogin(); loginTest.setup();
	 * loginTest.login(); loginTest.teardown();
	 * 
	 * }
	 */

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		//WebDriver is a interface
	    driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.simplilearn.com/");
		Thread.sleep(2000);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		
		
	}
	
	
	
	@Test
	@Parameters({"uname","pd"})
	public void login(String userName,String password) {
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement username = driver.findElement(By.name("user_login"));
	    String userName1 = sheet.getRow(0).getCell(0).getStringCellValue();
		username.sendKeys(userName1);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement pwd = driver.findElement(By.name("user_pwd"));
	    String password1 = sheet.getRow(0).getCell(1).getStringCellValue();
		pwd.sendKeys(password1);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		chkBox.click();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
		
		
		WebElement err = driver.findElement(By.id("msg_box"));
		String actErr = err.getText();
		String expErr = "The email or password you have entered is invalid.";
		if(actErr.equals(expErr)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
