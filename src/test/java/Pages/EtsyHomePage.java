package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomePage {

    WebDriver driver;

    public EtsyHomePage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "catnav-primary-link-10855")
    public WebElement jewelerySection;

    @FindBy(id = "catnav-primary-link-10923")
    public WebElement clothingSection;

    @FindBy(id = "catnav-primary-link-891")
    public WebElement homeSection;

    @FindBy(id = "catnav-primary-link-10983")
    public WebElement weddingSection;

    @FindBy(id = "catnav-primary-link-11049")
    public WebElement toysSection;

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;


}
