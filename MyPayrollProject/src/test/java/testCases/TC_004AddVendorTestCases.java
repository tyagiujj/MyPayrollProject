package testCases;

import java.util.Random;
import java.util.UUID;

import org.testng.annotations.Test;

import pageObjects.AddVendorPOM;
import testBase.BaseClass;

public class TC_004AddVendorTestCases extends  BaseClass {
	Random random = new Random();
	@Test(priority=2)
	public void NavigatetoAddVendorPage() throws InterruptedException {
		Thread.sleep(4000);
		driver.get("https://careers.myflowsoft.com/cloud/Asset/vendordetails.php");
	}
	@Test(priority=3)
	public void AddVendorDetalis() {
	
		AddVendorPOM adv = new AddVendorPOM(driver);
		String uniqueID = UUID.randomUUID().toString().substring(0, 5);
		int randomNum = random.nextInt(9000) + 1000;

		String vendorName = "Vendor_" + uniqueID;
		String email = "test" + randomNum + "@gmail.com";
		String shortCode = "SC" + randomNum;
		String contactPerson = "Person_" + uniqueID;
		String mobile = "98765" + (10000 + randomNum);
		
		System.out.println("Adding Vendor Details:");
		System.out.println("Vendor Name: " + vendorName);
		System.out.println("Email: " + email);
		System.out.println("Short Code: " + shortCode);
		System.out.println("Contact Person: " + contactPerson);
		System.out.println("Mobile: " + mobile);

		adv.addvendor();
		adv.vendorname(vendorName);
		adv.E_mail(email);
		adv.shortcode(shortCode);
		adv.contactperson(contactPerson);
		adv.mobile(mobile);
		adv.cmpy("ACTIVE");
		adv.submit();
		
		adv.acceptAlert();
		System.out.println("Vendor added successfully.");

	}

	
}