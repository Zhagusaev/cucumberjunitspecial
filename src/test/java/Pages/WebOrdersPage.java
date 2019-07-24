package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebOrdersPage {

    WebDriver driver;

    public WebOrdersPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(linkText = "Order")
    public WebElement orderLink;


    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]")
    public List<WebElement> actualListOfNames;

}
