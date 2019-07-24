package StepDefs;

import Pages.OrderLoginPage;
import Pages.WebOrdersOrderPage;
import Pages.WebOrdersPage;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderStep {
    WebDriver driver = Driver.getDriver();
    OrderLoginPage orderLoginPage = new OrderLoginPage();
    WebOrdersPage webOrdersPage = new WebOrdersPage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();

    @Given("user logs in with credentials username {string} password {string}")
    public void user_logs_in_with_credentials_username_password(String username, String password) {
        driver.get(Configuration.getProperty("orderUrl"));
        orderLoginPage.usernameBox.sendKeys(username);
        orderLoginPage.passwordBox.sendKeys(password);
        orderLoginPage.submitButton.click();
    }

    @Then("user clicks on Order")
    public void user_clicks_on_Order() {
        webOrdersPage.orderLink.click();
    }

    @Then("User creates orders")
    public void user_creates_orders(DataTable orders) {
        List<Map<String, String>> listOfMaps = orders.asMaps();

        for (Map<String, String> order : listOfMaps) {
            webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE+order.get("Quantity"));
            webOrdersOrderPage.customerNameBox.sendKeys(order.get("Customer name"));
            webOrdersOrderPage.streetBox.sendKeys(order.get("Street"));
            webOrdersOrderPage.cityBox.sendKeys(order.get("City"));
            webOrdersOrderPage.zipBox.sendKeys(order.get("Zip"));
            webOrdersOrderPage.cardSelector.click();
            webOrdersOrderPage.cardNumberBox.sendKeys(order.get("Card Nr"));
            webOrdersOrderPage.expDateBox.sendKeys(order.get("Expire Date"));
            webOrdersOrderPage.processButton.click();
        }
        System.out.println(listOfMaps);
    }

    @Then("User click on View Orders")
    public void user_click_on_View_Orders() {
        webOrdersPage.viewAllOrdersLink.click();

    }

    @Then("User verifies that orders are created")
    public void user_verifies_that_orders_are_created(DataTable ordersNames) {
        List<Map<String,String>> mapOfNames = ordersNames.asMaps(String.class,String.class);
        List<String> actualList = new ArrayList<String>();


    int count = 0;
        for (int i=0;i<webOrdersPage.actualListOfNames.size();i++){
            for (int k=0;k<mapOfNames.size();k++){

                if(webOrdersPage.actualListOfNames.get(i).getText().equalsIgnoreCase(mapOfNames.get(k).get("Customers name"))){
                    actualList.add(webOrdersPage.actualListOfNames.get(i).getText());
                    count++;
                }
            }
        }
         Assert.assertEquals(3,count);
    }

    @Then("verify user logs in to Web Order homepage")
    public void verify_user_logs_in_to_Web_Order_homepage() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "eb Orders";
        Assert.assertEquals("The expected "+expectedTitle+" didn't match with "+actualTitle,expectedTitle,actualTitle);
    }

    @Then("Verify user get error message {string}")
    public void verify_user_get_error_message(String expectedMessage) {
String actualMessage = orderLoginPage.errorMessage.getText();
Assert.assertEquals(expectedMessage,actualMessage);

    }

}
