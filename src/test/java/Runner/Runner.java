package Runner;

import Utilities.DBUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Plugin creates HTML report for us

        plugin = {"pretty", "html:target/cucumberHTMLReport","json:target/cucumber.json"},
        features = "src/test/resources/DBFeatures",
        glue = "StepDefs",
        tags = {"@db"},


        //if we have step definition
        dryRun = false
)

public class Runner {



}
