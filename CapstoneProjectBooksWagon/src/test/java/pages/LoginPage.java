package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class LoginPage {

	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;

	// Constructor
	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	public void clickLoginLink() {
		driver.findElement(Locators.myAccount).click();
	}

	public String findLoginText() {
		String text;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginText));
			text = driver.findElement(Locators.loginText).getText();
			Reporter.generateReport(driver, test, Status.PASS, "entered in Login Page");
		} catch (TimeoutException e) {
			text = "Log in";
			Reporter.generateReport(driver, test, Status.FAIL, "Cannot enter in Login Page");
		}

		return text;

	}


	// Perform login with given credentials
	public void login(String email, String password) {
		driver.findElement(Locators.emailField).sendKeys(email);
		driver.findElement(Locators.passwordField).sendKeys(password);
		driver.findElement(Locators.loginButton).click();
		

	}

	public boolean getLoginErrorMessage() {
		
//			String email = driver.findElement(Locators.emailError).getText().trim();
//			String pass = driver.findElement(Locators.passError).getText().trim();
//				if(email.contains("We didn't find an account with this Email")) {
//					Reporter.generateReport(driver, test, Status.FAIL, "Login Failure");
//					return false;
//				}
//				
//			 else if (pass.contains("Please enter correct password.")) {
//				Reporter.generateReport(driver, test, Status.FAIL, "Login Failure");
//				return false;
//				
//			} 
//			Reporter.generateReport(driver, test, Status.PASS, "Login Successful");
//			return true;
		
		
		    String email = driver.findElement(Locators.emailError).getText().trim();
		    String pass = driver.findElement(Locators.passError).getText().trim();

		    if (email.contains("We didn't find an account with this Email") ||
		        pass.contains("Please enter correct password.")) {
		        Reporter.generateReport(driver, test, Status.FAIL, "Login Failure");
		        return true;  // Error is present
		    }

		    Reporter.generateReport(driver, test, Status.PASS, "Login Successful");
		    return false;  // No error
		}

	

	public boolean isLoginAttempted() {
		// TODO Auto-generated method stub
		boolean result = driver.findElement(Locators.loginButton).isDisplayed();
		if(result) {
			Reporter.generateReport(driver, test, Status.PASS, "Login Button is displayed");
			return true;
		}
		else {
			Reporter.generateReport(driver, test, Status.FAIL, "Login Button is not Displayed");
			return false;
		}
	}

}
