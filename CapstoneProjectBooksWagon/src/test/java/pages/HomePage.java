package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import objectRepository.Locators;
import stepDefinitions.Hooks;
import utils.Reporter;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	
	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}
	
	public String validateLogin() {
		
		String loginName;
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.checkName));
			loginName = driver.findElement(Locators.checkName).getText();
			Reporter.generateReport(driver, test, Status.PASS, "Entered to Homepage");
			
		}catch(TimeoutException e) {
			loginName = "Dummy Name";
			Reporter.generateReport(driver, test, Status.FAIL, "Unable to enter the Homepage");
			
		}
		
		return loginName;
		
	}

}
