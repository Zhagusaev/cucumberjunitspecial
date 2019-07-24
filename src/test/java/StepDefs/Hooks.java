package StepDefs;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;


public class Hooks {
//    private static final Logger LOG= LoggerFactory.getLogger(Hooks.class);


    @Before
    public void setUp(){
        WebDriver driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Before scenario");
    }

    @After
    public void afterScenario(Scenario scenario)throws Exception{
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        Thread.sleep(5000);
        Driver.getDriver().quit();
    }
}
