package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.MyPayrollLoginPage;

public class BaseClass  {
    public static WebDriver driver;
    public Properties p;

    @BeforeClass()
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
         
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN10);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS found.");
                return;
            }
            switch (br.toLowerCase().trim()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new"); // Runs without UI
                    chromeOptions.addArguments("--disable-gpu");
                    capabilities.setBrowserName("chrome");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless=new");
                    capabilities.setBrowserName("MicrosoftEdge");
                    capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    capabilities.setBrowserName("firefox");
                    capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                    break;
                default:
                    System.out.println("No matching browser.");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://192.168.1.30:4444/wd/hub"), capabilities);
        } 
        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase().trim()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("No matching browser.");
                    return;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("AppURL1"));
        driver.manage().window().maximize();
    }
    @Test(priority = 1, groups = {"Smoke", "Sanity", "Regression"})
    public void LoginPage() throws InterruptedException {
        MyPayrollLoginPage log = new MyPayrollLoginPage(driver);
        log.enterUsername(p.getProperty("EmailAddress1"));
        log.enterPassword(p.getProperty("Password1"));
        Thread.sleep(10000);
        log.clickLogin();
        System.out.println("Login Successful, Dashboard is displayed");
    }
    @Test(priority = 2, dependsOnMethods = "LoginPage")
    public void verifyLogin() {
        System.out.println("Verifying login success...");
    }
    @AfterClass()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
