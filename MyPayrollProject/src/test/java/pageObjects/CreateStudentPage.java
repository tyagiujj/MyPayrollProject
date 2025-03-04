package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class CreateStudentPage extends BasePage {

    public CreateStudentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement middleNameField;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameField;

    @FindBy(xpath = "//select[@name='gender']")
    WebElement genderDropdown;

    @FindBy(xpath = "//input[@id='dob']")
    WebElement dateOfBirthField;

    @FindBy(xpath = "//td[contains(@class, 'today')]")
    WebElement todayDate;

    @FindBy(xpath = "//input[@id=\"email_id\"]")
    WebElement E_mail;

    @FindBy(xpath = "//input[@id=\"phone_number\"]")
    WebElement mobile;

    @FindBy(xpath = "//select[@id=\"grade\"]")
    WebElement grade;

    @FindBy(xpath = "//button[@name=\"updatevalue\"]")
    WebElement button;

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        middleNameField.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void selectGender(String gender) {
        Select select = new Select(genderDropdown);
        select.selectByVisibleText(gender);
    }

    public void selectCurrentDateFromCalendar() {
        dateOfBirthField.click();
        todayDate.click();
    }

    public void setEmail(String email) {
        E_mail.sendKeys(email);
    }

    public void enterMobile(String phone) {
        mobile.sendKeys(phone);
    }

    public void selectGrade(String Grade) {
        Select select = new Select(grade);
        select.selectByValue(Grade);
    }

    // Method to click the create button with a solution to ElementClickInterceptedException
    public void create() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button)); // Wait until the button is visible
        wait.until(ExpectedConditions.elementToBeClickable(button)); // Wait until the button is clickable
        
        // Scroll the element into view if necessary
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);

        // Click the button using JavaScriptExecutor to ensure no overlay issues
        js.executeScript("arguments[0].click();", button);
    }

    public WebElement getCreateButton() {
        return button;
    }
}
