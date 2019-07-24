package StepDefs;

import Pages.MyAppPage;
import Utilities.Configuration;
import Utilities.DBType;
import Utilities.DBUtils;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppSteps {

    MyAppPage myAppPage = new MyAppPage();
    WebDriver driver = Driver.getDriver();
    List<Map<String, Object>> UIListOfMaps;

    @Given("User navigates to My Application homepage")
    public void user_navigates_to_My_Application_homepage() {
        driver.get(Configuration.getProperty("MyApplicationURL"));
    }

    @Given("User gets the data from UI table")
    public void user_gets_the_data_from_UI_table() {
        UIListOfMaps = new ArrayList<Map<String, Object>>();
        Map<String, Object> UIMap1 = new HashMap<String, Object>();

        for (int i = 0; i < myAppPage.columnNames.size(); i++) {
            UIMap1.put(myAppPage.columnNames.get(i).getText(), myAppPage.firstRowData.get(i).getText());
        }

        UIListOfMaps.add(UIMap1);
//        UIMap.clear();

        Map<String, Object> UIMap2=new HashMap<String, Object>();
        for (int i = 0; i < myAppPage.columnNames.size(); i++) {
            UIMap2.put(myAppPage.columnNames.get(i).getText(), myAppPage.secondRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap2);
//        UIMap.clear();

        Map<String, Object> UIMap3=new HashMap<String, Object>();
        for (int i = 0; i < myAppPage.columnNames.size(); i++) {
            UIMap3.put(myAppPage.columnNames.get(i).getText(), myAppPage.thirdRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap3);
//        UIMap.clear();

        Map<String, Object> UIMap4=new HashMap<String, Object>();
        for (int i = 0; i < myAppPage.columnNames.size(); i++) {
            UIMap4.put(myAppPage.columnNames.get(i).getText(), myAppPage.fourthRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap4);
//        UIMap.clear();
    }

    @Then("verify data is matched with DB")
    public void verify_data_is_matched_with_DB() throws SQLException {
        DBUtils.establishConnection(DBType.ORACLE);

        for (int i = 0; i < UIListOfMaps.size(); i++) {

            String query = "select e.first_name, e.last_name, e.employee_id, j.job_title\n" +
                    "from employees e join jobs j\n" +
                    "using (job_id)\n" +
                    "where employee_id="+UIListOfMaps.get(i).get("Employee ID");

            List<Map<String, Object>> DBListOfMaps = DBUtils.runSQLquery(query);

            for (int i2 = 0; i2 < DBListOfMaps.get(0).size(); i2++) {

                Assert.assertEquals(DBListOfMaps.get(0).get(DBUtils.getColumnNames().get(i2)).toString(), UIListOfMaps.get(i).get(myAppPage.columnNames.get(i2).getText()).toString());
            }
        }
    }


}
