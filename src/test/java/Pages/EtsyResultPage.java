package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyResultPage {

    WebDriver driver;

    public EtsyResultPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='display-inline text-smaller']")
    public WebElement resultText;

    @FindBy(xpath = "//a[@data-path='Over $50']//span[@class='wt-radio__label']")
    public WebElement over50Button;

    @FindBy(xpath = "//span[@class='currency-value']")
    public List<WebElement> listOfPrices;

}
