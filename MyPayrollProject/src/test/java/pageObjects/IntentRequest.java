package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IntentRequest {
    WebDriver driver;
    WebDriverWait wait;

    public IntentRequest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='document-title']")
    WebElement Document;

    @FindBy(xpath="//textarea[@id='objective']")
    WebElement Objective;

    @FindBy(xpath="//textarea[@id='justification']")
    WebElement Justification;

    @FindBy(xpath="//select[@id='Assettype1']")
    WebElement Assettype;

    @FindBy(xpath="//select[@id='item1']")
    WebElement Item;

    @FindBy(xpath="//input[@id='quantity1']")
    WebElement Quantity;

    @FindBy(xpath="//input[@id='unit-price1']")
    WebElement UnitPrice;

    @FindBy(xpath="//input[@id='delivery-location']")
    WebElement Location;

    @FindBy(xpath="//textarea[@id='special-requirements']")
    WebElement SpecialRequirment;

    @FindBy(xpath="//textarea[@id='additional-notes']")
    WebElement Notes;

    @FindBy(xpath="//select[@id='preferred-vendors']")
    WebElement Vendors;

    @FindBy(xpath="//button[@id='saverequest']")
    WebElement Save;

    public void EnterTheDocumentType(String Doc) {
        wait.until(ExpectedConditions.visibilityOf(Document));
        Assert.assertTrue(Document.isEnabled(), "Document Text field is not Enabled");
        Document.sendKeys(Doc);
    }

    public void EnterTheObjective(String Obj) {
        wait.until(ExpectedConditions.visibilityOf(Objective));
        Assert.assertTrue(Objective.isEnabled(), "Objective Text Field is not Enabled");
        Objective.sendKeys(Obj);
    }

    public void EnterTheJustification(String Jus) {
        wait.until(ExpectedConditions.visibilityOf(Justification));
        Assert.assertTrue(Justification.isEnabled(), "Justification Text Field is not Enabled");
        Justification.sendKeys(Jus);
    }

    public void SelectTheAssetType1(String assetype) {
        wait.until(ExpectedConditions.visibilityOf(Assettype));
        Assert.assertTrue(Assettype.isEnabled(), "Asset Type DropDown is not Enabled");
        Select type = new Select(Assettype);
        type.selectByVisibleText(assetype);
    }

    public void SelectTheItem(String itm) {
        wait.until(ExpectedConditions.visibilityOf(Item));
        Assert.assertTrue(Item.isEnabled(), "Item DropDown is not Enabled");
        Select it = new Select(Item);
        it.selectByVisibleText(itm);
    }

    public void EnterTheQuantity(String Qty) {
        wait.until(ExpectedConditions.visibilityOf(Quantity));
        Assert.assertTrue(Quantity.isEnabled(), "Quantity Text Field is not Enabled");
        Quantity.sendKeys(Qty);
    }

    public void EnterTheUnitPrice(String Price) {
        wait.until(ExpectedConditions.visibilityOf(UnitPrice));
        Assert.assertTrue(UnitPrice.isEnabled(), "Unit Price Text Field is not Enabled");
        UnitPrice.sendKeys(Price);
    }

    public void EnterTheLocation(String Loc) {
        wait.until(ExpectedConditions.visibilityOf(Location));
        Assert.assertTrue(Location.isEnabled(), "Location Text Field is not Enabled");
        Location.sendKeys(Loc);
    }

    public void EnterTheRequirment(String Req) {
        wait.until(ExpectedConditions.visibilityOf(SpecialRequirment));
        Assert.assertTrue(SpecialRequirment.isEnabled(), "Special Requirement Text Field is not Enabled");
        SpecialRequirment.sendKeys(Req);
    }

    public void EnterTheNotes(String notes) {
        wait.until(ExpectedConditions.visibilityOf(Notes));
        Assert.assertTrue(Notes.isEnabled(), "Notes Text Field is not Enabled");
        Notes.sendKeys(notes);
    }

    public void SelectTheVendor(String Vndr) {
        wait.until(ExpectedConditions.visibilityOf(Vendors));
        Assert.assertTrue(Vendors.isEnabled(), "Vendors DropDown is not Enabled");
        Select ast = new Select(Vendors);
        ast.selectByVisibleText(Vndr);
    }
    public void ClickonSaveButton() {
    	    try {
    	        wait.until(ExpectedConditions.elementToBeClickable(Save)).click();
    	    } catch (org.openqa.selenium.ElementClickInterceptedException e) {
    	        System.out.println("Element click intercepted, using JavaScript click instead.");
    	        
    	        // Option 1: Scroll into view and click
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        js.executeScript("arguments[0].scrollIntoView(true);", Save);
    	        js.executeScript("arguments[0].click();", Save);
    	        }
    	    }
    	    public void acceptAlert() {
    			wait.until(ExpectedConditions.alertIsPresent());
    			Alert alert = driver.switchTo().alert();
    			System.out.println("Alert Text: " + alert.getText());
    			alert.accept();
    	    }}
