package testCases;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ApplyLeaves;
import testBase.BaseClass;
public class TC_009ApplyLeaveTestCases extends BaseClass {

    @Test(priority = 3)
    public void NavigateTotheApplyLeavePage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(4000);
        driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Leaves/ApplyLeaveNew.php?");
    }
    @Test(priority = 4)
    public void ApplyLeave() {
        ApplyLeaves leave = new ApplyLeaves(driver);
        leave.ClickonApplyLeaveButton();
        leave.SelectLeaveType("Casual Leave");
        leave.SelectTheLeaveCategory();
        leave.EnterTheStartingDate("05/03/2025");
        leave.EnterTheEndDate("06/03/2025");
        leave.EnterTheReason("Sick Leave");
        String leaveDays;
        for (int i = 0; i < 10; i++) {
            leaveDays = leave.getNumberOfDays();
            if (!leaveDays.isEmpty()) {
                break; }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        leaveDays = leave.getNumberOfDays();
        System.out.println("Calculated Leave Days: " + leaveDays);
        Assert.assertNotNull(leaveDays, "Leave days should not be null");
        Assert.assertFalse(leaveDays.isEmpty(), "Leave days should not be empty");
        Assert.assertNotEquals(leaveDays, "0", "Leave days should not be zero");
        leave.ClickonApplyLeave();
        leave.acceptAlert();
    }
}
