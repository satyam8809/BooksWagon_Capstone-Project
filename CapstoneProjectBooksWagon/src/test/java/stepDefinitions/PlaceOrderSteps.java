package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaceOrderPage;

public class PlaceOrderSteps {
	WebDriver driver = Hooks.driver;
	LoginPage loginPage;
	PlaceOrderPage placeOrderPage;
	CheckoutPage checkoutPage;
	ExtentTest test = Hooks.test;
	HomePage homePage;

	@Given("the browser is open")
	public void the_browser_is_open() {
		// Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("I navigate to the Bookswagon login page")
	public void i_navigate_to_the_bookswagon_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.bookswagon.com/");
		loginPage = new LoginPage(driver,test);
		loginPage.clickLoginLink();
		String expectedUrl = "https://www.bookswagon.com/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Given("I login with email {string} and password {string}")
	public void i_login_with_email_and_password(String email, String password) {
		// Write code here that turns the phrase above into concrete actions
		loginPage.login(email, password);
		homePage = new HomePage(driver,test);
    	String loginName = homePage.validateLogin();
    	Assert.assertTrue(loginName.contains("Satyam"));
	}
	
	
	@Then("user should be logged in successfull")
	public void user_should_be_logged_in_successfull() {
		homePage = new HomePage(driver,test);
    	String loginName = homePage.validateLogin();
    	
    	Assert.assertTrue(loginName.contains("Satyam"));
	}
	
	
	@When("user search for {string}")
	public void user_search_for(String bookName) {
		// Write code here that turns the phrase above into concrete actions
		placeOrderPage = new PlaceOrderPage(driver,test);
		placeOrderPage.searchBook(bookName);
		String result = placeOrderPage.isBookSearched();
		
		Assert.assertEquals(bookName.toLowerCase(), result.toLowerCase());
	}

	@When("user add the first result to cart")
	public void user_add_the_first_result_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		placeOrderPage.addFirstBookToCart();
		
		boolean result= placeOrderPage.isCartVisible();
		Assert.assertTrue(result);
//		Assert.assertEquals("Buy",result);
	}

	@When("user view my cart")
	public void user_view_my_cart() {
		// Write code here that turns the phrase above into concrete actions
		placeOrderPage.openCart();
		boolean result= placeOrderPage.isCartVisible();
		Assert.assertTrue(result);
	}

	@When("user proceed to checkout")
	public void user_proceed_to_checkout() {
		// Write code here that turns the phrase above into concrete actions
		placeOrderPage.clickCheckout();
		boolean result = placeOrderPage.isShippingVisible();
		Assert.assertEquals(true, result);
	}

	@When("user enter valid shipping details")
	public void user_enter_valid_shipping_details() {
		// Write code here that turns the phrase above into concrete actions
		checkoutPage = new CheckoutPage(driver, test); 
		checkoutPage.shippingDetails();
		boolean result = checkoutPage.isReviewVisible();
		Assert.assertEquals(true, result);
	}

	@Then("user should see {string}")
	public void user_should_see(String msg) {
		checkoutPage = new CheckoutPage(driver, test); 
		checkoutPage.reviewOrderSummary();

		boolean result = checkoutPage.checkoutMsg();
		Assert.assertTrue("Expected message not shown: " + msg, result);
		
	}


	
	@Then("user should get error message {string}")
	public void user_should_get_error_message(String errorMsg) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(errorMsg);
	    
	}

}