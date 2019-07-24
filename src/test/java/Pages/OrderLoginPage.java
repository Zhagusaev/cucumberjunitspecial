package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderLoginPage {


    public static void main(String[] args) {

    }

    WebDriver driver;

    public OrderLoginPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBox;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement submitButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMessage;
}
