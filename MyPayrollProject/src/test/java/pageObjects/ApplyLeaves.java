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
public class ApplyLeaves {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public ApplyLeaves(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[normalize-space()='Leave Application']")
    WebElement AddLeaveButton;

    @FindBy(xpath = "//select[@id='LeaveType']")
    WebElement LeaveType;

    @FindBy(xpath = "//input[@id='FullDay']")
    WebElement LeaveCategory;

    @FindBy(xpath = "//input[@id='start_date']")
    WebElement StartDate;

    @FindBy(xpath = "//input[@id='end_date']")
    WebElement EndDate;

    @FindBy(xpath = "//textarea[@id='reason']")
    WebElement Reason;

    @FindBy(xpath = "//button[@id='applyleave']")
    WebElement ApplyLeave;

    @FindBy(xpath = "//input[@id='LeaveTypeExisting']") // Number of days field
    WebElement NumberOfDays;

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void ClickonApplyLeaveButton() {
        scrollToElement(AddLeaveButton);
        AddLeaveButton.click();
    }
    public void SelectLeaveType(String LeaveTyp) {
        scrollToElement(LeaveType);
        new Select(LeaveType).selectByVisibleText(LeaveTyp);
    }
    public void SelectTheLeaveCategory() {
        scrollToElement(LeaveCategory);
        LeaveCategory.click();
    }
    public void EnterTheStartingDate(String s_date) {
        scrollToElement(StartDate);
        js.executeScript("arguments[0].value='" + s_date + "';", StartDate);
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", StartDate);
        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", StartDate);
    }
    public void EnterTheEndDate(String enddate) {
        scrollToElement(EndDate);
        js.executeScript("arguments[0].value='" + enddate + "';", EndDate);
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", EndDate);
        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", EndDate);
    }
    public void EnterTheReason(String reason) {
        scrollToElement(Reason);
        Reason.sendKeys(reason);
    }
    public void ClickonApplyLeave() {
        scrollToElement(ApplyLeave);
        ApplyLeave.click();
    }
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
    }
    public String getNumberOfDays() {
        scrollToElement(NumberOfDays);
        return NumberOfDays.getAttribute("value").trim();  } }
