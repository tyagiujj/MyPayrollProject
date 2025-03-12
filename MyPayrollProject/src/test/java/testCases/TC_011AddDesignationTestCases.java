package testCases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import pageObjects.AddDesignation;
import testBase.BaseClass;

public class TC_011AddDesignationTestCases extends BaseClass {
	
	@Test(priority=1)
	public void NavigateToAddDesignationPage() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Designation/Designation.php");	
	}
	@Test(priority=2)
	public void AddDesignation() {
		AddDesignation des= new AddDesignation(driver);
		des.ClickOnAddDesignation();
		des.EnterTheDesignationName("Sr.Software Tester");
		des.SelectTheDepartment("Quality Assurance");
		des.ClickonSaveButton();
	}
	 
	}
