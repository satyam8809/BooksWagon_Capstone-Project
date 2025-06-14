package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class PlaceOrderPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public PlaceOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	public void searchBook(String bookName) {
		driver.findElement(Locators.searchBox).clear();
		driver.findElement(Locators.searchBox).sendKeys(bookName);
		driver.findElement(Locators.searchButton).click();

//		return driver.findElement(Locators.searchBox).getText();
	}

	public String isBookSearched() {
		String bookName;
		try {
			bookName = driver.findElement(Locators.checkBookName).getText().replace("\"", "").trim();
			Reporter.generateReport(driver, test, Status.PASS, "Found the book");
		} catch (Exception e) {
			bookName = "Dummy Text";
			Reporter.generateReport(driver, test, Status.FAIL, "Book not found");
		}
		return bookName;
	}

	public void addFirstBookToCart() {
		driver.findElement(Locators.firstBookBuyBtn).click();
	}

	public boolean isCartVisible() {
		boolean buy=wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartIcon)).isDisplayed();
		if(buy) {
			Reporter.generateReport(driver, test, Status.PASS, "Cart is visible");
			return true;
		}
		else {
			Reporter.generateReport(driver, test, Status.FAIL, "Cart is not visible");
			return false;
		}

	}

	public void openCart() {
		WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartIcon));
		cartIcon.click();
	}

	public boolean isItemPresentInCart() {
		try {
			WebElement element = driver.findElement(Locators.moveToWishlist);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickCheckout() {
		driver.findElement(Locators.buy).click();
	}

	public boolean isShippingVisible() {
		boolean name = driver.findElement(Locators.shippingText).isDisplayed();
		if (name) {
			Reporter.generateReport(driver, test, Status.PASS, "Shipping is done");
			return true;
		} else {
			Reporter.generateReport(driver, test, Status.FAIL, "Shipping is not Done");
			return false;
		}

	}

	public String getSuccessMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isCartPageDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}
}