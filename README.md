# MyPayroll Web Automation Project 💸

This project covers automation of core HR and payroll functionalities of the **MyPayroll** web application using **Selenium WebDriver**, **TestNG**, and **Java**, designed with the **Page Object Model**.

## 🔧 Tech Stack

- ☕ Java
- 🤖 Selenium WebDriver
- ✅ TestNG (Test Framework)
- 🧱 Maven (Build & Dependency Management)
- 🌍 ChromeDriver (Browser Automation)
- 📂 Page Object Model (POM) Design Pattern
- 📋 Data Source: `config.properties`, ExcelReader 
- 📊 Reporting: TestNG default or ExtentReports

## 🧪 Modules Automated

- 🔐 Login with valid and invalid credentials
- 👤 Employee management (Add, Update, View)
- 🧾 Payslip generation verification
- 💰 Salary disbursement process
- 🚪 Logout functionality

## 📁 Project Structure
MyPayrollProject/ │ ├── src/test/java/ │ ├── testcases/ │ │ ├── LoginTest.java │ │ ├── EmployeeTest.java │ │ ├── PayslipTest.java │ │ └── SalaryTest.java │ │ │ ├── pages/ │ │ ├── LoginPage.java │ │ ├── DashboardPage.java │ │ ├── EmployeePage.java │ │ └── PayrollPage.java │ │ │ ├── base/ │ │ └── BaseTest.java │ │ │ └── utilities/ │ ├── ConfigReader.java │ └── ExcelReader.java │ ├── testng.xml ├── pom.xml └── README.md

