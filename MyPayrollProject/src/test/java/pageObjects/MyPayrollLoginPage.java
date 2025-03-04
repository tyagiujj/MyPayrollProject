package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyPayrollLoginPage extends BasePage {

    public MyPayrollLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user_names']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

   // @FindBy(xpath = "//button[normalize-space()='Sign In']")
   // WebElement signIn;
    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement signIn;

    public void enterUsername(String Username) {
        Assert.assertTrue(username.isDisplayed(), "Username field is not displayed");
        Assert.assertTrue(username.isEnabled(), "Username field is not enabled");
        username.sendKeys(Username);
        System.out.println("Entered Username: " + Username);
        Assert.assertFalse(Username.isEmpty(), "Username field should not be empty");
    }

    public void enterPassword(String Password) {
        Assert.assertTrue(password.isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(password.isEnabled(), "Password field is not enabled");
        password.sendKeys(Password);
        System.out.println("Entered Password");
        Assert.assertFalse(Password.isEmpty(), "Password field should not be empty");
    }

    public void clickLogin() {
        Assert.assertTrue(signIn.isDisplayed(), "Sign In button is not displayed");
        Assert.assertTrue(signIn.isEnabled(), "Sign In button is not enabled");
        signIn.click();
        System.out.println("Clicked on Sign In button");
    }
}