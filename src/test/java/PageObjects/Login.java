package PageObjects;

import StepDefinition.LoginAndAddCustomer;
import Utils.Assertion;
import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  {
    public WebDriver driver;
    @FindBy(css = "input#Email")
    @CacheLookup
    private WebElement userNameTextField;

    @FindBy(css = "input#Password")
    @CacheLookup
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[text() = 'Log in']")
    @CacheLookup
    private WebElement logInButton;

    @FindBy(css="div.content-header>h1")
    @CacheLookup
    private WebElement dashBoard;

    public void enterTextInUsernameField(String userName){
        userNameTextField.clear();
        userNameTextField.sendKeys(userName);
    }

    public void enterTextInPasswordTextField(String password){
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public void clickOnLogin(){
        logInButton.click();
    }

    public void dashBoardAppears(){
        String text = dashBoard.getText();
        System.out.println(Assertion.validation("Dashboard",text));
    }

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}
