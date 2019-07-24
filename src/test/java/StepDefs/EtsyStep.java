package StepDefs;

import Pages.EtsyHomePage;
import Pages.EtsyResultPage;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyStep {
    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    EtsyResultPage etsyResultPage = new EtsyResultPage();


    @Given("User is on Etsy homepage")
    public void user_is_on_Etsy_homepage() {

        driver.get(Configuration.getProperty("etsyUrl"));

    }

    @Then("User verifies homepage title {string}")
    public void user_verifies_homepage_title(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }



    @When("User click on {string}")
    public void user_click_on(String section) {
        if (section.equalsIgnoreCase(etsyHomePage.jewelerySection.getText())){
            etsyHomePage.jewelerySection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.clothingSection.getText())){
            etsyHomePage.clothingSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.homeSection.getText())){
            etsyHomePage.homeSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.weddingSection.getText())){
            etsyHomePage.weddingSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.toysSection.getText())){
            etsyHomePage.toysSection.click();
        }
    }

    @Then("user verifies {string}")
    public void user_verifies(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("User searches for {string}")
    public void user_searches_for(String item) throws Exception {

        etsyHomePage.searchBox.sendKeys(item );
        Thread.sleep(2000);
        etsyHomePage.searchBox.sendKeys(Keys.ENTER);

    }

    @Then("Verify that {string} is displayed in search message")
    public void verify_that_is_displayed_in_search_message(String item) {

        String actualMessage = etsyResultPage.resultText.getText();
        Assert.assertEquals("The expected: "+item+"didn't match with actual: "+actualMessage,item,actualMessage);
    }


    @Then("User selects over {int} price range")
    public void user_selects_over_price_range(Integer int1) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(etsyResultPage.over50Button));
            etsyResultPage.over50Button.click();
    }

    @Then("User verifies that result prices are over {int}")
    public void user_verifies_that_result_prices_are_over(Integer expectedPrice) {

        for (WebElement price: etsyResultPage.listOfPrices){
            if(!price.getText().equals("")){
                double actualPrice = Double.parseDouble(price.getText());
                Assert.assertTrue(actualPrice >= expectedPrice);
                System.out.println(actualPrice);
            }

//            int  actualPrice =Integer.parseInt(price.getText());
//            System.out.println(actualPrice);

        }
    }


}
