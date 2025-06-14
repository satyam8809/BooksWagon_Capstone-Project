package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class CheckoutPage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public CheckoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	public void shippingDetails() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.recipientName)).sendKeys("Satyam");
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.streetAddress)).sendKeys("Bihar");

            Select count = new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.country)));
            count.selectByIndex(1);

            Select st = new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.state)));
            st.selectByIndex(2);

            Select ct = new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.city)));
            ct.selectByIndex(2);

            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pinCode)).sendKeys("100613");
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobile)).sendKeys("1234567890");

            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(Locators.save));
            save.click();

		} catch (Exception e) {
			System.out.println("❌ Failed to select shipping address: " + e.getMessage());
		}
	}
	
	public boolean isReviewVisible() {
		boolean name = driver.findElement(Locators.reviewText).isDisplayed();
		if(name) {
			Reporter.generateReport(driver, test, Status.PASS, "Review is Visible");
			return true;
		}
		else {
			Reporter.generateReport(driver, test, Status.FAIL, "Review is not Visible");
			return false;
		}
		
	}

	public void reviewOrderSummary() {
		try {
			WebElement review = driver.findElement(Locators.reviewSave);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reviewSave));

			review.click();
//			
		} catch (Exception e) {
//			
		}
	}

	public boolean checkoutMsg() {
		boolean msg = driver.findElement(Locators.checkOut).isDisplayed();
			if (msg) {
				Reporter.generateReport(driver, test, Status.PASS, "Checkout completed successfully");
				return true;
			}
			else {
				Reporter.generateReport(driver, test, Status.FAIL, "Checkout is not completed");
				return false;
			}
	}


//	public boolean validateCheckOut(String message) {
//		 try {
//           return driver.findElement(Locators.checkOut).isDisplayed();
//       } catch (Exception e) {
//    	   return false;
//       }

	}

//  public void proceedToPayment() {
//        try {
//            driver.findElement(continueBtn).click();
//        } catch (Exception e) {
////            
//        }
//    }
//    public boolean verifyPurchaseMessage(String message) {
//        try {
//            return driver.findElement(paymentSuccessMessage).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public void skipShippingAddress() {
//        // Intentionally do nothing — simulate user skipping selection
//        System.out.println("🚫 Shipping address skipped.");
//    }
//
//    public boolean verifyWarningMessage(String expectedMessage) {
//        try {
//            return driver.findElement(warningMessage).getText().contains(expectedMessage);
//        } catch (Exception e) {
//            return false;
//        }
//    }