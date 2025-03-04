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
import org.testng.Assert;

public class AddAssetConfiguration {
	WebDriver driver;
	WebDriverWait wait;
	public AddAssetConfiguration(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Add Asset Type']")
	WebElement AddAssetButton;
	
	@FindBy(xpath="//input[@id='Asset_type']")
	WebElement AssetType;
	
	@FindBy(xpath="//input[@id='Assettypecode']")
	WebElement ShortCode;
	
	@FindBy(xpath="//select[@id='dept']")
	WebElement Department;
	
	@FindBy(xpath="//select[@id='Assettag']")
	WebElement TagId;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement Description;
	
   @FindBy(xpath="//button[@id='search']")
    WebElement Save;
    
   public void ClickonAddAssetButton() {
	   wait.until(ExpectedConditions.elementToBeClickable(AddAssetButton));
	   Assert.assertTrue(AddAssetButton.isDisplayed(), "Add Asset Button is not Display");
	   Assert.assertTrue(AddAssetButton.isEnabled(),"Add Asset Button is not Enabled");
	   AddAssetButton.click();
   }
   public void EnterAssetType(String Assettype) {
	   Assert.assertTrue(AssetType.isEnabled()," Asset Type  Text field is not Enabled ");
	   AssetType.sendKeys(Assettype);
	      }
   public void EntertheShortCode(String shortcode) {
	   Assert.assertTrue(ShortCode.isEnabled(), "Short Code Text Field is not Enabled");
	   ShortCode.sendKeys(shortcode);
   }
   public void SelectTheDepartment(String Departmentname) {
	   wait.until(ExpectedConditions.visibilityOf(Department));
	   Assert.assertTrue(Department.isDisplayed(), "Department DropDown Field is not Display");
	   Assert.assertTrue(Department.isEnabled(),"Department DropDown Field is not Enabled");
	   Select depr= new Select(Department);
	   depr.selectByVisibleText(Departmentname);   
   }
   public void SelectTheTagId(String TagID) {
	   wait.until(ExpectedConditions.visibilityOf(TagId));
	   Assert.assertTrue(TagId.isDisplayed(), "TagId DropDown Field is not Display");
	   Assert.assertTrue(TagId.isEnabled(), "TagId DropDown is not Enabled");
	   Select ID= new Select(TagId);
	   ID.selectByVisibleText(TagID);
   }
   public void EnterTheDescription(String description) {
	   wait.until(ExpectedConditions.visibilityOf(Description));
	   Assert.assertTrue(Description.isEnabled(), "Description Text Field is not Enabled");
	   Description.sendKeys(description);
   }
   public void ClickOnSave() {
	   wait.until(ExpectedConditions.elementToBeClickable(Save));
	   Assert.assertTrue(Save.isDisplayed(), "Save Button is not Display");
	   Assert.assertTrue(Save.isEnabled(), "Save Button is not Enabled");
	   Save.click();
   }
   public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}
}


