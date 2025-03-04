package pageObjects;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AddEmployee {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public AddEmployee(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@id='getDisabled']")
	WebElement AddEmployee;
	
	@FindBy(xpath = "//select[@id='salutation']")
	WebElement salutation;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='EmployeeDOB']")
	WebElement DOB;

	@FindBy(xpath = "//select[@id='Gender']")
	WebElement Gender;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='EmployeeID']")
	WebElement E_id;

	@FindBy(xpath = "//input[@id='JoiningDate']")
	WebElement DOJ;

	@FindBy(xpath = "//input[@id='Phone']")
	WebElement Phone;

	@FindBy(xpath = "//input[@id='empaddress']")
	WebElement Address;

	@FindBy(xpath = "//select[@id='Department_value']")
	WebElement Department;

	@FindBy(xpath = "//select[@id='Designation_value']")
	WebElement Designation;

	@FindBy(xpath = "//select[@id='role']")
	WebElement Roles;

	@FindBy(xpath = "//select[@id='employmenttype']")
	WebElement E_Type;

	@FindBy(xpath = "//select[@id='RolePermission']")
	WebElement Permission;

	@FindBy(xpath = "//button[@id='Employee_Form']")
	WebElement EmployeeForm;

	private void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void ClickonAddEmployee() {
		scrollToElement(AddEmployee);
		AddEmployee.click();
	}
	public void SelectThesalutation(String sal) {
		scrollToElement(salutation);
		new Select(salutation).selectByVisibleText(sal);
	}
	public void EnterTheFirstName(String Name) {
		scrollToElement(FirstName);
		FirstName.sendKeys(Name);
	}
	public void EnterTheDOB(String dob) {
		scrollToElement(DOB);
		js.executeScript("arguments[0].value='" + dob + "';", DOB);
	}
	public void SelectTheGender(String Gen) {
		scrollToElement(Gender);
		new Select(Gender).selectByVisibleText(Gen);
	}
	public void EnterTheEmail(String email) {
		scrollToElement(Email);
		Email.sendKeys(email);
	}
	public void EnterTheId(String EID) {
		scrollToElement(E_id);
		E_id.sendKeys(EID);
	}
	public void EnterTheDOJ(String doj) {
		scrollToElement(DOJ);
		js.executeScript("arguments[0].value='" + doj + "';", DOJ);
	}
	public void EnterThePhone(String Mobile) {
		scrollToElement(Phone);
		Phone.sendKeys(Mobile);
	}
	public void EnterTheAddress(String addes) {
		scrollToElement(Address);
		Address.sendKeys(addes);
	}
	public void SelectTheDepartment(String dep) {
		scrollToElement(Department);
		new Select(Department).selectByVisibleText(dep);
	}
	public void SelecttheDesignation(String Deg) {
		scrollToElement(Designation);
		new Select(Designation).selectByVisibleText(Deg);
	}
	public void SelectTheRoles(String role) throws InterruptedException {
		scrollToElement(Roles);
		Thread.sleep(2000);
		new Select(Roles).selectByVisibleText(role);
	}
	public void SelectEmployeeType(String Etype) {
		scrollToElement(E_Type);
		new Select(E_Type).selectByVisibleText(Etype);
	}
	public void SelectThePermission(String permis) {
		scrollToElement(Permission);
		new Select(Permission).selectByVisibleText(permis);
	}
	public void ClickonSubmitButton() {
		scrollToElement(EmployeeForm);
		EmployeeForm.click();
	}}

