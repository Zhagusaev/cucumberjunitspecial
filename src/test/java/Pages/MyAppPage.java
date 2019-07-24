package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAppPage {

    WebDriver driver;

    public MyAppPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[1]//td")
    public List<WebElement> firstRowData;


    @FindBy(xpath = "//tr[2]//td")
    public List<WebElement> secondRowData;

    @FindBy(xpath = "//tr[3]//td")
    public List<WebElement> thirdRowData;

    @FindBy(xpath = "//tr[4]//td")
    public List<WebElement> fourthRowData;

    @FindBy(xpath = "//th")
    public List<WebElement> columnNames;

}
