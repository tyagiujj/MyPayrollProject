package testCases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import java.util.Random;
import pageObjects.AddEmployee;
import testBase.BaseClass;

public class TC_008AddEmployeeTestCases extends BaseClass {
    Random random = new Random();
    int randomNum = random.nextInt(1000); 
    @Test(priority = 3)
    public void NavigateToAddEmployeePage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(4000);
        driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Employee/Employees.php");
    }
    @Test(priority = 4)
    public void AddEmployee() throws InterruptedException {
        AddEmployee emp = new AddEmployee(driver);
        emp.ClickonAddEmployee();
        emp.SelectThesalutation("Mr");
        emp.EnterTheFirstName("Brett Lee" + randomNum);
        emp.EnterTheDOB("02/01/199" + randomNum % 10);
        emp.SelectTheGender("Male");
        emp.EnterTheEmail("bretlee" + randomNum + "@gmail.com");
        emp.EnterTheId("stuti" + randomNum);
        emp.EnterTheDOJ("01/01/202" + randomNum % 5);
        emp.EnterThePhone("9756360" + (2000 + randomNum % 8000));
        emp.EnterTheAddress("Bangalore" + randomNum);
        emp.SelectTheDepartment("Product Development");
        emp.SelecttheDesignation("Product Development");
        emp.SelectTheRoles("Front-End Developer");
        emp.SelectEmployeeType("Permanent Employee");
        emp.SelectThePermission("Primary");
        emp.ClickonSubmitButton();
    }}
