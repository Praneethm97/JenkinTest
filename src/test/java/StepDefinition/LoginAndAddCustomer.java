package StepDefinition;

import PageObjects.Dashboard;
import PageObjects.Login;
import Utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoginAndAddCustomer extends BaseClass {
    @Given("Instantiate browser and enter Url")
    public void Instantiate_browser_and_enter_Url(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/admin/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        l = new Login(driver);

    }
    @When("Enter the {string} and {string}")
    public void enter_the_and(String un, String pwd) {

        l.enterTextInUsernameField(un);
        l.enterTextInPasswordTextField(pwd);

    }
    @Then("User click on the login")
    public void user_click_on_the_login() {
        l.clickOnLogin();

    }
    @Given("Click on customersection")
    public void click_on_customersection() {
        d = new Dashboard(driver);
        d.clickOnCustomerLink();

    }
    @Given("Click on customer")
    public void click_on_customer() {
       d.clickOnCustomerSection();
    }
    @When("Click on Add")
    public void click_on_add() {
       d.addCustomer();
    }
    @Then("Enter email,password,Firstname,Lastname and Company")
    public void enter_email_password_firstname_lastname_and_company() {
       d.setEmailTextField("anandm@yopmail.com");
       d.setPasswordTextField("Simh@chary1");
       d.setFirstNameTextField("Anand");
       d.setLastNameTextField("Mahindra");
       d.setCompanyTextField("TechM");
    }
    @Then("Enter date")
    public void enter_date() {
       d.selectDate();
    }
    @Then("Select the gender")
    public void select_the_gender() {
      d.selectGender();
    }
    @And("click on save button")
    public void click_on_save_button(){
        d.clickOnAddCustomer();
    }
    @Then("User gets the success message {string}")
    public void user_gets_the_success_message(String text) {
         d.getAlertText(text);
    }


}
