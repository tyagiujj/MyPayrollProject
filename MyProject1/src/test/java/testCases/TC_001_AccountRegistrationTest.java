package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Master"})
	public void verify_account_registration()
	{
		logger.info("******** Starting TC_001_AccountRegistrationTest  ***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("******** Clicked on Register Link  ***");

		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("******** Providing customer Details  ***");

		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("******** Validating expected Message..  ***");

		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");}
		catch(Exception e)
		{
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.fail();
			
		}
		logger.info("**** TC_001_AccountRegistrationTest Completed ***");
		}
		
		
	}
	
	
	
	









