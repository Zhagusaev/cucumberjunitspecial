package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersOrderPage {

    WebDriver driver;
    public WebOrdersOrderPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardSelector;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

}
