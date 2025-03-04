package pageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVendorPOM {
	WebDriver driver;
	WebDriverWait wait;
	
	public AddVendorPOM(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Add Vendor']")
	WebElement AddVendorButton;
	
	@FindBy(xpath="//input[@id='Vendorshopname']")
	WebElement VendorName;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='vendorcode']")
	WebElement ShortCode;
	
	@FindBy(xpath="//input[@id='Ownername']")
	WebElement ContactPerson;
	
	@FindBy(xpath="//input[@id='Mobile']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//select[@id='vendorstatus']")
	WebElement Company;
	
	@FindBy(xpath="//button[@id='saveVendor']")
	WebElement Save;
	
	public void addvendor() {
		wait.until(ExpectedConditions.elementToBeClickable(AddVendorButton));
		System.out.println("Add Vendor button is displayed: " + AddVendorButton.isDisplayed());
		System.out.println("Add Vendor button is enabled: " + AddVendorButton.isEnabled());
		AddVendorButton.click();
	}
	
	public void vendorname(String v_name) {
		wait.until(ExpectedConditions.visibilityOf(VendorName));
		System.out.println("Vendor Name field is displayed: " + VendorName.isDisplayed());
		System.out.println("Vendor Name field is enabled: " + VendorName.isEnabled());
		VendorName.sendKeys(v_name);
	}
	
	public void E_mail(String id) {
		wait.until(ExpectedConditions.visibilityOf(Email));
		System.out.println("Email field is displayed: " + Email.isDisplayed());
		System.out.println("Email field is enabled: " + Email.isEnabled());
		Email.sendKeys(id);
	}
	
	public void shortcode(String s_code) {
		wait.until(ExpectedConditions.visibilityOf(ShortCode));
		System.out.println("Short Code field is displayed: " + ShortCode.isDisplayed());
		System.out.println("Short Code field is enabled: " + ShortCode.isEnabled());
		ShortCode.sendKeys(s_code);
	}
	
	public void contactperson(String C_Person) {
		wait.until(ExpectedConditions.visibilityOf(ContactPerson));
		System.out.println("Contact Person field is displayed: " + ContactPerson.isDisplayed());
		System.out.println("Contact Person field is enabled: " + ContactPerson.isEnabled());
		ContactPerson.sendKeys(C_Person);
	}
	
	public void mobile(String number) {
		wait.until(ExpectedConditions.visibilityOf(PhoneNumber));
		System.out.println("Phone Number field is displayed: " + PhoneNumber.isDisplayed());
		System.out.println("Phone Number field is enabled: " + PhoneNumber.isEnabled());
		PhoneNumber.sendKeys(number);
	}
	
	public void cmpy(String companyName) {
		wait.until(ExpectedConditions.visibilityOf(Company));
		System.out.println("Company dropdown is displayed: " + Company.isDisplayed());
		System.out.println("Company dropdown is enabled: " + Company.isEnabled());
		Select select = new Select(Company);
		select.selectByVisibleText(companyName);
	}
	
	public void submit() {
		wait.until(ExpectedConditions.visibilityOf(Save));
		System.out.println("Submit button is displayed: " + Save.isDisplayed());
		System.out.println("Submit button is enabled: " + Save.isEnabled());
		Save.click();
	}

	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}
}
