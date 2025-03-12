package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDepartment {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public AddDepartment(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }    

    @FindBy(xpath = "//a[@class='btn add-btn']")
    WebElement AddDepartment;

    @FindBy(xpath = "//input[@id='departmentname']")
    WebElement DepartmentName;

    @FindBy(xpath = "//button[@id='savebutton']")
    WebElement SaveButton;

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ClickonAddDepartmentButon() {
        scrollToElement(AddDepartment);
        AddDepartment.click();
    }

    public void EnterTheDepartmentName(String Deprt) {
        scrollToElement(DepartmentName);
        DepartmentName.sendKeys(Deprt);
    }

    public void ClickonSaveButton() {
        scrollToElement(SaveButton);
        SaveButton.click();
    }
}
