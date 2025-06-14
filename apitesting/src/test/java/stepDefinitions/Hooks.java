package stepDefinitions;

import io.cucumber.java.*;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ExtentTest test = ExtentReportManager.createTest(scenario.getName());
        test.info("Starting Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        ExtentTest test = ExtentReportManager.getTest();
        if (scenario.isFailed()) {
            test.fail("Scenario Failed");
        } else {
            test.pass("Scenario Passed");
        }
        ExtentReportManager.flush();
    }
}
