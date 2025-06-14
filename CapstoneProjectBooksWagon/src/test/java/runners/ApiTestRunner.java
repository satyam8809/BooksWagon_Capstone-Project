package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/api",
    glue = "stepDefinitions",
    tags = "@api",
    plugin = {
        "pretty",
        "html:Reports/HTMLReport.html",
        "json:Reports/JSONReport.json",
        "junit:Reports/JUnitReport.xml"
    },
    monochrome = true
)
public class ApiTestRunner {
	
}