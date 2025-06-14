package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.Locators;
import pages.HomePage;
import pages.LoginPage;


public class LoginSteps {
    WebDriver driver = Hooks.driver;
    ExtentTest test = Hooks.test;
    LoginPage loginPage;
    HomePage homePage;

    @Given("user is on the login page")
    public void user_is_on_login_page() {
    	// assert title or url
    	loginPage = new LoginPage(driver,test);
    	loginPage.clickLoginLink();
    	String loginT = loginPage.findLoginText();
    	Assert.assertEquals("Log in", loginT);  // matches fallback
    	
    }

    @When("the user enters email as {string} and password {string} and click login button")
    public void the_user_enters_email_as_and_password_and_click_login_button(String email, String password) {
    	
    	loginPage = new LoginPage(driver,test);
    	Assert.assertTrue(loginPage.isLoginAttempted());
        loginPage.login(email, password);
        

    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    	homePage = new HomePage(driver,test);
    	String loginName = homePage.validateLogin();
    	
    	Assert.assertTrue(loginName.contains("Satyam"));

    }
    
    @Then("user should get error message")
    public void user_should_get_error_message() {
        // Write code here that turns the phrase above into concrete actions
//    	boolean error = loginPage.getLoginErrorMessage();
//    	
//    	Assert.assertTrue(error);
    	
    	Assert.assertTrue("Expected login error message, but none found", loginPage.getLoginErrorMessage());


    }
}
