package testCases;


import org.openqa.selenium.WindowType;


import org.testng.annotations.Test;
import pageObjects.IntentRequest;

import testBase.BaseClass;

public class TC_007IntentRequestTestCases extends BaseClass {
  
    @Test(priority=2,groups= {"Smoke,Sanity, Regression"})
    public void NavigateToIntentRequestPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://careers.myflowsoft.com/cloud/Asset/Multirow_IntendNew.php");    
    }
    @Test(priority=3,groups= {"Smoke,Sanity, Regression"})
    public void EnterAllTheDetailsForIntentRequest() {
        IntentRequest IR = new IntentRequest(driver);
        IR.EnterTheDocumentType("Software Document");
        IR.EnterTheObjective("Testing of Intent Request");
        IR.EnterTheJustification("Testing of Request");
        IR.SelectTheAssetType1("Networking Devices");
        IR.SelectTheItem("mouse");
        IR.EnterTheQuantity("5");
        IR.EnterTheUnitPrice("100");
        IR.EnterTheLocation("Bangalore");
        IR.EnterTheRequirment("Selenium With Java");
        IR.EnterTheNotes("TestNG");
        IR.SelectTheVendor("Vendor_1739960859");
        IR.ClickonSaveButton();
        IR.acceptAlert();
        System.out.println("Intent request form submitted successfully.");
    }
  
}
