package PageObjects;

import StepDefinition.LoginAndAddCustomer;
import Utils.Assertion;
import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public WebDriver driver;

    @FindBy(className = "nav-link")
    @CacheLookup
    private WebElement customerLink;

    @FindBy(xpath = "//p[text()=' Customers']")
    @CacheLookup
    private WebElement customerSection;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    @CacheLookup
    private WebElement addCustomer;

    @FindBy(css = "input#Email")
    @CacheLookup
    private WebElement emailTextField;

    @FindBy(css = "input#Password")
    @CacheLookup
    private  WebElement passwordTextField;

    @FindBy(css = "input#FirstName")
    @CacheLookup
    private  WebElement firstNameTextField;

    @FindBy(css = "input#LastName")
    @CacheLookup
    private WebElement lastNameTextField;

    @FindBy(css = "input#Gender_Male")
    @CacheLookup
    private WebElement genderRadioButton;

    @FindBy(css = "span[role='button]")
    @CacheLookup
    private WebElement dateButton;

    @FindBy(xpath = "//a[@title='Monday, April 4, 2022' and @href='#']")
    @CacheLookup
    private WebElement Date;

    @FindBy(css = "input#Company")
    @CacheLookup
    private  WebElement companyTextField;

    @FindBy(css = "i.far fa-save")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(css = "div.alert alert-success alert-dismissable")
    @CacheLookup
    private WebElement alert;

    public void clickOnCustomerLink(){
        customerLink.click();
    }
    public void clickOnCustomerSection(){
        customerSection.click();
    }

    public void clickOnAddCustomer(){
        addCustomer.click();
    }

    public void setEmailTextField(String email) {
        emailTextField.sendKeys(email);
    }

    public void setPasswordTextField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void setFirstNameTextField(String firstName) {
        firstNameTextField.sendKeys(firstName);
    }

    public void setLastNameTextField(String lastName) {
      lastNameTextField.sendKeys(lastName);
    }

    public void setCompanyTextField(String company) {
      companyTextField.sendKeys(company);
    }
    public void selectGender(){
        genderRadioButton.click();
    }
    public void selectDate(){
        dateButton.click();
        Date.click();
    }
    public void addCustomer(){
        saveButton.click();
    }
    public void getAlertText(String expected){
        String text = alert.getText();
        System.out.println(Assertion.validation(expected,text));
    }

    public Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
