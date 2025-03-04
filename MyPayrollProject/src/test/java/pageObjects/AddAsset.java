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

public class AddAsset {
	WebDriver driver;
	WebDriverWait wait;

	public AddAsset(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-primary d-flex align-items-center']")
	WebElement AddAssetButton;

	@FindBy(xpath = "//select[@id='AssetType']")
	WebElement AssetType;

	@FindBy(xpath = "//input[@id='AssetName']")
	WebElement AssetName;

	@FindBy(xpath = "//input[@id='Assettypeid']")
	WebElement ShortCode;

	@FindBy(xpath = "//select[@id='resourcestatus']")
	WebElement UsageStatus;

	@FindBy(xpath = "//select[@id='Packoof']")
	WebElement UOM;

	@FindBy(xpath = "//button[@id='search']")
	WebElement Save;

	public void ClickOnAddAssetButton() {
		wait.until(ExpectedConditions.elementToBeClickable(AddAssetButton));
		Assert.assertTrue(AddAssetButton.isDisplayed(), "Add Asset Button is not Displayed");
		Assert.assertTrue(AddAssetButton.isEnabled(), "Add Asset Button is not Enabled");
		AddAssetButton.click();
	}

	public void EnterTheAssetType(String assettype) {
		wait.until(ExpectedConditions.visibilityOf(AssetType));
		Assert.assertTrue(AssetType.isDisplayed(), "Asset Type Dropdown is not Displayed");
		Assert.assertTrue(AssetType.isEnabled(), "Asset Type Dropdown is not Enabled");
		Select asst = new Select(AssetType);
		asst.selectByVisibleText(assettype);
	}

	public void EnterTheAssetName(String Name) {
		wait.until(ExpectedConditions.visibilityOf(AssetName));
		Assert.assertTrue(AssetName.isEnabled(), "Asset Name Text field is not Enabled");
		AssetName.sendKeys(Name);
	}

	public void EnterTheShortCode(String code) {
		wait.until(ExpectedConditions.visibilityOf(ShortCode));
		Assert.assertTrue(ShortCode.isEnabled(), "Short Code Text field is not Enabled");
		ShortCode.sendKeys(code);
	}

	public void SelectTheUsageStatus(String Status) {
		wait.until(ExpectedConditions.visibilityOf(UsageStatus));
		Assert.assertTrue(UsageStatus.isDisplayed(), "Usage Status Dropdown is not Displayed");
		Assert.assertTrue(UsageStatus.isEnabled(), "Usage Status Dropdown is not Enabled");
		Select use = new Select(UsageStatus);
		use.selectByVisibleText(Status);
	}

	public void SelectTheUOM(String uom) {
		wait.until(ExpectedConditions.visibilityOf(UOM));
		Assert.assertTrue(UOM.isDisplayed(), "UOM Dropdown is not Displayed");
		Assert.assertTrue(UOM.isEnabled(), "UOM Dropdown is not Enabled");
		Select um = new Select(UOM);
		um.selectByVisibleText(uom);
	}

	public void ClickOnSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		Assert.assertTrue(Save.isDisplayed(), "Save Button is not Displayed");
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
