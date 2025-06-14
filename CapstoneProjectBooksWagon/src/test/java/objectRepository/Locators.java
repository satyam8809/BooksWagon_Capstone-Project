package objectRepository;

import org.openqa.selenium.By;

public class Locators {
//	SignUp Locators
	public static final By signupLink = By.xpath("(//a[contains(text(),'Sign')])[2]"); 
    public static final By fullName = By.id("ctl00_phBody_SignUp_txtName");
    public static final By mobileNumber = By.id("ctl00_phBody_SignUp_txtEmail");
//    public static final By validateButton = By.id("ctl00_phBody_SignUp_imgbtnEmail"); // phone/email verify button
    public static final By continueButton = By.id("ctl00_phBody_SignUp_btnContinue");
    public static final By signUpButton = By.id("ctl00_phBody_SignUp_btnSubmit");   //ctl00_phBody_SignUp_btnSubmit
    public static final By signupError = By.id("ctl00_phBody_SignUp_lblmsg"); // update if this differs
    public static final By otp = By.id("ctl00_phBody_SignUp_txtOTP");
    public static final By signUpText = By.xpath("//h3[text()=\"Sign up\"]");

	
	
//	Login Step Locators
	public static By loginText = By.xpath("//h3[text()=\"Log in\"]");
	public static By myAccount = By.id("ctl00_lblUser");
	public static By emailField = By.id("ctl00_phBody_SignIn_txtEmail"); // ctl00_phBody_SignIn_txtEmail
	public static By passwordField = By.id("ctl00_phBody_SignIn_txtPassword"); // ctl00_phBody_SignIn_txtPassword
	public static By loginButton = By.id("ctl00_phBody_SignIn_btnLogin"); // ctl00_phBody_SignIn_btnLogin

	// locators for Home Page
	public static By checkName = By.xpath("//span[contains(text(),'Satyam')]");
	
//	Login error locators
	public static By emailError = By.id("ctl00_phBody_SignIn_lblemailmsg");
	public static By passError = By.id("ctl00_phBody_SignIn_lblmsg");
	
	
//	PlaceOrder Locators
	public static By searchBox = By.id("inputbar");
	public static By searchButton = By.id("btnTopSearch");
	public static By firstBookBuyBtn = By.xpath("(//input[@value=\"Add to cart\"])[1]");
	public static By cartIcon = By.xpath("(//img[@alt='Cart Icon']/parent::a)[1]");
	public static By cartTotalItems = By.id("ctl00_phBody_BookCart_lvCart_imgPayment");
	public static By moveToWishlist = By.id("ctl00_phBody_BookCart_lvCart_ctrl0_btnMovetoWishlist");
	public static By buy = By.xpath("//input[@name=\"ctl00$phBody$BookCart$lvCart$imgPayment\"]");
	
//	BookName validation
	public static By checkBookName = By.xpath("//span[contains(text(),'selenium')]");
	
	
	//

//	Checkout Locators
	
	// Shipping Details
	public static By shippingText = By.xpath("//div[contains(text(),\'Shipping\')]"); 
	
	public static By recipientName = By.id("ctl00_cpBody_txtNewRecipientName");
	public static By streetAddress = By.id("ctl00_cpBody_txtNewAddress");
	public static By country = By.id("ctl00_cpBody_ddlNewCountry");   //ctl00_cpBody_ddlNewCountry
	public static By state = By.id("ctl00_cpBody_ddlNewState");
	public static By city = By.id("ctl00_cpBody_ddlNewCities");
	public static By pinCode = By.id("ctl00_cpBody_txtNewPincode");
	public static By mobile = By.id("ctl00_cpBody_txtNewMobile");
	public static By save = By.xpath("//input[@name=\"ctl00$cpBody$imgSaveNew\"]");
	

//	Review Order
	public static By reviewText = By.xpath("//h3[text()=\"Review your Order \"]");
	public static By reviewSave = By.xpath("//input[@name=\"ctl00$cpBody$ShoppingCart$lvCart$savecontinue\"]");
	
//	Checkout
	public static By checkOut = By.xpath("//img[@alt=\"Cart\"]");
	
	  public static By cardNumberField = By.id("card_number");        
	  public static By expiryField = By.id("card_expiry");             
	  public static By cvvField = By.id("card_cvv");                  
	  public static By payButton = By.id("btnPay");  
	  public static By successMessage = By.xpath("//*[contains(text(), 'Book Purchased')]");
	  public static By failureMessage = By.xpath("//*[contains(text(), 'Payment Failed')]");
}
