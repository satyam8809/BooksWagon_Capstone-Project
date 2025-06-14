package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features\\",
		glue = "stepDefinitions",
		plugin = {"pretty","html:reports/HTMLReports.html",
				  "json:reports/json_report.json",
				  "junit:reports/junit_report.xml"
		}
		
		)
public class TestRunner {

}
