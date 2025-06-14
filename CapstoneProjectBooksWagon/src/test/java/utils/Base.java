package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;

	public void launchBrowser() {
		Properties prop = PropertyReader.readProperties();
		
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid browser name, please check it");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		}
	
	public static void sleep(int msec) {
		try {
			Thread.sleep(msec);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
