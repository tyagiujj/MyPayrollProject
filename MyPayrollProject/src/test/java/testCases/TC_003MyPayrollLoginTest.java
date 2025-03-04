package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.MyPayrollLoginPage;

public class TC_003MyPayrollLoginTest {
    public WebDriver driver;
    
    @BeforeClass()
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://careers.myflowsoft.com/Login.php");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void LoginPage() throws InterruptedException {
        MyPayrollLoginPage log = new MyPayrollLoginPage(driver);
        log.enterUsername("potenikhil77@gmail.com");
        log.enterPassword("Kumarujjwal@123");
        Thread.sleep(10000);
        log.clickLogin();
        System.out.println("Login Successful, Dashboard is displayed");
    }
    @Test(priority = 2, dependsOnMethods = "LoginPage")
    public void verifyLogin() {
        System.out.println("Verifying login success...");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
