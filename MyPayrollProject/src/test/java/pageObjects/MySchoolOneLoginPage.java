package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySchoolOneLoginPage extends BasePage {
	
	public MySchoolOneLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath="//input[@name=\"imrobot\"]")
	WebElement robot;
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement loginButton;
	
	public void user(String Username) {
		username.sendKeys(Username);
	}
	public void pass(String password) {
		Password.sendKeys(password);
	}
	public void Robot() {
		robot.click();
	}
	public void button() {
		loginButton.click();
	}
}

