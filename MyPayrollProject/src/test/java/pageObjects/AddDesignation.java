package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDesignation {
	   WebDriver driver;
	    WebDriverWait wait;
	    JavascriptExecutor js;
	    public AddDesignation(WebDriver driver) {
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	    } 
	    
	    @FindBy(xpath="//a[@class='btn add-btn']")
	    WebElement AddDesignation;
	    
	    @FindBy(xpath ="//input[@id='Designationname']")
	    WebElement DesignationName;
	    
	    @FindBy(xpath="//select[@id='Department']")
	    WebElement Department;
	    
	    
	    @FindBy(xpath="//button[@id='search']")
	    WebElement Save;
	    
	    private void scrollToElement(WebElement element) {
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	    public void ClickOnAddDesignation() {
	    	scrollToElement(AddDesignation);
	    	AddDesignation.click();
	    }
	    public void EnterTheDesignationName(String Degi) {
	    	scrollToElement(DesignationName);
	    	DesignationName.sendKeys(Degi);
	    }
	    public void SelectTheDepartment(String Dep) {
	    	scrollToElement(Department);
	    	Select depa= new Select(Department);
	    	depa.selectByVisibleText(Dep);	
	    }
	    public void ClickonSaveButton() {
	    	scrollToElement(Save);
	    	Save.click();
	    }
}
