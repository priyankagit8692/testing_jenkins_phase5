package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbLogin {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FbLogin login = new FbLogin();
		login.setup();
		//login.login();
		login.login();

	}

	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		//WebDriver is a interface
	    driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://en-gb.facebook.com/");
		Thread.sleep(2000);

		
		//WebElement signIn = driver.findElement(By.linkText("Sign in"));
		//signIn.click();
		
		
	}
	
	public void login() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(000, TimeUnit.MILLISECONDS);
		//WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		//WebElement pass = driver.findElement(By.xpath("//input[@name='pass']"));
		//.WebElement login = driver.findElement(By.xpath("//*[@name='login']"));
		//   //*[text()='Facebook helps you connect and share with the people in your life.']
		
		//us of contains
		//h2[contains(text(),'Facebook')]
		
		//*[starts-with(text(),'Create')]
		
		/* Tag and ID CSS Selector
		 * Syntax : "css=tag#id"
		 * 
		 * Tag and class CSS Selector
		 * Syntax : "css=tag#class"
		 * 
		 * Tag and attribute CSS Selector
		 * Syntax : "css=tag[attribute=value]"
		 */
		
		WebElement email = driver.findElement(By.cssSelector("input#email"));
		email.sendKeys("priyankakumawat08866@gmail.com");
		WebElement pass = driver.findElement(By.cssSelector("input#pass"));
		pass.sendKeys("pkpk@8686");
		WebElement login = driver.findElement(By.cssSelector("button[name=login]"));
		login.click();
		
		//input[@name='commit']
		
		
	}
	
	public void signUp() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement signUp = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		signUp.click();
		Thread.sleep(2000);
//		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
//		firstname.sendKeys("Priyanka");
//		Thread.sleep(2000);
//		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
//		lastname.sendKeys("Kumawat");
//		Thread.sleep(3000);
		//WebElement email = driver.findElement(By.xpath("//*[text()='Mobile number or email address']"));
		//email.sendKeys("priyankakumawat08866@gmail.com");
		
		//Tag and ID Css selector tag#id
		//WebElement firstname = driver.findElement(By.cssSelector("input#u_9_b_fI"));
		//firstname.sendKeys("Priyanka");
		
		
		
		WebElement dayDropDown = driver.findElement(By.xpath("//*[@title='Day']"));
		Select day = new Select(dayDropDown);
		day.selectByVisibleText("1");
		
		Thread.sleep(3000);
		WebElement MonthDropDown = driver.findElement(By.xpath("//*[@title='Month']"));
		Select month = new Select(MonthDropDown);
		month.selectByVisibleText("Jun");
		
		Thread.sleep(3000);
		WebElement YearDropDown = driver.findElement(By.xpath("//*[@title='Year']"));
		Select year = new Select(YearDropDown);
		year.selectByVisibleText("1992");
		
		Thread.sleep(3000);
		WebElement gender = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		gender.click();
		
		
		//siblings:
		//input[@type='radio' and @value='1']//following::input[1]
		
		//preceeding
	    //input[@type='radio' and @value='1']//preceeding::input[1]
		
		//use of contains in xpath
		
		
		
		
		
		
		
	}
	
	public void teardown() {
		driver.quit();
	}
}
