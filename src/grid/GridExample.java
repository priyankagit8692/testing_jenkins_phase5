package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver");
		
		DesiredCapabilities obj = new DesiredCapabilities();
		obj.setBrowserName("chrome");
		obj.setPlatform(Platform.WINDOWS);
		String url = "http://192.168.56.1:4445/wd/hub";
		
		
		WebDriver driver = new RemoteWebDriver(new URL(url),obj);
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
	}

}
