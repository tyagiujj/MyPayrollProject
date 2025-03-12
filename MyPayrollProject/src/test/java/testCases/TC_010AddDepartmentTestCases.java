package testCases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pageObjects.AddDepartment;
import testBase.BaseClass;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_010AddDepartmentTestCases extends BaseClass {
    @Test(priority=2)
    public void NavigateToaddDeapartmentPage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Departments/Departments.php");
    }
    @Test(priority=3)
    public void AddDepartment() {
        AddDepartment adp = new AddDepartment(driver);
        adp.ClickonAddDepartmentButon();
       String uniqueDeptName = "Software Testing " + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        adp.EnterTheDepartmentName(uniqueDeptName);
       adp.ClickonSaveButton();
    }
}
