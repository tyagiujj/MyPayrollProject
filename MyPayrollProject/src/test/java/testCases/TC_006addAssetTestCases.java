package testCases;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AddAsset;
import pageObjects.MyPayrollLoginPage;
import testBase.BaseClass;

public class TC_006addAssetTestCases extends BaseClass{
    Random random = new Random();


    @Test(priority = 2)
    public void NavigatiToAddAssetConfigurationPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://careers.myflowsoft.com/cloud/Asset/addasset.php");
    }

    @Test(priority = 3)
    public void AddAsset() {
        AddAsset ads = new AddAsset(driver);
        ads.ClickOnAddAssetButton();
        
        String assetType = "Hardware Asset";
        String assetName = "Device-" + random.nextInt(1000);
        String shortCode = String.valueOf(random.nextInt(100));
        String usageStatus = "Consumable";
        String uom = "Quantity";

        System.out.println("Entering Asset Type: " + assetType);
        ads.EnterTheAssetType(assetType);

        System.out.println("Entering Asset Name: " + assetName);
        ads.EnterTheAssetName(assetName);

        System.out.println("Entering Short Code: " + shortCode);
       ads.EnterTheShortCode(shortCode);

        System.out.println("Selecting Usage Status: " + usageStatus);
        ads.SelectTheUsageStatus(usageStatus);

        System.out.println("Selecting UOM: " + uom);
        ads.SelectTheUOM(uom);

        System.out.println("Clicking Save Button");
        ads.ClickOnSaveButton();

        System.out.println("Accepting Alert");
        ads.acceptAlert();
    }

}
