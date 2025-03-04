package testCases;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AddAssetConfiguration;
import pageObjects.MyPayrollLoginPage;
import testBase.BaseClass;
public class TC_005AddAssetTestCases extends BaseClass {


    
    @Test(priority=2)
    public void NavigatiToAddAssetConfigurationPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://careers.myflowsoft.com/cloud/Asset/assetconfig.php");
    }
    
    @Test(priority=3, groups="Sanity")
    public void AddAssetConfigurations() throws InterruptedException {
        AddAssetConfiguration con = new AddAssetConfiguration(driver);
        con.ClickonAddAssetButton();
        String uniqueAssetType = "Laptop, Mouse " + System.currentTimeMillis();
        String uniqueShortCode = "MC" + (System.currentTimeMillis() % 1000);
        String uniqueDescription = "Testing " + System.currentTimeMillis();
       
        con.EnterAssetType(uniqueAssetType);
        con.EntertheShortCode(uniqueShortCode);
        con.SelectTheDepartment("Finance Department");
        con.SelectTheTagId("Yes");
        con.EnterTheDescription(uniqueDescription);
        con.ClickOnSave();
        con.acceptAlert();
    }
   
}
