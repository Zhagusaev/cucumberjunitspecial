package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Mapping - providing path of our feature file and Implementation files

        //Giving address of our feature files
        features = "src/test/resources/features/",
        //Where to look for implementation files
        glue = "stepDefs/",
        //Grouping scenarios
        tags = "@dataTable",
        //
        dryRun = false

)


public class TestRunner {


}
